import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parser_old 
{
	/* Esto sigue el siguiente formato, que se dejo de lado por un archivo JSON:
	 * 
	 * EMPRESA=algo
	 * PERIODO=sdasd;CUENTA1=12312;CUENTA2=.....
	 * PERIODO=asda;CUENTAx=234;CUENTAy=....
	 * .
	 * .
	 * .
	 * ......
	 */
	
	
	public static Enterprise parseCalculations(String path) throws Exception // hago que cree los objetos aca por ahora
	{	
	    	File f1 = new File(path);						//Despues de separar por lineas, la primer linea es la empresa; separo ambos strings del '=' y asigno el 2do string al nombre del objeto 'Enterprise'
	    	Scanner scanner = new Scanner(f1);				//Las demas lineas son un periodo y las cuentas separadas por ';'. Leo otra linea y la almaceno en un ArrayList (lista dinamica).
	    	Boolean firstLine = true;						//Creo un nuevo periodo y empiezo a analizar cada elemento del ArrayList. El primero es el periodo, los demas son las cuentas.
	    	String line;									//Despues de todo eso, proceso otra línea, hasta que me quede sin lineas para procesar
	    	Enterprise ent = new Enterprise();
	    	String[] attribute = new String[2];				//Es para almacenar los strings que separo del '='. Se supone que 'attribute[0]' es lo que esta a la izquierda del '=', y 'attribute[1]' lo que esta a la derecha
	    	List<String> values = new ArrayList<String>();
	    	
	    	while(scanner.hasNextLine())
	    	{
	    		values.clear();
	    		line = scanner.nextLine();
	    		
	    		if(firstLine)
	    		{
	    			attribute = line.split("=");
	    			ent.setEnterpriseName(attribute[1]); 	//La primer linea del archivo es 'empresa=algo'; con esto asigno 'algo' al objeto
	    			firstLine = !firstLine;
	    			continue;
	    		}
	    		
	    		values = Arrays.asList(line.split(";"));
	    		Period p = new Period();
	    		
	    		for(String val : values)
	    		{	    			
	    			attribute = val.split("=");
	    			
	    			if(attribute[0] == "PERIODO")		//Por ahora no hay nada que verifique si ya cargué el nombre de empresa/periodo, o si una cuenta ya fue cargada para ese periodo
	    			{
	    				p.setPeriodName(attribute[1]);
	    				continue;
	    			}
	    			
	    			Calculation calc = new Calculation();
	    			calc.setName(attribute[0]);
	    			calc.setValue(attribute[1]);
	    			p.addCalculation(calc);
	    		}
	    		
	    		ent.addPeriod(p);	    	//Cuando termino de agregarle valores al periodo, agrego el periodo a la empresa y vuelvo a buscar otra linea	
	    	}
	    	
	    	scanner.close();
	    	return ent;
	}	

}
