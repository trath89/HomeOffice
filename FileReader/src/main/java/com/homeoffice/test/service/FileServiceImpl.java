package com.homeoffice.test.service;

import com.homeoffice.test.model.FileInfo;
import com.homeoffice.test.service.FileService;

import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{
	
    private final Tika tika = new Tika();

    public List<FileInfo> getFiles(String directoryName) {
    	
        List<FileInfo> lstFileInfo = new ArrayList<FileInfo>();
        File directory = new File(directoryName);
                
        for (File file : directory.listFiles()) {
            String extension = getExtensionByApacheCommonLib(file.toString());
            FileInfo fileInformation = new FileInfo();
            fileInformation.setFileName(file.getName());
            fileInformation.setFileExtension(extension);
            fileInformation.setFileSize(file.length());
            try {
				fileInformation.setMimeType(tika.detect(file));
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("File not found");
			}
			
            lstFileInfo.add(fileInformation);
        }
        return lstFileInfo;
    }

    public List<FileInfo> setListOfSupportedFiles(String directoryName, List<String> extensions) {
        List<FileInfo> supportedFiles = new ArrayList<FileInfo>();
        for (FileInfo fileInfo : getFiles(directoryName)) {
            if (extensions.contains(fileInfo.getFileExtension())) {
                supportedFiles.add(fileInfo);
            }
        }
        return supportedFiles;
    }

    private String getExtensionByApacheCommonLib(String filename) {
        return FilenameUtils.getExtension(filename);
    }

}
