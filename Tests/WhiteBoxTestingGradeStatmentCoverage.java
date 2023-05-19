package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Grade;
import java.util.ArrayList;
import main.SubjectData;

public class WhiteBoxTestingGradeStatmentCoverage {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
    @Test
    /* *******************************************************************************************************/
    
    /* **************************Statment coverage for marks_to_grade function **************************** */
    
    /* ******************************************************************************************************/
    public void testAPlusGrade() {
        Grade grade = new Grade();
        String student_grade = grade.marks_to_grade(100);
        assertEquals("A+", student_grade);
    }

    @Test
    public void testAGrade() {
        Grade grade = new Grade();
        String student_grade = grade.marks_to_grade(93);
        assertEquals("A", student_grade);
    }

    @Test
    public void testBPlusGrade() {
        Grade grade = new Grade();
        String student_grade = grade.marks_to_grade(85);
        assertEquals("B+", student_grade);
    }

    @Test
    public void testBGrade() {
        Grade grade = new Grade();
        String student_grade = grade.marks_to_grade(82);
        assertEquals("B", student_grade);
    }

    @Test
    public void testCMinusGrade() {
        Grade grade = new Grade();
        String student_grade = grade.marks_to_grade(69);
        assertEquals("C-", student_grade);
    }

    @Test
    public void testDGrade() {
        Grade grade = new Grade();
        String student_grade = grade.marks_to_grade(61);
        assertEquals("D", student_grade);
    }

    @Test
    public void testFGrade() {
        Grade grade = new Grade();
        String student_grade = grade.marks_to_grade(30);
        assertEquals("F", student_grade);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputThrowsException() {
        Grade grade = new Grade();
        grade.marks_to_grade(110); // Input above the valid range should throw an exception
    }

    @Test
    public void testLowerBoundary() {
        Grade grade = new Grade();
        String student_grade = grade.marks_to_grade(0);
        assertEquals("F", student_grade);
    }

    @Test
    public void testUpperBoundary() {
        Grade grade = new Grade();
        String student_grade = grade.marks_to_grade(97);
        assertEquals("A+", student_grade);
    }

    
}

