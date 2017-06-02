import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import modelo.Indicator;
import modelo.IndicatorRepository;
import parser.IndicatorParser;
import viewModel.IndicatorsVM;


public class IndicatorsTest {

	@Test
	public void testAddNewIndicator()
	{
		IndicatorRepository repo = new IndicatorRepository();
		Indicator indicator = new Indicator("Indicator1", "#C1+#C2", IndicatorParser.parseIndicator("#C1+#C2"));
		IndicatorRepository.addIndicator(indicator);	
		
		IndicatorsVM indicators = new IndicatorsVM();		
		Indicator indicator2 = new Indicator("Indicator2", "#C1*#C2", IndicatorParser.parseIndicator("#C1*#C2"));
		
		indicators.setSelectedIndicator(indicator2);
		indicators.addNewIndicator();
		
		List<Indicator> indicatorList = new ArrayList<Indicator>();
		indicatorList.add(indicator);
		indicatorList.add(indicator2);
		
		assertEquals(IndicatorRepository.getIndicatorList(), indicatorList);
	}
	
	@Test
	public void testDeleteIndicator()
	{
		IndicatorRepository repo = new IndicatorRepository();
		Indicator indicator = new Indicator("Indicator1", "#C1+#C2", IndicatorParser.parseIndicator("#C1+#C2"));
		IndicatorRepository.addIndicator(indicator);
		
		IndicatorsVM indicators = new IndicatorsVM();
		indicators.setSelectedIndicator(indicator);
		indicators.deleteIndicator();
		
		assertTrue(indicators.getIndicators().isEmpty());
	}
}
