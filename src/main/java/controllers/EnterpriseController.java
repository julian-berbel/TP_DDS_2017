package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;

import modelo.JsonMapper;
import modelo.enterprise.Enterprise;
import modelo.enterprise.EnterpriseRepository;
import modelo.indicator.cache.CalculationCache;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class EnterpriseController extends Controller {
	public ModelAndView list(Request req, Response res){
		List<Enterprise> enterprises = withTransaction(() -> EnterpriseRepository.getInstance().getList());
		return new ModelAndView(enterprises, "enterprises/list.hbs");
	}
	
	public ModelAndView show(Request req, Response res){		
		Enterprise enterprise = withTransaction(() -> EnterpriseRepository.getInstance().getById(id(req)));
		return new ModelAndView(enterprise, "enterprises/show.hbs");
	}
	
	public Void batchLoad(Request req, Response res) {
		req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
		
        try (final InputStream in = req.raw().getPart("file").getInputStream()) {
        	String result = new BufferedReader(new InputStreamReader(in))
  				  							.lines().collect(Collectors.joining("\n"));
        	
        	withTransaction(() -> {
        		new JsonMapper().mapperFromJson(result);
        		CalculationCache.getInstance().clear();
        	});
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        res.redirect("/home");
        
        return null;
	}
	
	public Response delete(Request req, Response res){		
		withTransaction(() -> {
			Enterprise enteprise = EnterpriseRepository.getInstance().getById(id(req));
			EnterpriseRepository.getInstance().deleteElement(enteprise);
		});
		
		
		return res;
	}
	public ModelAndView filter(Request req, Response res){		
		List<Enterprise> enterprises = withTransaction(() -> EnterpriseRepository.getInstance().filterByName(req.queryParams("name")));
		return new ModelAndView(enterprises, "enterprises/filter.hbs");
	}
}
