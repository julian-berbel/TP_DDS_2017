import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;
import modelo.method.criteria.filter.*;

public class FilterCriteriaTest {
	
	List<Period> periods = Arrays.asList(
			new Period(2014, Arrays.asList(new Calculation("a", new BigDecimal("1")))),
			new Period(2015, Arrays.asList(new Calculation("a", new BigDecimal("2")))),
			new Period(2016, Arrays.asList(new Calculation("a", new BigDecimal("3")))),
			new Period(2017, Arrays.asList(new Calculation("a", new BigDecimal("4")))));
	
	Enterprise anEnterprise = new Enterprise("", periods);
	Enterprise anotherEnterprise = new Enterprise("", periods.stream()
		.sorted((a,b) -> b.getCalculation("a").getValue().compareTo(a.getCalculation("a").getValue()))
		.collect(Collectors.toList())
	);
	
	Indicator anIndicator = new Indicator("", "#a");

	@Test
	public void increasingIndicatorValue()
	{
		assertTrue(FilterCriteria.increasingIndicatorValue(anIndicator, 3).test(anEnterprise));
	}
	
	@Test
	public void decreasingIndicatorValue()
	{
		assertTrue(FilterCriteria.decreasingIndicatorValue(anIndicator, 3).test(anotherEnterprise));
	}
	
	@Test
	public void indicatorAverageHigherThan()
	{
		assertTrue(FilterCriteria.indicatorAverageHigherThan(anIndicator, new BigDecimal("2.49"), 3).test(anEnterprise));
	}
	
	@Test
	public void indicatorAverageLowerThan()
	{
		assertTrue(FilterCriteria.indicatorAverageLowerThan(anIndicator, new BigDecimal("2.51"), 3).test(anEnterprise));
	}
	
	@Test
	public void indicatorMedianHigherThan()
	{
		assertTrue(FilterCriteria.indicatorMedianHigherThan(anIndicator, new BigDecimal("2.49"), 3).test(anEnterprise));
	}
	
	@Test
	public void indicatorMedianLowerThan()
	{
		assertTrue(FilterCriteria.indicatorMedianLowerThan(anIndicator, new BigDecimal("2.51"), 3).test(anEnterprise));
	}
	
	@Test
	public void indicatorValueHigherThan()
	{
		assertTrue(FilterCriteria.indicatorValueHigherThan(anIndicator, new BigDecimal("0.99"), 3).test(anEnterprise));
	}
	
	@Test
	public void indicatorValueLowerThan()
	{
		assertTrue(FilterCriteria.indicatorValueLowerThan(anIndicator, new BigDecimal("4.01"), 3).test(anEnterprise));
	}
}