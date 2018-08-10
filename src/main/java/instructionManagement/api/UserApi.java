package instructionManagement.api;


import instructionManagement.model.InstructionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import instructionManagement.api.mapper.UserMapper;
import instructionManagement.api.model.*;
import instructionManagement.model.User;
import instructionManagement.services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserApi {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;


    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.POST,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> setUser(@RequestBody UserCreateView user) {
        userService.addUser(userMapper.createViewToUser(user));
        return ResponseEntity.accepted().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
    public UsersGetView getUsers() {
       List<UserGetView> usersGetView = new LinkedList<>();

        List<User> userList = userService.findUsers();
        for(User u : userList){
            usersGetView.add(userMapper.userToGetView(u));
        }

        UsersGetView users = new UsersGetView();
        users.setUsers(usersGetView);
        return users;
    }

    @CrossOrigin
    @RequestMapping(value="/users/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public UserGetView userById(@PathVariable("id") long id) {
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return  userMapper.userToGetView(user.get());
        }
        return null;
    }

    @CrossOrigin
    @RequestMapping(value="/users/user", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public UserGetView userByCredentials(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletResponse response) {
        User user = userService.findUser(userName, password);
        if(user != null){
            return  userMapper.userToGetView(user);
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.PUT,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.accepted().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.DELETE,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUser(@RequestBody UserCreateView user) {
        userService.deleteUser(userMapper.createViewToUser(user));
        return ResponseEntity.accepted().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{id}/accessRights", method = RequestMethod.PUT,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> setAccessRightsUser(@PathVariable("id") long id,
                                                    @RequestParam("canRead") boolean canRead,
                                                    @RequestParam("canWrite") boolean canWrite
                                                    ) {
        userService.setAccessRightsToUser(id, canRead, canWrite);
        return ResponseEntity.accepted().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{id}/level", method = RequestMethod.PUT,  produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> setLevel(@PathVariable("id") long id,
                                         @RequestParam(value = "values", required = false) List<Integer> values ,
                                         @RequestParam("instructionType") InstructionType instructionType
    ) {
        userService.addKnowledgeValuesToUser(id, values, instructionType);
        return ResponseEntity.accepted().build();
    }
}
