package CODES.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import CODES.Fruits;

public class TestFruits {
	
	private Fruits fruit;
	
	@BeforeEach
	public void setup() {
		fruit = new Fruits();
	}


	@AfterEach
	public void TearDown() {
		fruit = null;
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Apple", "Mango", "Melon", "Lemon"})
	public void testAddFruits(String param) {
		boolean actualResult = fruit.addFruits(param);
		assertEquals(true, actualResult);
	}
	@Disabled
	@Test
	public void testAddFruitsRainy() {
		boolean actualResult = fruit.addFruits("Apple"," Mango");
		assertNotEquals(true, actualResult);
	}
	
	@RepeatedTest(10)
	@Order(1)
	public void testGetStandNotNull() {
		assertNotNull(fruit.getStand());
	}
	
	@Order(2)
	@Test
	public void testGetStandContent() {
		List<String> expectedStand = Arrays.asList("Apple", "Mango");
		List<String> actulaREsult = fruit.getStand();
		assertIterableEquals(expectedStand, actulaREsult);
	}
	
	@RepeatedTest(10)
	@EnabledIf("toggleOnOff")
	@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_18)
	@Order(3)
	public void testCountStand() {
		
		assertTimeout(Duration.ofMillis(50), () -> {
			int expectedFruits = 10;
			int actualFruits = fruit.countFruits();
			assertTrue(actualFruits >= expectedFruits);
		});
	
		
	}
	
	@EnabledOnJre(JRE.JAVA_12)//conditional java 12 lang mag rurun
	@EnabledOnOs(OS.LINUX)//para maka pili ka kung saang os lang sya mag run pero by default kung ano yung os mo
	@Order(4)
	@Test
	public void testStandStream() {
		Stream<String> expecStream = Stream.of("Mango", "Apple");
		Stream<String> resultStream = fruit.getFruitStream();
		assertLinesMatch(expecStream, resultStream);
	}
	
	//CUSTOMIZING CONDITION KUNWARE
	//Switch
	public static boolean toggleOnOff() {
		return true;
	}
	

}
