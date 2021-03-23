/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_de_musicas;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author JFernandes
 */
public class ConnectionFactory {   
    
    public static String host = "localhost";
    public static String porta = "3306";
    public static String db = "sistema_de_musicas_2";
    public static String usuario = "root";
    public static String senha = "Pscrafa20mysql";
    
    
    public static Connection obterConexao () throws Exception{
        String url = String.format(
                "jdbc:mysql://%s:%s/%s",
                host,
                porta,
                db + "?useTimezone=true&serverTimezone=UTC"
            );
        return DriverManager.getConnection(url, usuario, senha);
        /*try{
            String url = String.format(
                "jdbc:mysql://%s:%s/%s",
                host,
                porta,
                db
            );
            return DriverManager.getConnection(url, usuario, senha);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }*/
        
    }
    
}
    

