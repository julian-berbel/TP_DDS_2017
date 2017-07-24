package modelo.method.criteria.filter;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;
import modelo.method.criteria.FilterCriterion;

public abstract class FilterCriteria
{
	private static Function<Predicate<Integer>, Predicate<Enterprise>> indicatorValueCompare(Indicator indicator, BigDecimal value, int years){
		return compare -> {
			return enterprise -> {
				return enterprise.getIndicatorValueFromLastNYears(indicator, years).stream()
						.allMatch(_value -> compare.test(_value.compareTo(value)));
			};
		};
	}
	
	private static Function<Predicate<Integer>, Predicate<Enterprise>> indicatorAverageCompare(Indicator indicator, BigDecimal value, int years){
		return compare -> {
			return enterprise -> {
				List<BigDecimal> values = enterprise.getIndicatorValueFromLastNYears(indicator, years);
				
				BigDecimal average = values.stream()
										.reduce(BigDecimal.ZERO, BigDecimal::add)
										.divide(new BigDecimal(values.size()));
				
				return compare.test(average.compareTo(value));
			};
		};
	}
	
	private static Function<Predicate<Integer>, Predicate<Enterprise>> indicatorMedianCompare(Indicator indicator, BigDecimal value, int years){
		return compare -> {
			return enterprise -> {
				List<BigDecimal> values = enterprise.getIndicatorValueFromLastNYears(indicator, years).stream()
						.sorted()
						.collect(Collectors.toList());

				int middle = values.size() / 2;
				BigDecimal median = values.get(middle);
	
				if(values.size() % 2 == 0)
				median = median.add(values.get(middle-1)).divide(new BigDecimal(2));
	
				return compare.test(median.compareTo(value));
			};
		};
	}
	
	private static Function<Predicate<Integer>, Predicate<Enterprise>> variatingIndicatorValue(Indicator indicator, int years){
		return compare -> {
			return enterprise -> {
				List<BigDecimal> values = enterprise.getIndicatorValueFromLastNYears(indicator, years);
				
				if(values.isEmpty()) return true;
				
				Tuple2<Boolean, BigDecimal> acumulador = new Tuple2<>(true, values.get(0));
				
				return Seq.seq(values).drop(1)
						.foldLeft(acumulador, (tuple, _value) -> new Tuple2<Boolean, BigDecimal>(tuple.v1 && compare.test(tuple.v2.compareTo(_value)), _value))
						.v1;
			};
		};
	}
		
	private static Predicate<Integer> HigherThan = result -> result > 0;
	private static Predicate<Integer> LowerThan = result -> result < 0;
	
	public static FilterCriterion indicatorValueHigherThan(Indicator indicator, BigDecimal value, int years){
		return new FilterCriterion(indicatorValueCompare(indicator, value, years).apply(HigherThan), "Indicador " + indicator.getName() + " mayor a " + value.toString() + " durante los ultimos " + String.valueOf(years) + " anios");
	}
	
	public static FilterCriterion indicatorValueLowerThan(Indicator indicator, BigDecimal value, int years){
		return new FilterCriterion(indicatorValueCompare(indicator, value, years).apply(LowerThan), "Indicador " + indicator.getName() + " menor a " + value.toString() + " durante los ultimos " + String.valueOf(years) + " anios");
	}
	
	public static FilterCriterion indicatorAverageHigherThan(Indicator indicator, BigDecimal value, int years){
		return new FilterCriterion(indicatorAverageCompare(indicator, value, years).apply(HigherThan), "Promedio del indicador " + indicator.getName() + " mayor a " + value.toString() + " durante los ultimos " + String.valueOf(years) + " anios");
	}
	
	public static FilterCriterion indicatorAverageLowerThan(Indicator indicator, BigDecimal value, int years){
		return new FilterCriterion(indicatorAverageCompare(indicator, value, years).apply(LowerThan), "Promedio del indicador " + indicator.getName() + " menor a " + value.toString() + " durante los ultimos " + String.valueOf(years) + " anios");
	}
	
	public static FilterCriterion indicatorMedianHigherThan(Indicator indicator, BigDecimal value, int years){
		return new FilterCriterion(indicatorMedianCompare(indicator, value, years).apply(HigherThan), "Media del indicador " + indicator.getName() + " mayor a " + value.toString() + " durante los ultimos " + String.valueOf(years) + " anios");
	}
	
	public static FilterCriterion indicatorMedianLowerThan(Indicator indicator, BigDecimal value, int years){
		return new FilterCriterion(indicatorMedianCompare(indicator, value, years).apply(LowerThan), "Media del indicador " + indicator.getName() + " menor a " + value.toString() + " durante los ultimos " + String.valueOf(years) + " anios");
	}
	
	public static FilterCriterion increasingIndicatorValue(Indicator indicator, int years){
		return new FilterCriterion(variatingIndicatorValue(indicator, years).apply(HigherThan), "Indicador " + indicator.getName() + " creciente durante los ultimos " + String.valueOf(years) + " anios");
	}
	
	public static FilterCriterion decreasingIndicatorValue(Indicator indicator, int years){
		return new FilterCriterion(variatingIndicatorValue(indicator, years).apply(LowerThan), "Indicador " + indicator.getName() + " decreciente durante los ultimos " + String.valueOf(years) + " anios");
	}
	
	public static FilterCriterion minimumLongevity(int minimumAge){
		return new FilterCriterion(enterprise -> {
			return enterprise.age() > minimumAge;
		}, "Antiguedad de la empresa mayor a " + String.valueOf(minimumAge) + " anios");
	}
}