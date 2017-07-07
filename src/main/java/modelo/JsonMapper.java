package modelo;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;

public class JsonMapper {

	public void mapper(JsonReader reader)
	{
		Gson gson = new Gson();
		
		
		ArrayList<Enterprise> enterpriseList = gson.fromJson(reader, new TypeToken<List<Enterprise>>(){}.getType());
		EnterpriseRepository.setEnterpriseList(enterpriseList);
	}
}
