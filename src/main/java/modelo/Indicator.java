package modelo;

import org.uqbar.commons.utils.Observable;

import exceptions.EmptyFieldException;
import math.Operable;

@Observable
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
		if(name == null) throw new EmptyFieldException("Nombre");
		this.name = name;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		if(formula == null) throw new EmptyFieldException("Formula");
		this.formula = formula;
	}
	
	public Operable getValue() {
		return value;
	}

	public void setValue(Operable value) {
		this.value = value;
	}

	public double reduce(Enterprise enterprise, int year){
		return value.reduce(enterprise, year);
	}
	
	public String normalize(){
		return value.toString();
	}
	
	@Override
	public String toString(){
		return "@" + name;
	}
}
