import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class StudentPanel extends Panel implements ActionListener {
    Panel studentGrades;
    Panel info;
    Label profileLink;
    Label firstName;
    Label lastName;
    Label username;
    JTable studentGradesTable;
    public StudentPanel(User user){
        GridLayout infoGrid = new GridLayout(0,4);
        profileLink = new Label("Profile");
        firstName = new Label("First Name: " + user.getFirstName());
        lastName = new Label("Last Name: " + user.getLastName());
        username = new Label("Username: " + user.getUsername());
        Label[] topInfo = new Label[]{profileLink, firstName, lastName, username};

        info = new Panel();
        info.setSize(HomeScreen.frameWidth, HomeScreen.frameHeight/4);
        for(Label i : topInfo){
            info.add(i);
        }
        info.setLayout(infoGrid);
        add(info);

        studentGrades = new Panel();

        String[] columnNames = new String[]{"Subjects", "Teachers", "Grades"};
        Student student = (Student) user;
        HashMap<String, ArrayList<Grade>> studentGrades = student.getSubjectGrades();

        for(String i : studentGrades.keySet()){
            ArrayList<Grade> grades = studentGrades.get(i);
            for(int j = 0; j < grades.size(); j++){
                Grade grade = grades.get(j);
                grade.getDenominators();
                grade.getNumerators();
            }
        }






    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
