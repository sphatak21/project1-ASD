import java.util.ArrayList;
public class Grade {
    private double numerator;
    private double denominator;
    public Grade (double numerator, double denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public double getNumerator() {
        return numerator;
    }
    public double getDenominator() {
        return denominator;
    }
    public static String GradetoString (ArrayList<Grade> grades){
        String s = "";
        for (int i = 0; i < grades.size(); i++){
            s += grades.get(i).getNumerator() + "/";
            s += grades.get(i).getDenominator() + "\n";
        }
        return s;
    }
}