public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    public User(String username, String firstName, String lastName, String password){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public static boolean checkPassword(String username, String password){
        User currentUser = Data.getUser(username);
        if(currentUser.password.equals(password)){
            return true;
        }
        return false;
    }
    public static boolean isStudent(String username) {
            int num = -1;
            for(int i = 0; i < username.length(); i++){
                try {
                    num = Integer.parseInt(Character.toString(username.charAt(i)));
                } catch (Exception e) {
                    num = -1;
                }
            }
            if (num >= 0){
                return true;
            }else{
                return false;
            }
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}