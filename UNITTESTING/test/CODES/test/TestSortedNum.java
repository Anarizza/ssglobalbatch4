package CODES.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CODES.SortedNum;

public class TestSortedNum {
	
	private SortedNum sortedNum;
	
	@BeforeEach
	public void setup() {
		sortedNum = new SortedNum();
	}


	@AfterEach
	public void TearDown() {
		sortedNum = null;
	}
	
	@Test
	public void testSort() {
		int [] expectedData = {1, 2, 3, 4, 6};
		int[] actualData = sortedNum.sort(new int [] {6,4,1,2,3});
		assertArrayEquals(expectedData, actualData);
		System.out.println(Arrays.toString(actualData));
		
	}

}
