package com.java.testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class TestDataInput {
	static Workbook workbook;
	static Sheet sheet;
	public static String excel_file = "C:\\Users\\lenovo pc\\Desktop\\New folder\\udhay\\Book1.xlsx";

	@DataProvider(name = "source")
	public static Object[][] getTestData() throws EncryptedDocumentException, IOException {

		File file = new File(excel_file);
		FileInputStream fis = new FileInputStream(file);
		workbook = WorkbookFactory.create(fis);
		sheet = workbook.getSheetAt(0);
		DataFormatter df = new DataFormatter();
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {

				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));

			}
		}
		return data;

	}

}
