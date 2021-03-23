/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_de_musicas;

import static com.mycompany.sistema_de_musicas.ConnectionFactory.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JFernandes
 */
public class UsuarioDAO {
    //metodo usado para verificar se o usuario existe na base de dados e responde sim ou não
    public static boolean existe (Usuario usuario) throws Exception{
        //1. Especificar o comando SQL
        String sql = "SELECT * FROM tb_usuarios WHERE nome_usuario = ? AND senha_usuario = ?";
        //2. Abrir uma conexão
        //try with resources
        //3. Preparar o comando
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){         
            //4. Substituir os placeholders (?)
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getSenhaUsuario());
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    
    public static void adicionarUsuario (Usuario usuario) throws Exception{
        String sql = "INSERT INTO tb_usuarios (nome_usuario, senha_usuario) VALUES (?,?);";
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getSenhaUsuario());
            ps.execute();
        }
    }
                
    //*******************metodo  obterUsuario usado em aula para obter  instancia do usuario logado
    
    public static Usuario obterUsuario(String nome_usuario, String senha_usuario){
        //Connection conexao = new ConnectionFactory().obterConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{Connection conexao = ConnectionFactory.obterConexao();
            
            ps = conexao.prepareStatement("SELECT * FROM tb_usuarios WHERE nome_usuario = ? AND senha_usuario = ?");
            
            ps.setString(1, nome_usuario);
            ps.setString(2, senha_usuario);
            
            rs =  ps.executeQuery();
            
                if (rs.next()) {
                        Usuario usuario = Usuario.getInstance();
                        usuario.setIdUsuario(rs.getInt("id_usuario"));
                        usuario.setNomeUsuario(rs.getString("nome_usuario"));
                        usuario.setSenhaUsuario(rs.getString("senha_usuario"));
            
                        return usuario;
                }
                return null;
                
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }/*
        //não estava sendo usada esta parte de baixo(finally) do metodo "obterUsuario"**********
        /* finally {
            ConnectionFactory.closeConnection(conexao, ps, rs);
        }nao estava sendo usado o finally***********
    }
    
    //*******************
                 
    //NAO USADO
    /* public static List <Usuario> listarUsuarios() throws Exception{
        String sql = "SELECT * FROM tb_usuarios";
        List <Usuario> usuarios = new ArrayList<>();
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                String nome_usuario = rs.getString("nome_usuario");
                Usuario usuario = new Usuario (id_usuario, nome_usuario);
                usuarios.add(usuario);
                //cursos.add(new Curso (id, nome, tipo));
            }
            return usuarios;
        }
    }*/
    
    /*//NAO USADO
    public static void atualizarUsuario (Usuario usuario) throws Exception{
        String sql = "UPDATE tb_usuarios SET nome_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getSenhaUsuario());
            ps.setInt(3, usuario.getIdUsuario());
            ps.execute();
        }
    }
    
    //NAO USADO
     public static void deletarUsuario (Usuario usuario) throws Exception{
        String sql = "DELETE FROM tb_usuarios WHERE id_usuario = ?";
        try(Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setInt(1, usuario.getIdUsuario());
            ps.execute();
        }
    }*/
     
    
}
    

