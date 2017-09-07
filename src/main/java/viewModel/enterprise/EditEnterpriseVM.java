package viewModel.enterprise;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar; 
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import exceptions.EmptyEnterpriseException;
import exceptions.EmptyFieldException;
import exceptions.ExistingEnterpriseException;
import exceptions.ExistingIndicatorException;
import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import modelo.enterprise.Period;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;




@Observable
public class EditEnterpriseVM {
	private String enterpriseName;
	private String originalEnterpriseName;
	private List<Period> periods = new ArrayList<Period>();;	
	private List<Integer> year;
	private Integer selectedYear;
	private List<Calculation> calculations=new ArrayList<Calculation>();;	
	private Calculation selectedCalculation;
	private Optional<Enterprise> targetEnterprise = Optional.empty();
	private Boolean editing= false;
	
	public EditEnterpriseVM(Optional<Enterprise> enterprise)
	{		
		enterprise.ifPresent(enterprise1 -> {
			enterpriseName=enterprise1.getName();
			originalEnterpriseName=enterprise1.getName();
			periods=enterprise1.getPeriods();
			editing = true;
		});
				
		this.yearInitiation();
	}
	
	public Optional<Enterprise> getTargetEnterprise() 
	{
		return targetEnterprise;
	}
	
	public String getEnterpriseName() 
	{
		return enterpriseName;
	}
	public List<Period> getPeriods() 
	{
		return periods;
	}

	public void setPeriods(List<Period> periods) 
	{
		this.periods = periods;
	}

	public void setEnterpriseName(String enterpriseName) 
	{
		this.enterpriseName = enterpriseName;
	}
	public List<Integer> getYear() {
		return year;
	}

	public void setYear(List<Integer> year) 
	{
		this.year = year;
	}
	public Integer getSelectedYear() 
	{
		return selectedYear;
	}

	public void setSelectedYear(Integer selectedYear) 
	{
		this.selectedYear = selectedYear;
		
		if (periodsContainsSelectedYear())
		{
			
			calculations= getPeriod().getCalculations();
			
			this.refreshList();
			
			
		}
		else
		{
			
			calculations = new ArrayList<Calculation>();//No me gusta eso pero no se me ocurre otra forma de actualizar calculations
			refreshList();								//dado que en caso de entrar aca no existe ningun periodo todavia.
		}
	}
	
	public List<Calculation> getCalculations() 
	{
		return calculations;
	}

	public void setCalculations(List<Calculation> calculations) 
	{
		if(periods.stream().anyMatch(period->period.getYear()==selectedYear))
		{	
			this.calculations = this.getPeriod().getCalculations();
		}	
	}

	public Calculation getSelectedCalculation() 
	{
		return selectedCalculation;
	}

	public void setSelectedCalculation(Calculation selectedCalculation) 
	{
		this.selectedCalculation = selectedCalculation;
	}
	
	
	private void yearInitiation()
	{
		year=new ArrayList<Integer>();
		Calendar cal= Calendar.getInstance(); 
		 
		for(int valor = cal.get(Calendar.YEAR);valor>=1910;valor--)
		{
			year.add(valor);
		}
	}
	
	public Period getPeriod()
	{
		return periods.stream().filter(period->period.getYear()==selectedYear).collect(Collectors.toList()).get(0);
	}
	
	private Boolean periodsContainsSelectedYear()
	{
		
		return periods.stream().anyMatch(period->period.getYear()==selectedYear);
	}
	
	public void createPeriod()
	{
		if(periods.size()==0 )
		{
			periods.add(new Period(selectedYear, new ArrayList<Calculation>()));
		}else if(!periodsContainsSelectedYear())
		{
			
			periods.add(new Period(selectedYear, new ArrayList<Calculation>()));
		}
	}
	
	public void refreshList()
	{
		ObservableUtils.firePropertyChanged(this, "calculations");
	}
	
	public void addNewCalculation(Optional<Calculation> newCalculation)
	{
		newCalculation.ifPresent(calculation ->{
			getPeriod().addCalculation(calculation);
			calculations= getPeriod().getCalculations();
			refreshList();
			});
		
		if(getPeriod().getCalculations().size()==0){
			periods.remove(getPeriod());
		}		
	}
	
	
	public void replaceSelectedCalculationWith(Optional<Calculation> targetCalculation)
	{
		targetCalculation.ifPresent(calculation -> getPeriod().replaceCalculation(selectedCalculation, calculation));
		refreshList();
	}
	
	public void deleteCalculation(){
		this.getPeriod().getCalculations().remove(selectedCalculation);
		if(getPeriod().getCalculations().size()==0){
			periods.remove(getPeriod());
		}
		else
		{
			calculations= getPeriod().getCalculations();
			refreshList();
		}
	}
	public void accept(){
			
		if(!editing && EnterpriseRepository.alreadyExists(enterpriseName)) throw new ExistingEnterpriseException(enterpriseName);
		if(enterpriseName== null) throw new EmptyFieldException("Nombre de la empresa"); 
		if(editing && !enterpriseName.equals(originalEnterpriseName) && IndicatorRepository.alreadyExists(enterpriseName))
		{
			throw new ExistingEnterpriseException(enterpriseName);
		}
			
		if(periods.size()>0)
		{
			targetEnterprise = Optional.of(new Enterprise(enterpriseName,periods));
		}
		else
		{
			throw new EmptyEnterpriseException();
		}
	}
	
	

}
