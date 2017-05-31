package vista;


import java.io.IOException;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.WindowOwner;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import viewModel.SaveIndicatorsVM;



@SuppressWarnings("serial")
public class SaveIndicatorsWindow extends Dialog<SaveIndicatorsVM> 
{
	public SaveIndicatorsWindow(WindowOwner owner)
	{
		super(owner, new SaveIndicatorsVM());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) 
	{
		mainPanel.setLayout(new VerticalLayout());
		Panel panel1 = new Panel(mainPanel);
		panel1.setLayout(new VerticalLayout());	
		
		new Label(panel1).setText("Guardar Indicadores");
	
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(this:: accept);
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}
	
	@Override
	protected void executeTask() 
	{		
		try 
		{			
			this.getModelObject().SaveIndicators();
		} 
		catch (BiffException e) 
		{
			showMessageBox("El archivo indicado no es valido o no es un archivo Excel (.xls)");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			showMessageBox("Error al abrir/escribir el archivo");
			e.printStackTrace();
		}
		catch(WriteException e)
		{
			showMessageBox("Error al crear el archivo");
			e.printStackTrace();
		}
		
		super.executeTask();
	}
	
	private void showMessageBox(String message)
	{
		MessageBox msgBox = new MessageBox(this, MessageBox.Type.Error);
		msgBox.setMessage(message);
		msgBox.open();
	}
}

