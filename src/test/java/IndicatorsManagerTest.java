import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import modelo.indicator.IndicatorsManager;

public class IndicatorsManagerTest {
	
	@Test
	public void readTest(){
		IndicatorsManager.setFilePath("testfiles/TestIndicadores.xls");
		Indicator dummyIndicator = new Indicator("IngresoNeto", "#C1 + #C2");
		try{
			IndicatorsManager.read();
			assertEquals(IndicatorRepository.getIndicator("IngresoNeto"), dummyIndicator);
		}
		catch(Exception e){
			fail("El archivo no existe");
		}		
	}

}
