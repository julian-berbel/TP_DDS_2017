package vista.method.criteria;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;

import java.util.Optional;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.windows.WindowOwner;
import viewModel.method.criteria.CriterionVM;

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
	
	public Optional<CriterionType> openWithReturn()
	{
		this.open();
		return getModelObject().getTargetCriterion();
	}
}
