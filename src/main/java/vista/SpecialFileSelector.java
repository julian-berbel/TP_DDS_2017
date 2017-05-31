package vista;

import org.uqbar.arena.widgets.Container;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.FileSelector;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;


public class SpecialFileSelector extends FileSelector		// No se si se podrá o se hará de otra forma o si ya lo hace, pero solo se me ocurrió modificar 
{															// el bindValueToProperty del fileSelector para hacer que acepte tirar excepciones
															// o tire las excepciones de una manera especial (en este caso que tire un MessageBox)
															// el hacer esto es irme al diablo, pero está copado hacer mods :P
	public SpecialFileSelector(Container container)
	{
		super(container);
	}
	
/*	@Override
	public <M,C extends ControlBuilder> Binding<M,Control,C> bindValueToProperty(String property)
	{
		
	}
	
	*/
}
