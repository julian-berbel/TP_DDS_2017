/*
 * import static org.junit.Assert.assertTrue; import static
 * org.junit.Assert.fail;
 * 
 * import java.io.IOException; import java.util.Arrays; import java.util.List;
 * 
 * import org.junit.Test;
 * 
 * import jxl.read.biff.BiffException; import modelo.indicator.Indicator; import
 * modelo.indicator.IndicatorRepository; import
 * viewModel.indicator.LoadIndicatorsVM;
 * 
 * public class LoadIndicatorsTest {
 * 
 * @Test public void testMethods() { LoadIndicatorsVM loader = new
 * LoadIndicatorsVM(); Indicator dummyIndicator = new Indicator("IngresoNeto",
 * "#ingresosOperacionesContinuas + #ingresosOperacionesDiscontinuas");
 * List<Indicator> indicatorList = Arrays.asList(dummyIndicator);
 * 
 * try { loader.setFilePath("files/TestIndicadores.xls");
 * assertTrue(IndicatorRepository.getInstance().getList().get(0).equals(
 * indicatorList.get(0)) );
 * 
 * } catch(BiffException e) { fail("El archivo no es valido"); }
 * catch(IOException e) { fail("Error al abrir el archivo"); } } }
 */