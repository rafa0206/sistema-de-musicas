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
public class Musica {
    
    private int id_musica;
    
    private String nome_genero;
    
    private String nome_artista;
    private String nome_musica;    
    private int nota_musica;
    private int nota_usuario;
    private double media_notas_musica;
    
    
    public Musica(){
        
    }
    
    public Musica (int id_musica, String nome_genero, String nome_artista, String nome_musica, int nota_usuario){
        this.id_musica = id_musica;
        this.nome_genero = nome_genero;
        this.nome_artista = nome_artista;
        this.nome_musica = nome_musica;
        this.nota_usuario = nota_usuario;            
    }
        
    public Musica (int id_musica, String nome_genero, String nome_artista, String nome_musica, double media_notas_musica){
          this.id_musica = id_musica;
        this.nome_genero = nome_genero;
        this.nome_artista = nome_artista;
        this.nome_musica = nome_musica;
        this.media_notas_musica = media_notas_musica; 
    }    
    
    public int getIdMusica (){
        return this.id_musica;
    }
        
    public String getNomeArtista (){
        return this.nome_artista;
    }
    
    public String getNomeMusica (){
        return this.nome_musica;
    }
    
    public int getNotaMusica (){
        return this.nota_musica;
    }
    
    public int getNotaUsuario (){
        return this.nota_usuario;
    }
    
    public double getMediaNotasMusica (){
        return this.media_notas_musica;
    }
            
    public String toString() {
        return String.format ("%s - %s - %s", nome_genero, nome_artista, nome_musica);
    }            
    
}
