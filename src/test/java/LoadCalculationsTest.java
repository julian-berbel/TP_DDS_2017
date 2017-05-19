import static org.junit.Assert.assertEquals;
import org.junit.Test;

import modelo.EnterpriseRepository;
import viewModel.LoadCalculationsVM;

public class LoadCalculationsTest {
	@Test
	public void evaluatesExpression() {
		LoadCalculationsVM cargador = new LoadCalculationsVM();
		cargador.setFilePath("docs/archivo de prueba de empresas.txt");
		cargador.parseFile();
		assertEquals(EnterpriseRepository.getEnterpriseList().get(0).getEnterpriseName(), "PepeHermanos");
	}
}
