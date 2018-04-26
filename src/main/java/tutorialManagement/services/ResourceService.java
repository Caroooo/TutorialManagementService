package tutorialManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutorialManagement.model.Resource;
import tutorialManagement.repositories.ResourceRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;


    public Optional<Resource> getResourceById(long id){
        return resourceRepository.findById(id);
    }

    public String getImage(String path) {
        return getFileAsBase64(path);
    }

    private String getFileAsBase64(String path) {

        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(path);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                stringBuilder.append(Base64.getEncoder().encodeToString(st.getBytes()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

      //  String audio =  "data:audio/mp3;base64," +stringBuilder.toString();

        return stringBuilder.toString();
    }
}
