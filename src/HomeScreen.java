import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class HomeScreen extends Frame implements WindowListener, ActionListener {
    Frame home;
    User currentUser;
    String currentUsername;
    Panel info;
    Label profileLink;
    Label firstName;
    Label lastName;
    Label username;
    Button logoutButton;
    public static int frameWidth;
    public static int frameHeight;
    public HomeScreen(User currentUser, int frameWidth, int frameHeight) {
        this.currentUser = currentUser;
        this.currentUsername = currentUser.getUsername();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.home = new Frame("Home");

        GridLayout infoGrid = new GridLayout(0,4);
        profileLink = new Label("Profile");
        firstName = new Label("First Name: " + currentUser.getFirstName());
        lastName = new Label("Last Name: " + currentUser.getLastName());
        username = new Label("Username: " + currentUser.getUsername());

        Label[] topInfo = new Label[]{profileLink, firstName, lastName, username};

        info = new Panel();
        info.setSize(frameWidth, frameHeight/10);
        for(Label i : topInfo){
            info.add(i);
        }
        info.setLayout(infoGrid);
        add(info);
        logoutButton = new Button("Log Out");
        logoutButton.addActionListener(this);
        if(User.isStudent(currentUsername)){
            StudentPanel panel = new StudentPanel(currentUser);
            panel.setSize(frameWidth, frameHeight);
            panel.add(logoutButton);
            add(panel);
        }else{
            TeacherPanel panel = new TeacherPanel(currentUser);
            panel.setSize(frameWidth, frameHeight);
            panel.add(logoutButton);
            add(panel);
        }


        this.addWindowListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        Login project = new Login();
        project.setSize(500,500);
        project.setVisible(true);
    }
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
}
