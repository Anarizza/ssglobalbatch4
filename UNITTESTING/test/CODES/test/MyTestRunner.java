package CODES.test;

import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTestRunner {

	public static void main(String[] args) {
		
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		Result result = junit.run(TestAllClasses.class);
		
		System.out.println(result.getRunCount());
		System.out.println(result.getFailureCount());
		System.out.println(result.getIgnoreCount());
		//List<Failure> failurs = result.getFailureCount();
		//for(Failure failure: failurs) {
		//	System.out.println(failure);
		//}

	}

}
