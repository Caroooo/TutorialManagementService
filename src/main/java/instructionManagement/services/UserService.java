package instructionManagement.services;

import instructionManagement.model.InstructionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import instructionManagement.model.User;
import instructionManagement.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findUser(String userName, String password) {
        return userRepository.findUserByUserNameAndPassword(userName, password);
    }

    public void updateUser(User viewToUser) {

        userRepository.save(viewToUser);
    }

    public void deleteUser(User viewToUser) {
        userRepository.delete(viewToUser);
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    public void setAccessRightsToUser(long id, boolean canRead, boolean canWrite) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setCanRead(canRead);
            user.get().setCanWrite(canWrite);
            user.get().setFirstVisit(true);
            userRepository.save(user.get());
        }
    }

    public void addKnowledgeValuesToUser(long id, List<Integer> values, InstructionType instructionType) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent() && values != null && !values.isEmpty()){
            List<Integer> presentValues = user.get().getLevel().get(instructionType).getValues();
            presentValues.addAll(values);
            user.get().getLevel().get(instructionType).setValues(presentValues);
            user.get().getLevel().get(instructionType).calcLevel();
            userRepository.save(user.get());
        }
    }
}
