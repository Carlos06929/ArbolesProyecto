/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1libreria1.formulario;
import ArbolesBInarios.*;
import InputOutputFicheros.Ficheros;
import com.mycompany.proyecto1libreria1.Director;
import com.mycompany.proyecto1libreria1.Pelicula;
import java.io.*;
import java.util.LinkedList;
import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author hp
 */
public class REGISTRO_DE_AUTORES extends javax.swing.JFrame {
    Director a1=new Director();List<Director> listaAut=new ArrayList<>();
    
    /**
     * Creates new form REGISTRO_DE_AUTORES
     */
   static int incre=1;
    public REGISTRO_DE_AUTORES() {
                initComponents();
                this.setLocationRelativeTo(null); 
                labelNumeroDeAutor.setText("# 1");
                inicializar();
       
    }
    
    private void inicializar() {
    ImageIcon icono = new ImageIcon("iconos/icono1.2.png");
    this.setIconImage(icono.getImage());
    }
    public void incrementarLabel(){
        incre++;
        String s="";
        s=s+incre;
        labelNumeroDeAutor.setText("# "+s);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombre_autor = new javax.swing.JTextField();
        nacionalidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelNumeroDeAutor = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre_autor.setBackground(new java.awt.Color(102, 102, 102));
        nombre_autor.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(nombre_autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 162, -1));

        nacionalidad.setBackground(new java.awt.Color(102, 102, 102));
        nacionalidad.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(nacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 160, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOMBRE DEL AUTOR:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 87, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NACIONALIDAD:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AUTOR");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 6, -1, -1));

        labelNumeroDeAutor.setBackground(new java.awt.Color(255, 255, 255));
        labelNumeroDeAutor.setForeground(new java.awt.Color(0, 0, 0));
        labelNumeroDeAutor.setOpaque(true);
        jPanel1.add(labelNumeroDeAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 18, 25));

        Registrar.setBackground(new java.awt.Color(0, 51, 51));
        Registrar.setForeground(new java.awt.Color(255, 255, 255));
        Registrar.setText("GRABAR");
        Registrar.setOpaque(false);
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 242, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/421124 (2).jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        
        if (incre==REGISTRODELIBROS.numero_autores) {
            
          
            REGISTRODELIBROS.listaAutores=listaAut;
              meterDatos();
            this.dispose();
            incre=1;
        }else{
            meterDatos();
            incrementarLabel();
        }
        
    }//GEN-LAST:event_RegistrarActionPerformed

    public void meterDatos(){
        Director a1=new Director();
        a1.setNombre(nombre_autor.getText());
        a1.setNacionalidad(nacionalidad.getText());
        
        
        
        listaAut.add(a1);
        
        
        nombre_autor.setText(null);
        nacionalidad.setText(null);
        
    }

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
            java.util.logging.Logger.getLogger(REGISTRO_DE_AUTORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(REGISTRO_DE_AUTORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(REGISTRO_DE_AUTORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REGISTRO_DE_AUTORES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new REGISTRO_DE_AUTORES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNumeroDeAutor;
    private javax.swing.JTextField nacionalidad;
    private javax.swing.JTextField nombre_autor;
    // End of variables declaration//GEN-END:variables

   
}
