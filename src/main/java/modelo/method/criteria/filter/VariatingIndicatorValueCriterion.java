
package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.time.Year;
import java.util.stream.Stream;

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
		Stream<BigDecimal> values = enterprise.getPeriods().stream()
				.filter(period -> period.getYear() > (Year.now().getValue() - lastNYears))
				.map(period -> indicator.reduce(enterprise, period.getYear()));
		
		Tuple2<Boolean, BigDecimal> acumulador = new Tuple2<>(true, values.findFirst().get().subtract(BigDecimal.ONE));
		
		return Seq.seq(values)
				.foldLeft(acumulador, (tuple, value) -> new Tuple2<Boolean, BigDecimal>(tuple.v1 && compare(tuple.v2.compareTo(value)), value))
				.v1;
	}
}