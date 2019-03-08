package utilities;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	Workbook book;
	Sheet sheet;

	// open a connection to the excel file
	public void setExcel(String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(BrowserHelper.getFilePath("resources", fileName));
			if (fileName.endsWith("xlsx")) {
				book = new XSSFWorkbook(fis);
			} else if (fileName.endsWith("xls")) {
				book = new HSSFWorkbook(fis);
			}
			sheet = book.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// count the number of rows
	public int getRowCount() {
		return sheet.getLastRowNum();
	}

	// count the number of columns
	public int getColumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	// read the data at a given cell
	public String readData(int r, int c) {
		Object data = null;
		Cell cell = sheet.getRow(r).getCell(c);
		CellType cType = cell.getCellTypeEnum();
		switch (cType) {
		case NUMERIC:
			data = (int) cell.getNumericCellValue();
			break;
		case STRING:
			data = cell.getStringCellValue();
			break;
		default:
			break;
		}
		return data.toString();
	}

	// read complete sheet data into 2D array
	public String[][] getExcelData(String fileName, String sheetName) {
		setExcel(fileName, sheetName);
		int nor = getRowCount();
		int noc = getColumnCount();
		String[][] data = new String[nor][noc];
		for (int r = 0; r < nor; r++) {
			for (int c = 0; c < noc; c++) {
				data[r][c] = readData(r+1, c);
			}
		}
		return data;
	}

	
	public static void main(String[] args) {
		ExcelHelper obj = new ExcelHelper();
		String[][] excelData = obj.getExcelData("testdata.xls", "roledata");
		for(String[] row : excelData) {
			for(String cell : row) {
				System.out.print(cell +"\t");
			}
			System.out.println();
		}
	}
}
