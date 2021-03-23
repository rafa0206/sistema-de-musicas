/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_de_musicas;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author JFernandes
 */
public class UsuarioAvaliaDAO {
            
    public static void avaliarMusica (UsuarioAvalia avaliacao) throws Exception{
        String sql = "INSERT INTO tb_usuario_avalia(id_usuario, id_musica, nota_usuario) VALUES (?, ?, ?)";
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setInt(1, avaliacao.getIdUsuario());
            ps.setInt(2, avaliacao.getIdMusica());
            ps.setInt(3, avaliacao.getNotaUsuario());
            ps.execute();                            
        }
    }
    
    public static void reavaliarMusica (UsuarioAvalia reavaliacao) throws Exception{
        String sql = "UPDATE tb_usuario_avalia SET nota_usuario = ? WHERE id_musica = ? and id_usuario = ?;";
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setInt(1, reavaliacao.getNotaUsuario());
            ps.setInt(2, reavaliacao.getIdMusica());
            ps.setInt(3, reavaliacao.getIdUsuario());
            ps.execute();
        }
    }
    
    
    public static void atualizarMediaMusica (UsuarioAvalia mediaMusica) throws Exception{
        String sql = "UPDATE tb_musicas SET media_notas_musica = (SELECT AVG(nota_usuario) FROM tb_usuario_avalia WHERE id_musica = ?) WHERE id_musica = ?;";
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setInt(1, mediaMusica.getIdMusica());
            ps.setInt(2, mediaMusica.getIdMusica());
            ps.execute();
        }
    }
        
}

