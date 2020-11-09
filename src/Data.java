import java.util.HashMap;
import java.util.ArrayList;
public class Data {
    private static HashMap <String, User> users = new HashMap<>();
    private static ArrayList<Student> students = new ArrayList<Student>();
    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    public static void init(){
        users.put("sphatak21", new Student("sphatak21", "Sidd", "Phatak","Password"));
        users.put("jdoe21", new Student("jdoe21", "John", "Doe", "JD1"));
        users.put("rwilson", new Teacher("rwilson", "Ryan", "Wilson", "APCSA", "Computer Science"));
        users.put("marnold", new Teacher("marnold", "Marie", "Arnold", "APLIT", "English"));
        users.put("sjidarian", new Teacher("sjidarian", "Sedrak", "Jidarian", "CALC3", "Math"));
        users.put("cprince", new Teacher("cprince", "Colleen", "Prince", "HEALTH", "Health"));
        users.put("nkelly", new Teacher("nkelly", "Nelson", "Kelly", "APGOV", "History"));
        users.put("gavena", new Teacher("gavena", "Gladys", "Avena", "ESPANOL", "Spanish"));
        users.put("mraquet", new Teacher("mraquet", "Mark", "Raquet", "APMECH", "Science"));
        assignUsers();

        String [] subjectArray = Student.getSubjectArray();
        for(Student i : students){
            for(String a : subjectArray){
                int x = 0;
                while(x < 3){
                    double grade = Math.random();
                    if(grade < .5){
                        grade+=.5;
                    }
                    int denom = 10;
                    double num = (int) (grade * 10);
                    i.setSubjectGrade(a, num, denom);
                    x++;
                }
            }
        }
    }
    public static boolean checkUsername(String username){
        for ( String i : users.keySet()) {
            if(username.equals(i)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkPassword(String username, String password){
        boolean valid = User.checkPassword(username, password);
        return valid;
    }
    public static User getUser(String username){
        return users.get(username);
    }
    public static Teacher getUserUsingSubject(String subject){
        for(Teacher i : teachers){
                if(i.getSubject().equals(subject)) {
                    return i;
                }
        }
        return null;
    }
    public static void assignUsers(){
        for(String i : users.keySet()){
            if(User.isStudent(i)){
                students.add((Student) users.get(i));
            }else{
                teachers.add((Teacher) users.get(i));
            }
        }
    }
    public static ArrayList<Student> getStudents() {
        return students;
    }
    public static Student getStudentUsingName(String fname, String lname){
        for(Student i : students){
            if(fname.equals(i.getFirstName()) && lname.equals(i.getLastName())){
                return i;
            }
        }
        return null;
    }
}