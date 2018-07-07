package instructionManagement.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import instructionManagement.api.model.UserCreateView;
import instructionManagement.api.model.UserGetView;
import instructionManagement.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User createViewToUser(UserCreateView user);

    UserGetView userToGetView(User user);
}
