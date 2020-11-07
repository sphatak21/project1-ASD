import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class TeacherPanel extends Panel implements TableModelListener {
    Panel StudentList;
    JTable table;
    Button addGrade;
    double numerator;
    double denominator;
    Teacher teacher;
    public TeacherPanel(User user){
        addGrade = new Button("Add Grade");
        teacher = (Teacher) user;
        displayTable();
    }
    public Object GetData(JTable table, int row_index, int col_index){
        return table.getModel().getValueAt(row_index, col_index);
    }
    public void tableChanged(TableModelEvent e){
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == 2){
                numerator = setVal(row, column, e);
            }else if (column == 4){
                denominator = setVal(row, column, e);
            }
            if(numerator >= 0 && denominator > 0){
                String name  = GetData(table, row, 0).toString();
                String[] arr = name.split(" ");
                Student s = Data.getStudentUsingName(arr[0], arr[1]);
                s.setSubjectGrade(teacher.getSubject(), numerator, denominator);
                remove(StudentList);
                numerator = -1;
                denominator = -1;
                displayTable();
            }
        }
        public Double setVal(int r, int c, TableModelEvent e){
            String object = GetData(table, r, c).toString();
            double num;
            try {
                num = Double.parseDouble(object);
            }catch (NumberFormatException er){
                num = -1;
            }
            return num;
        }
        public void displayTable(){
            StudentList = new Panel();
            StudentList.setSize(HomeScreen.frameWidth, 3*HomeScreen.frameHeight/4);
            ArrayList<Student> students = Data.getStudents();
            String[] columnNames = new String[]{"Name", "Grade", "Points Earned", "Divider", "Total"};
            String[][] data = new String[students.size()][5];
            int count = 0;
            for(Student i : students){
                double num = 0;
                double dem = 0;
                data[count][0] = i.getFirstName() + " " + i.getLastName();
                ArrayList<Grade> grades = i.getOneSubjectGrades(teacher.getSubject());
                for(Grade j : grades){
                    num += j.getNumerator();
                    dem += j.getDenominator();
                }
                if(Double.isNaN((100 * num / dem))){
                    data[count][1] = 0 + "%";
                }else{
                    data[count][1] = String.format("%.2f", 100 * num / dem) + "%";
                }
                data[count][2] = "";
                data[count][3] = "/";
                data[count][4] = "";
                count++;
            }
            table = new JTable(data, columnNames) {@Override
                public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 4;
            }
            };
            table.getModel().addTableModelListener(this);
            table.setBounds(0, HomeScreen.frameHeight/4, HomeScreen.frameWidth, HomeScreen.frameHeight);
            StudentList.setLayout(null);
            StudentList.add(addGrade);
            StudentList.add(table);
            add(StudentList);
        }
}