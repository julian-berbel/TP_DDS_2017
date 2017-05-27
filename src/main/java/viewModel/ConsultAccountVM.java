package viewModel;

import java.util.List;

import org.uqbar.commons.utils.Observable;
import modelo.Calculation;
import modelo.Enterprise;
import modelo.EnterpriseRepository;
import modelo.Period;

@Observable
public class ConsultAccountVM {

	private List<Enterprise> enterprises;
	private Enterprise selectedEnterprise;
	private List<Period> periods;
	private Period selectedPeriod;
	private List<Calculation> calculations;	
	
	public ConsultAccountVM()
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
	
	public List<Calculation> getCalculations() 
	{
		return calculations;
	}

	public void setCalculations(List<Calculation> calculations) 
	{
		this.calculations = calculations;
	}
	
	public void setSelectedEnterprise(Enterprise selectedEnterprise) 
	{
		
		this.selectedEnterprise = selectedEnterprise;
		periods = selectedEnterprise.getPeriods();
	}
	
	public void setSelectedPeriod(Period selectedPeriod){
			calculations = selectedPeriod.getCalculations();
	}	
	
}
