/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appclientmmt;

import comon.AllFileInfo;
import comon.FileDowInfo;
import comon.FileInfo;
import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author peter
 */
public class jmainclient extends javax.swing.JFrame {

    // send notification when connect or exit connect to server master
    PrintWriter outServerMasterStream;

    // all file
    AllFileInfo allf;

    // is connect servermaster
    boolean isConnectServerMaster = false;

    // moi fileserver is mot thread (DatagramSocket) co moi port
    Map<Integer, DatagramSocket> mapDatagramSocket = new HashMap<>();

    // port user
    List<Integer> portuse = new ArrayList<>();

    // lay tieng trinh dang download neu dong bao cho fileserver
    Map<String, DatagramSocket> mapIsDownloading = new HashMap<>();
    
    // status of file process downloading file 
    DefaultListModel modelFiledownding = new DefaultListModel();

    /**
     * Creates new form jmainserver
     */
    public jmainclient() {
        initComponents();
        error.setVisible(false);
        lab_ipclient.setText(getIP());
        txt_ipservermas.setText(getIP());
        txt_portmas.setText("2222");

        // update list all file va list processs
        DefaultListModel model = new DefaultListModel();
        model.removeAllElements();
        list_allfile.setModel(model);
        list_process.setModel(model);

        // path save
        lab_path_save.setText("No Selection");
    }

