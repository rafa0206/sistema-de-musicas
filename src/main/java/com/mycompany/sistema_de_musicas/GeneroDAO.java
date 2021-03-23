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
public class GeneroDAO {    
    
    public static List <Genero> listarGenerosPreferidos(Usuario usuario) throws Exception{
        String sql = "SELECT tb_generos.id_genero, tb_generos.nome_genero FROM tb_generos INNER JOIN tb_usuario_tem_genero"
                + " ON tb_generos.id_genero = tb_usuario_tem_genero.id_genero WHERE id_usuario = ?;";
        List <Genero> generos = new ArrayList<>();
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, /*1*/Usuario.getInstance().getIdUsuario());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_genero = rs.getInt("id_genero");
                String nome_genero = rs.getString("nome_genero");
                Genero genero = new Genero(id_genero, nome_genero);
                generos.add(genero);
            }
            return generos;
        }
    }   
    
    public static List <Genero> listarOutrosGeneros(Usuario usuario) throws Exception{
        String sql = "SELECT tb_generos.id_genero, tb_generos.nome_genero\n" +
                    "FROM tb_generos\n" +
                    "WHERE tb_generos.nome_genero NOT IN\n" +
                    "	(SELECT tb_generos.nome_genero \n" +
                    "	FROM tb_generos\n" +
                    "	INNER JOIN tb_usuario_tem_genero\n" +
                    "	ON tb_generos.id_genero = tb_usuario_tem_genero.id_genero\n" +
                    "	WHERE id_usuario = ?);";
        List <Genero> generos = new ArrayList<>();
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, /*1*/Usuario.getInstance().getIdUsuario());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id_genero = rs.getInt("id_genero");
                String nome_genero = rs.getString("nome_genero");
                Genero genero = new Genero(id_genero, nome_genero);
                generos.add(genero);
            }
            return generos;
        }
    }
       
}

