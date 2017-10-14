package viewModel.enterprise;

import java.util.List;
import java.util.Optional;

import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import modelo.enterprise.Period;


public class ConsultAccountVM {

	private List<Enterprise> enterprises;
	private Enterprise selectedEnterprise;
	private List<Period> periods;
	private Period selectedPeriod;
	private List<Calculation> calculations;	
	
	public ConsultAccountVM()
	{
		enterprises = EnterpriseRepository.getInstance().getList();
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
		if(selectedEnterprise != null)
		{	
			this.selectedEnterprise = selectedEnterprise;
			periods = selectedEnterprise.getPeriods();
		}	
	}
	
	public void setSelectedPeriod(Period selectedPeriod){
			calculations = selectedPeriod.getCalculations();
	}
	
	public void addNewEnterprise(Optional<Enterprise> enterprise){
		enterprise.ifPresent(newEnterprise -> {
			EnterpriseRepository.getInstance().addElement(newEnterprise);
			enterprises.add(newEnterprise);
		});
		
	}
	
	
	private int selectedIndex(){
		return enterprises.indexOf(selectedEnterprise);
	}
	
	public void updateEnterprise(Optional<Enterprise> enterprise){
		enterprise.ifPresent(newEnterprise -> {
			EnterpriseRepository.getInstance().updateElement(newEnterprise);
			enterprises.set(selectedIndex(), newEnterprise);
		});
		
	}
	
	public void deleteEnterprise(){
		if(selectedEnterprise != null){
			EnterpriseRepository.getInstance().deleteElement(selectedEnterprise);
			enterprises.remove(selectedEnterprise);
			
		}
	}
		
}
