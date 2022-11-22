package CODES.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import CODES.MathOp;

public class TestMathOp {
	
	private MathOp math;
	
	@BeforeEach
	public void setup() {
		math = new MathOp();
	}
	@AfterEach
	public void tearDown() {
		math = null;
	}
	
	//Exception Testing - Old  way
	@ParameterizedTest
	@ValueSource(ints = {100, 50, 90, 10,  -1, -5, -10})
	public void testDivide(int param) {
		int expectValue = 2;
		
		try {
			int actualValue = math.divide(200, param);
			assertEquals(expectValue, actualValue);
		}catch(Exception e) {
			fail("Did not apply try-catch");
		}
		
	}
	
	//Pag ang parameter is class type i.e enum class - morethan 1 param
	@ParameterizedTest
	@MethodSource("createParams")
	public void testDivideTwoParams(DivideParams params) {
	int expectValue = params.getExpectValue();
		
		assertDoesNotThrow(() -> {
			int actualValue = math.divide(params.getxParam(), params.getyParam());
			assertEquals(expectValue, actualValue);
		}, "did not appply try-catch" );
		
	}
		
	
	//NEW APPROACH -Exception testing
	@Test
	public void testDivideNew() {
		int expectValue = 10;
		
		assertDoesNotThrow(() -> {
			int actualValue = math.divide(10, 0);
			assertEquals(expectValue, actualValue);
		}, "did not appply try-catch" );
		
	}
	
	//METHOD SOURCH
	public static Stream<DivideParams> createParams(){
		return Stream.of(new DivideParams(10, 10, 1), 
						new DivideParams(-10, 5, -2), 
						new DivideParams(3, 0, 0));
	}
	
}

class DivideParams {
	
	public DivideParams(int xParam, int yParam, int expectValue) {
		this.xParam = xParam;
		this.yParam = yParam;
		this.expectValue = expectValue;
	
	}
	
	private int xParam;
	private int yParam;
	private int expectValue;
	
	public int getxParam() {
		return xParam;
	}
	public void setxParam(int xParam) {
		this.xParam = xParam;
	}
	public int getyParam() {
		return yParam;
	}
	public void setyParam(int yParam) {
		this.yParam = yParam;
	}
	public int getExpectValue() {
		return expectValue;
	}
	public void setExpectValue(int expectValue) {
		this.expectValue = expectValue;
	}
	
}


