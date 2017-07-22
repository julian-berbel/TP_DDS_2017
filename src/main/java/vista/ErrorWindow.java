package vista;

import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.Window;

public class ErrorWindow {	
	public static void show(Window<?> owner, String message){
		MessageBox msgBox = new MessageBox(owner, MessageBox.Type.Error);
		msgBox.setMessage(message);
		msgBox.open();
	}
}
