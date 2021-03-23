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
public class UsuarioTemGeneroDAO {
    
    public static void usuarioAdicionaGenero (UsuarioTemGenero usuariotemgenero) throws Exception{
        String sql = "INSERT INTO tb_usuario_tem_genero (id_usuario, id_genero) VALUES (?, ?);";
        //String sql = "INSERT INTO tb_generos (nome_genero) VALUES (?);";
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setInt(1, /*1*/Usuario.getInstance().getIdUsuario());
            ps.setInt(2, /*3*/usuariotemgenero.getIdGenero()/**/);
            ps.execute();
        }
    }
    
    public static void usuarioRemoveGenero (UsuarioTemGenero usuariotemgenero) throws Exception{
        String sql = "DELETE FROM tb_usuario_tem_genero WHERE id_usuario = ? AND id_genero = ?;";
        //String sql = "INSERT INTO tb_generos (nome_genero) VALUES (?);";
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setInt(1, /*1*/Usuario.getInstance().getIdUsuario());
            ps.setInt(2, /*3*/usuariotemgenero.getIdGenero()/**/);
            ps.execute();
        }
    }
    
}
