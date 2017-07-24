package viewModel.method.criteria;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;

@Observable
public abstract class IndicatorRelatedCriterionVM<CriterionType> extends CriterionVM<CriterionType> {

	protected List<Indicator> indicators = IndicatorRepository.getIndicatorList();
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
