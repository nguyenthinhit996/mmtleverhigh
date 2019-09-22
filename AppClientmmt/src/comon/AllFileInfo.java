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
public class AllFileInfo implements Serializable{
    private static long serialVersionUID = 1L;

    public static void setSerialVersionUID(long serialVersionUID) {
        AllFileInfo.serialVersionUID = serialVersionUID;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    // 1 live , 0 off
    private int status;
    private List<FileInfo> lsFile;

    public AllFileInfo() {
    }

     

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the lsFile
     */
    public List<FileInfo> getLsFile() {
        return lsFile;
    }

    /**
     * @param lsFile the lsFile to set
     */
    public void setLsFile(List<FileInfo> lsFile) {
        this.lsFile = lsFile;
    }

    public AllFileInfo(int status, List<FileInfo> lsFile) {
        this.status = status;
        this.lsFile = lsFile;
    }
    
    
}
