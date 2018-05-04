package tutorialManagement.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tutorialManagement.Application;
import tutorialManagement.api.mapper.TutorialMapper;
import tutorialManagement.api.model.TutorialCreateView;
import tutorialManagement.api.model.TutorialGetView;
import tutorialManagement.api.model.TutorialsGetView;

import tutorialManagement.model.Tutorial;
import tutorialManagement.services.ResourceService;
import tutorialManagement.services.StorageService;
import tutorialManagement.services.TutorialService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class TutorialApi {

    @Autowired
    private TutorialService tutorialService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private TutorialMapper tutorialMapper;
    @Autowired
    private ResourceService resourceService;


    @CrossOrigin
    @RequestMapping(value = "/tutorials", method = RequestMethod.POST,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> setTutorial(@RequestBody TutorialCreateView tutorial) {
        tutorialService.addTutorial(tutorialMapper.createViewToTutorial(tutorial));
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
    @GetMapping(value = "/tutorials/resources/{resourceId}")
    @ResponseBody
    public ResponseEntity<Resource> getResource(@PathVariable("resourceId") long id) {
        Optional<tutorialManagement.model.Resource> resource = resourceService.getResourceById(id);
        if(resource.isPresent()){

            Resource file = resourceService.loadFile(resource.get().getPath(), resource.get().getResourceType());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename\"" +file.getFilename() + "\"")
                    .body(file);
        }
        return ResponseEntity.notFound().build();
    }

}
