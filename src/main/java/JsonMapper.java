import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JsonMapper {

	public void mapper(JsonReader reader)
	{
		Gson gson = new Gson();
		
		
		ArrayList<Enterprise> enterpriseList = gson.fromJson(reader, new TypeToken<List<Enterprise>>(){}.getType());
		EnterpriseList.setEnterpriseList(enterpriseList);
	}
}
