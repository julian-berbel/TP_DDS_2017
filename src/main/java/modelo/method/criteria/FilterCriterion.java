package modelo.method.criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import modelo.enterprise.Enterprise;

public abstract class FilterCriterion implements Criterion
{	
	protected abstract boolean criterion(Enterprise enterprise);
	
	public List<Enterprise> apply(List<Enterprise> enterprises){
		List<Enterprise> enterprises2 = new ArrayList<Enterprise>();
		return enterprises.stream()
				.filter(enterprise -> criterion(enterprise))
				.collect(Collectors.toList());
	/*	for(int i=0;enterprises.size()>i;i++)
		{
		if(criterion(enterprises.get(i))){
			enterprises2.add(enterprises.get(i));
		}
		}
		return enterprises2;*/
	}
}
