package instructionManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import instructionManagement.model.Resource;
import instructionManagement.model.ResourceType;
import instructionManagement.repositories.ResourceRepository;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    private final Path rootLocation = Paths.get("C:\\Users\\carom\\Documents\\FHV\\Master\\Angular-Projects\\resourcen");

    @Autowired
    private ResourceRepository resourceRepository;


    public Optional<Resource> getResourceById(long id){
        return resourceRepository.findById(id);
    }

    public List<Resource> getResources(){
        return resourceRepository.findAll();
    }

    public org.springframework.core.io.Resource loadFile(String filename, ResourceType resourceType) {
        try {

            //read file
            File file = new File(rootLocation + "//" + filename);
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fis.read(bytes);

            //make new encoded file
            String encodedString = fileContentToBase64(bytes, resourceType);
            File base64File = new File(rootLocation + "//encoded" + filename);
            FileWriter fileWriter = new FileWriter(base64File);
            fileWriter.write(encodedString);
            fileWriter.flush();
            fileWriter.close();
            Path newFile = rootLocation.resolve(base64File.getPath());
            org.springframework.core.io.Resource newResource = new UrlResource(newFile.toUri());

            if (newResource.exists() || newResource.isReadable()) {
                return newResource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String fileContentToBase64(byte[] bytes, ResourceType resourceType) {
        String contentInBase64 = Base64.getEncoder().encodeToString(bytes);
        String prefix = "";
        switch (resourceType){
            case IMAGE: prefix = "data:image/png;base64,";
                break;
            case AUDIO: prefix = "data:audio/mp3;base64,";
                break;
            case VIDEO: prefix = "data:video/mp4;base64,";
                break;
        }
        return prefix + contentInBase64;
    }

    public Resource store(MultipartFile file) {
        Resource resource = new Resource();
        resource.setOriginalName(file.getOriginalFilename());
        String ending = "";
        if(file.getOriginalFilename().endsWith(".png")){
            ending = ".png";
            resource.setResourceType(ResourceType.IMAGE);
        } else if(file.getOriginalFilename().endsWith(".jpg")){
            ending = ".jpg";
            resource.setResourceType(ResourceType.IMAGE);
        }else if (file.getOriginalFilename().endsWith(".mp3")){
            ending = ".mp3";
            resource.setResourceType(ResourceType.AUDIO);
        }else if(file.getOriginalFilename().endsWith(".mp4")){
            ending = ".mp4";
            resource.setResourceType(ResourceType.VIDEO);
        }

        Resource savedResource = resourceRepository.save(resource);
        savedResource.setPath(savedResource.getId() + ending);
        resourceRepository.save(savedResource);
        try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(savedResource.getPath()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }

        return savedResource;
    }

    public void saveResource(Resource resource) {
        resourceRepository.save(resource);
    }
}
