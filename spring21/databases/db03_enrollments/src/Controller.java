/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: DB 03 - Controller
 * Student(s) Name(s): Sara White, Tj Virbick, Letitia Fickling
 */

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Controller {

    private EntityManager em;
    private Session session;

    public Controller() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db03");
        em = emf.createEntityManager();
        session = em.unwrap(Session.class);
    }

    // TODO: return a Student entity from the given id (or null if the entity does not exist)
    public Student getStudent(int id) {
        /*SessionImpl sessionImpl = (SessionImpl) session;
        Connection conn = sessionImpl.connection();
        String sql = "SELECT id, name FROM students WHERE id= " + id; 
        Statement statement = conn.createStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet != null) {
            return resultSet;
        }
        conn.close();
        return null; */

        Return em.find(Student.class, id);
    }

    // TODO: add the given student entity, returning true/false depending whether the operation was successful or not
    public boolean addStudent(final Student student) {
        /*SessionImpl sessionImpl = (SessionImpl) session;
        Connection conn = sessionImpl.connection();
        PreparedStatement statement = conn.prepareStatement(sql);
        int id = student.getId();
        String name = student.getName();
        String sql = "INSERT INTO Students VALUES (?, ?)";
        statement.setString(1, id); 
        statement.setString(2, name); 
        //Statement statement = conn.createStatement();
        int count = statement.executeUpdate(sql);
        conn.close();
        if (count == 1) {
            return true;
        }
        else {
            return false;
        }
        conn.close(); */
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        return em.contains(student);
    }

    // TODO: return a list of all Course entities
    public List<Course> getCourses() {

        list<Course> courses = (List<Course>)em.createQuery("SELECT a FROM Course c").getResultList(); 
        return courses;
    }

    // TODO: enroll a student to a course based on the given parameters, returning true/false depending whether the operation was successful or not
    public boolean enrollStudent(String code, int id) {
        
        Enrollment enrollment = new Enrollment();
        EnrollmentPK enrollmentPK = new EnrollmentPK();
        enrollmentPK.setCode(code);
        enrollmentPK.setId(id);
        enrollment.setEnrollmentPK(enrollmentPK);

        em.getTransaction().begin();
        em.persist(enrollment);
        em.getTransaction().commit();

        /*if (enrollmentPK.getId() > 0) {
            return true;
        } else {
            return false;
        } */
        return em.contains(enrollment);
        
    }

    // TODO: drop a student from a course based on the given parameters, returning true/false depending whether the operation was successful or not
    public boolean dropStudent(String code, int id) {
        /*
        Enrollment enrollment = new Enrollment();
        EnrollmentPK enrollmentPK = new EnrollmentPK();
        enrollmentPK = enrollment.getEnrollmentPK();

        if(enrollmentPK.getId() == id && enrollmentPK.getCode().equals(code)) {
            em.remove(enrollment);
            em.remove(enrollmentPK);
            return true;
        }
        return false;
        */

        EnrollmentPK enrollmentPK = new EnrollmentPK(code, id);
        Enrollment enrollment = em.find(Enrollment.class, enrollmentPK);
        em.getTransaction().begin();
        em.remove(enrollment);
        em.getTransaction().commit();

        return em.contains(enrollment);
    }

    // TODO: return a list of all Student entities enrolled in the given course (hint: use the stored procedure 'list_students')
    public List<Student> getStudentsEnrolled(String course) {
        SessionImpl sessionImpl = (SessionImpl) session;
        Connection conn = sessionImpl.connection();
        String sql = "CALL list_students (?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, course);

            ResultSet resultSet = statement.executeQuery();

            List<Student> students = new ArrayList<Student>();

            do {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Student student = new Student();
                student.setName(name);
                student.setId(id);

                students.add(student);

            } while (resultSet.next());

            conn.close();
            return students;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }
    
}