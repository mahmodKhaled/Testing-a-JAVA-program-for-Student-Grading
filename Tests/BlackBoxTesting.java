package Tests;

import org.junit.Test;
import static org.junit.Assert.*;

import main.Grade;
import java.util.ArrayList;
import main.SubjectData;

public class BlackBoxTesting {
    /*
        Requirements:
        1. Subject name: It must be Alphabetic characters and Spaces. the name should not start with space
        2. Subject-code: It must be 6-7 Alphanumeric characters. The first 3 are Alphabetic followed by 3 numeric characters. The sevens should be s if exists.
        3. Full mark: It is a numeric number of the value: 100
        4. Student name: It must be Alphabetic characters and Spaces. the name should not start with space.
        5. Student number: the length of this field must be Alphanumeric characters of exact length of 8 characters. It should start with numbers and might End with only one alphabetic character
        6. Student Activities mark: It is an integer of a value from 0 up to 10 of the full mark
        7. Oral/Practical mark: It is an integer of a value from 0 up to 10 of the full mark
        8. Midterm exam mark: It is an integer of a value from 0 up to 20 of the full mark
        9. Final exam mark: It is an integer of a value from 0 up to 60 of the full mark
    */
    
    // Boundary Value Analysis
    // 1. Subject name: Test with 0 characters
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_name_starting_with_space(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("", "CSE220", "100");
        assertArrayEquals(null, subject_data_array);
    }

