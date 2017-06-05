package viewModel;
import java.util.List;
import java.util.Optional;

import org.uqbar.commons.utils.Observable;

import exceptions.DeleteUsedIndicatorException;
import modelo.Indicator;
import modelo.IndicatorRepository;
import org.uqbar.commons.model.ObservableUtils;


@Observable
public class IndicatorsVM {
	
	private List<Indicator> indicators;
	private Indicator selectedIndicator;
	
	public IndicatorsVM(){
		refreshList();
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
	}
}
