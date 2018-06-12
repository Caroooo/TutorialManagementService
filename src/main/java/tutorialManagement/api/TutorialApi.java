package tutorialManagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import tutorialManagement.api.mapper.ResourceMapper;
import tutorialManagement.api.mapper.TutorialMapper;
import tutorialManagement.api.model.*;

import tutorialManagement.model.Tutorial;

import tutorialManagement.services.ResourceService;
import tutorialManagement.services.TutorialService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class TutorialApi {

    @Autowired
    private TutorialService tutorialService;
    @Autowired
    private TutorialMapper tutorialMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceService resourceService;

    @CrossOrigin
    @RequestMapping(value = "/tutorials", method = RequestMethod.POST,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> setTutorial(@RequestBody TutorialCreateView tutorial) {

        tutorialService.addTutorial(tutorial);
        return ResponseEntity.accepted().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/tutorials", method = RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
    public TutorialsGetView getTutorials() {
        List<TutorialGetView> tutorialsGetView = new LinkedList<>();

        List<Tutorial> tutorialList = tutorialService.getTutorials();
        for(Tutorial t : tutorialList){
            tutorialsGetView.add(tutorialMapper.tutorialToGetView(t));
        }

        TutorialsGetView tutorials = new TutorialsGetView();
        tutorials.setTutorials(tutorialsGetView);
        return tutorials;
    }

    @CrossOrigin
    @RequestMapping(value="/tutorials/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public TutorialGetView tutorialById(@PathVariable("id") long id) {
        Optional<Tutorial> t = tutorialService.getTutorialById(id);
        if(t.isPresent()){
            return  tutorialMapper.tutorialToGetView(t.get());
        }
        return null;
    }

    @CrossOrigin
    @GetMapping(value = "/tutorials/resources/file/{resourceId}")
    @ResponseBody
    public ResponseEntity<Resource> getResourceFile(@PathVariable("resourceId") long id) {
        Optional<tutorialManagement.model.Resource> resource = resourceService.getResourceById(id);
        if(resource.isPresent()){

            Resource file = resourceService.loadFile(resource.get().getPath(), resource.get().getResourceType());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename\"" +file.getFilename() + "\"")
                    .body(file);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @GetMapping(value = "/tutorials/resources/{resourceId}")
    @ResponseBody
    public tutorialManagement.model.Resource getResource(@PathVariable("resourceId") long id) {
        Optional<tutorialManagement.model.Resource> resource = resourceService.getResourceById(id);
        if(resource.isPresent()){

            Resource file = resourceService.loadFile(resource.get().getPath(), resource.get().getResourceType());
            return resource.get();
        }
        return null;
    }

    @CrossOrigin
    @GetMapping(value = "/tutorials/resources")
    @ResponseBody
    public ResponseEntity<List<ResourceGetView>> getResources() {
        List<tutorialManagement.model.Resource> resourceList = resourceService.getResources();

        if(!resourceList.isEmpty()){
            List<ResourceGetView> resourceGetViews = new LinkedList<>();
            for(tutorialManagement.model.Resource r : resourceList){
                resourceGetViews.add(resourceMapper.resourceToGetView(r));
            }
            return ResponseEntity.ok(resourceGetViews);
        }
        return ResponseEntity.notFound().build();
    }


    @CrossOrigin(exposedHeaders = "Location")
    @PostMapping("/tutorials/resources/")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, UriComponentsBuilder b) {
        String message = "";
        try {
            tutorialManagement.model.Resource resource = resourceService.store(file);
         //   files.add(file.getOriginalFilename());
            UriComponents uriComponents =
                    b.path("/tutorials/resources/{resourceId}").buildAndExpand(resource.getId());

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());
            return new ResponseEntity(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

}
