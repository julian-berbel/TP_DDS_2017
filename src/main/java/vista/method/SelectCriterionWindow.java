package vista.method;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewModel.method.SelectCriterionVM;
import vista.method.criteria.CriterionWindow;

@SuppressWarnings("serial")
public abstract class SelectCriterionWindow<CriterionType> extends SimpleWindow<SelectCriterionVM<CriterionType>>
{
	public SelectCriterionWindow(WindowOwner owner) 
	{
		super(owner, new SelectCriterionVM<CriterionType>());
	}
	
	@Override
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(()->this.close());	
	}
	
	public CriterionType openWithReturn() 
	{
		this.open();
		return getModelObject().getTargetCriterion();
	}
	
	protected void addCriterionButton(Panel panel, String caption, CriterionWindow<CriterionType, ?> window){
		new Button(panel).setCaption(caption).onClick(() -> {
			CriterionType newCriterion = window.openWithReturn();
			this.getModelObject().setTargetCriterion(newCriterion);
			this.close();
		}).setWidth(300);
	}
}
