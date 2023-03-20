public class main {
    public static void main(String[] args){
        String file_name = "src/Example Data.txt";
        SubjectData subject_data = new SubjectData();
        subject_data.load_data(file_name);
        Grade grade = new Grade(subject_data);
        grade.calculate_grade();
        grade.calculate_gpa();
        grade.generate_student_gradings();
    	
    }
}
