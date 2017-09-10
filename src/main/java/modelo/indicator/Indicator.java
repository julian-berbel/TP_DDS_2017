package modelo.indicator;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.uqbar.commons.utils.Observable;
import exceptions.EmptyFieldException;
import modelo.ModelEntity;
import modelo.enterprise.Enterprise;
import modelo.indicator.math.Operable;
import modelo.indicator.parser.IndicatorParser;

@Entity
@Observable
public class Indicator extends ModelEntity implements Operable
{
	
	@Column(nullable = false)
	private String name;
	private String formula;
	
	@Transient
	private Operable value;

	public Indicator(String name, String formula){
		if(name == null) throw new EmptyFieldException("Nombre");
		if(formula == null) throw new EmptyFieldException("Formula");
		this.name = name;
		this.formula = formula;
		this.value = IndicatorParser.parseIndicator(formula);
	}
	
	public Indicator(){}
	
	public String getName() 
	{
		return name;
	}

	public String getFormula() {
		return formula;
	}
	
	public Operable getValue() {
		if(value == null) value = IndicatorParser.parseIndicator(formula);
		return value;
	}

	public BigDecimal reduce(Enterprise enterprise, int year){
		return getValue().reduce(enterprise, year);
	}
	
	public boolean tryReduce(Enterprise enterprise, int year)
	{
		try
		{
			reduce(enterprise, year);
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
	
	public String normalize(){
		return getValue().toString();
	}
	
	@Override
	public String toString(){
		return "@" + name;
	}
	
	public Boolean uses(Indicator indicator){
		return getValue().includes(indicator);
	}
	
	public Boolean includes(Indicator indicator){
		return this == indicator || getValue().includes(indicator);
	}
}
