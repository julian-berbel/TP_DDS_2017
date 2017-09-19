package viewModel;

import modelo.JsonMapper;

public class SaveChangesVM 
{
	
	public void exportToFile()
	{
		JsonMapper jsonMapper= new JsonMapper();
		jsonMapper.mapperToFile();
	}
	
}
