public class Teacher extends User{
    private String subject;
    public Teacher(String username, String firstName, String lastName, String password, String subject){
        super(username, firstName,  lastName, password);
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }
}
