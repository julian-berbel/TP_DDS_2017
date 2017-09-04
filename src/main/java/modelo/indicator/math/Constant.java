package modelo.indicator.math;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;

import org.apache.commons.beanutils.converters.BigDecimalConverter;

import modelo.enterprise.Enterprise;
import modelo.indicator.Indicator;

public class Constant extends Operable {
	
	@Column(nullable = false)
	@Convert(converter = BigDecimalConverter.class)
	public BigDecimal value;
	
	public Constant(BigDecimal value){
		this.value = value;
	}
	
	public BigDecimal reduce(Enterprise enterprise, int year){
		return value;
	}
	
	public String toString(){
		return String.valueOf(value);
	}
	
	public Boolean includes(Indicator indicator){
		return false;
	}
}
