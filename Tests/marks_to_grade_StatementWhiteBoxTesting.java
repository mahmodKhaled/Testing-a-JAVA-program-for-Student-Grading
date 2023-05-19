package Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import main.Grade;

public class marks_to_grade_StatementWhiteBoxTesting {
	Grade grade=new Grade();
	String studentGrade;
	@Test
	public void APlusTest() {
		
		studentGrade=grade.marks_to_grade(100);
		assertEquals(studentGrade,"A+");
		
	}
	
	@Test
	public void ATest() {
		studentGrade=grade.marks_to_grade(95);
		assertEquals(studentGrade,"A");
	}
	
	@Test
	public void AMinusTest() {
		
		studentGrade=grade.marks_to_grade(90);
		assertEquals(studentGrade,"A-");
	}
	
	@Test
	public void BPlusTest() {
		
		studentGrade=grade.marks_to_grade(85);
		assertEquals(studentGrade,"B+");
	}
	
	@Test
	public void BTest() {
		
		studentGrade=grade.marks_to_grade(80);
		assertEquals(studentGrade,"B");
	}
	
	@Test
	public void BMinusTest() {
		studentGrade=grade.marks_to_grade(78);
		assertEquals(studentGrade,"B-");
	}
	
	@Test
	public void CPlusTest() {
		studentGrade=grade.marks_to_grade(74);
		assertEquals(studentGrade,"C+");
	}
	
	@Test
	public void CTest() {
		
		studentGrade=grade.marks_to_grade(71);
		assertEquals(studentGrade,"C");
		
	}
	
	@Test
	public void CMniusTest() {
		
		studentGrade=grade.marks_to_grade(68);
		assertEquals(studentGrade,"C-");
	}
	
	@Test
	public void DPlusTest() {
		
		studentGrade=grade.marks_to_grade(65);
		assertEquals(studentGrade,"D+");
	}
	
	@Test
	public void DTest() {
		
		studentGrade=grade.marks_to_grade(61);
		assertEquals(studentGrade,"D");
	}
	
	@Test
	public void FTest() {
		
		studentGrade=grade.marks_to_grade(50);
		assertEquals(studentGrade,"F");
	}
	
	@Test
	public void outOfRangeTest() {
		
		Exception exception = assertThrows(Exception.class, () -> grade.marks_to_grade(150));
		assertEquals("the student marks aren't in range", exception.getMessage());
		
	}
	
	
	
	

}