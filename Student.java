package echoservermadimadi;
import java.io.Serializable;
/**
 *
 * @author madi madi
 */
public class  Student implements Serializable {
    private static final long serialVersionUID = -1848148348931789644L; 
    private int counter; // number of loops for run method in Thead class.
    private int age;
    private String gender;
    private String name;
    private int counter_from;
    private int counter_to;
    private int increment;
    private int id;
    private String dob;

    // Getters 
    public int getCounter_from() {
        return counter_from;
    }

    public String getName() {
        return name;
    }

    public int getCounter_to() {
        return counter_to;
    }

    public int getIncrement() {
        return increment;
    }
     public String getDOB() {
        return dob;
    }
        public int getID() {
        return id;
    }
// Setters

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public void setCounter_to(int counter_to) {
        this.counter_to = counter_to;
    }

    public void setCounter_from(int counter_from) {
        this.counter_from = counter_from;
    }

    public void setName(String name) {
        this.name = name;
    }
     public void Setdob(String dob) {
        this.dob = dob;
    }
         public void Setid(int id) {
       this.id=id;
    }

    /**
     * My constructor that populates name, count from and to and increment
     * values..
     */
    public Student(int id,String name,String dob, int counter_from, int counter_to, int counter_increment) {
this.id=id;
        
        this.name = name;
          this.dob = dob;
        this.counter_from = counter_from;
        this.counter = counter_from;
        this.counter_to = counter_to;
        this.increment = counter_increment;
        
    }
/**
 * toString method to override! in inherited childs 
 * @return 
 */

    public String toString() {
        return null;
    }
    
    public String methodone(){
    return null;
    }
}


