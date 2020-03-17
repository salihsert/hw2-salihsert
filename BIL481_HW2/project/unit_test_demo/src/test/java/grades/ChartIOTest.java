package demo.junit_class_demo.grades;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Assert.*;

public class ChartIOTest {
	
	ChartIO io = new ChartIO();
	@Test
	public void test_readFile_happyPath() {
		String file = "src/test/resources/grades_normal.csv";
		int[] satirlar = new int[3];
		satirlar[0] = 15;
		satirlar[1] = 10;
		satirlar[2] = 0;

		Assert.assertArrayEquals(satirlar,io.readFile(file));

	}

	@Test (expected = IllegalArgumentException.class)
	public void test_readFile_SadPath() {
		io.readFile("jgdf1234jlkjkgsd09");
	}

	@Test (expected = NumberFormatException.class)
	public void testInvalidGrades() {
		String file = "src/test/resources/grades_invalid.csv";
		io.readFile(file);
	}

}
