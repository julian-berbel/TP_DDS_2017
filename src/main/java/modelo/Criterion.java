package modelo;

import java.util.List;

public interface Criterion {
	public List<Enterprise> apply(List<Enterprise> enterprises);
}
