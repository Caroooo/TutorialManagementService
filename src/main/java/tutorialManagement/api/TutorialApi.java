package tutorialManagement.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tutorialManagement.api.mapper.TutorialMapper;
import tutorialManagement.api.model.TutorialCreateView;
import tutorialManagement.api.model.TutorialGetView;
import tutorialManagement.api.model.TutorialsGetView;
import tutorialManagement.model.Resource;
import tutorialManagement.model.Tutorial;
import tutorialManagement.services.ResourceService;
import tutorialManagement.services.TutorialService;

import java.io.File;
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
    @GetMapping(value = "/tutorials/resources/{resourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getResource(@PathVariable("resourceId") long id) {
        Optional<Resource> resource = resourceService.getResourceById(id);
        if(resource.isPresent()){
            return resourceService.getImage(resource.get().getPath());
        }
        return null;
    }

}
