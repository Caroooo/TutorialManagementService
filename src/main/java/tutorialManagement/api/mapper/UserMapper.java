package tutorialManagement.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tutorialManagement.api.model.UserCreateView;
import tutorialManagement.api.model.UserGetView;
import tutorialManagement.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User createViewToUser(UserCreateView user);

    UserGetView userToGetView(User user);
}
