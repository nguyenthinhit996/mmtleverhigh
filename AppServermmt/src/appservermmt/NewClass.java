/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appservermmt;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 *
 * @author peter
 */
public class NewClass {
    public static void main(String[] args) throws UnknownHostException, SocketException{
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(Inet4Address.getLocalHost().getHostAddress());
        
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while(e.hasMoreElements())
        {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements())
            {
                InetAddress i = (InetAddress) ee.nextElement();
                 
                if(i.isSiteLocalAddress()){
                    System.out.println("i.isSiteLocalAddress()"+i.getHostAddress());
                }
            }
        }
    }
}
