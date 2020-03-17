package demo.junit_class_demo.math;

import org.junit.Test;

import demo.junit_class_demo.math.MyMath;

import org.junit.Assert;

/**
 * An class that provides test cases for the 
 * "simple" math operations of the MyMath 
 * class, for demonstrating Unit Testing.
 * @author agkortzis (antonis.gkortzis@gmail.com)
 */
public class MyMathTest {
	MyMath mm = new MyMath();
	
	/*
	 * A unit test that checks a valid positive input
	 */
    @Test
    public void testGetSignShouldReturnPositive() {
        Assert.assertEquals("positive", mm.checkSign(10));
    }
    
    /*
	 * A unit test that checks a valid negative input
	 */
    @Test
    public void testGetSignShouldReturnNegative() {
        Assert.assertEquals("negative", mm.checkSign(-10));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUnSignedInput() {
        mm.checkSign(0);
    }

    @Test
    public void testReverseNegative() {
        Assert.assertEquals(10, mm.reverseNumber(-10));
    }
    @Test
    public void testReversePozitive() {

        Assert.assertEquals(-20, mm.reverseNumber(20));
    }
    @Test
    public void testReverseEqual() {
        Assert.assertEquals(0, mm.reverseNumber(0));
    }
}



