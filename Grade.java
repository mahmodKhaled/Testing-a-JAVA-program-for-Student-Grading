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
    		if(studentMark>=97)
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
    	      else if(studentMark<60)
    	    	  grade = "F";
    	      else 
    	    	  throw new IllegalArgumentException("the student marks aren't in range");
    		studentsGrades.add(grade);
    	}
		return this.studentsGrades;
    }
    public void calculate_gpa(){
    	for(int i=0;i<SIZE;i++) {
    		int gpa;
    		String grade=studentsGrades.get(i);
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
    }
    public void generate_student_gradings(){
    	try {
    	      FileWriter myWriter = new FileWriter("output.txt");
    	      String subjectName=subject_data.getSubjectName();
    	      int maxMark=subject_data.getFullMark();
    	      myWriter.write("                   Subject Name:"+"                  "+subjectName +" "+"Max Mark:" +maxMark+"\n\n\n");
    	      myWriter.write("                    Student name        Student number    GPA        Grade"+"\n\n");
    	      for(int i=0;i<SIZE;i++) {
    	    	  String studentName=subject_data.getStudentNames().get(i);
    	    	  String studentNumber=subject_data.getStudentNumbers().get(i);
    	    	  String studentGrade=studentsGrades.get(i);
    	    	  float studentGpa=studentsGPA.get(i);
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
