import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionListener;

public class Login extends Frame implements WindowListener, ActionListener {
    Label usernameLabel = new Label("Enter your username:");
    Label passwordLabel = new Label("Enter your password:");
    TextField username = new TextField();
    JPasswordField password = new JPasswordField();
    Button loginButton;
    private static int projectWidth = 500;
    private static int projectHeight = 500;
    static Login project = new Login();

    public static void main(String[] args){
        Data.init();
        project.setSize(projectWidth, projectHeight);
        project.setVisible(true);

    }

    public Login() {

        usernameLabel.setBounds(projectWidth/5, 4*projectHeight/10, 150, 25);
        passwordLabel.setBounds(usernameLabel.getX(), usernameLabel.getY()+ 50, 150, 25);
        username.setBounds(usernameLabel.getX() + 150, usernameLabel.getY(), 150, 25);
        password.setBounds(passwordLabel.getX() + 150, passwordLabel.getY(), 150, 25);

        loginButton = new Button("Login");
        loginButton.setBounds(200,300,100, 40);
        loginButton.addActionListener(this);

        add(usernameLabel);
        add(passwordLabel);
        add(username);
        add(password);
        add(loginButton);
        this.addWindowListener(this);
        setLayout(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String usernameStr = username.getText();
        String passwordStr = password.getText();
        boolean usernameValid = Data.checkUsername(usernameStr);
        if(usernameValid){
            boolean passwordValid = Data.checkPassword(usernameStr, passwordStr);
            if(passwordValid){
                User currentUser = Data.getUser(usernameStr);
                login(currentUser);
            }else{
                username.setText("Incorrect Password");
                password.setText("");
            }
        }else {
            username.setText("Incorrect Username");
            password.setText("");
        }
    }
    public void login(User currentUser){
        project.dispose();
        HomeScreen homeScreen = new HomeScreen(currentUser, 600, 600);
        homeScreen.setSize(600,600);
        homeScreen.setVisible(true);
    }

    @Override public void windowOpened(WindowEvent e) {

    }
    @Override public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    @Override public void windowClosed(WindowEvent e) {

    }
    @Override public void windowIconified(WindowEvent e) {

    }
    @Override public void windowDeiconified(WindowEvent e) {

    }
    @Override public void windowActivated(WindowEvent e) {

    }
    @Override public void windowDeactivated(WindowEvent e) {

    }
}
