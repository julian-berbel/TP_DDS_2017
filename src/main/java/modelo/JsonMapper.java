package modelo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;

public class JsonMapper {
  public void mapperFromJson(String json) {
    ArrayList<Enterprise> enterpriseList = new Gson().fromJson(json, new TypeToken<List<Enterprise>>() {
    }.getType());
    EnterpriseRepository.getInstance().batchLoad(enterpriseList);
  }
}
