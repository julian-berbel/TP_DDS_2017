package viewModel;
import java.math.BigDecimal;
import java.util.List;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import modelo.method.criteria.Criterion;
import modelo.method.criteria.FilterCriterion;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;

@Observable
public class AverageHigherThanValueVM {

	private List<Indicator> indicators;
	private BigDecimal value;
	private int numberYears;
	private FilterCriterion targetCriterion;
	private Indicator selectedIndicator;
	
	public void refreshList()
	{
		setIndicators(IndicatorRepository.getIndicatorList());
		ObservableUtils.firePropertyChanged(this, "indicators");
	}
	public int getNumberYears() {
		return numberYears;
	}

	public void setNumberYears(int numberYears) {
		this.numberYears = numberYears;
	}
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public FilterCriterion getTargetCriterion() {
		return targetCriterion;
	}

	public void setTargetCriterion(FilterCriterion newCriterion) {
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