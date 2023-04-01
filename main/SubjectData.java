package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SubjectData {
    private String subject_name;
    private String subject_code;
    private int full_mark;
    private ArrayList<String> student_names;
    private ArrayList<String> student_numbers;
    private ArrayList<Integer> student_activities_marks;
    private ArrayList<Integer> oral_practical_marks;
    private ArrayList<Integer> midterm_exam_marks;
    private ArrayList<Integer> final_exam_marks;

    public SubjectData(){
        this.subject_name = "";
        this.subject_code = "";
        this.full_mark = 0;
        this.student_names = new ArrayList<>();
        this.student_numbers = new ArrayList<>();
        this.student_activities_marks = new ArrayList<>();
        this.oral_practical_marks = new ArrayList<>();
        this.midterm_exam_marks = new ArrayList<>();
        this.final_exam_marks = new ArrayList<>();
    }

    public String[] validate_subject_data(String subject_name, String subject_code, String full_mark){
        String[] subject_data = new String[3];
        if(subject_name.matches("[a-zA-Z ]+") && !subject_name.startsWith(" ")){
            subject_data[0] = subject_name;
        }
        else{
            throw new IllegalArgumentException("Please enter appropriate Subject Name.");
        }
        if(subject_code.length() == 6){
            for(int i = 0; i < 3; i++){
                if(Character.isLetter(subject_code.charAt(i))){
                    continue;
                }
                else {
                    throw new IllegalArgumentException("Please enter appropriate Subject Code.");
                }
            }
            for(int i = 3; i < 6; i++){
                if(Character.isDigit(subject_code.charAt(i))){
                    continue;
                }
                else {
                    throw new IllegalArgumentException("Please enter appropriate Subject Code.");
                }
            }
            subject_data[1] = subject_code;
        }
        else if(subject_code.length() == 7){
            for(int i = 0; i < 3; i++){
                if(Character.isLetter(subject_code.charAt(i))){
                    continue;
                }
                else {
                    throw new IllegalArgumentException("Please enter appropriate Subject Code.");
                }
            }
            for(int i = 3; i < 6; i++){
                if(Character.isDigit(subject_code.charAt(i))){
                    continue;
                }
                else {
                    throw new IllegalArgumentException("Please enter appropriate Subject Code.");
                }
            }
            if(subject_code.charAt(6) == 's'){
                subject_data[1] = subject_code;
            }
            else {
                throw new IllegalArgumentException("Please enter appropriate Subject Code.");
            }
        }
        else{
            throw new IllegalArgumentException("Please enter appropriate Subject Code.");
        }
        if(Integer.parseInt(full_mark) == 100){
            subject_data[2] = full_mark;
        }
        else{
            throw new IllegalArgumentException("Please enter appropriate Full Mark.");
        }
        return subject_data;
    }
    public String[] validate_student_data(String student_name, String student_number, String student_activities_mark, String oral_practical_mark, String midterm_exam_mark, String final_exam_mark){
        String[] student_data = new String[6];
        if(student_name.matches("[a-zA-Z ]+") && !student_name.startsWith(" ")){
            student_data[0] = student_name;
        }
        else{
            throw new IllegalArgumentException("Please enter appropriate Student Name.");
        }
        if(student_number.length() == 8){
            for(int i = 0; i < 7; i++){
                if(Character.isDigit(student_number.charAt(i))){
                    continue;
                }
                else{
                    throw new IllegalArgumentException("Please enter appropriate Student Number.");
                }
            }
            if(Character.isDigit(student_number.charAt(7)) || Character.isLetter(student_number.charAt(7))){
                student_data[1] = student_number;
            }
            else{
                throw new IllegalArgumentException("Please enter appropriate Student Number.");
            }
        }
        else{
            throw new IllegalArgumentException("Please enter appropriate Student Number.");
        }
        if(Integer.parseInt(student_activities_mark) >= 0 && Integer.parseInt(student_activities_mark) <= 10){
            student_data[2] = student_activities_mark;
        }
        else{
            throw new IllegalArgumentException("Please enter appropriate Student Activities mark.");
        }
        if(Integer.parseInt(oral_practical_mark) >= 0 && Integer.parseInt(oral_practical_mark) <= 10){
            student_data[3] = oral_practical_mark;
        }
        else{
            throw new IllegalArgumentException("Please enter appropriate Oral/Practical mark.");
        }
        if(Integer.parseInt(midterm_exam_mark) >= 0 && Integer.parseInt(midterm_exam_mark) <= 20){
            student_data[4] = midterm_exam_mark;
        }
        else{
            throw new IllegalArgumentException("Please enter appropriate Midterm exam mark.");
        }
        if(Integer.parseInt(final_exam_mark) >= 0 && Integer.parseInt(final_exam_mark) <= 60){
            student_data[5] = final_exam_mark;
        }
        else{
            throw new IllegalArgumentException("Please enter appropriate Final exam mark.");
        }
        return student_data;
    }
    public void load_data(String file_name){
        String line;
        boolean subject_flag = true;
        try
        {
            FileReader file_reader = new FileReader(file_name);
            BufferedReader buffer_read = new BufferedReader(file_reader);

            // reading the file, line by line
            while((line = buffer_read.readLine()) != null){
                String[] line_split = line.split(",");
                if(subject_flag){
                    String[] validated_subject_data = validate_subject_data(line_split[0], line_split[1], line_split[2]);
                    this.subject_name = validated_subject_data[0];
                    this.subject_code = validated_subject_data[1];
                    this.full_mark = Integer.parseInt(validated_subject_data[2]);
                    subject_flag = false;
                    continue;
                }
                String[] validated_student_data = validate_student_data(line_split[0], line_split[1], line_split[2], line_split[3], line_split[4], line_split[5]);
                this.student_names.add(validated_student_data[0]);
                this.student_numbers.add(validated_student_data[1]);
                this.student_activities_marks.add(Integer.parseInt(validated_student_data[2]));
                this.oral_practical_marks.add(Integer.parseInt(validated_student_data[3]));
                this.midterm_exam_marks.add(Integer.parseInt(validated_student_data[4]));
                this.final_exam_marks.add(Integer.parseInt(validated_student_data[5]));
            }
            buffer_read.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception: " + e);
        }
    }
    public String getSubjectName() {
        return subject_name;
    }

    public String getSubjectCode() {
        return subject_code;
    }

    public int getFullMark() {
        return full_mark;
    }

    public ArrayList<String> getStudentNames() {
        return student_names;
    }

    public ArrayList<String> getStudentNumbers() {
        return student_numbers;
    }

    public ArrayList<Integer> getStudentActivitiesMarks() {
        return student_activities_marks;
    }

    public ArrayList<Integer> getOralPracticalMarks() {
        return oral_practical_marks;
    }

    public ArrayList<Integer> getMidtermExamMarks() {
        return midterm_exam_marks;
    }

    public ArrayList<Integer> getFinalExamMarks() {
        return final_exam_marks;
    }
}