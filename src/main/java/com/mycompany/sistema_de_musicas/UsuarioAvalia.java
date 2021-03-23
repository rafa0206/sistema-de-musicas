/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_de_musicas;

/**
 *
 * @author JFernandes
 */
public class UsuarioAvalia {
    
    private int id_musica;
    private int id_usuario;
    private int nota_usuario;
    
    public UsuarioAvalia (){ 
    }
    
     public int getIdUsuario (){
        return this.id_usuario;
    }
          
    public void setIdUsuario (int id_usuario){
        this.id_usuario = id_usuario;
    }
       
    public int getNotaUsuario (){
        return this.nota_usuario;
    }
    
    public void setNotaUsuario (int nota_usuario){
        this.nota_usuario = nota_usuario;
    }
    
    public int getIdMusica (){
        return this.id_musica;
    }
    
    public void setIdMusica (int id_musica){
        this.id_musica = id_musica;
    }
        
}
