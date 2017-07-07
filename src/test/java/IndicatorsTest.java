import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import java.util.Optional;

import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import viewModel.IndicatorsVM;

public class IndicatorsTest {

	@Test
	public void testAddNewIndicator()
	{
		new IndicatorRepository();
		Indicator indicator = new Indicator("Indicator1", "#C1+#C2");
		IndicatorRepository.addIndicator(indicator);	
		
		IndicatorsVM indicators = new IndicatorsVM();		
		Indicator indicator2 = new Indicator("Indicator2", "#C1*#C2");
		
		indicators.setSelectedIndicator(indicator2);
		indicators.addNewIndicator(Optional.of(indicator2));
		
		List<Indicator> indicatorList = new ArrayList<Indicator>();
		indicatorList.add(indicator);
		indicatorList.add(indicator2);
		
		assertEquals(IndicatorRepository.getIndicatorList(), indicatorList);
	}
	
	@Test
	public void testDeleteIndicator()
	{
		new IndicatorRepository();
		Indicator indicator = new Indicator("Indicator1", "#C1+#C2");
		IndicatorRepository.addIndicator(indicator);
		
		IndicatorsVM indicators = new IndicatorsVM();
		indicators.setSelectedIndicator(indicator);
		indicators.deleteIndicator();
		
		assertTrue(indicators.getIndicators().isEmpty());
	}
}
