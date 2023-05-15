package main;
import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        if (args.length != 1){
            args = new String[1];
            args[0] = "src/Example Data.txt";
        }
        SubjectData subject_data = new SubjectData();
        boolean flag = subject_data.load_data(args[0]);
        if (!flag){
            System.out.println("Failed to load and validate the data from Example Data file.");
            return;
        }
        else{
             System.out.println("Successfully loaded and validated the data from Example Data file.");
            ArrayList<Integer> student_activities_marks = subject_data.getStudentActivitiesMarks();
            ArrayList<Integer> oral_practical_marks = subject_data.getOralPracticalMarks();
            ArrayList<Integer> midterm_exam_marks = subject_data.getMidtermExamMarks();
            ArrayList<Integer> final_exam_marks = subject_data.getFinalExamMarks();
            Grade grade = new Grade();
            ArrayList<String> student_grades = grade.calculate_grade(student_activities_marks, oral_practical_marks, midterm_exam_marks, final_exam_marks);
            ArrayList<Float> students_GPA = grade.calculate_gpa(student_grades);
            System.out.println("Successfully calculated the grades and GPA for each student.");
            String subject_name = subject_data.getSubjectName();
            int full_mark = subject_data.getFullMark();
            ArrayList<String> student_names = subject_data.getStudentNames();
            ArrayList<String> student_numbers = subject_data.getStudentNumbers();
            grade.generate_student_gradings(subject_name, full_mark, student_names, student_numbers, student_grades, students_GPA);
        }
       
    }
}
