import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SubjectData {
    private String subject_name;
    private String subject_code;
    private int full_mark;
    private String[] student_names;
    private String[] student_numbers;
    private int[] student_activities_marks;
    private int[] oral_practical_marks;
    private int[] midterm_exam_marks;
    private int[] final_exam_marks;

    public SubjectData(){
        this.subject_name = "";
        this.subject_code = "";
        this.full_mark = 0;
    }

    public void load_data(String file_name){
        String line;
        try
        {
            FileReader file_reader = new FileReader(file_name);
            BufferedReader buffer_read = new BufferedReader(file_reader);

            // reading the file, line by line
            while((line = buffer_read.readLine()) != null){
                System.out.println(line);
            }
            buffer_read.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception: " + e);
        }
    }
}
