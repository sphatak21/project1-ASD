import java.util.ArrayList;

public class Teacher extends User{
    private String subject;
    private ArrayList<Student> students = Data.getStudents();

    public Teacher(String username, String firstName, String lastName, String password, String subject){
        super(username, firstName,  lastName, password);
        this.subject = subject;
    }

    /*public void addSubjectGrade(Student student, String numerator, String denominator) {
        Student selectedStudent = student;
        ArrayList <String[]> grades = selectedStudent.getOneSubjectGrades(subject);
        grades.add(grade);
    }*/

}
