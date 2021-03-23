/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_de_musicas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JFernandes
 */
public class MusicaDAO {
    
               
     
    public static List <Musica> listarMusicas(Usuario usuario) throws Exception{
        String sql = "SELECT tb_musicas.id_musica, tb_generos.nome_genero, tb_musicas.nome_artista, tb_musicas.nome_musica, tb_musicas.nota_musica\n" +
                    "FROM tb_musicas_tem_genero\n" +
                    "INNER JOIN tb_musicas \n" +
                    "ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica\n" +
                    "INNER JOIN tb_generos\n" +
                    "ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero\n" +
                    "where tb_musicas.nome_musica NOT IN \n" +
                    "	(SELECT tb_musicas.nome_musica\n" +
                    "	FROM tb_musicas_tem_genero\n" +
                    "	INNER JOIN tb_musicas \n" +
                    "	ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica\n" +
                    "	INNER JOIN tb_generos\n" +
                    "	ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero\n" +
                    "	INNER JOIN tb_usuario_avalia\n" +
                    "	ON tb_musicas_tem_genero.id_musica = tb_usuario_avalia.id_musica\n" +
                    "	where id_usuario = 1);";
        List <Musica> musicas = new ArrayList<>();
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                int id_musica = rs.getInt("id_musica");
                String nome_genero = rs.getString("nome_genero");
                String nome_artista = rs.getString("nome_artista");
                String nome_musica = rs.getString("nome_musica");
                int nota_musica = rs.getInt("nota_musica");
                Musica musica = new Musica (id_musica, nome_genero, nome_artista, nome_musica, nota_musica);
                musicas.add(musica);
            }
            return musicas;
        }
    }
    
    
    public static List <Musica> listarMinhasAvaliacoes(Usuario usuario) throws Exception{
        String sql = "SELECT tb_musicas.id_musica, tb_generos.nome_genero, tb_musicas.nome_artista, tb_musicas.nome_musica, tb_usuario_avalia.nota_usuario\n" +
                    "FROM tb_musicas_tem_genero\n" +
                    "INNER JOIN tb_musicas \n" +
                    "ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica\n" +
                    "INNER JOIN tb_generos\n" +
                    "ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero\n" +
                    "INNER JOIN tb_usuario_avalia\n" +
                    "ON tb_musicas_tem_genero.id_musica = tb_usuario_avalia.id_musica\n" +
                    "where id_usuario = ?;";
        List <Musica> musicas = new ArrayList<>();
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, /*1*/Usuario.getInstance().getIdUsuario());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_musica = rs.getInt("id_musica");
                String nome_genero = rs.getString("nome_genero");
                String nome_artista = rs.getString("nome_artista");
                String nome_musica = rs.getString("nome_musica");
                int nota_usuario = rs.getInt("nota_usuario");
                Musica musica = new Musica (id_musica, nome_genero, nome_artista, nome_musica, nota_usuario);
                musicas.add(musica);
            }
            return musicas;
        }
    }
     
    
    public static List <Musica> listarMusicasRecomendadas(Usuario usuario) throws Exception{
         String sql = "SELECT tb_musicas.id_musica, tb_generos.nome_genero, tb_musicas.nome_artista, tb_musicas.nome_musica, tb_musicas.media_notas_musica \n" +
                    "FROM tb_musicas_tem_genero\n" +
                    "INNER JOIN tb_musicas \n" +
                    "ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica\n" +
                    "INNER JOIN tb_generos\n" +
                    "ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero\n" +
                    "	WHERE tb_musicas.nome_musica NOT IN\n" +
                    "	(SELECT tb_musicas.nome_musica\n" +
                    "	FROM tb_musicas_tem_genero\n" +
                    "	INNER JOIN tb_musicas \n" +
                    "	ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica\n" +
                    "	INNER JOIN tb_generos\n" +
                    "	ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero\n" +
                    "	INNER JOIN tb_usuario_avalia\n" +
                    "	ON tb_musicas_tem_genero.id_musica = tb_usuario_avalia.id_musica\n" +
                    "	where id_usuario = ?)\n" +
                    "		AND tb_generos.nome_genero IN \n" +
                    "		(SELECT tb_generos.nome_genero \n" +
                    "		FROM tb_generos\n" +
                    "		INNER JOIN tb_usuario_tem_genero\n" +
                    "		ON tb_generos.id_genero = tb_usuario_tem_genero.id_genero\n" +
                    "		WHERE id_usuario = ?);";
        List <Musica> musicas = new ArrayList<>();
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, /*1*/Usuario.getInstance().getIdUsuario());
            ps.setInt(2, /*1*/Usuario.getInstance().getIdUsuario());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                //Musica musica = new Musica();
                int id_musica = rs.getInt("id_musica");
                String nome_genero = rs.getString("nome_genero");
                String nome_artista = rs.getString("nome_artista");
                String nome_musica = rs.getString("nome_musica");
                Double media_notas_musica = rs.getDouble("media_notas_musica");
                Musica musica = new Musica (id_musica, nome_genero, nome_artista, nome_musica, media_notas_musica);
                musicas.add(musica);
            }
            return musicas;
        }
    }
    
}
    

