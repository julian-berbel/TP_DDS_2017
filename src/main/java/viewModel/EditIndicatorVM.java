package viewModel;

import org.uqbar.commons.utils.Observable;

import exceptions.FormulaErrorException;
import exceptions.MissingIndicatorException;
import modelo.Indicator;
import parser.IndicatorParser;

@Observable
public class EditIndicatorVM {
	
	private String name;
	private String formula;
	private Indicator indicadorAEditar;
	
	public EditIndicatorVM(Indicator indicadorAEditar){
		this.indicadorAEditar = indicadorAEditar;
		name = indicadorAEditar.getName();
		formula = indicadorAEditar.getFormula();
	}
	
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

	public void newIndicator() throws FormulaErrorException, MissingIndicatorException{
		indicadorAEditar.setName(name);
		indicadorAEditar.setFormula(formula);
		indicadorAEditar.setValue(IndicatorParser.parseIndicator(this.formula));
	}
	
}
