package main;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Grade {
    private ArrayList<Float> studentsGPA;
    private ArrayList<String> studentsGrades;
    
    public Grade(){
        this.studentsGPA = new ArrayList<>();
		this.studentsGrades = new ArrayList<>();
    }

	public String marks_to_grade(int studentMark) {
		String grade="";
		if(studentMark>=97 && studentMark<=100)
			grade = "A+";
		else if(studentMark>=93 && studentMark<97)
			grade = "A";
		else if(studentMark>=89 && studentMark<93)
			grade = "A-";
		else if(studentMark>=84 && studentMark<89)
			grade = "B+";
		else if(studentMark>=80 && studentMark<84)
			grade = "B";
		else if(studentMark>=76 && studentMark<80)
			grade = "B-";
		else if(studentMark>=73 && studentMark<76)
			grade = "C+";
		else if(studentMark>=70 && studentMark<73)
			grade = "C";
		else if(studentMark>=67 && studentMark<70)
			grade = "C-";
		else if(studentMark>=64 && studentMark<67)
			grade = "D+";
		else if(studentMark>=60 && studentMark<64)
			grade = "D";
		else if(studentMark<60 && studentMark>=0)
			grade = "F";
		else 
			throw new IllegalArgumentException("the student marks aren't in range");
		return grade;
	}	

    public ArrayList<String> calculate_grade(ArrayList<Integer> student_activities_marks, ArrayList<Integer> oral_practical_marks
	, ArrayList<Integer> midterm_exam_marks, ArrayList<Integer> final_exam_marks){
    	String grade="";
    	int studentMark=0;
    	for(int i=0;i< student_activities_marks.size();i++) {
    		int studentActivityMark= student_activities_marks.get(i); //0 to 10
    		int studentOralMark= oral_practical_marks.get(i); //0 to 10
    		int studentMidtermMark= midterm_exam_marks.get(i); //0 to 10
    		int studentFinalMark= final_exam_marks.get(i); //0 to 10
    		studentMark=studentActivityMark+studentOralMark+studentMidtermMark+studentFinalMark;
    		grade = marks_to_grade(studentMark);
    		studentsGrades.add(grade);
    	}
		return this.studentsGrades;
    }
    public ArrayList<Float> calculate_gpa(ArrayList<String> student_grades){
    	for(int i=0;i<student_grades.size();i++) {
    		String grade= student_grades.get(i);
    		switch(grade) {
    		case("A+"):
    			studentsGPA.add((float) 4);
    		break;
    		case("A"):
    			studentsGPA.add((float) 4);
    		break;
    		case("A-"):
    			studentsGPA.add((float) 3.7);
    		break;
    		case("B+"):
    			studentsGPA.add((float) 3.3);
    		break;
    		case("B"):
    			studentsGPA.add((float) 3);
    		break;
    		case("B-"):
    			studentsGPA.add((float) 2.7);
    		break;
    		case("C+"):
    			studentsGPA.add((float) 2.3);
    		break;
    		case("C"):
    			studentsGPA.add((float) 2);
    		break;
    		case("C-"):
    			studentsGPA.add((float) 1.7);
    		break;
    		case("D+"):
    			studentsGPA.add((float) 1.3);
    		break;
    		case("D"):
    			studentsGPA.add((float) 1);
    		break;
    		case("F"):
    			studentsGPA.add((float) 0);
    		break;
    		default:
    			throw new IllegalArgumentException("unhandled gpa case."+ i+" "+grade);
    		}
    	}
		return this.studentsGPA;
    }
    public void generate_student_gradings(String subject_name, int full_mark, ArrayList<String> student_names
	, ArrayList<String> student_numbers, ArrayList<String> student_grades, ArrayList<Float> student_gpa){
    	try {
    	      FileWriter myWriter = new FileWriter("output.txt");
    	      String subjectName = subject_name;
    	      int maxMark = full_mark;
    	      myWriter.write("                   Subject Name:"+subjectName +"\t\t\t\t"+"Max Mark:" +maxMark+"\n\n\n");
    	      myWriter.write("                    Student name        Student number    GPA        Grade"+"\n\n");
    	      for(int i=0;i<student_names.size();i++) {
    	    	  String studentName= student_names.get(i);
    	    	  String studentNumber= student_numbers.get(i);
    	    	  String studentGrade = student_grades.get(i);
    	    	  float studentGpa = student_gpa.get(i);
    	    	  String formattedString=String.format("%32s%16s%16f%10s", studentName, studentNumber, studentGpa,studentGrade);
    	    	  myWriter.write(formattedString+"\n");
    	      }
    	      myWriter.close();
    	      System.out.println("Successfully wrote to the file.");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    }
}
