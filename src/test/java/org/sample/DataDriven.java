package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseclass.BaseClass;

public class DataDriven extends BaseClass {

	public static void main(String[] args) throws IOException {
		
		File f=new File("C:\\Users\\Rohith Kumar\\eclipse-workspace\\Sample\\DataSheets\\datasheet.xlsx");
		FileInputStream input=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(input);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(4);
		Cell c = r.getCell(0);
		System.out.println(c);
	}

}
