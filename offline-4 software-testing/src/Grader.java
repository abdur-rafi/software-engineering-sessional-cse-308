import customExceptions.ExceedsTotalMarks;
import customExceptions.InvalidCredit;
import customExceptions.NegativeMark;
import customExceptions.NonNumberInput;

public class Grader {

    public static String calcGrade(String mark_, String credit_) throws NegativeMark, ExceedsTotalMarks, InvalidCredit, NonNumberInput {

        double mark;
        double credit;

        try {
            mark = Double.parseDouble(mark_);
        } catch (Exception e){
            throw new NonNumberInput("mark should be a number");
        }

        try{
            credit = Integer.parseInt(credit_);
        } catch (Exception e){
            throw new NonNumberInput("credit should be a number");
        }

        if(mark < 0){
            throw new NegativeMark("Mark cannot be negative");
        }
        else if(mark > 400){
            throw new ExceedsTotalMarks("Mark exceeds total available marks");
        }
        int grade = (int) Math.ceil(mark);
        if(credit != 3 && credit != 4){
            throw new InvalidCredit("credit must be 3 or 4 ");
        }
        if(credit == 3){
            if(grade >= 240) return "A";
            if(grade >= 210) return "B";
            if(grade >= 180) return "C";
            return "F";
        }
        else {
            if(grade >= 320) return "A";
            if(grade >= 280) return "B";
            if(grade >= 240) return "C";
            return "F";
        }
    }
}
