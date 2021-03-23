/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_de_musicas;

import java.util.Date;
import java.util.List;
//import java.sql.Date;

public class UsuarioTemGenero {
    
    private int id_usuario;    
    private int id_genero;
    
    //private Date data_genero;
    
    
     public UsuarioTemGenero (int id_usuario, int id_genero){
         this.id_usuario = id_usuario;
         this.id_genero = id_genero;       
    }
     
    public UsuarioTemGenero (){     
    }
  
    public int getIdUsuario (){
        return this.id_usuario;
    }
    
    public void setIdUsuario (int id_usuario){
        this.id_usuario = id_usuario;
    }
    
    public int getIdGenero (){
        return this.id_genero;
    }
    
    public void setIdGenero (int id_genero){
        this.id_genero = id_genero;
    }
    
    public String toString() {
        return String.format ("%d", "- %d" + id_genero, id_genero);
    }
}

