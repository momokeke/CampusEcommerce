package com.seu.dm.entities;

public class Picture {
    private Integer id;

    private byte[] binaryFile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getBinaryFile() {
        return binaryFile;
    }

    public void setBinaryFile(byte[] binaryFile) {
        this.binaryFile = binaryFile;
    }
}