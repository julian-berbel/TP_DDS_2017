package viewModel.indicator;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import exceptions.DeleteUsedIndicatorException;
import exceptions.MissingFileException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import modelo.indicator.Indicator;
import modelo.indicator.IndicatorRepository;
import modelo.indicator.IndicatorsManager;

import org.uqbar.commons.model.ObservableUtils;


@Observable
public class IndicatorsVM {
	
	private List<Indicator> indicators;
	private Indicator selectedIndicator;
	private Boolean indicatorsChanged;
	
	public IndicatorsVM(){
		indicatorsChanged = false;
		indicators = IndicatorRepository.getIndicatorList();
	}
	
	public List<Indicator> getIndicators() {
		return indicators;
	}
	
	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}
	
	public Indicator getSelectedIndicator() {
		return selectedIndicator;
	}
	
	public void setSelectedIndicator(Indicator selectedIndicator) {
		this.selectedIndicator = selectedIndicator;
	}
	
	public void replaceSelectedIndicatorWith(Optional<Indicator> newIndicator){
		newIndicator.ifPresent(indicator -> IndicatorRepository.replace(selectedIndicator, indicator));
		refreshList();
	}

	public void deleteIndicator(){
		if(IndicatorRepository.anyUses(selectedIndicator)) throw new DeleteUsedIndicatorException();
		indicators.remove(selectedIndicator);
		refreshList();
	}
	
	public void addNewIndicator(Optional<Indicator> newIndicator){
		newIndicator.ifPresent(indicator -> IndicatorRepository.addIndicator(indicator));
		refreshList();
	}
	
	public void refreshList(){
		indicators = IndicatorRepository.getIndicatorList();
		ObservableUtils.firePropertyChanged(this, "indicators");
		indicatorsChanged = true;
	}
	
	public Boolean verifyIfSomethingChanged()
	{
		return indicatorsChanged;
	}
	
	public void somethingChanged()
	{
		indicatorsChanged = true;
	}
	
	public void saveChanges() throws BiffException, WriteException, IOException
	{		
		if(!IndicatorsManager.fileLoaded()) throw new MissingFileException("Debe cargar el archivo de cuentas antes de poder guardar los cambios");
		
		IndicatorsManager.writeExcel();		
	}
	
}
