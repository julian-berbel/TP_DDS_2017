package viewModel;

import java.util.List;
import java.util.Optional;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import modelo.Criterion;
import modelo.Indicator;
import modelo.IndicatorRepository;

@Observable
public class MaximizeIndicatorCriterionVM {

	private List<Indicator> indicators;
	private Criterion targetCriterion;
	private Indicator selectedIndicator;
	
	public void refreshList()
	{
		setIndicators(IndicatorRepository.getIndicatorList());
		ObservableUtils.firePropertyChanged(this, "indicators");
	}

	public Criterion getTargetCriterion() {
		return targetCriterion;
	}

	public void setTargetCriterion(Criterion newCriterion) {
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
