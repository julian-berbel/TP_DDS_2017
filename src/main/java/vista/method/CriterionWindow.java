package vista.method;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;

import modelo.indicator.Indicator;
import viewModel.method.CriterionVM;

@SuppressWarnings("serial")

public class CriterionWindow<CriterionType, VMType extends CriterionVM<CriterionType>> extends SimpleWindow<VMType>
{
	private String title;
	
	public CriterionWindow(WindowOwner owner, VMType vm, String title)
	{
		super(owner, vm);
		this.title = title;
	}
	
	@Override	
	protected void createFormPanel(Panel mainPanel)
	{
		this.setTitle(title);
		
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Seleccione el indicador que desea comparar");
		
		List<Indicator> indicatorList = new List<Indicator>(mainPanel);
		indicatorList.bindItemsToProperty("indicators");
		indicatorList.bindValueToProperty("selectedIndicator");
		indicatorList.setWidth(300);
		indicatorList.setHeight(200);
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(()->
		{
			this.getModelObject().buildCriterion();
			this.close();
		});
		
		new Button(actions).setCaption("Cancelar").onClick(this::close);
	}
	
	public CriterionType openWithReturn()
	{
		this.getModelObject().refreshList();
		this.open();
		return getModelObject().getTargetCriterion();
	}
}
