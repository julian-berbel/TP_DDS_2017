import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import parser.*;


public class IndicatorParserTest {
	@Test
	public void parser() {
		double resultado = 0;
		new IndicatorParser(new ByteArrayInputStream("(11 - 7) * 18 / 2".getBytes(StandardCharsets.UTF_8)));
		try{
			resultado = IndicatorParser.Start().reduce();
		} catch(Exception e){
			System.out.println(e);
		}
		assertEquals(36, resultado, 0);
	}
	
}

