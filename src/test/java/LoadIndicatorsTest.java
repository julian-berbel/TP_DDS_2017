import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jxl.read.biff.BiffException;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import viewModel.indicator.LoadIndicatorsVM;

public class LoadIndicatorsTest {

	@Test
	public void testMethods()
	{
		LoadIndicatorsVM loader = new LoadIndicatorsVM();
		List<Indicator> indicatorList = new ArrayList<Indicator>();
		Indicator dummyIndicator = new Indicator("IngresoNeto", "#C1 + #C2");
		indicatorList.add(dummyIndicator);
		
		try
		{
			loader.setFilePath("testfiles/TestIndicadores.xls");
			assertEquals(IndicatorRepository.getIndicatorList(), indicatorList);			
		}
		catch(BiffException e)
		{
			fail("El archivo no es valido");
		}
		catch(IOException e)
		{
			fail("Error al abrir el archivo");
		}
	}
}
