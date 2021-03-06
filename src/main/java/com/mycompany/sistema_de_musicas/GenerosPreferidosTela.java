/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema_de_musicas;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JFernandes
 */
public class GenerosPreferidosTela extends javax.swing.JFrame {

    /**
     * Creates new form GenerosPreferidosTela
     */
    public GenerosPreferidosTela() {
        super ("Gêneros Preferidos");
        initComponents();
        listarGenerosPreferidos();
        listarOutrosGeneros();
        //buscarGenerosPreferidos();
        //buscarOutrosGeneros ();
        setLocationRelativeTo(null);
    }
    
    
    private void listarGenerosPreferidos (){
        try{
            List <Genero> generos = GeneroDAO.listarGenerosPreferidos(Usuario.getInstance());
            generosPreferidosComboBox.setModel(new DefaultComboBoxModel<>(generos.toArray(new Genero[0])));
                    
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tente novamente mais tarde");
        }
    }
    
    private void listarOutrosGeneros (){
        try{
            List <Genero> generos = GeneroDAO.listarOutrosGeneros(Usuario.getInstance());
            outrosGenerosComboBox.setModel(new DefaultComboBoxModel<>(generos.toArray(new Genero[0])));
                    
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Tente novamente mais tarde");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generosPreferidosPanel = new javax.swing.JPanel();
        removerGeneroButton = new javax.swing.JButton();
        adicionarGeneroButton = new javax.swing.JButton();
        generosPreferidosComboBox = new javax.swing.JComboBox<>();
        outrosGenerosComboBox = new javax.swing.JComboBox<>();
        voltarButton = new javax.swing.JButton();
        generosPreferidosTextField = new javax.swing.JTextField();
        outrosGenerosTextField = new javax.swing.JTextField();
        idOutrosGenTextField = new javax.swing.JTextField();
        idGenPreferidosTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        generosPreferidosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Gêneros Preferidos"));

        removerGeneroButton.setText("Remover gênero");
        removerGeneroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerGeneroButtonActionPerformed(evt);
            }
        });

        adicionarGeneroButton.setText("Adicionar gênero");
        adicionarGeneroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarGeneroButtonActionPerformed(evt);
            }
        });

        generosPreferidosComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder("Gêneros Preferidos"));
        generosPreferidosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generosPreferidosComboBoxActionPerformed(evt);
            }
        });

        outrosGenerosComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder("Outros gêneros"));
        outrosGenerosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outrosGenerosComboBoxActionPerformed(evt);
            }
        });

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        idOutrosGenTextField.setEditable(false);

        idGenPreferidosTextField.setEditable(false);

        javax.swing.GroupLayout generosPreferidosPanelLayout = new javax.swing.GroupLayout(generosPreferidosPanel);
        generosPreferidosPanel.setLayout(generosPreferidosPanelLayout);
        generosPreferidosPanelLayout.setHorizontalGroup(
            generosPreferidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generosPreferidosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generosPreferidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generosPreferidosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outrosGenerosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(generosPreferidosPanelLayout.createSequentialGroup()
                        .addComponent(idOutrosGenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(outrosGenerosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adicionarGeneroButton))
                    .addGroup(generosPreferidosPanelLayout.createSequentialGroup()
                        .addGroup(generosPreferidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generosPreferidosPanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(generosPreferidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(removerGeneroButton))
                            .addComponent(voltarButton)
                            .addComponent(idGenPreferidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        generosPreferidosPanelLayout.setVerticalGroup(
            generosPreferidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generosPreferidosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltarButton)
                .addGap(18, 18, 18)
                .addComponent(generosPreferidosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(generosPreferidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(removerGeneroButton, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(generosPreferidosTextField)
                    .addComponent(idGenPreferidosTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(55, 55, 55)
                .addComponent(outrosGenerosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(generosPreferidosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adicionarGeneroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outrosGenerosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idOutrosGenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generosPreferidosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generosPreferidosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removerGeneroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerGeneroButtonActionPerformed
        // TODO add your handling code here:
        int id_genero = Integer.parseInt(idGenPreferidosTextField.getText());
        String nome_genero = generosPreferidosTextField.getText();        
        if (nome_genero == null || nome_genero.length() <= 0){
            JOptionPane.showMessageDialog(null, "Olha, tem algo faltando");
            return;
        }
        try{
            int escolha = JOptionPane.showConfirmDialog(null, "Remover gênero?");
            if (escolha == JOptionPane.YES_OPTION){
                UsuarioTemGenero usuariotemgenero = new UsuarioTemGenero();
                usuariotemgenero.setIdGenero(/*3/*usuariotemgenero.getIdGenero()*/id_genero);
                usuariotemgenero.setIdUsuario(/*1*/Usuario.getInstance().getIdUsuario());                        
                UsuarioTemGeneroDAO.usuarioRemoveGenero(usuariotemgenero);
                //listarGenerosPreferidos();
                //listarOutrosGeneros();
                //buscarCursos();
                JOptionPane.showMessageDialog(null, "Gênero removido");
                listarOutrosGeneros();
                listarGenerosPreferidos();
                generosPreferidosTextField.setText("");
                idGenPreferidosTextField.setText("");
            }
           
            else{
                JOptionPane.showMessageDialog(null, "Tá bom");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Algo deu errado. Tente novamente mais tarde.");             
        }
    }//GEN-LAST:event_removerGeneroButtonActionPerformed

    private void adicionarGeneroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarGeneroButtonActionPerformed
        // TODO add your handling code here:
        int id_genero = Integer.parseInt(idOutrosGenTextField.getText());
        String nome_genero = outrosGenerosTextField.getText();        
        if (nome_genero == null || nome_genero.length() <= 0){
            JOptionPane.showMessageDialog(null, "Olha, tem algo faltando");
            return;
        }
        try{
            int escolha = JOptionPane.showConfirmDialog(null, "Adicionar gênero?");
            if (escolha == JOptionPane.YES_OPTION){
                UsuarioTemGenero usuariotemgenero = new UsuarioTemGenero();
                usuariotemgenero.setIdGenero(/*3/*usuariotemgenero.getIdGenero()*/id_genero);
                usuariotemgenero.setIdUsuario(/*1*/Usuario.getInstance().getIdUsuario());                        
                UsuarioTemGeneroDAO.usuarioAdicionaGenero(usuariotemgenero);
                JOptionPane.showMessageDialog(null, "Gênero adicionado");
                listarGenerosPreferidos();
                listarOutrosGeneros();
                outrosGenerosTextField.setText("");
                idOutrosGenTextField.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null, "Tá bom");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Algo deu errado. Tente novamente mais tarde.");             
        }
                             
    }//GEN-LAST:event_adicionarGeneroButtonActionPerformed

    private void generosPreferidosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generosPreferidosComboBoxActionPerformed
        // TODO add your handling code here:
        Genero genero = (Genero)generosPreferidosComboBox.getSelectedItem();
        generosPreferidosTextField.setText(genero.getNomeGenero());
        idGenPreferidosTextField.setText(Integer.toString(genero.getIdGenero()));
    }//GEN-LAST:event_generosPreferidosComboBoxActionPerformed

    private void outrosGenerosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outrosGenerosComboBoxActionPerformed
        // TODO add your handling code here:
        Genero genero = (Genero)outrosGenerosComboBox.getSelectedItem();
        outrosGenerosTextField.setText(genero.getNomeGenero());
        idOutrosGenTextField.setText(Integer.toString(genero.getIdGenero()));
    }//GEN-LAST:event_outrosGenerosComboBoxActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        // TODO add your handling code here:
        DashboardTela db = new DashboardTela();
               db.setVisible(true);
               this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GenerosPreferidosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerosPreferidosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerosPreferidosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerosPreferidosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerosPreferidosTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarGeneroButton;
    private javax.swing.JComboBox<Genero> generosPreferidosComboBox;
    private javax.swing.JPanel generosPreferidosPanel;
    private javax.swing.JTextField generosPreferidosTextField;
    private javax.swing.JTextField idGenPreferidosTextField;
    private javax.swing.JTextField idOutrosGenTextField;
    private javax.swing.JComboBox<Genero> outrosGenerosComboBox;
    private javax.swing.JTextField outrosGenerosTextField;
    private javax.swing.JButton removerGeneroButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
