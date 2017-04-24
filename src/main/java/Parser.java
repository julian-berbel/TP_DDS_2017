import java.util.List;
import java.util.ArrayList;

public class Parser 
{
	public static void parseCalculations(String path, Enterprise ent) // hago que cree los objetos aca por ahora
	{																  //lo que me genera dudas es si los cambios que le haga a ent acá se reflejan en las otras clases que usan eso, o esto es una copia
							
		List<String> lines = new ArrayList<String>(/* aca tendria que poner algo para separar por lineas el txt */); 
		
		//Despues de separar por lineas, la primer linea que sería la empresa, la separo. Las demas lineas son un periodo y las cuentas separadas por ';'
		//Ahora voy a tener que agarrar a partir del 2do elemento del array de arriba y separar por ';'. Con eso tengo separados periodo y cuentas 
		//(por cada linea que proceso, podria agarrar y crear el periodo, sus atributos, y agregarselo a ent)
		
		
	}
}