    String getIP() {
        Enumeration e;
        try {
            e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();

                    if (i.isSiteLocalAddress()) {
                        System.out.println("i.isSiteLocalAddress()" + i.getHostAddress());
                        return i.getHostAddress();
                    }
                }
            }

        } catch (SocketException ex) {

        }
        return "localhost";
    }

    public class ServerStart implements Runnable {

        @Override
        public void run() {
            Socket sock;
            try {
                // ket noi voi Servermaster
                sock = new Socket(txt_ipservermas.getText().toString(), Integer.valueOf(txt_portmas.getText()));
                outServerMasterStream = new PrintWriter(sock.getOutputStream());
                // gui thong bao den day la file server
                outServerMasterStream.println("client");
                outServerMasterStream.flush();
                error.setText("Connect success ");
                error.setVisible(true);
                error.setForeground(Color.GREEN);
                // thread lang nghe ket noi tu server nhan thong tin all file

                ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
                while ((allf = (AllFileInfo) input.readObject()) != null) {
                    if (allf.getStatus() == 1) {
                        DefaultListModel model = new DefaultListModel();
                        for (FileInfo i : allf.getLsFile()) {
                            for (String j : i.getLsName()) {
                                String in = i.getIpServerFile() + "|" + i.getPortServerFile() + "|" + j;
                                model.addElement(in);
                            }
                        }
                        list_allfile.setModel(model);
                    } else {
                        DefaultListModel model = new DefaultListModel();
                        list_allfile.setModel(model);
                        allf.setLsFile(null);
                        error.setText("Error connect with server");
                        error.setForeground(Color.red);
                        error.setVisible(true);
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Ok ket noi thanh cong");
            } catch (IOException ex) {
                error.setText("Connect Error");
                error.setForeground(Color.red);
                error.setVisible(true);
                isConnectServerMaster = false;
                Thread.currentThread().interrupt();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(jmainclient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lab_ipclient = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_connect = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_portmas = new javax.swing.JTextField();
        txt_ipservermas = new javax.swing.JTextField();
        error = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_process = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_allfile = new javax.swing.JList<>();
        btn_downloadfile = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        lab_path_save = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(119, 194, 218));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 600));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("My IP:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel2.setText("Input information of server master");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("IP :");

        lab_ipclient.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lab_ipclient.setText("localhost");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setText("The files are available");

        btn_connect.setBackground(new java.awt.Color(83, 136, 53));
        btn_connect.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_connect.setText("Connect ");
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel4.setText("Information of client");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Port:");

        txt_portmas.setText("jTextField1");

        txt_ipservermas.setText("jTextField1");

        error.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        error.setForeground(new java.awt.Color(171, 22, 22));
        error.setText("Error connect");

        list_process.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list_process);

        list_allfile.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(list_allfile);

        btn_downloadfile.setBackground(new java.awt.Color(83, 136, 53));
        btn_downloadfile.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_downloadfile.setText("Download File");
        btn_downloadfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_downloadfileActionPerformed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(46, 45, 38));
        btn_cancel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_cancel.setText("Cancel Download");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        lab_path_save.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lab_path_save.setText("D:/abc");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel9.setText("The files are processing");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lab_ipclient))
                                    .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ipservermas, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_portmas)
                                    .addComponent(btn_connect, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 362, Short.MAX_VALUE)
                                .addComponent(btn_cancel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lab_path_save, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_downloadfile, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lab_ipclient, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txt_ipservermas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_portmas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_connect))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_downloadfile)
                    .addComponent(lab_path_save))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancel)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        // TODO add your handling code here:
        if (!isConnectServerMaster) {
            if (StringUtils.isEmpty(txt_ipservermas.getText())
                    || StringUtils.isEmpty(txt_portmas.getText())) {
                error.setText("Connect Error");
                error.setForeground(Color.red);
                error.setVisible(true);
            } else {
                error.setVisible(false);
                // conenct servermaster
                Thread serverStart = new Thread(new ServerStart());
                serverStart.start();
            }
        } else {
            error.setText("Connect is exist");
            error.setForeground(Color.GREEN);
            error.setVisible(true);
        }
    }//GEN-LAST:event_btn_connectActionPerformed

    private void btn_downloadfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_downloadfileActionPerformed
        // TODO add your handling code here:
        if (list_allfile.getModel().getSize() != 0) {
            if (list_allfile.getSelectedValue() != null) {
                String value = list_allfile.getSelectedValue();
                System.out.println(value);
                // check is downloading 
                if (!isDownloading(value)) {
                    // get path save
                    selectPathSave();
                    if (!lab_path_save.getText().equals("No Selection")) {
                        String regex = "\\|";
                        String[] spl = value.split(regex);
                        // kiem tra port da duoc tao chua
                        if (mapDatagramSocket.containsKey(Integer.valueOf(spl[1]))) {
                            Thread a = new Thread(new Send_Receive_File(spl[0], Integer.valueOf(spl[1]),
                                    spl[2], lab_path_save.getText(), mapDatagramSocket.get(Integer.valueOf(spl[1]))));
                            a.start();

                        } else {
                            // tao DatagramSocket clientSocket de gui nhan file
                            int port = Integer.valueOf(spl[1]);
                            try {
                                // socket chu 
                                DatagramSocket clientSocket = new DatagramSocket(port);
                                mapDatagramSocket.put(port, clientSocket);
                                Thread a = new Thread(new Send_Receive_File(spl[0], Integer.valueOf(spl[1]),
                                        spl[2], lab_path_save.getText(), clientSocket));
                                a.start();
                            } catch (Exception ex) {
                                Logger.getLogger(jmainclient.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            } else {
                Confim con = new Confim("Not choose file !!!");
                con.setLocation(400, 200);
                con.setAlwaysOnTop(true);
                con.setVisible(true);
            }
        } else {
            Confim con = new Confim("Not files in list !!!");
            con.setLocation(400, 200);
            con.setAlwaysOnTop(true);
            con.setVisible(true);
        }
    }//GEN-LAST:event_btn_downloadfileActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
         if (list_allfile.getModel().getSize() != 0) {
            if (list_allfile.getSelectedValue() != null) {
                
            }else{
                Confim con = new Confim("Not choose file !!!");
                con.setLocation(400, 200);
                con.setAlwaysOnTop(true);
                con.setVisible(true);
            }
         }else{
            Confim con = new Confim("Not files in list !!!");
            con.setLocation(400, 200);
            con.setAlwaysOnTop(true);
            con.setVisible(true);
         }
    }//GEN-LAST:event_btn_cancelActionPerformed

    boolean isDownloading(String value) {
        for (Map.Entry<String, DatagramSocket> ii : mapIsDownloading.entrySet()) {
            String[] slp = ii.getKey().split("\\|");
            if (value.equals(slp[2])) {
                return true;
            }
        }
        return false;
    }

    class Send_Receive_File implements Runnable {

        private static final int MAX_PIECES_OF_FILE_SIZE = 1024 * 63;
        private String ipServerFile;
        private int portServerFile;
        private String namefile;
        private String destinationName;
        private DatagramSocket clientSocket;

        public Send_Receive_File(String ipServerFile, int portServerFile, String namefile,
                String destinationName, DatagramSocket clientSocket) {
            this.ipServerFile = ipServerFile;
            this.portServerFile = portServerFile;
            this.namefile = namefile;
            this.destinationName = destinationName;
            this.clientSocket = clientSocket;
        }

        String getPort() {
            Random rand = new Random();
            int random = rand.nextInt((8999 - 8000) + 1) + 5000;
            return String.valueOf(random);
        }

        @Override
        public void run() {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos;
            String port;
            DatagramSocket socForServer;
            try {
                int indexModeldownloading=modelFiledownding.size();
                // gui thong tin den file server de dang ki port moi
                while (true) {
                    ByteArrayOutputStream byteofclient = new ByteArrayOutputStream();
                    ObjectOutputStream oosofclinet = new ObjectOutputStream(byteofclient);
                    while (true) {
                        port = getPort();
                        if (!portuse.contains(Integer.valueOf(port))) {
                            portuse.add(Integer.valueOf(port));
                            break;
                        }
                    }
                    String s = lab_ipclient.getText() + "|" + port + "|" + getNamefile();
                    System.out.print(" Gui " + s);
                    oosofclinet.writeUTF(s);
                    oosofclinet.flush();
                    DatagramPacket sendPacketofclient = new DatagramPacket(byteofclient.toByteArray(),
                            byteofclient.toByteArray().length, InetAddress.getByName(getIpServerFile()), getPortServerFile());
                    clientSocket.send(sendPacketofclient);
                    // nhan ket qua server
                    byte[] receiveInfor = new byte[MAX_PIECES_OF_FILE_SIZE];
                    DatagramPacket receiveFileDownLoadPk = new DatagramPacket(receiveInfor, receiveInfor.length);
                    clientSocket.receive(receiveFileDownLoadPk);
                    ByteArrayInputStream bais = new ByteArrayInputStream(
                            receiveFileDownLoadPk.getData());
                    ObjectInputStream ois = new ObjectInputStream(bais);
                    String sre = ois.readUTF();
                    if (sre.equals("ok")) {
                        socForServer = new DatagramSocket(Integer.valueOf(port));
                        break;
                    }
                }
                int portsocForServer = Integer.valueOf(port);
                // them cao map is downloading server file
                final String namemapIsDownloading = ipServerFile + "|" + port + "|" + namefile;
                mapIsDownloading.put(namemapIsDownloading, socForServer);

                //byte[] datafile=new byte[MAX_PIECES_OF_FILE_SIZE];
                //FileDowInfo filedowss= new FileDowInfo(namefile,datafile,ipServerFile,portServerFile,0,0,1);
                FileDowInfo filedowss = new FileDowInfo();
                filedowss.setIpServerFile(ipServerFile);
                filedowss.setPortServer(portsocForServer);
                filedowss.setNameFile(namefile);
                filedowss.setSogoithu(0);
                filedowss.setSoluonggoi(0);
                filedowss.setStatus(1);

                // gui thong ten file can dowloadn
                oos = new ObjectOutputStream(baos);
                oos.writeObject(filedowss);
                DatagramPacket sendPacket = new DatagramPacket(baos.toByteArray(),
                        baos.toByteArray().length, InetAddress.getByName(getIpServerFile()), portsocForServer);
                socForServer.send(sendPacket);

                // tao file nay trong cline
                System.out.println("Create file...");
                File fileRecetver = new File(destinationName + File.separatorChar + namefile);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileRecetver));
                System.out.println("Receiving nhan thong tin khich thuoch file...");

                // nhan thong tin khich thuoc file
                byte[] receiveFileDownLoad = new byte[MAX_PIECES_OF_FILE_SIZE];
                DatagramPacket receiveFileDownLoadPk = new DatagramPacket(receiveFileDownLoad, receiveFileDownLoad.length);
                socForServer.receive(receiveFileDownLoadPk);
                ByteArrayInputStream bais = new ByteArrayInputStream(
                        receiveFileDownLoadPk.getData());
                ObjectInputStream ois = new ObjectInputStream(bais);
                FileDowInfo filedownreceive = (FileDowInfo) ois.readObject();   
                
                // set status 
                // status downloading file
                String filestatus=namefile+"|0%";
                modelFiledownding.set(indexModeldownloading, filestatus);
                list_process.setModel(modelFiledownding);
                
                // nhan tat ca cac goi cua file
                List<FileDowInfo> listFile;
                List<Integer> PacketReceive;
                Map<List<FileDowInfo>, List<Integer>> dsFiledownreceive = new HashMap<>();
                int sogoi = filedownreceive.getSoluonggoi();
                long timenhan = sogoi * 750; // moi goi 750 milisecond  ( 10mb ~ 2 minute)
                System.out.println(" start nhan goi trong " + timenhan + " mili s ");
                dsFiledownreceive = readPackTiList(timenhan, socForServer, sogoi,indexModeldownloading,0);
                Iterator mapFileVsPack = dsFiledownreceive.entrySet().iterator();
                Map.Entry entry = (Map.Entry) mapFileVsPack.next();
                listFile = (List<FileDowInfo>) entry.getKey();
                PacketReceive = (List<Integer>) entry.getValue();             
                
                while (true) {
                    if (listFile.size() != sogoi) {
                        System.out.println("Loii khong du goi gui lai server file Thieu goi tin :");
                        Set<Integer> seti = getPacketLost(PacketReceive, sogoi);
                        String s = xuatSet(seti);
                        System.out.println("So goi tin thieu gui ve file server " + s);
                        // gui thong bao la thieu goi tin 
                        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
                        ObjectOutputStream oos2 = new ObjectOutputStream(baos2);
                        oos2.writeUTF(s);
                        oos2.flush();
                        DatagramPacket sendPacket2 = new DatagramPacket(baos2.toByteArray(),
                                baos2.toByteArray().length, InetAddress.getByName(getIpServerFile()), portsocForServer);
                        socForServer.send(sendPacket2);

                        Map<List<FileDowInfo>, List<Integer>> dsFiledownreceive2 = new HashMap<>();
                        // get length of so goi mat
                        String[] spl = s.split("\\,");
                        long timenhan2 = spl.length * 750;
                        System.out.println(" start nhan " + spl.length + " goi trong " + timenhan2 + " mili s ");
                        dsFiledownreceive2 = readPackTiList(timenhan2, socForServer, spl.length,indexModeldownloading,dsFiledownreceive.size());
                        Iterator mapFileVsPack2 = dsFiledownreceive2.entrySet().iterator();
                        Map.Entry entry2 = (Map.Entry) mapFileVsPack2.next();
                        // nhan tat ca cac goi cua file
                        List<FileDowInfo> listFile2 = (List<FileDowInfo>) entry2.getKey();
                        //List<Integer> PacketReceive2 = (List<Integer>) entry2.getValue();
                        for (FileDowInfo i : listFile2) {
                            if (!PacketReceive.contains(i.getSogoithu())) {
                                listFile.add(i);
                                PacketReceive.add(i.getSogoithu());
                            }
                        }

                    } else {
                        // bao serfile la ok roi
                        for (int i = 0; i < 10; i++) {
                            System.out.println("gui lai server file OK");
                            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
                            ObjectOutputStream oos2 = new ObjectOutputStream(baos2);
                            oos2.writeUTF("ok");
                            oos2.flush();
                            DatagramPacket sendPacket2 = new DatagramPacket(baos2.toByteArray(),
                                    baos2.toByteArray().length, InetAddress.getByName(getIpServerFile()), portsocForServer);
                            socForServer.send(sendPacket2);
                            Thread.sleep(100);
                        }
                        break;
                    }
                }

                // keim tra dong goi file lai
                Collections.sort(listFile, new FiledownreceiveComparator());
                for (FileDowInfo i : listFile) {
                    System.out.println(i.getSogoithu());
                    if (i.getSogoithu() == i.getSoluonggoi()) {
                        bos.write(i.getDatafile(), 0, i.getGoicuoicung());
                    } else {
                        bos.write(i.getDatafile(), 0, i.getDatafile().length);
                    }

                    bos.flush();
                    System.out.println("Ghi thanh cong");
                }
                Iterator<Integer> itr = portuse.iterator();
                while (itr.hasNext()) {
                    if (itr.next() == portsocForServer) {
                        itr.remove();
                        break;
                    }
                }
                // chay xong xoa no trong isdonwloading
                for (Map.Entry<String, DatagramSocket> ii : mapIsDownloading.entrySet()) {
                    if (ii.getKey().equals(namemapIsDownloading)) {
                        mapIsDownloading.remove(ii.getKey());
                        break;
                    }
                }
                // tai xong dung tieng trinh luon
                Thread.currentThread().interrupt();
            } catch (Exception ex) {
                Logger.getLogger(jmainclient.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }

        }

        Map<List<FileDowInfo>, List<Integer>> readPackTiList(long maxtime, DatagramSocket socForServer, int maxgoi,int indexs,int numdownloaded) {
            Map<List<FileDowInfo>, List<Integer>> mapdsFiledownreceives = new HashMap<>();
            List<FileDowInfo> dsFiledownreceives = new ArrayList<>();
            List<Integer> dspacket = new ArrayList<>();
            long timestart = System.currentTimeMillis();
            int index = 1;
            
             
            try {
                while (true) {

                    if ((System.currentTimeMillis() - timestart) > maxtime) {
                        System.out.println("Qua time");
                        break;
                    }
                    byte[] receiveFileDownLoads = new byte[MAX_PIECES_OF_FILE_SIZE];
                    DatagramPacket receiveFileDownLoadPks = new DatagramPacket(receiveFileDownLoads, receiveFileDownLoads.length);
                    socForServer.receive(receiveFileDownLoadPks);
                    ByteArrayInputStream baiss = new ByteArrayInputStream(
                            receiveFileDownLoadPks.getData());
                    ObjectInputStream oiss = new ObjectInputStream(baiss);
                    FileDowInfo filedownreceives = (FileDowInfo) oiss.readObject();
                    System.out.println("Receiving File " + filedownreceives.getNameFile() + " goi " + filedownreceives.getSogoithu());
                    dsFiledownreceives.add(filedownreceives);
                    dspacket.add(filedownreceives.getSogoithu());
                    // status 3 gui file xong
                    if (filedownreceives.getStatus() == 3) {
                        break;
                    }
                    if (maxgoi == index) {
                        break;
                    }
                    index++;
                    int upmaxfilestatus=((dsFiledownreceives.size()+numdownloaded)/maxgoi)*100 ;
                    String upfilestatus=namefile+ "|"+String.valueOf(upmaxfilestatus)+"%";
                    modelFiledownding.set(indexs, upfilestatus);
                    list_process.setModel(modelFiledownding);
                }
            } catch (Exception ex) {
                Logger.getLogger(jmainclient.class.getName()).log(Level.SEVERE, null, ex);
            }
            mapdsFiledownreceives.put(dsFiledownreceives, dspacket);
            return mapdsFiledownreceives;
        }

        Set<Integer> getPacketLost(List<Integer> readPackTiList, int max) {
            Set<Integer> res = new HashSet<>();
            for (int i = 1; i <= max; i++) {
                if (!readPackTiList.contains(i)) {
                    res.add(i);
                }
            }
            return res;
        }

        String xuatSet(Set<Integer> getPacketLost) {
            StringBuilder a = new StringBuilder();
            for (int i : getPacketLost) {
                a.append(String.valueOf(i));
                a.append(",");
            }
            a.deleteCharAt(a.length() - 1);
            System.out.println(a);
            return a.toString();
        }

        // sort
        class FiledownreceiveComparator implements Comparator<FileDowInfo> {

            @Override
            public int compare(FileDowInfo o1, FileDowInfo o2) {
                if (o1.getSogoithu() > o2.getSogoithu()) {
                    return 1;
                }
                return -1;
            }
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
         * @return the portServerFile
         */
        public int getPortServerFile() {
            return portServerFile;
        }

        /**
         * @param portServerFile the portServerFile to set
         */
        public void setPortServerFile(int portServerFile) {
            this.portServerFile = portServerFile;
        }

        /**
         * @return the namefile
         */
        public String getNamefile() {
            return namefile;
        }

        /**
         * @param namefile the namefile to set
         */
        public void setNamefile(String namefile) {
            this.namefile = namefile;
        }

        /**
         * @return the destinationName
         */
        public String getDestinationName() {
            return destinationName;
        }

        /**
         * @param destinationName the destinationName to set
         */
        public void setDestinationName(String destinationName) {
            this.destinationName = destinationName;
        }

        /**
         * @return the clientSocket
         */
        public DatagramSocket getClientSocket() {
            return clientSocket;
        }

        /**
         * @param clientSocket the clientSocket to set
         */
        public void setClientSocket(DatagramSocket clientSocket) {
            this.clientSocket = clientSocket;
        }

    }

    void selectPathSave() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose Folde Save File");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());
            lab_path_save.setText(chooser.getSelectedFile().toString());
        } else {
            System.out.println("No Selection ");
            lab_path_save.setText("No Selection");
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (outServerMasterStream != null) {
            outServerMasterStream.print("exit");
            outServerMasterStream.flush();
        }
        // gui den cac serverfile dang download bao la Ok dong nghia vs viec hoang thanh down
        for (Map.Entry<String, DatagramSocket> ii : mapIsDownloading.entrySet()) {
            try {
                String slp[] = ii.getKey().split("\\|");
                System.out.println("gui lai server file OK");
                ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
                ObjectOutputStream oos2 = new ObjectOutputStream(baos2);
                oos2.writeUTF("ok");
                oos2.flush();
                DatagramPacket sendPacket2 = new DatagramPacket(baos2.toByteArray(),
                        baos2.toByteArray().length, InetAddress.getByName(slp[0]), Integer.valueOf(slp[1]));
                ii.getValue().send(sendPacket2);
            } catch (Exception e) {
                System.out.print(e);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jmainclient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jmainclient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jmainclient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jmainclient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jmainclient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_connect;
    private javax.swing.JButton btn_downloadfile;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lab_ipclient;
    private javax.swing.JLabel lab_path_save;
    private javax.swing.JList<String> list_allfile;
    private javax.swing.JList<String> list_process;
    private javax.swing.JTextField txt_ipservermas;
    private javax.swing.JTextField txt_portmas;
    // End of variables declaration//GEN-END:variables
}
