/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appservermmt;

import comon.AllFileInfo;
import comon.FileInfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter
 */
public class jmainserver extends javax.swing.JFrame {

    // gui ver fileserver if shutdown
    ArrayList clientOutputStreams;
    
    // gui ver fileserver if shutdown
    ArrayList fileServerOutputStreams;
    
    // list file
    List<FileInfo> listFile= new ArrayList<>();
    
    
    String ip =getIP();
    int port=2222;
    
    /**
     * Creates new form jmainserver
     */
    public jmainserver() {
        initComponents();
        lab_ipservermaster.setText(ip);
        lab_portservermaster.setText(String.valueOf(port));
        startServer();
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
        lab_portservermaster = new javax.swing.JLabel();
        lab_ipservermaster = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btn_clearscript = new javax.swing.JButton();
        btn_savescript1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Master");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(119, 194, 218));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("IP:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel2.setText("Information of server master");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Port:");

        lab_portservermaster.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lab_portservermaster.setText("2222");

        lab_ipservermaster.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lab_ipservermaster.setText("localhost");

        txt_area.setEditable(false);
        txt_area.setColumns(20);
        txt_area.setRows(5);
        jScrollPane1.setViewportView(txt_area);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setText("Information of connections");

        btn_clearscript.setBackground(new java.awt.Color(171, 153, 36));
        btn_clearscript.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_clearscript.setText("Clear ");
        btn_clearscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearscriptActionPerformed(evt);
            }
        });

        btn_savescript1.setBackground(new java.awt.Color(171, 153, 36));
        btn_savescript1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_savescript1.setText("Save ");
        btn_savescript1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_savescript1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_savescript1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_clearscript, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(lab_ipservermaster)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lab_portservermaster, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(lab_portservermaster)
                    .addComponent(lab_ipservermaster, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clearscript)
                    .addComponent(btn_savescript1))
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
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

    private void btn_clearscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearscriptActionPerformed
        // TODO add your handling code here:
        txt_area.setText("");
    }//GEN-LAST:event_btn_clearscriptActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        tellEveryClientShutDownOrUpdateAllFile(0);
        tellEveryFileServerShutdown();
    }//GEN-LAST:event_formWindowClosing

    private void btn_savescript1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_savescript1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_savescript1ActionPerformed

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
            java.util.logging.Logger.getLogger(jmainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jmainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jmainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jmainserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jmainserver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clearscript;
    private javax.swing.JButton btn_savescript1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lab_ipservermaster;
    private javax.swing.JLabel lab_portservermaster;
    private javax.swing.JTextArea txt_area;
    // End of variables declaration//GEN-END:variables

    public class ServerStart implements Runnable 
    {
        void printFileConnect(int act,FileInfo f){
         if(act==-1){
             txt_area.append("------- Lost a file info---------\n");
             txt_area.append(f.getIpServerFile()+"\n");
             txt_area.append(f.getDestinationDirectory()+"\n");
             for(String i:f.getLsName()){
                 txt_area.append(i+"\n");
             }
             txt_area.append("------- Lost a file info---------\n");
         }
         if(act==1){
             txt_area.append("------- Add a file info---------\n");
             txt_area.append("/n");
             txt_area.append(f.getIpServerFile());
             txt_area.append("/n");
             txt_area.append(f.getDestinationDirectory());
             for(String i:f.getLsName()){
                 txt_area.append(i);
                 txt_area.append("/n");
             }
             txt_area.append("------- Add a file info---------\n");
         }
     }
        @Override
        public void run() 
        {
            clientOutputStreams = new ArrayList();
            fileServerOutputStreams= new ArrayList();

            try 
            {
                // server for serverfile
                ServerSocket serverSock = new ServerSocket(2222);
                
                while (true) 
                {
				Socket Sock = serverSock.accept();
				PrintWriter writer = new PrintWriter(Sock.getOutputStream());
                                
                                InputStreamReader isReader = new InputStreamReader(Sock.getInputStream());
                                BufferedReader reader = new BufferedReader(isReader);
                                String identity;
                                if((identity = reader.readLine()) != null){
                                    if(identity.equals("client")){
                                        // send all infor files to client
                                        ObjectOutputStream  out= new ObjectOutputStream(Sock.getOutputStream());
                                        AllFileInfo allf= new AllFileInfo();
                                        if(listFile.size()!=0){
                                            allf.setLsFile(listFile);
                                            allf.setStatus(1);
                                            out.writeObject(allf);
                                            out.reset();
                                        }
                                        
                                        // tao thread client
                                        Thread listener = new Thread(new ClientHandler(Sock, out));
                                        listener.start();
                                        clientOutputStreams.add(out);
                                        txt_area.append("Got a connection client. "+Sock.getInetAddress()+"\n");
                                    }
                                    else{

                                        // tao thread file server
                                        Thread listener = new Thread(new FileServerHandler(Sock, writer));
                                        listener.start();
                                        fileServerOutputStreams.add(writer);
                                        txt_area.append("Got a connection FileServer. "+Sock.getInetAddress()+"\n"); 
                                    }
                                }

				
                }
            }
            catch (Exception ex)
            {
                txt_area.append("Error making a connection. \n");
            }
        }
    }
    
    // thread client
    public class ClientHandler implements Runnable	
    {
       BufferedReader inClient;
       Socket sockClient;
       ObjectOutputStream Outclient;

       public ClientHandler(Socket clientSocket, ObjectOutputStream out) 
       {
            Outclient = out;
            try 
            {
                sockClient = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sockClient.getInputStream());
                inClient = new BufferedReader(isReader);
            }
            catch (Exception ex) 
            {
                txt_area.append("Unexpected error ClientHandler... \n");
            }

       }

       @Override
       public void run() 
       {
            String message ;
            String[] data;

            try 
            {
                    while ((message = inClient.readLine()) != null) 
                    {
                        if(message.equals("exit")){
                            txt_area.append("Lost conect Client " + message +sockClient.getInetAddress() +"\n");
                            clientOutputStreams.remove(Outclient);
                            Thread.currentThread().interrupt();
                        }
                    }
             } 
             catch (Exception ex) 
             {
                txt_area.append("Lost conect Client "+sockClient.getInetAddress()+"\n");
                ex.printStackTrace();
                clientOutputStreams.remove(Outclient);
             }
	} 
    }
    
    // thread file server
    public class FileServerHandler implements Runnable	
    {
                                        
       ObjectInputStream inFileServer;
       Socket sockFileServer;
       PrintWriter outFileServer;

       public FileServerHandler(Socket Socket, PrintWriter out) 
       {
            outFileServer = out;
            try 
            {
                sockFileServer = Socket;
                inFileServer = new ObjectInputStream(sockFileServer.getInputStream());
            }
            catch (Exception ex) 
            {
                txt_area.append("Unexpected error FileServerHandler... \n");
            }

       }

       @Override
       public void run() 
       {
            try 
            {
                FileInfo fileInfo;
                while ( (fileInfo=(FileInfo) inFileServer.readObject()) != null) 
                {     
                    if(fileInfo.getStatus()==0){
                       
                        Iterator<FileInfo> in=listFile.iterator();
                        while(in.hasNext()){
                            FileInfo f=in.next();
                            if(f.getIpServerFile().equals(fileInfo.getIpServerFile())
                            && fileInfo.getPortServerFile() == f.getPortServerFile()){
                               in.remove();
                               printFileConnect(0, f);
                           }
                        }
                        tellEveryClientShutDownOrUpdateAllFile(1);
                        fileServerOutputStreams.remove(outFileServer);
                        Thread.currentThread().interrupt();
                    }else{
                        listFile.add(fileInfo);
                        printFileConnect(1, fileInfo);
                        tellEveryClientShutDownOrUpdateAllFile(1);
                    }
                   
                } 
             } 
             catch (Exception ex) 
             {
                txt_area.append("Lost a connection FileServer. "+sockFileServer.getInetAddress()+"\n");
                ex.printStackTrace();
                fileServerOutputStreams.remove(outFileServer);
             }
	} 
    }
     
     String getIP()
     {
         Enumeration e;
        try {
            e = NetworkInterface.getNetworkInterfaces();
            while(e.hasMoreElements())
            {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements())
                {
                    InetAddress i = (InetAddress) ee.nextElement();

                    if(i.isSiteLocalAddress()){
                        System.out.println("i.isSiteLocalAddress()"+i.getHostAddress());
                        return i.getHostAddress();
                    }
                }
            }
           
        } catch (SocketException ex) {
            Logger.getLogger(jmainserver.class.getName()).log(Level.SEVERE, null, ex);
            txt_area.append("Get address Error !!! ");
        }
        return "localhost";   
     }
     
     // stop all thread 
     public void  tellEveryClientShutDownOrUpdateAllFile(int act) 
     {
        if(clientOutputStreams != null){
            Iterator client = clientOutputStreams.iterator();
            while (client.hasNext()) 
            {
                try 
                {  
                    ObjectOutputStream  out=(ObjectOutputStream) client.next();
                    AllFileInfo abc=new AllFileInfo(act, listFile);
                    
                    out.writeObject(abc);
                    out.reset();
                    abc=null;
                } 
                catch (Exception ex) 
                {
                    txt_area.append("Error telling everyone. \n");
                }
            }
        } 
    }
    
     public void tellEveryFileServerShutdown() 
     {
        if(fileServerOutputStreams != null){
            Iterator fileser = fileServerOutputStreams.iterator();
            while (fileser.hasNext()) 
            {
                try 
                {
                    PrintWriter writer = (PrintWriter) fileser.next();
                    writer.println("exitservermaster");
                    txt_area.append("Sending: exitservermaster \n");
                    writer.flush();
                    txt_area.setCaretPosition(txt_area.getDocument().getLength());

                } 
                catch (Exception ex) 
                {
                    txt_area.append("Error telling everyone. \n");
                }
            }   
        }
    }
     
     // start server master
     void startServer(){
          Thread startSer= new Thread(new ServerStart());
          startSer.start();
          txt_area.append("Server is running...\n");
     }
     
     void printFileConnect(int act,FileInfo f){
         if(act==0){
             txt_area.append("------- Lost a file info---------\n");
             txt_area.append(f.getIpServerFile()+"\n");
             txt_area.append(f.getPortServerFile()+"\n");
             txt_area.append(f.getDestinationDirectory()+"\n");
             for(String i:f.getLsName()){
                 txt_area.append(i+"\n");
             }
             txt_area.append("------- Lost a file info---------\n");
         }
         if(act==1){
             txt_area.append("------- Add a file info---------\n");
             txt_area.append(f.getIpServerFile()+"\n");
             txt_area.append(f.getPortServerFile()+"\n");
             txt_area.append(f.getDestinationDirectory()+"\n");
             for(String i:f.getLsName()){
                 txt_area.append(i+"\n");
             }
             txt_area.append("------- Add a file info---------\n");
         }
     }
}
