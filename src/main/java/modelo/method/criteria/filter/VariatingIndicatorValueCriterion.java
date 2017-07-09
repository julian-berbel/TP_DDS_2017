
package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.util.List;

import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public abstract class VariatingIndicatorValueCriterion extends IndicatorRelatedCriterion
{
	public VariatingIndicatorValueCriterion(Indicator indicator, int years) 
	{
		super(indicator, years);
	}
	
	public boolean criterion(Enterprise enterprise) 
	{
		List<BigDecimal> values = enterprise.getIndicatorValueFromLastNYears(indicator, lastNYears);
		
		if(values.isEmpty()) return true;
		
		Tuple2<Boolean, BigDecimal> acumulador = new Tuple2<>(true, values.get(0));
		
		return Seq.seq(values).drop(1)
				.foldLeft(acumulador, (tuple, value) -> new Tuple2<Boolean, BigDecimal>(tuple.v1 && compare(tuple.v2.compareTo(value)), value))
				.v1;
	}
}