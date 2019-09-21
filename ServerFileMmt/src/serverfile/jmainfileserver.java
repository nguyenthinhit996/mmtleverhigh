package serverfile;

 
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author peter
 */
public class jmainfileserver extends javax.swing.JFrame {

     ArrayList clientOutputStreams ;
     PrintWriter outServerMasterStream;
     boolean isConnect =false;
    /**
     * Creates new form jmainserver
     */
    public jmainfileserver() {
        initComponents();
        error.setVisible(false);
        txt_ipserver.setText("");
        txt_port.setText("");
        ipfileserver.setText(getIP());
        // random 5000 5999
        lab_port.setText(getPort());
        txt_ipserver.setText(getIP());
        txt_port.setText("2222");
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
        ipfileserver = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_connection = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_port = new javax.swing.JTextField();
        txt_ipserver = new javax.swing.JTextField();
        error = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_file = new javax.swing.JList<>();
        brower = new javax.swing.JButton();
        lab_path = new javax.swing.JLabel();
        lab_port = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File server");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(119, 194, 218));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 500));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("My IP:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel2.setText("Input information of server master");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("IP :");

        ipfileserver.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        ipfileserver.setText("localhost");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setText("The files are available");

        btn_connection.setBackground(new java.awt.Color(83, 136, 53));
        btn_connection.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_connection.setText("Connect ");
        btn_connection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel4.setText("Information of File Server");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Port:");

        txt_port.setText("2222");

        txt_ipserver.setText("192.168.000.0");

        error.setBackground(new java.awt.Color(59, 52, 51));
        error.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        error.setForeground(new java.awt.Color(171, 22, 22));
        error.setText("Connect error ");

        list_file.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(list_file);

        brower.setBackground(new java.awt.Color(181, 171, 57));
        brower.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        brower.setText("Brower");
        brower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browerActionPerformed(evt);
            }
        });

        lab_path.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lab_path.setText("D:/abc/cbf/");

        lab_port.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lab_port.setText("localhost");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setText("Port:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_connection, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ipfileserver)
                                .addGap(108, 108, 108)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lab_port))
                            .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ipserver, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lab_path, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brower, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ipfileserver, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lab_port, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brower)
                    .addComponent(lab_path))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txt_ipserver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_connection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_connectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectionActionPerformed
        // TODO add your handling code here:
        // kiem tra set thu muc chua
         if(!isConnect){
             if(StringUtils.isEmpty(lab_path.getText()) 
                || StringUtils.isEmpty(txt_ipserver.getText()) 
                || StringUtils.isEmpty(txt_port.getText())){
                error.setText("Connect Error");
                error.setForeground(Color.red);
                error.setVisible(true);
            }else{
                error.setVisible(false);
                // conenct servermaster
                Thread serverStart = new Thread(new ServerStart());
                serverStart.start();
             }
        }else{
             error.setText("Connect is exit");
             error.setForeground(Color.GREEN);
            error.setVisible(true);
         }
        
            
            // vua nhan dc vua gui dc
            ArrayList clientOutputStreams = new ArrayList();

    }//GEN-LAST:event_btn_connectionActionPerformed

    private void browerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_browerActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        // gui gat ket noi server master
        if(outServerMasterStream != null){
            outServerMasterStream.print("exit");
            outServerMasterStream.flush();
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
            java.util.logging.Logger.getLogger(jmainfileserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jmainfileserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jmainfileserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jmainfileserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jmainfileserver().setVisible(true);
            }
        });
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
             
        }
        return "localhost";   
     }

    // random port 5000 5999
    String getPort(){
        Random rand = new Random();
         int random = rand.nextInt((5999 - 5000) + 1) + 5000;
         return String.valueOf(random);
    }
    
    // thread start server
    
    public class ServerStart implements Runnable 
    {
        @Override
        public void run() 
        {
             Socket sock;
            try {
                // ket noi voi Servermaster
                sock = new Socket(txt_ipserver.getText().toString(), Integer.valueOf(txt_port.getText()));
                outServerMasterStream = new PrintWriter(sock.getOutputStream());
                // gui thong bao den servermaster la file server
                outServerMasterStream.println("serverfile");
                outServerMasterStream.flush();
                // thread lang nghe ket noi tu server
                Thread serverMasterHandler = new Thread( new ServerMasterHandler(sock));
                serverMasterHandler.start();
                isConnect=true;
                error.setText("Connect success ");
                error.setVisible(true);
                error.setForeground(Color.GREEN);
                System.out.println("Ok ket noi thanh cong");
                
                // ket noi UDP vs client
                while (true) {                    
                  break;  
                } 
                
                
            } catch (Exception ex) {
                Logger.getLogger(jmainfileserver.class.getName()).log(Level.SEVERE, null, ex);
                error.setText("Connect Error");
                error.setForeground(Color.red);
                error.setVisible(true); 
                Thread.currentThread().interrupt();
                isConnect=false;
            }
        }
    }
    
    
    // ServerMasterHandler
     public class ServerMasterHandler implements Runnable	
   {
       BufferedReader inFileServer;
       Socket sockFileServer;
        

       public ServerMasterHandler(Socket Socket) 
       {            
            try 
            {
                sockFileServer = Socket;
                InputStreamReader isReader = new InputStreamReader(sockFileServer.getInputStream());
                inFileServer = new BufferedReader(isReader);
            }
            catch (Exception ex) 
            {
                error.setText("Error connect with server");
                error.setVisible(true);
                error.setForeground(Color.red);
                Thread.currentThread().interrupt();
                isConnect=false;
            }

       }

       @Override
       public void run() 
       {
            String message;
            String[] data;

            try 
            {
                while ((message = inFileServer.readLine()) != null) 
                {
                    if(message.equals("exitservermaster")){
                       error.setText("Error connect with server");
                       error.setVisible(true);
                       error.setForeground(Color.red);
                       isConnect=false;
                       Thread.currentThread().interrupt();
                       
                    }
                } 
             } 
             catch (Exception ex) 
             { 
                 error.setText("Error connect with server");
                 error.setVisible(true);
                 error.setForeground(Color.red);
                ex.printStackTrace();
                isConnect=false;
                Thread.currentThread().interrupt();
             } 
	} 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brower;
    private javax.swing.JButton btn_connection;
    private javax.swing.JLabel error;
    private javax.swing.JLabel ipfileserver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lab_path;
    private javax.swing.JLabel lab_port;
    private javax.swing.JList<String> list_file;
    private javax.swing.JTextField txt_ipserver;
    private javax.swing.JTextField txt_port;
    // End of variables declaration//GEN-END:variables
}
