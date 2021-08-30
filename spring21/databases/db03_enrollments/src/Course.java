import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;

/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: DB 03 - Course
 * Student(s) Name(s): Sara White, Tj Virbick, Letitia Fickling
 */



@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    private String code;
    private String title;
    private String instructor;
    private int max;
    private int actual;


    @OneToMany(mappedBy = "code")
    private List<Enrollment> enrollments; 


    
    public List<Enrollment> getEnrollments() { 
        return enrollments; 
    } 
    
    public void setEnrollments(List<Enrollments> enrollments) { 
        this.enrollments = enrollments; 
    } 


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    @Override
    public String toString() {
        return code + "-" + title+ "-" + actual+ "-" + max+ "-" + actual + "Enrolled Students: " + enrollments;
    }

}
