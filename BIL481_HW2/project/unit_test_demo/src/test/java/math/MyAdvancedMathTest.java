package demo.junit_class_demo.math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import demo.junit_class_demo.math.MyAdvancedMath;
import demo.junit_class_demo.math.MyMath;

import static org.mockito.Mockito.*;

/**
 * An class that provides test cases for the 
 * "advanced" math operations of the MyAdvancedMath 
 * class, for demonstrating Unit Testing.
 */
public class MyAdvancedMathTest {
	/* 
	 * A reference to the MyAdvancedMath class
	 * whose methods we are testing in this class
	 */
	MyAdvancedMath mam ;
	
	/*
	 * This is a constructor which is called 
	 * when the MyAdvancedMathTest
	 */
	public MyAdvancedMathTest() {
		this.mam = new MyAdvancedMath();
	}


	@Test
	public void testZeroSum() {
		Assert.assertEquals(0, mam.add(0, 0));
	}




	@Test
	public void testNormalADD(){
		Assert.assertEquals(15, mam.add(10, 5));
	}


	/*
	 * A test case for the exceptions caused when
	 * the result of the addition doesn't fit 
	 * in an Integer variable.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAdd_shouldThrowException_overflow() {
		mam.add(Integer.MAX_VALUE, 1);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * one or more input values are negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testAdd_shouldThrowException_negativeInput1() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input numbers should be positive.");
		mam.add(-10, 5);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAdd_shouldThrowException_negativeInput2() {
		mam.add(5, -10);
	}
		
	/*
	 *  The following method aims to test the reverseArray 
	 *  of the MyAdvancedMath class. However, its execution 
	 *  depends on the MyMath's reverseNumber method and a fail 
	 *  in this method can cause this test to fail too. Thus, the 
	 *  test is not isolated and cannot be called a valid Unit Test.
	 *  The test_reverseArray_Mocking() is the atomic and 
	 *  isolated unit test for the reverseArray method.
	 */
	@Test
	public void test_reverseArray() {
		MyMath obj = new MyMath();
		int[] testValues = {5,10,-15,-20};
		Assert.assertArrayEquals(new int[]{-5,-10,15,20},
				mam.reverseArray(testValues, obj));
	}
	
	/*
	 * The following test aims to fix the problem described in 
	 * the previous test_reverseArray test case. In order to 
	 * isolate the external (to this class) dependencies (MyMath)
	 * we have to mock them and predefine the results of
	 * all calls that we plan to execute on the MyMaths' methods.
	 */
	@Test
	public void test_reverseArray_Mocking() {
		MyMath obj = mock(MyMath.class);
		// Pre-define the results of the reverseNumber calls
		when(obj.reverseNumber(5)).thenReturn(-5);
		when(obj.reverseNumber(10)).thenReturn(-10);
		when(obj.reverseNumber(-15)).thenReturn(15);
		when(obj.reverseNumber(-20)).thenReturn(20);

		int[] testValues = {5,10,-15,-20};
		// Call the reverseArray with the mocked MyMath instance
		Assert.assertArrayEquals(new int[]{-5,-10,15,20},
				mam.reverseArray(testValues, obj));

	}
}
