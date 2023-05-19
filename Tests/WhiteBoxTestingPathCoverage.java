package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Grade;
import java.util.ArrayList;
import main.SubjectData;


public class WhiteBoxTestingPathCoverage {

    @Test
    public void testGradeConversion_APlus() {
        Grade grade = new Grade();
        assertEquals("A+", grade.marks_to_grade(97));
    }

    @Test
    public void testGradeConversion_A() {
        Grade grade = new Grade();
        assertEquals("A", grade.marks_to_grade(93));
    }

    @Test
    public void testGradeConversion_AMinus() {
        Grade grade = new Grade();
        assertEquals("A-", grade.marks_to_grade(89));
    }

    @Test
    public void testGradeConversion_BPlus() {
        Grade grade = new Grade();
        assertEquals("B+", grade.marks_to_grade(84));
    }

    @Test
    public void testGradeConversion_B() {
        Grade grade = new Grade();
        assertEquals("B", grade.marks_to_grade(80));
    }

    @Test
    public void testGradeConversion_BMinus() {
        Grade grade = new Grade();
        assertEquals("B-", grade.marks_to_grade(76));
    }

    @Test
    public void testGradeConversion_CPlus() {
        Grade grade = new Grade();
        assertEquals("C+", grade.marks_to_grade(73));
    }

    @Test
    public void testGradeConversion_C() {
        Grade grade = new Grade();
        assertEquals("C", grade.marks_to_grade(70));
    }

    @Test
    public void testGradeConversion_CMinus() {
        Grade grade = new Grade();
        assertEquals("C-", grade.marks_to_grade(67));
    }

    @Test
    public void testGradeConversion_DPlus() {
        Grade grade = new Grade();
        assertEquals("D+", grade.marks_to_grade(64));
    }

    @Test
    public void testGradeConversion_D() {
        Grade grade = new Grade();
        assertEquals("D", grade.marks_to_grade(60));
    }

    @Test
    public void testGradeConversion_F() {
        Grade grade = new Grade();
        assertEquals("F", grade.marks_to_grade(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGradeConversion_NegativeMark() {
        Grade grade = new Grade();
        grade.marks_to_grade(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGradeConversion_MarkGreaterThan100() {
        Grade grade = new Grade();
        grade.marks_to_grade(101);
    }
}
