/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comon;

import java.io.Serializable;

/**
 *
 * @author peter
 */
public class FileDowInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nameFile;
    private String ipServerFile;
    private int portServer;

    public FileDowInfo(String nameFile, String ipServerFile, int portServer) {
        this.nameFile = nameFile;
        this.ipServerFile = ipServerFile;
        this.portServer = portServer;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getIpServerFile() {
        return ipServerFile;
    }

    public int getPortServer() {
        return portServer;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void setIpServerFile(String ipServerFile) {
        this.ipServerFile = ipServerFile;
    }

    public void setPortServer(int portServer) {
        this.portServer = portServer;
    }
    
    
    
    
}
