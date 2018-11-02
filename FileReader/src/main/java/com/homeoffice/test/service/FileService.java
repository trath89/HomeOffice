package com.homeoffice.test.service;

import java.util.List;

import com.homeoffice.test.model.FileInfo;

public interface FileService {
	
	List<FileInfo> getFiles(String directoryName);
	
	List<FileInfo> setListOfSupportedFiles(String directoryName, List<String> extensions);
	
}
