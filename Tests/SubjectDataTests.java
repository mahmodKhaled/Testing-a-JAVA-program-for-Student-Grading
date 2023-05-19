package Tests;
import org.junit.Test;
import static org.junit.Assert.*;
import main.SubjectData;




public class SubjectDataTests {
    /*
        Requirements:
        1. Subject name: It must be Alphabetic characters and Spaces. the name should not start with space
        2. Subject-code: It must be 6-7 Alphanumeric characters. The first 3 are Alphabetic followed by 3 numeric characters. The sevens should be s if exists.
        3. Full mark: It is a numeric number of the value: 100
        4. Student name: It must be Alphabetic characters and Spaces. the name should not start with space.
        5. Student number: the length of this field must be Alphanumeric characters of exact length of 8 characters. It should start with numbers and might End with only oneAlphabetic character
        6. Student Activities mark: It is an integer of a value from 0 up to 10 of the full mark
        7. Oral/Practical mark: It is an integer of a value from 0 up to 10 of the full mark
        8. Midterm exam mark: It is an integer of a value from 0 up to 20 of the full mark
        9. Final exam mark: It is an integer of a value from 0 up to 60 of the full mark
    */
    
    /*
    * Test cases for SubjectData.java
    Methods:
    1. validate_subject_data(String subject_name, String subject_code, String full_mark)
    2. validate_subject_data(String student_name, String student_number, String student_activities_mark, String oral_practical_mark, String midterm_exam_mark, String final_exam_mark)
    3. 
     */
    

    // Requirement 1 Name with spaces
    @Test 
    public void test_validate_subject_data(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "CSE220", "100");
        String[] expected_data = {"Data Structures", "CSE220", "100"};
        assertArrayEquals(expected_data, subject_data_array);
    }

    // Requirement 1 Name starting with space
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_name_starting_with_space(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data(" Data Structures", "CSE220", "100");
        assertArrayEquals(null, subject_data_array);
    }

    // Requirement 1 Name with numbers
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_name_with_numbers(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures 220", "CSE220", "100");
        assertArrayEquals(null, subject_data_array);
    }

    
    // Requirement 2 Subject code with 7 characters and s
    @Test
    public void test_validate_subject_data_subject_code_with_7_characters_and_s(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "CSE220s", "100");
        String[] expected_data = {"Data Structures", "CSE220s", "100"};
        assertArrayEquals(expected_data, subject_data_array);
    }

    // Requirement 2 Subject code with 7 characters and no s
    // it should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_subject_code_with_7_characters_and_no_s(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "CSE2201", "100");
        assertArrayEquals(null, subject_data_array);
    }
    
    
    // Requirement 2 Subject code with 5 characters
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_subject_code_with_5_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "CSE22", "100");
        assertArrayEquals(null, subject_data_array);
    }

    // Requirement 2 Subject code with 8 characters
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_subject_code_with_8_characters(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "CSE2201", "100");
        assertArrayEquals(null, subject_data_array);
    }

    // Requirement 2 Subject code srarting with numbers
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_subject_code_starting_with_numbers(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "220CSE", "100");
        assertArrayEquals(null, subject_data_array);
    }

    // Requirement 2 Subject code with no numbers
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_subject_code_with_no_numbers(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "CSECSE", "100");
        assertArrayEquals(null, subject_data_array);
    }


    // Requirement 3 Full mark with 99
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_full_mark_with_99(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "CSE220", "99");
        assertArrayEquals(null, subject_data_array);
    }

    // Requirement 3 Full mark with 101
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_full_mark_with_101(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "CSE220", "101");
        assertArrayEquals(null, subject_data_array);
    }

    // Requirement 3 Full mark with "Hundred"
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_subject_data_full_mark_with_hundred(){
        SubjectData subject_data = new SubjectData();
        String[] subject_data_array = subject_data.validate_subject_data("Data Structures", "CSE220", "Hundred");
        assertArrayEquals(null, subject_data_array);
    }

    // Requirement 4 Student name with spaces
    @Test
    public void test_validate_student_data(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "10", "10", "10", "10");
        String[] expected_data = {"Eren Yeager", "20180001", "10","10","10","10"};
        assertArrayEquals(expected_data, student_data_array);
    }

    // Requirement 4 Student name starting with space
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_name_starting_with_space(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data(" Eren Yeager", "20180001", "10", "10", "10", "10");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 4 Student name with numbers
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_name_with_numbers(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager 1", "20180001", "10", "10", "10", "10");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 5 Student ID with 7 characters
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_id_with_7_characters(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "2018000", "10", "10", "10", "10");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 5 Student ID with 9 characters
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_id_with_9_characters(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "201800001", "10", "10", "10", "10");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 5 Student ID starting with n
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_id_starting_with_n(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "n0180001", "10", "10", "10", "10");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 5 Student ID 8 length ending with n
    @Test
    public void test_validate_student_data_id_ending_with_n(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "2018000n", "10", "10", "10", "10");
        String[] expected_data = {"Eren Yeager", "2018000n", "10","10","10","10"};
        assertArrayEquals(expected_data, student_data_array);
    }


    // Requirement 5 Student ID 8 length ending with nn
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_id_ending_with_nn(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "201800nn", "10", "10", "10", "10");
        assertArrayEquals(null, student_data_array);
    }


    /*
     * Requirement 6,7,8,9
     * student_activity_mark with 0
     * oral_practical_mark with 0
     * midterm_exam_mark with 0
     * final_exam_mark with 0
     */
    @Test
    public void test_validate_student_data_marks_with_0(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "0", "0", "0", "0");
        String[] expected_data = {"Eren Yeager", "20180001", "0","0","0","0"};
        assertArrayEquals(expected_data, student_data_array);
    }

    /*
     * Requirement 6,7,8,9
     * student_activity_mark with 10
     * oral_practical_mark with 10
     * midterm_exam_mark with 20
     * final_exam_mark with 60
     */
    @Test
    public void test_validate_student_data_marks_with_10_10_20_60(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "10", "10", "20", "60");
        String[] expected_data = {"Eren Yeager", "20180001", "10","10","20","60"};
        assertArrayEquals(expected_data, student_data_array);
    }


    // Requirement 6 student_activity_mark with 11
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_student_activity_mark_with_11(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "11", "10", "20", "60");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 6 student_activity_mark with -1
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_student_activity_mark_with_minus_1(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "-1", "10", "20", "60");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 7 oral_practical_mark with 11
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_oral_practical_mark_with_11(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "10", "11", "20", "60");
        assertArrayEquals(null, student_data_array);
    }


    // Requirement 7 oral_practical_mark with -1
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_oral_practical_mark_with_minus_1(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "10", "-1", "20", "60");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 8 midterm_exam_mark with 21
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_midterm_exam_mark_with_21(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "10", "10", "21", "60");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 8 midterm_exam_mark with -1
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_midterm_exam_mark_with_minus_1(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "10", "10", "-1", "60");
        assertArrayEquals(null, student_data_array);
    }

    // Requirement 9 final_exam_mark with 61
    // It should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_validate_student_data_final_exam_mark_with_61(){
        SubjectData subject_data = new SubjectData();
        String[] student_data_array = subject_data.validate_student_data("Eren Yeager", "20180001", "10", "10", "20", "61");
        assertArrayEquals(null, student_data_array);
    }


}
