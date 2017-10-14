package viewModel.enterprise;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import exceptions.ExistingEnterpriseException;
import modelo.enterprise.Calculation;
import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import modelo.enterprise.Period;


public class EditEnterpriseVM {
	private String enterpriseName;
	private List<Period> periods = new ArrayList<Period>();;	
	private List<Integer> year;
	private Integer selectedYear;
	private List<Calculation> calculations=new ArrayList<Calculation>();;	
	private Calculation selectedCalculation;
	private Optional<Enterprise> targetEnterprise=Optional.empty();
	
	public EditEnterpriseVM(Optional<Enterprise> enterprise)
	{		
		enterprise.ifPresent(enterprise1 -> {
			enterpriseName=enterprise1.getName();
			targetEnterprise = enterprise;
			periods=enterprise1.getPeriods();
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
		}
		else
		{
			
			calculations = new ArrayList<Calculation>();//No me gusta eso pero no se me ocurre otra forma de actualizar calculations
																											//dado que en caso de entrar aca no existe ningun periodo todavia.
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
		return periods.stream().filter(period->period.getYear()==selectedYear).findFirst().get();
	}
	
	private Boolean periodsContainsSelectedYear()
	{
		
		return periods.stream().anyMatch(period->period.getYear()==selectedYear);
	}
	
	public void createPeriod()
	{
		if(periods.isEmpty() )
		{
			periods.add(new Period(selectedYear, new ArrayList<Calculation>()));
		}else if(!periodsContainsSelectedYear())
		{
			
			periods.add(new Period(selectedYear, new ArrayList<Calculation>()));
		}
	}
	
	public void addNewCalculation(Optional<Calculation> newCalculation)
	{
		newCalculation.ifPresent(calculation ->{
			getPeriod().addCalculation(calculation);
			calculations= getPeriod().getCalculations();
			});
		
		if(getPeriod().getCalculations().isEmpty()){
			periods.remove(getPeriod());
		}		
	}
	
	
	public void replaceSelectedCalculationWith(Optional<Calculation> targetCalculation)
	{
		targetCalculation.ifPresent(calculation -> getPeriod().replaceCalculation(selectedCalculation, calculation));
	}
	
	public void deleteCalculation(){
		this.getPeriod().getCalculations().remove(selectedCalculation);
		if(getPeriod().getCalculations().isEmpty()){
			periods.remove(getPeriod());
		}
		else
		{
			calculations= getPeriod().getCalculations();
		}
	}
	
	private boolean editing(){
		return targetEnterprise.isPresent();
	}
	
	private boolean nameViolation(){
		return (!editing() && EnterpriseRepository.getInstance().alreadyExists(enterpriseName)) ||
				(editing() && !enterpriseName.equals(targetEnterprise.get().getName()) && EnterpriseRepository.getInstance().alreadyExists(enterpriseName));
	}

	public void accept(){
		if(nameViolation()) throw new ExistingEnterpriseException(enterpriseName);
		
		
		targetEnterprise = Optional.of(
				editing() ? new Enterprise(enterpriseName, periods, targetEnterprise.get().getId()) : new Enterprise(enterpriseName, periods));
	}

}
