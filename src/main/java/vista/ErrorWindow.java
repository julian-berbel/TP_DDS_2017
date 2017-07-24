package vista;

import org.uqbar.arena.windows.MessageBox;
import org.uqbar.arena.windows.Window;

public class ErrorWindow {	
	public static void show(Window<?> owner, String message){
		_show(owner, message);
	}
	
	public static void show(Window<?> owner, Exception e){
		_show(owner, e.getMessage());
	}
	
	private static void _show(Window<?> owner, String message){
		MessageBox msgBox = new MessageBox(owner, MessageBox.Type.Error);
		msgBox.setMessage(message);
		msgBox.open();
	}
}
