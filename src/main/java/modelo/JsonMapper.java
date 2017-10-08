package modelo;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;

public class JsonMapper {
	
	public void mapperFromJson(JsonReader reader)
	{
		Gson gson = new Gson();
		
		
		ArrayList<Enterprise> enterpriseList = gson.fromJson(reader, new TypeToken<List<Enterprise>>(){}.getType());
		EnterpriseRepository.getInstance().importEnterprises(enterpriseList);		
	}
	public void mapperToFile()
	{
		Gson gson = new Gson();
		String json = gson.toJson(EnterpriseRepository.getInstance().getList());
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(EnterpriseRepository.getInstance().getFilePath());
	            pw = new PrintWriter(fichero);
                pw.print(json);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           //El finally para asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
}
