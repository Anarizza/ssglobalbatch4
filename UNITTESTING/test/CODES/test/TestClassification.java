package CODES.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import CODES.Classification;

public class TestClassification {
	
	private Classification classification;
	
	@BeforeEach
	public void setup() {
		classification = Classification.EXCELLENT;
	}


	@AfterEach
	public void TearDown() {
		classification = null;
	}
	
	@Test
	public void testEvaluate() {
		Classification actualResult = Classification.evaluate(75);
		Classification expecResult = Classification.PASS;
		assertSame(expecResult, actualResult);
	}
	
	@ParameterizedTest
	@EnumSource(Classification.class)
	public void testGetWeights(Classification rating) {
		double expectValue = 60;
		double actualValue = Classification.computeWeights(rating);
		assertFalse(actualValue >= expectValue);
	}
	
}
