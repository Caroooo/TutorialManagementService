package instructionManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class LevelMapping {

    private static int NUM = 39;
    private static int LOWER_THRESHOLD = 0;
    private static int UPPER_THRESHOLD = 2;
    private static int DEFAULT_VALUE = 1;
    private Long id;
    private Level level;
    private List<Integer> values;
    private double WMA;

    public LevelMapping() {
        values = new LinkedList<>();
        WMA = DEFAULT_VALUE;
    }

    public LevelMapping(Level level) {
        values = new LinkedList<>();
        WMA = DEFAULT_VALUE;
        this.level = level;
    }

    public LevelMapping(Level level, List<Integer> values) {
        this.level = level;
        this.values = values;
    }
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Level getLevel() {
        calcLevel();
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @ElementCollection
    @JsonIgnore
    @Column(name = "LEVEL_MAPPING_VALUES")
    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
    @JsonIgnore
    public double getWMA() {
        calcWMA();
        return WMA;
    }

    public void setWMA(double WMA) {
        this.WMA = WMA;
    }

    private void calcWMA(){
        if(!values.isEmpty()) {
            List<Integer> val;
            if (values.size() >= NUM) {
               val = values.subList(values.size() - NUM, values.size());

            } else {
                val = values.subList(0, values.size());
            }
            System.out.print("Zeitreihe= [");
            int sum = 0;
            int weights = 0;
            for (int i = 0; i < val.size(); i++) {
                System.out.print(val.get(i) + ",");
                sum = sum + (val.get(i) * (i + 1));
                weights = weights + i+1;
            }
            System.out.print("]");
            System.out.println();
            WMA = sum / weights;

        }else{
            WMA = DEFAULT_VALUE;
            System.out.println("values is empty");
        }

    }

    public void calcLevel() {
        calcWMA();
        System.out.println("WMA = " + WMA);
        if(WMA < LOWER_THRESHOLD){
            level = Level.PRO;
        }else if(WMA >= LOWER_THRESHOLD && WMA <= UPPER_THRESHOLD){
            level = Level.LAYMAN;
        }else{
            level = Level.ROOKIE;
        }
    }
}
