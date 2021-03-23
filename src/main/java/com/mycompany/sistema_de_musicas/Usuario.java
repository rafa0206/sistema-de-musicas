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
public class Usuario {
    
    private int id_usuario;
    private String nome_usuario;
    private String senha_usuario;
    private static Usuario instance;//******
    
    
    public Usuario (int id_usuario, String nome_usuario, String senha_usuario){
        this(nome_usuario, senha_usuario);
        this.id_usuario = id_usuario;               
    }
    
    public Usuario (String nome_usuario, String senha_usuario){
        this.nome_usuario = nome_usuario;
        this.senha_usuario = senha_usuario;               
    }
    
    private Usuario (){
        //this.id_usuario = id_usuario;             
    }
    
    public static Usuario getInstance(){
        if (instance == null){
            instance = new Usuario();
        }
        return instance;
    }
    
    
    public int getIdUsuario (){
        return this.id_usuario;
    }
    
    public void setIdUsuario (int id_usuario){
        this.id_usuario = id_usuario;
    }
        
    public String getNomeUsuario (){
        return this.nome_usuario;
    }
    
    public void setNomeUsuario (String nome_usuario){
        this.nome_usuario = nome_usuario;
    }
    
    public String getSenhaUsuario (){
        return this.senha_usuario;
    }
    
    public void setSenhaUsuario (String senha_usuario){
        this.senha_usuario = senha_usuario;
    }    
           
}
