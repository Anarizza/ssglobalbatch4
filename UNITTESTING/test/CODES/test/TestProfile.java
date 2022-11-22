package CODES.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CODES.Profile;

public class TestProfile {
	
	private Profile profile;
	
	// SetUp and Initiation
	//Fixtures
	
	@BeforeEach
	public void setup() {
		profile = new Profile();
		
	}
	
	@AfterEach
	public void tearDown() {
		profile = null;//garbage collect
	}
	
	
	// Test cases in the form of methods
	@Test
	public void testShowProfile() {
		//Profile profile = new Profile();//Do not Do this
		String expectedRec = "Juan 90";
		String actualRec = profile.showProfile();
		assertNotEquals(expectedRec, actualRec);
		System.out.println(actualRec);
		
	}
	@Test
	public void testIncreaseAge() {
		int expectedAge = 28;
		int actualAge = profile.increaseAge(10);
		assertEquals(expectedAge, actualAge);// pag di nag match walang execute na actual value
		System.out.println(actualAge);
	}
	
	
}
