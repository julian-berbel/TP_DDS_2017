package modelo.method.result;

import org.uqbar.commons.utils.Observable;

import modelo.enterprise.Enterprise;

@Observable
public class Error extends Result {
	private Exception exception;
		
	public Error(Enterprise enterprise, Exception exception){
		super(enterprise);
		this.exception = exception;
	}

	@Override
	public Boolean isError(){
		return true;
	}
	
	public String getErrorMessage(){
		return exception.getMessage();
	}
}
