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
public class Genero {
    
    private int id_genero;
    private String nome_genero;
    
    
    public Genero (){       
    }
    
    public Genero (int id_genero, String nome_genero){
        this.nome_genero = nome_genero;
        this.id_genero = id_genero;               
    }
    
    public String getNomeGenero (){
        return this.nome_genero;
    }
    
    public int getIdGenero (){
        return this.id_genero;
    }
    
    public String toString() {
        return String.format ("%s", nome_genero);
    }    
    
}