    // 2. Subject-code: Test with 5 characters
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_code_with_5_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Testing", "CSE22", "100");
        assertArrayEquals(null, subject_data_array);
    }

    // 2. Subject-code: Test with 8 characters
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_code_with_8_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Testing", "CSECSE45", "100");
        assertArrayEquals(null, subject_data_array);
    }

    // 2. Subject-code: Test with 7 characters
    @Test
    public void test_validate_subject_data_code_with_7_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Testing", "CSE220", "100");
        assertArrayEquals(new String[]{"Testing", "CSE220", "100"}, subject_data_array);
    }

    // 3. Full mark: Test with 99
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_full_mark_with_99(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Testing", "CSE220", "99");
        assertArrayEquals(null, subject_data_array);
    }

    // 3. Full mark: Test with 101
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_full_mark_with_101(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Testing", "CSE220", "101");
        assertArrayEquals(null, subject_data_array);
    }

    // 3. Full mark: Test with 100
    @Test
    public void test_validate_subject_data_full_mark_with_100(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Testing", "CSE220", "100");
        assertArrayEquals(new String[]{"Testing", "CSE220", "100"}, subject_data_array);
    }


    // 4. Student name: Test with 0 characters
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_name_with_0_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("", "12345678", "10", "10", "10", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 4. Student name: Test with 1 characters
    @Test
    public void test_validate_student_data_name_with_1_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("T", "12345678", "10", "10", "10", "10");
        assertArrayEquals(new String[]{"T", "12345678", "10", "10", "10", "10"}, subject_data_array);
    }

    // 5. Student number: Test with 7 characters
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_number_with_7_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "1234567", "10", "10", "10", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 5. Student number: Test with 9 characters
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_number_with_9_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "123456789", "10", "10", "10", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 5. Student number: Test with 8 characters
    @Test
    public void test_validate_student_data_number_with_8_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "10", "10"}, subject_data_array);
    }

    // 5. Student number: Test with 8 characters and last 2 characters are alphabetic
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_number_with_8_characters_and_last_2_characters_are_alphabetic(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "123456AA", "10", "10", "10", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 5. Student number: Test with 8 characters and last 1 character is alphabetic
    @Test
    public void test_validate_student_data_number_with_8_characters_and_last_1_character_is_alphabetic(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "1234567A", "10", "10", "10", "10");
        assertArrayEquals(new String[]{"Testing", "1234567A", "10", "10", "10", "10"}, subject_data_array);
    }

    // 6. Student Activities mark with -1
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_activities_mark_with_minus_1(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "-1", "10", "10", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 6. Student Activities mark with 0
    @Test
    public void test_validate_student_data_activities_mark_with_0(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "0", "10", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "0", "10", "10", "10"}, subject_data_array);
    }

    // 6. Student Activities mark with 1 
    @Test
    public void test_validate_student_data_activities_mark_with_1(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "1", "10", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "1", "10", "10", "10"}, subject_data_array);
    }

    // 6. Student Activities mark with 5
    @Test
    public void test_validate_student_data_activities_mark_with_5(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "5", "10", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "5", "10", "10", "10"}, subject_data_array);
    }

    // 6. Student Activities mark with 9
    @Test
    public void test_validate_student_data_activities_mark_with_9(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "9", "10", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "9", "10", "10", "10"}, subject_data_array);
    }

    // 6. Student Activities mark with 10
    @Test
    public void test_validate_student_data_activities_mark_with_10(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "10", "10"}, subject_data_array);
    }

    // 6. Student Activities mark with 11
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_activities_mark_with_11(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "11", "10", "10", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 7. oral mark with -1
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_oral_mark_with_minus_1(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "-1", "10", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 7. oral mark with 0
    @Test
    public void test_validate_student_data_oral_mark_with_0(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "0", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "0", "10", "10"}, subject_data_array);
    }

    // 7. oral mark with 1
    @Test
    public void test_validate_student_data_oral_mark_with_1(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "1", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "1", "10", "10"}, subject_data_array);
    }

    // 7. oral mark with 5
    @Test
    public void test_validate_student_data_oral_mark_with_5(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "5", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "5", "10", "10"}, subject_data_array);
    }

    // 7. oral mark with 9
    @Test
    public void test_validate_student_data_oral_mark_with_9(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "9", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "9", "10", "10"}, subject_data_array);
    }

    // 7. oral mark with 10
    @Test
    public void test_validate_student_data_oral_mark_with_10(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "10", "10"}, subject_data_array);
    }

    // 7. oral mark with 11
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_oral_mark_with_11(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "11", "10", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 8. midterm mark with -1
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_midterm_mark_with_minus_1(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "-1", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 8. midterm mark with 0
    @Test
    public void test_validate_student_data_midterm_mark_with_0(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "0", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "0", "10"}, subject_data_array);
    }

    // 8. midterm mark with 1
    @Test
    public void test_validate_student_data_midterm_mark_with_1(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "1", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "1", "10"}, subject_data_array);
    }

    // 8. midterm mark with 10
    @Test
    public void test_validate_student_data_midterm_mark_with_10(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "10", "10"}, subject_data_array);
    }

    // 8. midterm mark with 19
    @Test
    public void test_validate_student_data_midterm_mark_with_19(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "19", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "19", "10"}, subject_data_array);
    }

    // 8. midterm mark with 20
    @Test
    public void test_validate_student_data_midterm_mark_with_20(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "20", "10");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "20", "10"}, subject_data_array);
    }

    // 8. midterm mark with 21
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_midterm_mark_with_21(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "21", "10");
        assertArrayEquals(null, subject_data_array);
    }

    // 9. final mark with -1
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_final_mark_with_minus_1(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "-1");
        assertArrayEquals(null, subject_data_array);
    }

    // 9. final mark with 0
    @Test
    public void test_validate_student_data_final_mark_with_0(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "0");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "10", "0"}, subject_data_array);
    }

    // 9. final mark with 1
    @Test
    public void test_validate_student_data_final_mark_with_1(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "1", "10", "10", "1");
        assertArrayEquals(new String[]{"Testing", "12345678", "1", "10", "10", "1"}, subject_data_array);
    }

    // 9. final mark with 30
    @Test
    public void test_validate_student_data_final_mark_with_50(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "30");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "10", "30"}, subject_data_array);
    }

    // 9. final mark with 59
    @Test
    public void test_validate_student_data_final_mark_with_59(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "59");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "10", "59"}, subject_data_array);
    }

    // 9. final mark with 60
    @Test
    public void test_validate_student_data_final_mark_with_60(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "60");
        assertArrayEquals(new String[]{"Testing", "12345678", "10", "10", "10", "60"}, subject_data_array);
    } 

    // 9. final mark with 61
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_final_mark_with_61(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_student_data("Testing", "12345678", "10", "10", "10", "61");
        assertArrayEquals(null, subject_data_array);
    }


    /*
     * Boundary Value Analysis of marks_to_grade method
     */



    
    // mark = 101 (invalid mark)
    @Test(expected = IllegalArgumentException.class)
    public void test_marks_to_grade_101(){
        Grade grade = new Grade();
        String actual_grade = grade.marks_to_grade(101);
        assertEquals(null, actual_grade);
    }
    

    // Teseting for A+ grade
    // 1. mark = 97, 98, 99, 100
    @Test
    public void test_marks_to_grade_A_plus(){
        Grade grade = new Grade();
        assertEquals("A+", grade.marks_to_grade(97));
        assertEquals("A+", grade.marks_to_grade(98));
        assertEquals("A+", grade.marks_to_grade(99));
        assertEquals("A+", grade.marks_to_grade(100));
        // Not A+ grade
        assertNotEquals("A+", grade.marks_to_grade(96));
    }



    // Teseting for A grade
    // 1. mark = 93, 94, 95, 96
    @Test
    public void test_marks_to_grade_A(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("A", grade.marks_to_grade(93));
        assertEquals("A", grade.marks_to_grade(94));
        assertEquals("A", grade.marks_to_grade(95));
        assertEquals("A", grade.marks_to_grade(96));

        // Not A grade
        assertNotEquals("A", grade.marks_to_grade(92));
        assertNotEquals("A", grade.marks_to_grade(97));
    }

    // Teseting for A- grade
    // mark = 89, 90, 91, 92
    @Test
    public void test_marks_to_grade_A_minus(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("A-", grade.marks_to_grade(89));
        assertEquals("A-", grade.marks_to_grade(90));
        assertEquals("A-", grade.marks_to_grade(91));
        assertEquals("A-", grade.marks_to_grade(92));

        // Not A- grade
        assertNotEquals("A-", grade.marks_to_grade(88));
        assertNotEquals("A-", grade.marks_to_grade(93));
    }

    // Teseting for B+ grade
    // mark = 84, 85, 86, 87, 88
    @Test
    public void test_marks_to_grade_B_plus(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("B+", grade.marks_to_grade(84));
        assertEquals("B+", grade.marks_to_grade(85));
        assertEquals("B+", grade.marks_to_grade(86));
        assertEquals("B+", grade.marks_to_grade(87));
        assertEquals("B+", grade.marks_to_grade(88));

        // Not B+ grade
        assertNotEquals("B+", grade.marks_to_grade(83));
        assertNotEquals("B+", grade.marks_to_grade(89));
    }

    // Teseting for B grade
    // mark = 80, 81, 82, 83
    @Test
    public void test_marks_to_grade_B(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("B", grade.marks_to_grade(80));
        assertEquals("B", grade.marks_to_grade(81));
        assertEquals("B", grade.marks_to_grade(82));
        assertEquals("B", grade.marks_to_grade(83));

        // Not B grade
        assertNotEquals("B", grade.marks_to_grade(79));
        assertNotEquals("B", grade.marks_to_grade(84));
    }

    // Teseting for B- grade
    // mark = 76, 77, 78, 79
    @Test
    public void test_marks_to_grade_B_minus(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("B-", grade.marks_to_grade(76));
        assertEquals("B-", grade.marks_to_grade(77));
        assertEquals("B-", grade.marks_to_grade(78));
        assertEquals("B-", grade.marks_to_grade(79));

        // Not B- grade
        assertNotEquals("B-", grade.marks_to_grade(75));
        assertNotEquals("B-", grade.marks_to_grade(80));
    }

    // Teseting for C+ grade
    // mark = 73, 74, 75
    @Test
    public void test_marks_to_grade_C_plus(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("C+", grade.marks_to_grade(73));
        assertEquals("C+", grade.marks_to_grade(74));
        assertEquals("C+", grade.marks_to_grade(75));

        // Not C+ grade
        assertNotEquals("C+", grade.marks_to_grade(72));
        assertNotEquals("C+", grade.marks_to_grade(76));
    }

    // Teseting for C grade
    // mark = 70, 71, 72
    @Test
    public void test_marks_to_grade_C(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("C", grade.marks_to_grade(70));
        assertEquals("C", grade.marks_to_grade(71));
        assertEquals("C", grade.marks_to_grade(72));

        // Not C grade
        assertNotEquals("C", grade.marks_to_grade(69));
        assertNotEquals("C", grade.marks_to_grade(73));
    }

    // Teseting for C- grade
    // mark = 67, 68, 69
    @Test
    public void test_marks_to_grade_C_minus(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("C-", grade.marks_to_grade(67));
        assertEquals("C-", grade.marks_to_grade(68));
        assertEquals("C-", grade.marks_to_grade(69));

        // Not C- grade
        assertNotEquals("C-", grade.marks_to_grade(66));
        assertNotEquals("C-", grade.marks_to_grade(70));
    }

    // Teseting for D+ grade
    // mark = 64, 65, 66
    @Test
    public void test_marks_to_grade_D_plus(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("D+", grade.marks_to_grade(64));
        assertEquals("D+", grade.marks_to_grade(65));
        assertEquals("D+", grade.marks_to_grade(66));

        // Not D+ grade
        assertNotEquals("D+", grade.marks_to_grade(63));
        assertNotEquals("D+", grade.marks_to_grade(67));
    }

    // Teseting for D grade
    // mark = 60, 61, 62, 63
    @Test
    public void test_marks_to_grade_D(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("D", grade.marks_to_grade(60));
        assertEquals("D", grade.marks_to_grade(61));
        assertEquals("D", grade.marks_to_grade(62));
        assertEquals("D", grade.marks_to_grade(63));

        // Not D grade
        assertNotEquals("D", grade.marks_to_grade(59));
        assertNotEquals("D", grade.marks_to_grade(64));
    }

    // Teseting for F grade
    // mark = 0, 1, 30, 58,59
    @Test
    public void test_marks_to_grade_F(){
        Grade grade = new Grade();
        // array of marks
        assertEquals("F", grade.marks_to_grade(0));
        assertEquals("F", grade.marks_to_grade(1));
        assertEquals("F", grade.marks_to_grade(30));
        assertEquals("F", grade.marks_to_grade(58));
        assertEquals("F", grade.marks_to_grade(59));

        // Not F grade
        assertNotEquals("F", grade.marks_to_grade(60));
    }

    // Teseting for Invalid grade < 0
    // mark = -1
    @Test(expected = IllegalArgumentException.class)
    public void test_marks_to_grade_negative(){
        Grade grade = new Grade();
        String actual_grade = grade.marks_to_grade(-1);
        assertEquals(null, actual_grade);
    }
   

}

