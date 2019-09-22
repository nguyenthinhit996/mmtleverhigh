/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comon;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author peter
 */
public class FileInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String destinationDirectory;
    private String ipServerFile;
    private List<String>lsName;
    private int status;

    public FileInfo() {
    }

    public FileInfo(String destinationDirectory, String ipServerFile, List<String> lsName, int status) {
        this.destinationDirectory = destinationDirectory;
        this.ipServerFile = ipServerFile;
        this.lsName = lsName;
        this.status = status;
    }

    

    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    public String getIpServerFile() {
        return ipServerFile;
    }

    
    public List<String> getLsName() {
        return lsName;
    }

    public int getStatus() {
        return status;
    }

     

    public void setDestinationDirectory(String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }

    public void setIpServerFile(String ipServerFile) {
        this.ipServerFile = ipServerFile;
    }

    

    public void setLsName(List<String> lsName) {
        this.lsName = lsName;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
