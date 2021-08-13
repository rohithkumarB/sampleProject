package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven2 {

	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\Rohith Kumar\\eclipse-workspace\\Sample\\DataSheets\\datasheet.xlsx");
		FileInputStream i=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(i);
		Sheet s = w.getSheet("Sheet1");
		for (int j = 0; j < s.getPhysicalNumberOfRows(); j++) {
			Row r = s.getRow(j);
			for (int k = 0; k < r.getPhysicalNumberOfCells(); k++) {
				Cell cell = r.getCell(k);
				System.out.println(cell);
			}
		}
		System.out.println("Number Of Row: "+s.getPhysicalNumberOfRows());
	}

}
