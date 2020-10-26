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

    static Login project = new Login();

    public static void main(String[] args){
        project.setSize(500,500);
        project.setVisible(true);

    }

    public Login() {
        Data.init();
        usernameLabel.setBounds(100, 200, 150, 25);
        passwordLabel.setBounds(100, 250, 150, 25);
        username.setBounds(250, 200, 150, 25);
        password.setBounds(250, 250, 150, 25);

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
                loadLoginScreen(currentUser);
            }
        }
    }
    public void loadLoginScreen(User currentUser){
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
