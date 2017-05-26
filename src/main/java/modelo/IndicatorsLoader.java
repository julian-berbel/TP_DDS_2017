package modelo;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import parser.IndicatorParser;

public class IndicatorsLoader
{
	private String filePath;
	
	public IndicatorsLoader(String filePath_)
	{
		filePath = filePath_;
	}
	public void read() throws IOException  
	{
        File inputWorkbook = new File(filePath);
        Workbook w;
        try 
        {
        	WorkbookSettings wkbkSet = new WorkbookSettings();
        	wkbkSet.setSuppressWarnings(true);
            w = Workbook.getWorkbook(inputWorkbook,wkbkSet);
            
            // Para usar la primera hoja
            Sheet sheet = w.getSheet(0);            
            Cell indicators = this.getCellWithString(sheet,"Indicadores");
            
	        int columnNumber = indicators.getColumn();
	        int rowNumber = indicators.getRow();
	        int columnIndex = columnNumber;
	        int rowIndex = rowNumber;
	        
            

			List<Indicator> list = new ArrayList<Indicator>();
            
	        while(!cellIsEmpty(sheet.getCell(columnIndex,rowIndex)))
	        {
	        	rowIndex++;
	        	String name = sheet.getCell(columnIndex,rowIndex).getContents();
	        	String formula = sheet.getCell(columnIndex+1,rowIndex).getContents();
	        	Indicator indicator = new Indicator(name, formula, IndicatorParser.parseIndicator(formula));
	        	list.add(indicator);
	        }
	        	IndicatorRepository.setIndicatorList(list);
	        	
        } catch (BiffException e) //Esta excepcion es por que este API solo lee .xls, Hay que catchearlo en la window para que le informe al usuario que solo soporta .xls
        {
            e.printStackTrace();
        }
    }
	
	 public Cell getCellWithString(Sheet sheet,String string)
	 {
		 for (int j = 0; j < sheet.getColumns(); j++) 
	     {
			 for (int i = 0; i < sheet.getRows(); i++) 
	         {
				 Cell cell = sheet.getCell(j, i);
	             CellType type = cell.getType();
	                
	             if (type == CellType.LABEL) 
	             {
	            	 if(string.equals(cell.getContents()))
	                 {
	                	return cell;
	                 }
	             }
	                 
	        }
	     }
		 return null;
	 }
	
	public Boolean cellIsEmpty(Cell cell)
	{
		return cell.getContents().isEmpty();
	}
	
	

}
