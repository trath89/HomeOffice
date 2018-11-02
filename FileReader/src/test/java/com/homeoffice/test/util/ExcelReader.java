package com.homeoffice.test.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ExcelReader {

    private static XSSFSheet ExcelSheet;
    
    private static XSSFWorkbook ExcelWBook;

	private static Workbook workbook;

    public List<String[]> readAllRowsExcel(String filePath, String sheetName) {
        List<String[]> myVehicleList = new ArrayList<String[]>();

        int rows = 0;
        try {
            FileInputStream ExcelFile = new FileInputStream(filePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelSheet = ExcelWBook.getSheet(sheetName);
            rows = ExcelSheet.getPhysicalNumberOfRows();
        } catch (IOException e) {
        	e.printStackTrace();
			System.err.println("File Not Found");
		}

        for (int rowNum = 0; rowNum < rows; rowNum++) {
            myVehicleList.add(readExcelRow(filePath, sheetName, rowNum));
        }
        return myVehicleList;
    }

    private String[] readExcelRow(String filePath, String sheetName, int rowNum) {

        String[] vehicleData = new String[3];
        try {
            FileInputStream ExcelFile = new FileInputStream(filePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelSheet = ExcelWBook.getSheet(sheetName);
            vehicleData[0] = (ExcelSheet.getRow(rowNum).getCell(0).getStringCellValue());
            vehicleData[1] = (ExcelSheet.getRow(rowNum).getCell(1).getStringCellValue());
            vehicleData[2] = (ExcelSheet.getRow(rowNum).getCell(2).getStringCellValue());
            return vehicleData;
        } catch (IOException e) {
            return vehicleData;
        }
    }
    
    private List<String>  read(String filePath){
    	
    	List<String> myVehicleList = new ArrayList<String>();
    	    	
    	try {
            FileInputStream excelFile = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
            	Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    myVehicleList.add(currentCell.getStringCellValue());

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return myVehicleList;
    }
    
}
