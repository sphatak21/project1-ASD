import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class StudentPanel extends Panel {
    Panel studentGradesPanel;
    public StudentPanel(User user){
        studentGradesPanel = new Panel();
        studentGradesPanel.setSize(HomeScreen.frameWidth, 3*HomeScreen.frameHeight/4);

        String[] columnNames = new String[]{"Subjects", "Teachers", "Grades"};
        Student student = (Student) user;
        HashMap<String, ArrayList<Grade>> studentGrades = student.getSubjectGrades();
        String[][] rowData = new String[studentGrades.size()][3];
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
                rowData[count][2] = 0 + "%";
            }else{
                rowData[count][2] = String.format("%.2f", 100 * num / dem) + "%";
            }
            count++;
        }
        JTable table = new JTable(rowData, columnNames){@Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }};
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(table.getSelectedRow() != -1){
                    String a = table.getValueAt(table.getSelectedRow(), 0).toString();
                    ArrayList<Grade> grades = student.getOneSubjectGrades(a);
                    JOptionPane.showMessageDialog(null, Grade.GradetoString(grades));

                }
            }
        });
        table.setBounds(0, HomeScreen.frameHeight/4, HomeScreen.frameWidth, HomeScreen.frameHeight/2);
        JScrollPane sp = new JScrollPane(table);
        studentGradesPanel.add(sp);
        studentGradesPanel.add(table);
        studentGradesPanel.setLayout(null);
        add(studentGradesPanel);
    }
}
