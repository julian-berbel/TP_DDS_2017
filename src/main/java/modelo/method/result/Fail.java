package modelo.method.result;

import modelo.enterprise.Enterprise;

public class Fail extends Result {
	
	public Fail(Enterprise enterprise){
		super(enterprise);
	}
	
	public void insertInto(MethodReport report) {
    report.addFail(this);
  }
}
