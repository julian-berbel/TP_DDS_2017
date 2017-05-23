package modelo;

import math.Operable;

public class Indicator implements Operable
{
	private String name = "";
	private String content = "";
	private Operable value;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getContent() 
	{
		return content;
	}
	
	public void setContent(String content) 
	{
		this.content = content;
	}

	public double reduce(){
		return value.reduce();
	}
}
