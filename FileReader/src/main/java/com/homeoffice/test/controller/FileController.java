package com.homeoffice.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.homeoffice.test.model.FileInfo;
import com.homeoffice.test.service.FileService;

import java.util.List;

@Controller
public class FileController {

    private FileService fileService;
    
   @Autowired
    public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

    public List<FileInfo> getFiles(String directoryName){
        return fileService.getFiles(directoryName);
    }
    
    public List<FileInfo> setListOfSupportedFiles(String directoryName, List<String> extensions){
    	return fileService.setListOfSupportedFiles(directoryName, extensions);
    }

}
