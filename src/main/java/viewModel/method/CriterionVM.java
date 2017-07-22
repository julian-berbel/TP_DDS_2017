package viewModel.method;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;

@Observable
public abstract class CriterionVM<CriterionType> {

	protected List<Indicator> indicators;
	protected CriterionType targetCriterion;
	protected Indicator selectedIndicator;
	
	public void refreshList()
	{
		indicators = IndicatorRepository.getIndicatorList();
	}

	public CriterionType getTargetCriterion() {
		return targetCriterion;
	}

	public void setTargetCriterion(CriterionType newCriterion) {
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
	
	public abstract void buildCriterion();
}
