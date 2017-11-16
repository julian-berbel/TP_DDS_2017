package modelo.enterprise;

import java.util.List;

import modelo.db.Repository;
import modelo.db.withFetchableName;

public class EnterpriseRepository extends Repository<Enterprise> implements withFetchableName<Enterprise>
{
	private static EnterpriseRepository instance = new EnterpriseRepository();
		
	private EnterpriseRepository(){
		super("Enterprise", Enterprise.class);
	}

	private String filePath;

	private Boolean fileLoaded= false;

	public static EnterpriseRepository getInstance(){
		return instance;
	}

	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public Boolean getFileLoaded() {
		return fileLoaded;
	}
	
	public void batchLoad(List<Enterprise> enterprises){
		enterprises.forEach(this::upsertByName);
	}
}
