package vista;

import org.uqbar.arena.widgets.Container;
import org.uqbar.arena.widgets.FileSelector;

@SuppressWarnings("serial")
public class SpecialFileSelector extends FileSelector		// No se si se podr� o se har� de otra forma o si ya lo hace, pero solo se me ocurri� modificar 
{															// el bindValueToProperty del fileSelector para hacer que acepte tirar excepciones
															// o tire las excepciones de una manera especial (en este caso que tire un MessageBox)
															// el hacer esto es irme al diablo, pero est� copado hacer mods :P
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
