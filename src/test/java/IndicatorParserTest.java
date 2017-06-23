import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Test;
import modelo.Enterprise;
import parser.*;

public class IndicatorParserTest {
	Enterprise dummyEnterprise = new Enterprise(); 
	
	@Test
	public void parser() {
		BigDecimal resultado = new BigDecimal(0);
		new IndicatorParser(System.in);
		
		resultado = IndicatorParser.parseIndicator("(11 - 7) * 18 / 2").reduce(dummyEnterprise, 0);

		assertEquals(resultado, new BigDecimal(36));
	}
	
}

