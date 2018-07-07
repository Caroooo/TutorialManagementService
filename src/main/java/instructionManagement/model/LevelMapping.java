package instructionManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class LevelMapping {

    private static int NUM = 39;
    private static int LOWER_THRESHOLD = 30;
    private static int UPPER_THRESHOLD = 500;
    private static int DEFAULT_VALUE = 40;
    private Long id;
    private Level level;
    private List<Integer> values;
    private double WMS;

    public LevelMapping() {
        values = new LinkedList<>();
        WMS = DEFAULT_VALUE;
    }

    public LevelMapping(Level level) {
        values = new LinkedList<>();
        WMS = DEFAULT_VALUE;
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
    @Column(name = "WEIGHTED_MOVING_SUM")
    public double getWeightedMovingSum() {
        calcWMS();
        return WMS;
    }

    public void setWeightedMovingSum(double wms) {
        this.WMS = wms;
    }


    private void calcWMS(){
        if(!values.isEmpty()) {
            List<Integer> val;
            if (values.size() >= NUM) {
               val = values.subList(values.size() - NUM, values.size());
                System.out.print("Zeitreihe= [");
                int sum = 0;
                for (int i = 0; i < val.size(); i++) {
                    System.out.print(val.get(i) + ",");
                    sum = sum + (val.get(i) * (i + 1));
                }
                System.out.print("]");
                System.out.println();
                WMS = sum;
            } else {
                val = values.subList(0, values.size());
                System.out.print("Zeitreihe= [");
                int sum = 0;
                for (int i = 0; i < val.size(); i++) {
                    System.out.print(val.get(i) + ",");
                    sum = sum + (val.get(i) * (i + 1));
                }
                System.out.print("]");
                System.out.println();
                WMS = sum;
               // System.out.println("not enough values: " + values.size());
            }

        }else{
            System.out.println("values is empty");
        }

    }

  /*  private double expSmooth(double lastResult, int index){
        if(index >= values.size()){
            return lastResult;
        }
        double result = (alpha * values.get(index)) + (1 - alpha) * lastResult;
        return expSmooth(result, ++index);
    }

    private double calcSmoothing(){
        if(!values.isEmpty()) {
            List<Integer> val;
            if (values.size() >= NUM) {
                return expSmooth(values.get(0), 1);
            } else if(values.size() >= 2) {
                return expSmooth(values.get(0), 1);
              //   System.out.println("not enough values: " + values.size());
            }else{
                System.out.println("not enough values: " + values.size());
            }

        }else{
            System.out.println("values is empty");
        }
        return 0;
    }*/

    public void calcLevel() {
    /*    calcWMA();
        System.out.println("WMA = " + weightedMovingAverage);
        if(weightedMovingAverage < 3){
            level = Level.PRO;
        }else if(weightedMovingAverage >= 3 && weightedMovingAverage <= 18){
            level = Level.LAYMAN;
        }else{
            level = Level.ROOKIE;
        } */
        calcWMS();
        System.out.println("WMS = " + WMS);
        if(WMS < LOWER_THRESHOLD){
            level = Level.PRO;
        }else if(WMS >= LOWER_THRESHOLD && WMS <= UPPER_THRESHOLD){
            level = Level.LAYMAN;
        }else{
            level = Level.ROOKIE;
        }
  /*   double res = calcSmoothing();
        System.out.println("result: " + res);
        if(res < 30){
            level = Level.PRO;
        }else if(res >= 30 && res <= 500){
            level = Level.LAYMAN;
        }else{
            level = Level.ROOKIE;
        }*/
    }
}
