import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;
import modelo.method.criteria.order.MaximizeIndicatorCriterion;
import modelo.method.criteria.order.MinimizeIndicatorCriterion;

public class OrderCriteriaTest {
	
	List<Period> periods = Arrays.asList(new Period(2017, Arrays.asList(new Calculation("a", new BigDecimal("4")))));
	List<Period> otherPeriods = Arrays.asList(new Period(2017, Arrays.asList(new Calculation("a", new BigDecimal("1")))));
	
	Enterprise anEnterprise = new Enterprise("", periods);
	Enterprise anotherEnterprise = new Enterprise("", otherPeriods);
	
	Indicator anIndicator = new Indicator("", "#a");

	@Test
	public void maximizeIndicatorCriterion()
	{
		assertEquals(new MaximizeIndicatorCriterion(anIndicator).compare(anEnterprise, anotherEnterprise), -1);
	}
	
	@Test
	public void minimizeIndicatorCriterion()
	{
		assertEquals(new MinimizeIndicatorCriterion(anIndicator).compare(anEnterprise, anotherEnterprise), 1);
	}
	
}