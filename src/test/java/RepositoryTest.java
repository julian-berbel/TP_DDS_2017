import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;

public class RepositoryTest implements TransactionalOps, WithGlobalEntityManager{
	

	Indicator indicator = new Indicator("Indicator", "123");
	
	@Before
	public void setup(){
		withTransaction(() -> entityManager().createQuery("delete from Indicator").executeUpdate());
	}
		
	@Test
	public void testAddNewIndicator()
	{
		IndicatorRepository.getInstance().addElement(indicator);
		assertEquals(IndicatorRepository.getInstance().getIndicator("Indicator"), indicator);
	}
	
	@Test
	public void testDeleteIndicator()
	{
		IndicatorRepository.getInstance().addElement(indicator);
		IndicatorRepository.getInstance().deleteElement(indicator);
		
		assertTrue(IndicatorRepository.getInstance().getList().isEmpty());
	}
	
	@Test
	public void testUpdateIndicator()
	{
		IndicatorRepository.getInstance().addElement(indicator);
		Indicator updatedIndicator = new Indicator("Indicator", "321", indicator.getId());
		IndicatorRepository.getInstance().updateElement(updatedIndicator);
		
		entityManager().refresh(indicator);
		
		assertEquals("321", indicator.getFormula());
	}
	
}
