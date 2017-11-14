package modelo.indicator.cache;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import modelo.db.ModelEntity;

@Entity
@Table(name = "PreCalculations")
public class PreCalculation extends ModelEntity {
	
	public String formula;
	public Long enterpriseId;
	public int year;
	public BigDecimal result;
	
	protected PreCalculation() {}
	
	public PreCalculation(String formula, Long enterpriseId, int year, BigDecimal result){
		this.formula = formula;
		this.enterpriseId = enterpriseId;
		this.year = year;
		this.result = result;
	}
	
	public BigDecimal getResult() {
		return result;
	}
}
