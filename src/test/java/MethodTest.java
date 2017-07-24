import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;
import modelo.method.Method;
import modelo.method.criteria.FilterCriterion;
import modelo.method.criteria.MixedCriterion;
import modelo.method.criteria.OrderCriterion;
import modelo.method.criteria.filter.FilterCriteria;
import modelo.method.criteria.order.MaximizeIndicatorCriterion;
import modelo.method.result.Fail;
import modelo.method.result.Pass;

public class MethodTest {
	
	private Enterprise newEnterprise(int value, int anotherValue){
		List<Period> periods = Arrays.asList(
				new Period(2017, Arrays.asList(new Calculation("a", new BigDecimal(String.valueOf(value))),
												new Calculation("b", new BigDecimal(String.valueOf(anotherValue))))));
		return new Enterprise("", periods);
	}
		
	Enterprise enterprise11 = newEnterprise(1, 1);
	Enterprise enterprise21 = newEnterprise(2, 1);
	Enterprise enterprise34 = newEnterprise(3, 4);
	Enterprise enterprise35 = newEnterprise(3, 5);
	Enterprise enterprise32 = newEnterprise(3, 2);
	Enterprise enterprise51 = newEnterprise(5, 1);
	
	List<Enterprise> enterprises = Arrays.asList(enterprise11, enterprise21, enterprise34, enterprise35, enterprise32, enterprise51);
	
	Indicator anIndicator = new Indicator("", "#a");
	Indicator anotherIndicator = new Indicator("", "#b");
	
	List<FilterCriterion> filterCriteria;
	List<OrderCriterion> orderCriteria;
	
	Method aMethod;
	
	@Before
	public void setUp(){
		filterCriteria = new ArrayList<FilterCriterion>();
		orderCriteria = new ArrayList<OrderCriterion>();
		aMethod = new Method("", filterCriteria, orderCriteria, new ArrayList<MixedCriterion>());
	}
	
	@Test
	public void TestMethodWithMultipleFilters()
	{
		filterCriteria.add(FilterCriteria.indicatorValueHigherThan(anIndicator, new BigDecimal("2"), 0));
		filterCriteria.add(FilterCriteria.indicatorValueLowerThan(anIndicator, new BigDecimal("5"), 0));
				
		assertEquals(aMethod.apply(enterprises), Arrays.asList(	new Fail(enterprise11), 
																new Fail(enterprise21), 
																new Pass(enterprise34), 
																new Pass(enterprise35),
																new Pass(enterprise32),
																new Fail(enterprise51)));
	}
	
	@Test
	public void TestAMethodAnOrderCriterionWithMultipleReturnsTheEnterprisesSortedBySaidCriterion()
	{
		orderCriteria.add(new MaximizeIndicatorCriterion(anIndicator));
		orderCriteria.add(new MaximizeIndicatorCriterion(anotherIndicator));
				
		assertEquals(aMethod.apply(enterprises), Arrays.asList(	new Pass(enterprise51),
																new Pass(enterprise35),
																new Pass(enterprise34),
																new Pass(enterprise32),
																new Pass(enterprise21),
																new Pass(enterprise11)));
	}

}
