package viewModel.method.criteria.filter;

import java.math.BigDecimal;


public abstract class IndicatorStatisticCompareVM extends FilterCriterionVM{

	protected BigDecimal value;
	
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}