/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: DB 03 - Enrollment
 * Student(s) Name(s): Sara White, Tj Virbick, Letitia Fickling
 */


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "enrollments")
public class Enrollment implements Serializable {

    @EmbeddedId
    private EnrollmentPK enrollmentPK;

    /*
    @OneToMany
    @JoinColumns({
        @JoinColumn(name = "code"),
        @JoinColumn(name =" id")
    })

    */

    @ManyToOne
    @JoinColumn(name = "code")
    private Course course;

    @OneToOne
    @JoinColumn(name = "id")
    private Student student;


    public EnrollmentPK getEnrollmentPK() {
        return enrollmentPK;
    }

    public void setEnrollmentPK(EnrollmentPK enrollmentPK) {
        this.enrollmentPK = enrollmentPK;
    }

    /*@OneToMany(mappedBy = "id")
    private List<Student> students; */


    /*
    public List<Student> getStudents() { 
        return students; 
    } 
    
    public void setStudents(List<Student> students) { 
        this.students = students; 
    } */

    @Override
    public String toString() {
        return "Enrollement{" + "enrollmentPK=" +  enrollmentPK;
    }
}

