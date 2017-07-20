package vista.method;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewModel.SelectCriterionVM;

@SuppressWarnings("serial")
public abstract class SelectCriterionWindow<T> extends SimpleWindow<SelectCriterionVM<T>>
{
	public SelectCriterionWindow(WindowOwner owner) 
	{
		super(owner, new SelectCriterionVM<T>());
	}
	
	@Override
	protected void addActions(Panel actions)
	{
		new Button(actions).setCaption("Volver").onClick(()->this.close());	
	}
	
	public T openWithReturn() 
	{
		this.open();
		return getModelObject().getTargetCriterion();
	}
}
