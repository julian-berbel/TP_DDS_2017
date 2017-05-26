package viewModel;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.uqbar.commons.utils.Observable;

import modelo.Indicator;
import modelo.IndicatorRepository;
import parser.IndicatorParser;

@Observable
public class NewIndicatorVM {
	
	private String name;
	private String formula;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public void newIndicator(){
		IndicatorParser.ReInit(new ByteArrayInputStream(formula.getBytes(StandardCharsets.UTF_8)));
		IndicatorRepository.addIndicator(new Indicator(this.name, this.formula, IndicatorParser.parseIndicator(this.formula)));
	}
}
