package viewModel;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;
import modelo.Calculation;
import modelo.EnterpriseRepository;

@Observable
public class ConsultAccountVM {

	private List<String> enterprises;
	private String selectedEnterprise;
	private List<String> periods;
	private String selectedPeriod;
	private List<Calculation> calculations;	
	
	
	
	public ConsultAccountVM()
	{
		enterprises =  EnterpriseRepository.getEnterprisesNameList();		
	}	
	
	public List<String> getEnterprises() 
	{
		return enterprises;
	}
	
	public void setEnterprises(List<String> enterprise)
	{
		this.enterprises = enterprise;
	}	
	
	public String getSelectedEnterprise() 
	{
		return selectedEnterprise;
	}
	public List<String> getPeriods() 
	{
		return periods;
	}
	
	public void setPeriods(List<String> periods) 
	{
		this.periods = periods;
	}
	
	public String getSelectedPeriod() 
	{
		return selectedPeriod;
	}
	
	public List<Calculation> getCalculations() 
	{
		return calculations;
	}

	public void setCalculations(List<Calculation> calculationss) 
	{
		calculations = calculationss;
	}
	public void setSelectedEnterprise(String selectedEnterpris) 
	{
		
		selectedEnterprise = selectedEnterpris;
		periods= EnterpriseRepository.getEnterprisePeriodsList(selectedEnterprise).stream()
				.map(year -> year.toString()).collect(Collectors.toList());
	}
	
	

	public void setSelectedPeriod(String selectedPeriod) 
	{
		if(selectedPeriod!= null)
		{
			Integer _selectedPeriod = Integer.parseInt(selectedPeriod);
			calculations = EnterpriseRepository.getPeriodAccountList(selectedEnterprise, _selectedPeriod);
		}	
	}	
	
	
}
