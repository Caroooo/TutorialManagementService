package instructionManagement.model;

import org.aspectj.apache.bcel.generic.Instruction;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class User {

    private Long id;
    private String userName;
    private String password;
    private boolean canRead;
    private boolean canWrite;
    private boolean isFirstVisit;
    private Map<InstructionType, LevelMapping> level = new HashMap<>();

    public User() {
        canRead = true;
        isFirstVisit= true;
        LevelMapping wartungLevel = new LevelMapping(Level.LAYMAN);
        LevelMapping werkstuekLevel = new LevelMapping(Level.LAYMAN);
        LevelMapping werkzeugLevel = new LevelMapping(Level.LAYMAN);
        level.put(InstructionType.WARTUNG, wartungLevel);
        level.put(InstructionType.WERKSTUECK, werkstuekLevel);
        level.put(InstructionType.WERKZEUG, werkzeugLevel);
    }

    public User(String userName, String password, boolean canRead, boolean canWrite, boolean isFirstVisit, Map<InstructionType, LevelMapping> level) {
        this.userName = userName;
        this.password = password;
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.isFirstVisit = isFirstVisit;
        this.level = level;
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

    @OneToMany(cascade = CascadeType.ALL)
    @MapKeyColumn(name="id")
    public Map<InstructionType, LevelMapping> getLevel() {
        for(LevelMapping l : level.values()){
            l.calcLevel();
        }
        return level;
    }

    public void setLevel(Map<InstructionType, LevelMapping> level) {
        this.level = level;
    }
}
