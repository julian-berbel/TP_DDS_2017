package vista;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import viewModel.SaveChangesVM;


@SuppressWarnings("serial")
public class SaveChangesWindow extends Dialog<SaveChangesVM> 
{
	
	public SaveChangesWindow(WindowOwner owner)
	{		
		super(owner, new SaveChangesVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		this.setTitle("Save changes...");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("¿Desea guardar los cambios?");	
	}

	@Override
	protected void addActions(Panel actions) 
	{
		new Button(actions).setCaption("Si").onClick(this::accept);
				
		new Button(actions).setCaption("No").onClick(this::cancel);
	}	
}

