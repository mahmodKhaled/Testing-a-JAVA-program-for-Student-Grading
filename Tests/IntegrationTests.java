package Tests;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import main.Grade;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import main.Grade;
import main.SubjectData;
import main.main;

public class IntegrationTests {
    private Grade grade;
    private SubjectData subjectData;
    private ByteArrayOutputStream baos;
    private ByteArrayInputStream bais;
    /*
     We will apply Bottom-Up integration testing to test the integration parts of the code that includes the folowing 
     structure:
     1. main
     |__ 2. load_data
        |__ 3. validate_subject_data
        |__ 4. validate_student_data
     |__ 5. calculate_grades
        |__ 6. marks_to_grades
     |__ 7. calculate_gpa
     |__ 8. generate_student_marks
     */

    @Before
    public void setUp(){
        grade = new Grade();
        subjectData = new SubjectData();
         bais = null;
        baos = new ByteArrayOutputStream();
        PrintStream print_stream = new PrintStream(baos);
        System.setOut(print_stream);
    }

    @Test
    public void marks_to_gradesTest(){
        ArrayList<Integer> marks = new ArrayList<Integer>(Arrays.asList(90, 80, 70, 60, 50, 40, 30, 20, 10, 0));
        ArrayList<String> expectedGrades = new ArrayList<String>(Arrays.asList("A-", "B", "C", "D", "F", "F", "F", "F", "F", "F"));
        ArrayList<String> actualGrades = new ArrayList<String>();
        for (int i = 0; i < marks.size(); i++){
            actualGrades.add(grade.marks_to_grade(marks.get(i)));
        }
        assertEquals(expectedGrades, actualGrades);
    }

    @Test
    public void validate_subject_dataTest(){
        String[] subject_data = new String[3];
        subject_data[0] = "Math";
        subject_data[1] = "MAT101";
        subject_data[2] = "100";
        String[] expected_data = subjectData.validate_subject_data("Math", "MAT101", "100");
        assertArrayEquals(expected_data, subject_data);
    }

    @Test
    public void validate_student_dataTest(){
        String[] student_data = new String[6];
        student_data[0] = "Ahmed";
        student_data[1] = "20170001";
        student_data[2] = "7";
        student_data[3] = "6";
        student_data[4] = "14";
        student_data[5] = "42";
        String[] expected_data = subjectData.validate_student_data("Ahmed", "20170001", "7", "6", "14", "42");
        assertArrayEquals(expected_data, student_data);
    }

    @Test
    public void calculate_gradesTest(){
        ArrayList<Integer> student_activites_marks = new ArrayList<Integer>(Arrays.asList(7, 6, 5, 9));
        ArrayList<Integer> oral_marks = new ArrayList<Integer>(Arrays.asList(10, 10, 10, 10));
        ArrayList<Integer> mid_marks = new ArrayList<Integer>(Arrays.asList(20, 20, 20, 20));
        ArrayList<Integer> final_marks = new ArrayList<Integer>(Arrays.asList(40, 35, 52, 44));
        ArrayList<String> expectedGrades = new ArrayList<String>(Arrays.asList("B-", "C", "B+", "B"));
        ArrayList<String> actualGrades = grade.calculate_grade(student_activites_marks, oral_marks, mid_marks, final_marks);
        assertEquals(expectedGrades, actualGrades);
    }

    @Test
    public void calculate_gpaTest(){
        ArrayList<String> grades = new ArrayList<String>(Arrays.asList("A-", "B", "C", "D", "F", "A", "C+", "C"));
        ArrayList<Float> expected_gpa = new ArrayList<Float>(Arrays.asList(3.7f, 3.0f, 2.0f, 1.0f, 0.0f, 4.0f, 2.3f, 2.0f));
        ArrayList<Float> actual_gpa = grade.calculate_gpa(grades);
        assertEquals(expected_gpa, actual_gpa);
    }

    @Test
    public void generate_student_marksTest(){
        String subject_name = "Math";
        int full_mark = 100;
        ArrayList<String> student_names = new ArrayList<String>(Arrays.asList("Ahmed", "Mohamed", "Ali"));
        ArrayList<String> students_numbers = new ArrayList<String>(Arrays.asList("20170001", "20170002", "20170003"));
        ArrayList<String> student_grades = new ArrayList<String>(Arrays.asList("A-", "B", "C"));
        ArrayList<Float> student_gpa = new ArrayList<Float>(Arrays.asList(3.7f, 3.0f, 2.0f));
        grade.generate_student_gradings(subject_name, full_mark, student_names, students_numbers, student_grades, student_gpa);
        String expected_output = "Successfully wrote to the file.";
        assertEquals(expected_output, baos.toString().trim());
    }

    @Test
    public void load_dataTest(){
        String file_name = "C:\\Users\\mahmo\\Desktop\\Testing-a-JAVA-program-for-Student-Grading\\src\\Example Data.txt";
        subjectData.load_data(file_name);
        ArrayList<Integer> student_activities_marks = subjectData.getStudentActivitiesMarks();
        ArrayList<Integer> oral_practical_marks = subjectData.getOralPracticalMarks();
        ArrayList<Integer> midterm_exam_marks = subjectData.getMidtermExamMarks();
        ArrayList<Integer> final_exam_marks = subjectData.getFinalExamMarks();
        ArrayList<String> student_names = subjectData.getStudentNames();
        ArrayList<String> student_numbers = subjectData.getStudentNumbers();
        ArrayList<Integer> expected_student_activities_marks = new ArrayList<Integer>(Arrays.asList(8, 10, 9, 7, 8, 10, 9));
        ArrayList<Integer> expected_oral_practical_marks = new ArrayList<Integer>(Arrays.asList(9, 8, 10, 6, 7, 9, 8));
        ArrayList<Integer> expected_midterm_exam_marks = new ArrayList<Integer>(Arrays.asList(18, 17, 20, 16, 18, 19, 17));
        ArrayList<Integer> expected_final_exam_marks = new ArrayList<Integer>(Arrays.asList(50, 52, 55, 45, 48, 58, 53));
        ArrayList<String> expected_student_names = new ArrayList<String>(Arrays.asList("John Doe", "Jane Smith", "Bob Johnson", "Alice Lee", "Tom Brown", "Sara Davis", "David Wilson"));
        ArrayList<String> expected_student_numbers = new ArrayList<String>(Arrays.asList("12345678", "23456789", "34567890", "45678901", "56789012", "67890123", "78901234"));
        //assertEquals(expected_student_activities_marks, student_activities_marks);
        assertEquals(expected_oral_practical_marks, oral_practical_marks);
        assertEquals(expected_midterm_exam_marks, midterm_exam_marks);
        assertEquals(expected_final_exam_marks, final_exam_marks);
        assertEquals(expected_student_names, student_names);
        assertEquals(expected_student_numbers, student_numbers);
    }

    @Test
    public void mainTest(){
        String file_name = "C:\\Users\\mahmo\\Desktop\\Testing-a-JAVA-program-for-Student-Grading\\src\\Example Data.txt";
        String[] args = new String[1];
        args[0] = file_name;
        main.main(args);
        String expected_output = "Successfully loaded and validated the data from Example Data file." +
                "Successfully calculated the grades and GPA for each student." +
                "Successfully wrote to the file.";
        expected_output = expected_output.replaceAll("\\s+", "");
        assertEquals(expected_output, baos.toString().trim().replaceAll("\\s+", ""));
    }
}