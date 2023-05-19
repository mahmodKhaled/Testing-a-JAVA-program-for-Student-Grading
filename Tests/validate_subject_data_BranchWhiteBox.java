package Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import main.SubjectData;

class validate_subject_data_BranchWhiteBox {
	
	SubjectData subjectData=new SubjectData();
	
	

	@Test
	void correctDataWithSixCharactersTest() {
		String[] validated_subject_data = subjectData.validate_subject_data(
				"English", "ENG101", "100"
						);
		
		String[] actual_subject_data= {"English","ENG101","100"};
		assertEquals(true,Arrays.equals(validated_subject_data, actual_subject_data));
		
		
		
	}
	
	
	
	@Test
	void wrongSubjectNameTest() {

		Exception exception = assertThrows(Exception.class, () -> subjectData.validate_subject_data(
				" Eng2ish", "ENG101", "100"
				));
		
		assertEquals("Please enter appropriate Subject Name.", exception.getMessage());
	}
	
	@Test
	void wrongSubjectLettersCodeTest() {

		Exception exception = assertThrows(Exception.class, () -> subjectData.validate_subject_data(
				"English", "E0G101", "100"
				));
		
		assertEquals("Please enter appropriate Subject Code.", exception.getMessage());
	}
	
	@Test
	void wrongSubjectNumbersCodeTest() {

		Exception exception = assertThrows(Exception.class, () -> subjectData.validate_subject_data(
				"English", "ENG1N1", "100"
				));
		
		assertEquals("Please enter appropriate Subject Code.", exception.getMessage());
	}
	
	@Test
	void correctDataWithSevenLettersSubjectCodeTest() {
		String[] validated_subject_data = subjectData.validate_subject_data(
				"English", "ENG101s", "100"
						);
		
		String[] actual_subject_data= {"English","ENG101s","100"};
		assertEquals(true,Arrays.equals(validated_subject_data, actual_subject_data));
		
		
		
	}
	
	@Test
	void wrongSubjectWithSevenLettersCodeTest() {

		Exception exception = assertThrows(Exception.class, () -> subjectData.validate_subject_data(
				"English", "E0G101s", "100"
				));
		
		assertEquals("Please enter appropriate Subject Code.", exception.getMessage());
	}
	
	@Test
	void wrongSubjectNumbersWithSevenCharactersCodeTest() {

		Exception exception = assertThrows(Exception.class, () -> subjectData.validate_subject_data(
				"English", "ENG1N1s", "100"
				));
		
		assertEquals("Please enter appropriate Subject Code.", exception.getMessage());
	}
	
	@Test
	void wrongLastCharacterWithSevenCharactersCodeTest() {

		Exception exception = assertThrows(Exception.class, () -> subjectData.validate_subject_data(
				"English", "ENG101p", "100"
				));
		
		assertEquals("Please enter appropriate Subject Code.", exception.getMessage());
	}
	
	@Test
	void tooLongSuubjectCodeCodeTest() {

		Exception exception = assertThrows(Exception.class, () -> subjectData.validate_subject_data(
				"English", "ENG101sss", "100"
				));
		
		assertEquals("Please enter appropriate Subject Code.", exception.getMessage());
	}
	
	@Test
	void wrongFullMarkTest() {

		Exception exception = assertThrows(Exception.class, () -> subjectData.validate_subject_data(
				"English", "ENG101s", "60"
				));
		
		assertEquals("Please enter appropriate Full Mark.", exception.getMessage());
	}
	
}