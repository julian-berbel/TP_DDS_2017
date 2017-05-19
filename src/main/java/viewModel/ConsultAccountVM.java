package viewModel;

import java.util.List;
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
	
	public void setPeriods(List<String> periodss) 
	{
		periods = periodss;
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
		periods=EnterpriseRepository.getEnterprisePeriodsList(selectedEnterprise);			
	}
	
	

	public void setSelectedPeriod(String selectedPeriodd) 
	{		
		
		selectedPeriod = selectedPeriodd;			
		if(selectedPeriod!= null)
		{
			calculations = EnterpriseRepository.getPeriodAccountList(selectedEnterprise, selectedPeriod);
		}	
	}	
	
	
}
