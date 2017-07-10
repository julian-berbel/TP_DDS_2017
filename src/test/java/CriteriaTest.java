import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;
import modelo.indicator.parser.IndicatorParser;
import modelo.method.criteria.filter.*;

public class CriteriaTest {
	
	List<Period> periods = Arrays.asList(
			new Period(2014, Arrays.asList(new Calculation("a", new BigDecimal("1")))),
			new Period(2015, Arrays.asList(new Calculation("a", new BigDecimal("2")))),
			new Period(2016, Arrays.asList(new Calculation("a", new BigDecimal("3")))),
			new Period(2017, Arrays.asList(new Calculation("a", new BigDecimal("4")))));
	
	Enterprise anEnterprise = new Enterprise("", periods);
	
	Object a = new IndicatorParser(System.in);
	
	Indicator anIndicator = new Indicator("", "#a");

	@Test
	public void increasingIndicatorValueCriterion()
	{
		assertTrue(new IncreasingIndicatorValueCriterion(anIndicator, 3).criterion(anEnterprise));
	}
	
	@Test
	public void indicatorAverageHigherThanValueCriterion()
	{
		assertTrue(new IndicatorAverageHigherThanValueCriterion(anIndicator, new BigDecimal("2.49"), 3).criterion(anEnterprise));
	}
	
	@Test
	public void indicatorAverageLessThanValueCriterion()
	{
		assertTrue(new IndicatorAverageLessThanValueCriterion(anIndicator, new BigDecimal("2.51"), 3).criterion(anEnterprise));
	}
	
	@Test
	public void indicatorMedianHigherThanValueCriterion()
	{
		assertTrue(new IndicatorMedianHigherThanValueCriterion(anIndicator, new BigDecimal("2.49"), 3).criterion(anEnterprise));
	}
	
	@Test
	public void indicatorMedianLessThanValueCriterion()
	{
		assertTrue(new IndicatorMedianLessThanValueCriterion(anIndicator, new BigDecimal("2.51"), 3).criterion(anEnterprise));
	}
	
	@Test
	public void indicatorValueHigherThanCriterion()
	{
		assertTrue(new IndicatorValueHigherThanCriterion(anIndicator, new BigDecimal("0.99"), 3).criterion(anEnterprise));
	}
	
	@Test
	public void indicatorValueLessThanCriterion()
	{
		assertTrue(new IndicatorValueLessThanCriterion(anIndicator, new BigDecimal("4.01"), 3).criterion(anEnterprise));
	}
}
