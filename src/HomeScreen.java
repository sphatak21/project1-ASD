import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends Frame implements ActionListener {
    Frame home;
    User currentUser;
    String currentUsername;
    public static int frameWidth;
    public static int frameHeight;
    public HomeScreen(User currentUser, int frameWidth, int frameHeight) {
        this.currentUser = currentUser;
        this.currentUsername = currentUser.getUsername();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.home = new Frame("Home");
        if(User.isStudent(currentUsername)){
            StudentPanel panel = new StudentPanel(currentUser);
            panel.setSize(frameWidth, frameHeight);
            add(panel);
        }else{
            System.out.print("teacher");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
