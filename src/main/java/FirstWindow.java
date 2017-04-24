
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;


@SuppressWarnings("serial")
public class FirstWindow extends MainWindow<FirstVM>
{
	public FirstWindow()
	{
		super(new FirstVM());
	}
	
	@Override
	
	public void createContents(Panel mainPanel)
	{
		this.setTitle("");
		mainPanel.setLayout(new VerticalLayout());
	
		new Button(mainPanel)
			.setCaption("Cargar Cuentas")
			.onClick(()->{ new LoadCalculationsWindow(this).open(); });		
	}
	
	
	public static void main(String[] args)
	{
		new FirstWindow().startApplication();
	}
}