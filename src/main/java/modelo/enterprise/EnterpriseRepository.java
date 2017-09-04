package modelo.enterprise;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;
import java.util.ArrayList;

public class EnterpriseRepository implements WithGlobalEntityManager
{
	private static List<Enterprise> enterprises = new ArrayList<Enterprise>();
	
	public void addEnterprise(Enterprise ent)
	{
		entityManager().persist(ent);
		enterprises.add(ent);
	}
	
	public static List<Enterprise> getEnterpriseList()
	{
		return enterprises;
	}
	
	public static void setEnterpriseList(List<Enterprise> _enterprises)
	{
		enterprises = _enterprises;
	}
	
}
