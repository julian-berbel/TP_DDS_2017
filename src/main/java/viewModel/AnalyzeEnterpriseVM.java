package viewModel;

import java.math.BigDecimal;
import java.util.List;
import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;

@Observable
public class AnalyzeEnterpriseVM {

	private List<Enterprise> enterprises;
	private Enterprise selectedEnterprise;
	private List<Period> periods;
	private Period selectedPeriod;
	private List<Indicator> indicators;	
	private Indicator selectedIndicator;
	private BigDecimal value;
	
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public AnalyzeEnterpriseVM()
	{
		enterprises =  EnterpriseRepository.getEnterpriseList();
	}	
	
	public List<Enterprise> getEnterprises() 
	{
		return enterprises;
	}
	
	public void setEnterprises(List<Enterprise> enterprise)
	{
		this.enterprises = enterprise;
	}	
	
	public Enterprise getSelectedEnterprise() 
	{
		return selectedEnterprise;
	}
	public List<Period> getPeriods() 
	{
		return periods;
	}
	
	public void setPeriods(List<Period> periods) 
	{
		this.periods = periods;
	}
	
	public Period getSelectedPeriod() 
	{
		return selectedPeriod;
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
		value = selectedIndicator.reduce(selectedEnterprise, selectedPeriod.getYear());
	}
	
	public void setSelectedEnterprise(Enterprise selectedEnterprise) 
	{
		this.selectedEnterprise = selectedEnterprise;
		periods = selectedEnterprise.getPeriods();
	}
	
	public void setSelectedPeriod(Period selectedPeriod){
		this.selectedPeriod = selectedPeriod;
		indicators = IndicatorRepository.getAvailableIndicatorForPeriodList(selectedEnterprise,selectedPeriod);
	}	
	
}
