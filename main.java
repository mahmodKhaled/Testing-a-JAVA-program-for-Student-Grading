import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        String file_name = "src/Example Data.txt";
        SubjectData subject_data = new SubjectData();
        subject_data.load_data(file_name);
        ArrayList<Integer> student_activities_marks = subject_data.getStudentActivitiesMarks();
        ArrayList<Integer> oral_practical_marks = subject_data.getOralPracticalMarks();
        ArrayList<Integer> midterm_exam_marks = subject_data.getMidtermExamMarks();
        ArrayList<Integer> final_exam_marks = subject_data.getFinalExamMarks();
        Grade grade = new Grade();
        grade.calculate_grade(student_activities_marks, oral_practical_marks, midterm_exam_marks, final_exam_marks);
        grade.calculate_gpa();
        grade.generate_student_gradings();
    	
    }
}
