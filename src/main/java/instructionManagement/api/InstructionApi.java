package instructionManagement.api;

import instructionManagement.model.InstructionType;
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
import instructionManagement.api.mapper.ResourceMapper;
import instructionManagement.api.mapper.InstructionMapper;
import instructionManagement.api.model.*;

import instructionManagement.model.Instruction;

import instructionManagement.services.ResourceService;
import instructionManagement.services.InstructionService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class InstructionApi {

    @Autowired
    private InstructionService instructionService;
    @Autowired
    private InstructionMapper instructionMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceService resourceService;

    @CrossOrigin
    @RequestMapping(value = "/instructions", method = RequestMethod.POST,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> setInstruction(@RequestBody InstructionCreateView instructionCreateView) {

        instructionService.addInstruction(instructionCreateView);
        return ResponseEntity.accepted().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/instructions", method = RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
    public InstructionsGetView getInstructions() {
        List<InstructionGetView> instructionGetViews = new LinkedList<>();

        List<Instruction> instructionList = instructionService.getInstructions();
        for(Instruction t : instructionList){
            instructionGetViews.add(instructionMapper.instructionToGetView(t));
        }

        InstructionsGetView instructions = new InstructionsGetView();
        instructions.setInstructions(instructionGetViews);
        return instructions;
    }

    @CrossOrigin
    @RequestMapping(value="/instructions/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public InstructionGetView instructionById(@PathVariable("id") long id) {
        Optional<Instruction> t = instructionService.getInstructionById(id);
        if(t.isPresent()){
            return  instructionMapper.instructionToGetView(t.get());
        }
        return null;
    }

    @CrossOrigin
    @GetMapping(value = "/instructions/resources/file/{resourceId}")
    @ResponseBody
    public ResponseEntity<Resource> getResourceFile(@PathVariable("resourceId") long id) {
        Optional<instructionManagement.model.Resource> resource = resourceService.getResourceById(id);
        if(resource.isPresent()){

            Resource file = resourceService.loadFile(resource.get().getPath(), resource.get().getResourceType());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename\"" +file.getFilename() + "\"")
                    .body(file);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @GetMapping(value = "/instructions/resources/{resourceId}")
    @ResponseBody
    public instructionManagement.model.Resource getResource(@PathVariable("resourceId") long id) {
        Optional<instructionManagement.model.Resource> resource = resourceService.getResourceById(id);
        if(resource.isPresent()){

            Resource file = resourceService.loadFile(resource.get().getPath(), resource.get().getResourceType());
            return resource.get();
        }
        return null;
    }

    @CrossOrigin
    @GetMapping(value = "/instructions/resources")
    @ResponseBody
    public ResponseEntity<List<ResourceGetView>> getResources() {
        List<instructionManagement.model.Resource> resourceList = resourceService.getResources();

        if(!resourceList.isEmpty()){
            List<ResourceGetView> resourceGetViews = new LinkedList<>();
            for(instructionManagement.model.Resource r : resourceList){
                resourceGetViews.add(resourceMapper.resourceToGetView(r));
            }
            return ResponseEntity.ok(resourceGetViews);
        }
        return ResponseEntity.notFound().build();
    }


    @CrossOrigin(exposedHeaders = "Location")
    @PostMapping("/instructions/resources/")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, UriComponentsBuilder b) {
        String message = "";
        try {
            instructionManagement.model.Resource resource = resourceService.store(file);
         //   files.add(file.getOriginalFilename());
            UriComponents uriComponents =
                    b.path("/instructions/resources/{resourceId}").buildAndExpand(resource.getId());

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());
            return new ResponseEntity(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/instructions/types")
    @ResponseBody
    public ResponseEntity<InstructionType[]> getInstructionTypes() {

        InstructionType[] types = InstructionType.values();
        return ResponseEntity.ok(types);

    }

}
