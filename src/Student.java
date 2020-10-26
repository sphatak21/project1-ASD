import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {

    private  HashMap<String, ArrayList<Grade>> subjectGrades = new HashMap<String, ArrayList<Grade>>();
    private static String[] subjectArray = new String[]
            {"Math", "Science", "History", "English", "Health", "Spanish", "Computer Science"};
    public Student(String username, String firstName, String lastName, String password){
        super(username, firstName, lastName, password);
        for(int i = 0; i < subjectArray.length; i++){
            this.subjectGrades.put(subjectArray[i], new ArrayList<Grade>());
        }
    }

    public ArrayList<Grade> getOneSubjectGrades(String subject) {
        return subjectGrades.get(subject);
    }

    public HashMap<String, ArrayList<Grade>> getSubjectGrades() {
        return subjectGrades;
    }

    public static String[] getSubjectArray() {
        return subjectArray;
    }

}
