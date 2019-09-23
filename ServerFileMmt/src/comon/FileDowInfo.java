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
    private static long serialVersionUID = 1L;
    private String nameFile;
    private byte[] datafile; 
    private String ipServerFile;
    private int portServer;
    private int soluonggoi;
    private int sogoithu;
    // 1 bat dau gui , 2  dang gui , 3 gui hoang thanh.
    private int status;

    public FileDowInfo() {
    }

    public FileDowInfo(String nameFile, byte[] datafile, String ipServerFile, int portServer, int soluonggoi, int sogoithu, int status) {
        this.nameFile = nameFile;
        this.datafile = datafile;
        this.ipServerFile = ipServerFile;
        this.portServer = portServer;
        this.soluonggoi = soluonggoi;
        this.sogoithu = sogoithu;
        this.status = status;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the nameFile
     */
    public String getNameFile() {
        return nameFile;
    }

    /**
     * @param nameFile the nameFile to set
     */
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    /**
     * @return the datafile
     */
    public byte[] getDatafile() {
        return datafile;
    }

    /**
     * @param datafile the datafile to set
     */
    public void setDatafile(byte[] datafile) {
        this.datafile = datafile;
    }

    /**
     * @return the ipServerFile
     */
    public String getIpServerFile() {
        return ipServerFile;
    }

    /**
     * @param ipServerFile the ipServerFile to set
     */
    public void setIpServerFile(String ipServerFile) {
        this.ipServerFile = ipServerFile;
    }

    /**
     * @return the portServer
     */
    public int getPortServer() {
        return portServer;
    }

    /**
     * @param portServer the portServer to set
     */
    public void setPortServer(int portServer) {
        this.portServer = portServer;
    }

    /**
     * @return the soluonggoi
     */
    public int getSoluonggoi() {
        return soluonggoi;
    }

    /**
     * @param soluonggoi the soluonggoi to set
     */
    public void setSoluonggoi(int soluonggoi) {
        this.soluonggoi = soluonggoi;
    }

    /**
     * @return the sogoithu
     */
    public int getSogoithu() {
        return sogoithu;
    }

    /**
     * @param sogoithu the sogoithu to set
     */
    public void setSogoithu(int sogoithu) {
        this.sogoithu = sogoithu;
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

    
}
