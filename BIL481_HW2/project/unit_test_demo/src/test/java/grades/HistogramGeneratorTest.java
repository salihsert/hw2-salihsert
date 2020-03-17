package demo.junit_class_demo.grades;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import demo.junit_class_demo.grades.HistogramGenerator;
import demo.junit_class_demo.grades.ChartIO;
import org.jfree.chart.JFreeChart;

public class HistogramGeneratorTest {
	ChartIO io = mock(ChartIO.class);
	/*@Test
	public void test_generate_normal() {

	}*/
	@Test
	public void test_createChart() {
		HistogramGenerator hg=new HistogramGenerator(io);
		assertTrue(hg.createChart(new int[]{1,2,3,4,5,6,7,8,9,10}) !=null);
	}
	@Test
	public void test_calculateFrequencies(){
		int frequencies[]={1,1,1,1,1,1,1,1,1,1,1};
		int grades[]={0,1,2,3,4,5,6,7,8,9,10};
		HistogramGenerator hg = new HistogramGenerator(io);
		assertArrayEquals(frequencies,hg.calculateFrequencies(grades));
	}


}
