package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven3 {

	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\Rohith Kumar\\eclipse-workspace\\Sample\\DataSheets\\datasheet.xlsx");
		FileInputStream input=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(input);
		Sheet s = w.getSheet("Sheet1");
		int numberOfRows = s.getPhysicalNumberOfRows();
		String value = null;
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int cellType = c.getCellType();
				if (cellType==1) {
					value = c.getStringCellValue();
				}
				else if (DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
				}else {
					double d = c.getNumericCellValue();
					long l= (long)d;
					value = String.valueOf(l);
				}
				System.out.println(value);
			}
		}
	}

}
