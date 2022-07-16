import customExceptions.ExceedsTotalMarks;
import customExceptions.InvalidCredit;
import customExceptions.NegativeMark;
import customExceptions.NonNumberInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {

    @Test
    void testGradeA() {
        String mark = "300";
        try {
            assertEquals("A", Grader.calcGrade(mark, 3),"Test for A grade for 3 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for A grade for 3 credit course failed");
        }
        mark = "350";
        try {
            assertEquals("A", Grader.calcGrade(mark, 4),"Test for A grade for 4 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for A grade for 4 credit course failed");
        }
    }

    @Test
    void testGradeABoundary() {
        try {
            assertEquals("A", Grader.calcGrade("239.000001", 3),"Test for A grade on boundary values for 3 credit course failed");
            assertEquals("A", Grader.calcGrade("400", 3),"Test for A grade on boundary values for 3 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for A grade on boundary values for 3 credit course failed");
        }
        try {
            assertEquals("A", Grader.calcGrade("319.000001", 4),"Test for A grade on boundary values for 4 credit course failed");
            assertEquals("A", Grader.calcGrade("400", 4),"Test for A grade on boundary values for 4 credit course failed");

        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for A grade on boundary values for 4 credit course failed");
        }
    }

    @Test
    void testGradeB() {
        String mark = "230";
        try {
            assertEquals("B", Grader.calcGrade(mark, 3),"Test for B grade for 3 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for B grade for 3 credit course failed");
        }
        mark = "310";
        try {
            assertEquals("B", Grader.calcGrade(mark, 4),"Test for B grade for 4 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for B grade for 4 credit course failed");
        }
    }


    @Test
    void testGradeBBoundary() {
        try {
            assertEquals("B", Grader.calcGrade("209.000001", 3),"Test for B grade on boundary values for 3 credit course failed");
            assertEquals("B", Grader.calcGrade("239", 3),"Test for B grade on boundary values for 3 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for B grade on boundary values for 3 credit course failed");
        }
        try {
            assertEquals("B", Grader.calcGrade("279.000001", 4),"Test for B grade on boundary values for 4 credit course failed");
            assertEquals("B", Grader.calcGrade("319", 4),"Test for B grade on boundary values for 4 credit course failed");

        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for B grade on boundary values for 4 credit course failed");
        }
    }


    @Test
    void testGradeC() {
        String mark = "180";
        try {
            assertEquals("C", Grader.calcGrade(mark, 3),"Test for C grade for 3 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for C grade for 3 credit course failed");
        }
        mark = "270";
        try {
            assertEquals("C", Grader.calcGrade(mark, 4),"Test for C grade for 4 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for C grade for 4 credit course failed");
        }
    }

    @Test
    void testGradeCBoundary() {
        try {
            assertEquals("C", Grader.calcGrade("179.000001", 3),"Test for C grade on boundary values for 3 credit course failed");
            assertEquals("C", Grader.calcGrade("209", 3),"Test for C grade on boundary values for 3 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for C grade on boundary values for 3 credit course failed");
        }
        try {
            assertEquals("C", Grader.calcGrade("239.000001", 4),"Test for C grade on boundary values for 4 credit course failed");
            assertEquals("C", Grader.calcGrade("279", 4),"Test for C grade on boundary values for 4 credit course failed");

        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for C grade on boundary values for 4 credit course failed");
        }
    }


    @Test
    void testFGrade() {
        String mark = "170";
        try {
            assertEquals("F", Grader.calcGrade(mark, 3),"Test for F grade for 3 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for F grade for 3 credit course failed");
        }
        mark = "230";
        try {
            assertEquals("F", Grader.calcGrade(mark, 4),"Test for F grade for 4 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for F grade for 4 credit course failed");
        }
    }

    @Test
    void testGradeFBoundary() {
        try {
            assertEquals("F", Grader.calcGrade("0", 3),"Test for F grade on boundary values for 3 credit course failed");
            assertEquals("F", Grader.calcGrade("179", 3),"Test for F grade on boundary values for 3 credit course failed");
        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for F grade on boundary values for 3 credit course failed");
        }
        try {
            assertEquals("F", Grader.calcGrade("0", 4),"Test for F grade on boundary values for 4 credit course failed");
            assertEquals("F", Grader.calcGrade("239", 4),"Test for F grade on boundary values for 4 credit course failed");

        } catch (NegativeMark | ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
            exception.printStackTrace();
            fail("Test for F grade on boundary values for 4 credit course failed");
        }
    }


    @Test
    void testInvalidNumber() {
        boolean failed = true;
        try {
            Grader.calcGrade("-.000001", 3);
            Grader.calcGrade("-.000001", 4);

        }
        catch (NegativeMark negativeMark){
            failed = false;
        }
        catch ( ExceedsTotalMarks | InvalidCredit | NonNumberInput exception) {
        }
        if(failed)
            fail("Test for negative marks failed. Method did not throw proper exception");

        failed = true;

        try {
            Grader.calcGrade("400.000001", 3);
            Grader.calcGrade("400.000001", 4);

        }
        catch (ExceedsTotalMarks exceedsTotalMarks){
            failed = false;
        }
        catch (NegativeMark |  InvalidCredit | NonNumberInput exception) {
        }
        if(failed)
            fail("Test for more than total marks failed. Method did not throw proper exception");

    }

    @Test
    void testNonNumber() {
        boolean failed = true;
        try {
            Grader.calcGrade("400a.s", 3);

        }
        catch (NonNumberInput negativeMark){
            failed = false;
        }
        catch ( ExceedsTotalMarks | InvalidCredit | NegativeMark exception) {
        }
        if(failed)
            fail("Test for negative marks failed. Method did not throw proper exception");

    }


    @Test
    void testInvalidCredit(){
        boolean failed = true;
        try {
            Grader.calcGrade("100",5);
            Grader.calcGrade("100",0);
        } catch (NegativeMark | NonNumberInput | ExceedsTotalMarks negativeMark) {
//            negativeMark.printStackTrace();
        } catch (InvalidCredit invalidCredit) {
            failed = false;
        }
        if(failed)
            fail("Test for invalid credit failed. Method did not throw proper exception");

    }




}