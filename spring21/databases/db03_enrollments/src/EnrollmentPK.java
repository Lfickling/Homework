import javax.persistence.Embeddable;

/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: DB 03 - EnrollmentPK
 * Student(s) Name(s): Sara White, Tj Virbick, Letitia Fickling
 */

@Embeddable
public class EnrollmentPK implements Serializable {

    private String code;
    private int id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EnrollmentPK{" + "code=" + code + ", id=" + id +"}";
    }

}

