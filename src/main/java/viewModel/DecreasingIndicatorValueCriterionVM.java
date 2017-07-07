package viewModel;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import modelo.method.criteria.Criterion;

@Observable
public class DecreasingIndicatorValueCriterionVM 
{

	private List<Indicator> indicators;
	private int numberYears;
	private Criterion targetCriterion;
	private Indicator selectedIndicator;
	
	public void refreshList()
	{
		setIndicators(IndicatorRepository.getIndicatorList());
		ObservableUtils.firePropertyChanged(this, "indicators");
	}
	
	public int getNumberYears()
	{
		return numberYears;
	}

	public void setNumberYears(int numberYears)
	{
		this.numberYears = numberYears;
	}

	public Criterion getTargetCriterion() 
	{
		return targetCriterion;
	}

	public void setTargetCriterion(Criterion newCriterion)
	{
		this.targetCriterion = newCriterion;
	}

	public List<Indicator> getIndicators()
	{
		return indicators;
	}

	public void setIndicators(List<Indicator> indicators) 
	{
		this.indicators = indicators;
	}

	public Indicator getSelectedIndicator()
	{
		return selectedIndicator;
	}

	public void setSelectedIndicator(Indicator selectedIndicator) 
	{
		this.selectedIndicator = selectedIndicator;
	}
}
