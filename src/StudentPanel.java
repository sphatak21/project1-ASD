import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentPanel extends Panel implements ActionListener {
    Panel studentGradesPanel;
    public StudentPanel(User user){
        studentGradesPanel = new Panel();
        studentGradesPanel.setSize(HomeScreen.frameWidth, 3*HomeScreen.frameHeight/4);

        String[] columnNames = new String[]{"Subjects", "Teachers", "Grades"};
        Student student = (Student) user;
        HashMap<String, ArrayList<Grade>> studentGrades = student.getSubjectGrades();


        String[][] rowData = new String[studentGrades.size()][3];
        double finalGrade = 0;
        int count = 0;
        for(String i : studentGrades.keySet()){
            double num = 0;
            double dem = 0;
            for(int j = 0; j < studentGrades.get(i).size(); j ++){
                num += studentGrades.get(i).get(j).getNumerator();
                dem += studentGrades.get(i).get(j).getDenominator();
            }
            rowData[count][0] = i;
            rowData[count][1] = Data.getUserUsingSubject(i).getFirstName() + " " + Data.getUserUsingSubject(i).getLastName();
            if(Double.isNaN((100 * num / dem))){
                rowData[count][2] = String.valueOf(0) + "%";
            }else{
                rowData[count][2] = String.valueOf(100 * num / dem) + "%";
            }
            count++;
        }
        JTable table = new JTable(rowData, columnNames){@Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }};
        table.setBounds(0, HomeScreen.frameHeight/4, HomeScreen.frameWidth, HomeScreen.frameHeight/2);
        JScrollPane sp = new JScrollPane(table);
        studentGradesPanel.add(sp);
        studentGradesPanel.add(table);
        studentGradesPanel.setLayout(null);
        add(studentGradesPanel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
