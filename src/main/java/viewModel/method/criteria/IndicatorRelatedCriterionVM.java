package viewModel.method.criteria;

import java.util.List;

import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;


public abstract class IndicatorRelatedCriterionVM<CriterionType> extends CriterionVM<CriterionType> {

	protected List<Indicator> indicators = IndicatorRepository.getInstance().getList();
	protected Indicator selectedIndicator;
	
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
