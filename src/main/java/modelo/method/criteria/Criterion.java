package modelo.method.criteria;

import java.util.List;

import modelo.enterprise.Enterprise;

public interface Criterion {
	public List<Enterprise> apply(List<Enterprise> enterprises);
}
