package com.homeoffice.test.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homeoffice.test.controller.FileController;
import com.homeoffice.test.model.FileInfo;

import java.util.ArrayList;
import java.util.List;

public class ServiceReader {

    public List<String[]> getVehicleInfo(String fileType, String folderName) {
    	
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext(new String[] {"Spring-AutoScan.xml"});
    	FileController fileController = (FileController) context.getBean("fileController");
    	
        CSVReader csvReader = new CSVReader();
        ExcelReader excelReader = new ExcelReader();
        List<String> extensions = new ArrayList<String>();
        List<FileInfo> matchingFiles;
        extensions.add(fileType);
        matchingFiles = fileController.setListOfSupportedFiles(folderName, extensions);
        List<String[]> myVehicleList = new ArrayList<String[]>();
        for (FileInfo fileInfo : matchingFiles) {
            if (fileType.equals("csv") && fileInfo.getFileExtension().equals("csv")) {
                myVehicleList = csvReader.getContents(folderName + "/" + fileInfo.getFileName(), myVehicleList);
            } else if (fileType.equals("xlsx") && fileInfo.getFileExtension().equals("xlsx")) {
                myVehicleList = excelReader.readAllRowsExcel(folderName + "/" + fileInfo.getFileName(), "Sheet1");
            } else {
                System.err.println("The file is not supported");
            }
        }
        return myVehicleList;
    }
}
