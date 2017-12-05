package modelo.indicator;

import java.io.File;
import java.io.IOException;
import exceptions.RepeatedIndicatorExcelException;
import exceptions.RepeatedIndicatorInSystemException;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class IndicatorsManager {
  private static String filePath;
  private static String sheetName;
  public static Boolean fileLoaded = false;

  public static void setFilePath(String path) {
    filePath = path;
  }

  public static void read() throws IOException, BiffException {
    File inputWorkbook = new File(filePath);
    Workbook w;

    WorkbookSettings wkbkSet = new WorkbookSettings();
    wkbkSet.setSuppressWarnings(true);
    w = Workbook.getWorkbook(inputWorkbook, wkbkSet);

    // Para usar la primera hoja
    Sheet sheet = w.getSheet(0);

    sheetName = sheet.getName();
    Cell indicators = getCellWithString(sheet, "Indicadores");

    int columnNumber = indicators.getColumn();
    int rowNumber = indicators.getRow();

    String repeatedString = null;
    if ((repeatedString = repeatedIndicatorExcel(sheet, columnNumber, rowNumber + 1)) != null) {
      throw new RepeatedIndicatorExcelException(repeatedString);
    } else if ((repeatedString = repeatedIndicatorSystem(sheet, columnNumber, rowNumber + 1)) != null) {
      throw new RepeatedIndicatorInSystemException(repeatedString);
    } else {
      int columnIndex = columnNumber;
      int rowIndex = rowNumber + 1;

      while (!cellIsEmpty(sheet.getCell(columnIndex, rowIndex))) {
        String name = sheet.getCell(columnIndex, rowIndex).getContents();
        String formula = sheet.getCell(columnIndex + 1, rowIndex).getContents();

        Indicator indicator = new Indicator(name, formula);

        IndicatorRepository.getInstance().addElement(indicator);

        rowIndex++;
      }
      fileLoaded = true;
      w.close();
      /*
       * se estaban leyendo todos los indicadores y recien a lo ultimo se
       * agregaban a indicatorRepository, entonces al leer la cuenta 'Margen'
       * que usa el @IngresoNeto tiraba error porque @IngresoNeto no existia en
       * indicatorRepository todavia
       */
    }
  }

  public static Cell getCellWithString(Sheet sheet, String string) {
    for (int j = 0; j < sheet.getColumns(); j++) {
      for (int i = 0; i < sheet.getRows(); i++) {
        Cell cell = sheet.getCell(j, i);
        CellType type = cell.getType();

        if (type == CellType.LABEL) {
          if (string.equals(cell.getContents())) {
            return cell;
          }
        }
      }
    }

    return null;
  }

  public static String repeatedIndicatorSystem(Sheet sheet, int columnNumber, int rawNumber) {

    for (int i = rawNumber; i < sheet.getRows(); i++) {
      Cell cell = sheet.getCell(columnNumber, i);
      String indicatorName = cell.getContents();

      if (IndicatorRepository.getInstance().alreadyExists(indicatorName)) {
        return indicatorName;
      }
    }

    return null;
  }

  public static String repeatedIndicatorExcel(Sheet sheet, int columnNumber, int rawNumber) {

    for (int i = rawNumber; i < sheet.getRows(); i++) {
      Cell cell = sheet.getCell(columnNumber, i);
      String indicatorName = cell.getContents();
      if (indicatorName != "") {

        for (int i2 = i + 1; i2 < sheet.getRows(); i2++) {

          Cell cell2 = sheet.getCell(columnNumber, i2);
          if (indicatorName.equals(cell2.getContents())) {
            if (indicatorName.isEmpty() == false) {
              return indicatorName;
            }
          }
        }
      }
    }

    return null;
  }

  public static void deleteSheetContents(WritableSheet sheet) throws RowsExceededException, WriteException {
    for (int j = 0; j < sheet.getColumns(); j++) {
      for (int i = 0; i < sheet.getRows(); i++) {
        Label label = new Label(j, i, new String());
        sheet.addCell(label);
      }
    }
  }

  public static Boolean cellIsEmpty(Cell cell) {
    return cell.getContents().isEmpty();
  }

  public static void writeExcel() throws BiffException, IOException, WriteException {
    WorkbookSettings wkbkSet = new WorkbookSettings();
    wkbkSet.setSuppressWarnings(true);
    Workbook target_workbook = Workbook.getWorkbook(new File(filePath), wkbkSet);
    WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath), target_workbook);

    WritableSheet sheet = workbook.getSheet(sheetName);
    Cell indicators = getCellWithString(sheet, "Indicadores");
    int columnNumber = indicators.getColumn();
    int rowNumber = indicators.getRow();
    int columnIndex = columnNumber;
    int rowIndex = rowNumber + 1;

    deleteSheetContents(sheet);

    Label label = new Label(columnNumber, rowNumber, "Indicadores");
    sheet.addCell(label);
    Label label2 = new Label(columnNumber + 1, rowNumber, "Formula");
    sheet.addCell(label2);

    for (int index = 0; index < IndicatorRepository.getInstance().getList().size(); index++) {
      Label indicator = new Label(columnIndex, rowIndex,
          IndicatorRepository.getInstance().getList().get(index).getName());
      sheet.addCell(indicator);
      Label formula = new Label(columnIndex + 1, rowIndex,
          IndicatorRepository.getInstance().getList().get(index).getFormula());
      sheet.addCell(formula);
      rowIndex++;
    }

    workbook.write();
    workbook.close();

  }

  public static Boolean fileLoaded() {
    return fileLoaded;
  }
}
