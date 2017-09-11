package viewModel.enterprise;

import java.util.List;
import java.util.Optional;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import exceptions.MissingFileException;
import modelo.JsonMapper;
import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import modelo.enterprise.Period;

@Observable
public class ConsultAccountVM {

	private List<Enterprise> enterprises;
	private Enterprise selectedEnterprise;
	private List<Period> periods;
	private Period selectedPeriod;
	private List<Calculation> calculations;	
	private Boolean enterprisesChanged=false;
	public ConsultAccountVM()
	{
		enterprises =  EnterpriseRepository.getInstance().getEnterpriseList();		
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
	public void addNewEnterprise(Optional<Enterprise> newEnterprise){
		newEnterprise.ifPresent(enterprise -> EnterpriseRepository.getInstance().addEnterprise(enterprise));
		refreshList();
	}
	public void refreshList(){
		enterprises =  EnterpriseRepository.getInstance().getEnterpriseList();
		ObservableUtils.firePropertyChanged(this, "enterprises");
		enterprisesChanged = true;
	}
	
	public void replaceSelectedEnterpriseWith(Optional<Enterprise> targetEnterprise){
		targetEnterprise.ifPresent(enterprise -> EnterpriseRepository.getInstance().replaceEnterprise(selectedEnterprise, enterprise));
		refreshList();
	}
	
	public void deleteEnterprise()
	{
		
		EnterpriseRepository.getInstance().deleteEnterprise(selectedEnterprise);
		enterprises =  EnterpriseRepository.getInstance().getEnterpriseList();
		ObservableUtils.firePropertyChanged(this, "enterprises");
		enterprisesChanged = true;
	}
	
	public Boolean verifyIfSomethingChanged()
	{
		return enterprisesChanged;
	}
	
	public void saveChanges()
	{
		if(EnterpriseRepository.getInstance().getFileLoaded()==false) throw new MissingFileException("Debe cargar el archivo de cuentas antes de poder guardar los cambios");
		JsonMapper jsonMapper= new JsonMapper();
		jsonMapper.mapperToFile();
	}
	
}
