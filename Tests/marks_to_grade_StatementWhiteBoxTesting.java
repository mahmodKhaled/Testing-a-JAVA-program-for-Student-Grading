package Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import main.Grade;

class marks_to_grade_StatementWhiteBoxTesting {
	Grade grade=new Grade();
	String studentGrade;
	@Test
	void APlusTest() {
		
		studentGrade=grade.marks_to_grade(100);
		assertEquals(studentGrade,"A+");
		
	}
	
	@Test
	void ATest() {
		studentGrade=grade.marks_to_grade(95);
		assertEquals(studentGrade,"A");
	}
	
	@Test
	void AMinusTest() {
		
		studentGrade=grade.marks_to_grade(90);
		assertEquals(studentGrade,"A-");
	}
	
	@Test
	void BPlusTest() {
		
		studentGrade=grade.marks_to_grade(85);
		assertEquals(studentGrade,"B+");
	}
	
	@Test
	void BTest() {
		
		studentGrade=grade.marks_to_grade(80);
		assertEquals(studentGrade,"B");
	}
	
	@Test
	void BMinusTest() {
		studentGrade=grade.marks_to_grade(78);
		assertEquals(studentGrade,"B-");
	}
	
	@Test
	void CPlusTest() {
		studentGrade=grade.marks_to_grade(74);
		assertEquals(studentGrade,"C+");
	}
	
	@Test
	void CTest() {
		
		studentGrade=grade.marks_to_grade(71);
		assertEquals(studentGrade,"C");
		
	}
	
	@Test
	void CMniusTest() {
		
		studentGrade=grade.marks_to_grade(68);
		assertEquals(studentGrade,"C-");
	}
	
	@Test
	void DPlusTest() {
		
		studentGrade=grade.marks_to_grade(65);
		assertEquals(studentGrade,"D+");
	}
	
	@Test
	void DTest() {
		
		studentGrade=grade.marks_to_grade(61);
		assertEquals(studentGrade,"D");
	}
	
	@Test
	void FTest() {
		
		studentGrade=grade.marks_to_grade(50);
		assertEquals(studentGrade,"F");
	}
	
	@Test
	void outOfRangeTest() {
		
		Exception exception = assertThrows(Exception.class, () -> grade.marks_to_grade(150));
		assertEquals("the student marks aren't in range", exception.getMessage());
		
	}
	
	
	
	

}