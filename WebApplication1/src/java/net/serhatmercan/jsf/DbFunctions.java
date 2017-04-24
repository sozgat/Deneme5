/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.serhatmercan.jsf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toshiba
 */
public class DbFunctions {
    
    public static void baglantiKapa(Connection con)
    {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(KayitKontrol.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Baglanti kapatilirken hata olustu!");
        }
    }
    
    public static Connection getCon()
    {
        Connection con = null;
        String url = "jdbc:derby://localhost:1527/HUKUKWEBDB";
        String user = "hukukwebdb", pass = "1234";
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(KayitKontrol.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Veritabanina Baglanilamadi!\nDetay : "+ex.getMessage());
            return null;
        }
        
        return con;
    }
    
    public static String stringToDate(String date)
    {
        String[] formats = date.split("/");
        return "{d'"+formats[2]+"-"+formats[1]+"-"+formats[0]+"'}";
    }
}