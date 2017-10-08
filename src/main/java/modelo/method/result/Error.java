package modelo.method.result;

import modelo.enterprise.Enterprise;

public class Error extends Result {
	private Exception exception;
		
	public Error(Enterprise enterprise, Exception exception){
		super(enterprise);
		this.exception = exception;
	}
	
	public String getErrorMessage(){
		return exception.getMessage();
	}
}
