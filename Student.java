
import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String fatherName;
    private String dob;
    private String phone;
    private String email;
    private String sscGpa;
    private String hscGpa;
    private Waiver waiver;
    private Department department;

    public Student(String name, String fatherName, String dob, String phone, String email,
                   String sscGpa, String hscGpa, Waiver waiver, Department department) {
        this.name = name;
        this.fatherName = fatherName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.sscGpa = sscGpa;
        this.hscGpa = hscGpa;
        this.waiver = waiver;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nFather's Name: " + fatherName +
                "\nDate of Birth: " + dob +
                "\nPhone: " + phone +
                "\nEmail: " + email +
                "\nSSC GPA: " + sscGpa +
                "\nHSC GPA: " + hscGpa +
                "\nWaiver: " + waiver +
                "\nDepartment: " + department;
    }
}