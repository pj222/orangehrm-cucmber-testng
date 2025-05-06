	package utils;

	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import java.io.FileInputStream;
	import java.io.IOException;

	public class Excelreader {
	    private Workbook workbook;
	    private Sheet sheet;

	    public Excelreader(String filePath, String sheetName) {
	        try {
	            FileInputStream file = new FileInputStream(filePath);
	            workbook = new XSSFWorkbook(file);
	            sheet = workbook.getSheet(sheetName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public String getCellData(int row, int col) {
	        return sheet.getRow(row).getCell(col).toString();
	    }

	    public int getRowCount() {
	        return sheet.getLastRowNum();
	    }

	    public void closeWorkbook() {
	        try {
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


