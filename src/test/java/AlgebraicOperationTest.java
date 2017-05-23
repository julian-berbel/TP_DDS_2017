import static org.junit.Assert.assertEquals;
import org.junit.Test;

import math.*;

public class AlgebraicOperationTest {
	Constant firstOperand = new Constant(4);
	Constant secondOperand = new Constant(8);

	@Test
	public void addition() {
		assertEquals(new Addition(firstOperand, secondOperand).reduce(), 12, 0);
	}
	
	@Test
	public void subtraction() {	
		assertEquals(new Subtraction(firstOperand, secondOperand).reduce(), -4, 0);
	}
	
	@Test
	public void multiplication() {		
		assertEquals(new Multiplication(firstOperand, secondOperand).reduce(), 32, 0);
	}
	
	@Test
	public void division() {
		assertEquals(new Division(firstOperand, secondOperand).reduce(), 0.5, 0);
	}	
}