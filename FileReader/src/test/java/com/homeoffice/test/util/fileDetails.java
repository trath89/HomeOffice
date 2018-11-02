package com.homeoffice.test.util;

class fileDetails {
    private final Long fileSize;
    private final String fileName;
    private final String mimeType;

    public fileDetails(long fileSize, String fileName, String mimeType) {
        this.fileSize = fileSize;
        this.fileName = fileName;
        this.mimeType = mimeType;
    }

    public Long getfileSize() {
        return fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

}
