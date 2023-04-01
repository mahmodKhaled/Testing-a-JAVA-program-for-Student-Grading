package Tests;
import org.junit.Test;
import static org.junit.Assert.*;
import main.Grade;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeTests {
    /*
     * Test the Grade class
     * Methods to test:
     * calculate_grade(ArrayList<Integer> student_activities_marks, ArrayList<Integer> oral_practical_marks, ArrayList<Integer> midterm_exam_marks, ArrayList<Integer> final_exam_marks)
     * calculate_gpa(ArrayList<String> student_grades)
     * marks_to_grade(int studentMark)
     */

     // Test For calculate_gpa
    @Test
    public void testCalculateGPA() {
        Grade grade = new Grade();
        ArrayList<String> student_grades = new ArrayList<>();
        // add grades to the arraylist
        student_grades.add("A+");
        student_grades.add("A");
        student_grades.add("A-");
        student_grades.add("B+");
        student_grades.add("B");
        student_grades.add("B-");
        student_grades.add("C+");
        student_grades.add("C");
        student_grades.add("C-");
        student_grades.add("D+");
        student_grades.add("D");
        student_grades.add("F");
        // expected GPA
        ArrayList<Float> expectedGPA = new ArrayList<>();
        expectedGPA.add((float) 4);
        expectedGPA.add((float) 4);
        expectedGPA.add((float) 3.7);
        expectedGPA.add((float) 3.3);
        expectedGPA.add((float) 3);
        expectedGPA.add((float) 2.7);
        expectedGPA.add((float) 2.3);
        expectedGPA.add((float) 2);
        expectedGPA.add((float) 1.7);
        expectedGPA.add((float) 1.3);
        expectedGPA.add((float) 1);
        expectedGPA.add((float) 0);
        // actual GPA
        ArrayList<Float> actualGPA = grade.calculate_gpa(student_grades);
        // compare expected and actual GPA
        assertArrayEquals(expectedGPA.toArray(), actualGPA.toArray());

    }

    // Test For marks_to_grade
    // Test for A+
    @Test
    public void testMarksToGradeAPlus() {
        Grade grade = new Grade();
        int studentMark = 97;
        String expectedGrade = "A+";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }


    // Test for A
    @Test
    public void testMarksToGradeA() {
        Grade grade = new Grade();
        int studentMark = 93;
        String expectedGrade = "A";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }


    // Test for A-
    @Test
    public void testMarksToGradeAMinus() {
        Grade grade = new Grade();
        int studentMark = 89;
        String expectedGrade = "A-";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }

    // Test for B+
    @Test
    public void testMarksToGradeBPlus() {
        Grade grade = new Grade();
        int studentMark = 84;
        String expectedGrade = "B+";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }

    // Test for B
    @Test
    public void testMarksToGradeB() {
        Grade grade = new Grade();
        int studentMark = 80;
        String expectedGrade = "B";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }

    // Test for B-
    @Test
    public void testMarksToGradeBMinus() {
        Grade grade = new Grade();
        int studentMark = 76;
        String expectedGrade = "B-";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }

    // Test for C+
    @Test
    public void testMarksToGradeCPlus() {
        Grade grade = new Grade();
        int studentMark = 73;
        String expectedGrade = "C+";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }

    // Test for C
    @Test
    public void testMarksToGradeC() {
        Grade grade = new Grade();
        int studentMark = 70;
        String expectedGrade = "C";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }

    // Test for C-
    @Test
    public void testMarksToGradeCMinus() {
        Grade grade = new Grade();
        int studentMark = 67;
        String expectedGrade = "C-";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }

    // Test for D+
    @Test
    public void testMarksToGradeDPlus() {
        Grade grade = new Grade();
        int studentMark = 64;
        String expectedGrade = "D+";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }

    // Test for D
    @Test
    public void testMarksToGradeD() {
        Grade grade = new Grade();
        int studentMark = 60;
        String expectedGrade = "D";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }

    // Test for F
    @Test
    public void testMarksToGradeF() {
        Grade grade = new Grade();
        int studentMark = 50;
        String expectedGrade = "F";
        String actualGrade = grade.marks_to_grade(studentMark);
        assertEquals(expectedGrade, actualGrade);
    }
}
