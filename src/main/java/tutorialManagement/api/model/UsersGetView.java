package tutorialManagement.api.model;

import java.util.List;

public class UsersGetView {

    private List<UserGetView> users;


    public List<UserGetView> getUsers() {
        return users;
    }

    public void setUsers(List<UserGetView> users) {
        this.users = users;
    }
}
