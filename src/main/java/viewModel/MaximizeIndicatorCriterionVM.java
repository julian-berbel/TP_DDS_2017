package viewModel;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import modelo.method.criteria.Criterion;
import modelo.method.criteria.OrderCriterion;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;

@Observable
public class MaximizeIndicatorCriterionVM {

	private List<Indicator> indicators;
	private OrderCriterion targetCriterion;
	private Indicator selectedIndicator;
	
	public void refreshList()
	{
		setIndicators(IndicatorRepository.getIndicatorList());
		ObservableUtils.firePropertyChanged(this, "indicators");
	}

	public OrderCriterion getTargetCriterion() {
		return targetCriterion;
	}

	public void setTargetCriterion(OrderCriterion newCriterion) {
		this.targetCriterion = newCriterion;
	}

	public List<Indicator> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}

	public Indicator getSelectedIndicator() {
		return selectedIndicator;
	}

	public void setSelectedIndicator(Indicator selectedIndicator) {
		this.selectedIndicator = selectedIndicator;
	}

}
