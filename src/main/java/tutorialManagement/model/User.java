package tutorialManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    private Long id;
    private String userName;
    private String password;
    private int laymanInformation;
    private int rookieInformation;
    private boolean canRead;
    private boolean canWrite;
    private boolean isFirstVisit;

    public User() {
        canRead = true;
        isFirstVisit= true;
        laymanInformation = 6;
    }

    public User(String userName, String password, int laymanInformation, int rookieInformation, boolean canRead, boolean canWrite, boolean isFirstVisit) {
        this.userName = userName;
        this.password = password;
        this.laymanInformation = laymanInformation;
        this.rookieInformation = rookieInformation;
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.isFirstVisit = isFirstVisit;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique=true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLaymanInformation() {
        return laymanInformation;
    }

    public void setLaymanInformation(int laymanInformation) {
        this.laymanInformation = laymanInformation;
    }

    public int getRookieInformation() {
        return rookieInformation;
    }

    public void setRookieInformation(int rookieInformation) {
        this.rookieInformation = rookieInformation;
    }

    public boolean isCanRead() {
        return canRead;
    }

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public boolean isCanWrite() {
        return canWrite;
    }

    public void setCanWrite(boolean canWrite) {
        this.canWrite = canWrite;
    }

    public boolean isFirstVisit() {
        return isFirstVisit;
    }

    public void setFirstVisit(boolean firstVisit) {
        isFirstVisit = firstVisit;
    }
}
