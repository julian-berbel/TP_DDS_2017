import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.stream.JsonReader;

public class FileLoader {
	private String filePath= "";
	
	public FileLoader(String path){
		filePath = path;
	}
	
	public JsonReader reader() throws FileNotFoundException  {
		return new JsonReader(new FileReader(filePath));
	}
	
}

