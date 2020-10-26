import java.util.HashMap;
public class Data {
    private static HashMap <String, User> users = new HashMap<>();
    public static void init(){
        users.put("sphatak21", new Student("sphatak21", "Sidd", "Phatak","Password"));
        users.put("rwilson", new Teacher("rwilson", "Ryan", "Wilson", "APCSA", "Computer Science"));
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
    /*public static void assignUsers(){
        for(String i : users.keySet()){
            if(User.isStudent(i)){
                students.add((Student) users.get(i));
            }else{
                teachers.add((Teacher) users.get(i));
            }
        }
    }*/

}