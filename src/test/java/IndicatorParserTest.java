import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Enterprise;
import parser.*;

public class IndicatorParserTest {
	Enterprise dummyEnterprise = new Enterprise(); 
	
	@Test
	public void parser() {
		double resultado = 0;
		new IndicatorParser(System.in);
		try{
			resultado = IndicatorParser.parseIndicator("(11 - 7) * 18 / 2").reduce(dummyEnterprise, 0);
		} catch(Exception e){
			System.out.println(e);
		}
		assertEquals(36, resultado, 0);
	}
	
}

