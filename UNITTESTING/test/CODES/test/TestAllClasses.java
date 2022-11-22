package CODES.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;


@Suite
/*@SelectClasses(value = {TestFruits.class, 
		TestMathOp.class,
		TestClassification.class})
*/
@SelectPackages(value = {"CODES.test"})
public class TestAllClasses {
	
	
}
