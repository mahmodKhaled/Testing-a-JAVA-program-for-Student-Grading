package Tests;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import main.Grade;

public class calculate_grade_CFG {
	Grade grade=new Grade();
	@Test
	
	void forLoopPathTest() 
	{
		ArrayList<Integer> student_activities_marks=new ArrayList<Integer>();
		student_activities_marks.add(8);
		
		ArrayList<Integer> oral_practical_marks=new ArrayList<Integer>();
		oral_practical_marks.add(10);
		
		ArrayList<Integer> midterm_exam_marks=new ArrayList<Integer>();
		midterm_exam_marks.add(18);
		
		ArrayList<Integer> final_exam_marks=new ArrayList<Integer>();
		final_exam_marks.add(48);
		
		ArrayList<String> grades=new ArrayList<String>();
		
		grades=grade.calculate_grade(student_activities_marks, oral_practical_marks
				, midterm_exam_marks,  final_exam_marks);
		assertEquals("B+",grades.get(0));
	}
	
	@Test
	
	void emptyArrayListTest() 
	{
		ArrayList<Integer> student_activities_marks=new ArrayList<Integer>();
		
		
		ArrayList<Integer> oral_practical_marks=new ArrayList<Integer>();
	;
		
		ArrayList<Integer> midterm_exam_marks=new ArrayList<Integer>();
	
		
		ArrayList<Integer> final_exam_marks=new ArrayList<Integer>();
		
		
		ArrayList<String> grades=new ArrayList<String>();
		
		grades=grade.calculate_grade(student_activities_marks, oral_practical_marks
				, midterm_exam_marks,  final_exam_marks);
		assertEquals("[]",grades.toString());
	}

}