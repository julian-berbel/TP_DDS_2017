import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LoadCalculationsTest {
	@Test
	public void evaluatesExpression() {
		LoadCalculationsVM cargador = new LoadCalculationsVM();
		cargador.setFilePath("docs/archivo de prueba de empresas.txt");
		cargador.parseFile();
		assertEquals(EnterpriseList.getEnterpriseList().get(0).getEnterpriseName(), "PepeHermanos");
	}
}
