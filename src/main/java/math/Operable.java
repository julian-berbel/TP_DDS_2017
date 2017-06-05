package math;

import modelo.Enterprise;
import modelo.Indicator;

public interface Operable {
	public double reduce(Enterprise enterprise, int year);
	
	public Boolean includes(Indicator indicator);
}
