/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymapplication;


import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author unknown
 */
public class DBConnection {
    
    public static Connection EtablirConnection()
    {
        String db_string = "C:\\DGSoft\\GYM_Data_Base.sqlite";
//        String db_string = "GYM_Data_Base.sqlite";
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con=null;
            con=DriverManager.getConnection("jdbc:sqlite:"+db_string);
            
            System.out.println("gymapplication.DBConnection.Success");
            return con;
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
             System.out.println("gymapplication.DBConnection.Faild");
            return null;
        }
        
        
    }
    
    
}
