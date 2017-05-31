import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.IndicatorRepository;
import modelo.IndicatorsManager;
import parser.IndicatorParser;
import modelo.Indicator;

public class IndicatorsManagerTest {
	
	@Test
	public void readTest(){
		IndicatorsManager.setFilePath("testfiles/TestIndicadores");
		Indicator dummyIndicator = new Indicator("IngresoNeto", "#C1 + #C2", IndicatorParser.parseIndicator("#C1 + #C2") );
		try{
			IndicatorsManager.read();
			assertEquals(IndicatorRepository.getIndicator("IngresoNeto"), dummyIndicator);
		}
		catch(Exception e){
			fail("El archivo no existe");
		}		
	}

}
