package org.alda.dsm.utl.examenbdsql;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQLNube{
    Connection conn;

    public Connection open(){
        String url="jdbc:mysql://uxriuxak6iw7aisx:RMTsa5yT8oVi54B1YIoa@blf5yrxdurktlt7y7bsn-mysql.services.clever" +
                "-cloud.com:3306/blf5yrxdurktlt7y7bsn";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url);
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void close(){
        if (conn!=null){
            try{
                conn.close();
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("Exception controlada.");
            }
        }
    }
}
