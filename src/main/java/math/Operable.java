package math;

import java.math.BigDecimal;
import modelo.Enterprise;
import modelo.Indicator;

public interface Operable {
	public BigDecimal reduce(Enterprise enterprise, int year);
	
	public Boolean includes(Indicator indicator);
}
