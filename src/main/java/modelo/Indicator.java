package modelo;

import math.Operable;

public class Indicator implements Operable
{
	private String name;
	private String formula;
	private Operable value;
	
	public Indicator(String name, String formula, Operable value){
		this.name = name;
		this.formula = formula;
		this.value = value;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public double reduce(Enterprise enterprise, int year){
		return value.reduce(enterprise, year);
	}
}
