/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1libreria1.formulario;

import ArbolesBInarios.AVL;
import ArbolesBInarios.ArbolB;
import ArbolesBInarios.ArbolBinarioBusqueda;
import ArbolesBInarios.IArbolBusqueda;
import ArbolesBInarios.MVias;
import InputOutputFicheros.Ficheros;
import com.mycompany.proyecto1libreria1.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class REGISTRODELIBROS extends javax.swing.JFrame {
    int codigo=0;
    IArbolBusqueda<Integer,Pelicula> arbol;
    /**
     * Creates new form REGISTRODELIBROS
     */
   
    public REGISTRODELIBROS() {
        initComponents();
        
        this.setLocationRelativeTo(null);  
        
    }
    public REGISTRODELIBROS(int codigo) {
        initComponents();
        this.codigo=codigo;
        codigoDeLibro.setText(String.valueOf(codigo));
        this.setLocationRelativeTo(null);  
        inicializar();
        
    }
    private void inicializar() {
    ImageIcon icono = new ImageIcon("iconos/icono1.2.png");
    this.setIconImage(icono.getImage());
    }
    
    public static int numero_autores=1;
    static List<Director> listaAutores=new LinkedList<>();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tituloDeLibro = new javax.swing.JTextField();
        edicion = new javax.swing.JTextField();
        idioma = new javax.swing.JTextField();
        nPaginas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        codigoDeLibro = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATOS DEL LIBRO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 8, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CODIGO DE LIBRO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TITULO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("EDICION:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("IDIOMA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 60, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nº PAGINAS:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        tituloDeLibro.setBackground(new java.awt.Color(102, 102, 102));
        tituloDeLibro.setForeground(new java.awt.Color(255, 255, 255));
        tituloDeLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloDeLibroActionPerformed(evt);
            }
        });
        jPanel1.add(tituloDeLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 80, 242, -1));

        edicion.setBackground(new java.awt.Color(102, 102, 102));
        edicion.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(edicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 242, -1));

        idioma.setBackground(new java.awt.Color(102, 102, 102));
        idioma.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(idioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 242, -1));

        nPaginas.setBackground(new java.awt.Color(102, 102, 102));
        nPaginas.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(nPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 210, 242, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INGRESAR AUTORES");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, -1, 40));

        codigoDeLibro.setBackground(new java.awt.Color(255, 255, 255));
        codigoDeLibro.setForeground(new java.awt.Color(0, 0, 0));
        codigoDeLibro.setOpaque(true);
        jPanel1.add(codigoDeLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 86, 16));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("AUTORES:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Volver");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 639, 100, -1));

        jButton3.setBackground(new java.awt.Color(0, 51, 51));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Registrar");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 637, 106, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DESCRIPCIÓN:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        descripcion.setBackground(new java.awt.Color(102, 102, 102));
        descripcion.setColumns(20);
        descripcion.setForeground(new java.awt.Color(255, 255, 255));
        descripcion.setLineWrap(true);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 250, 246));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/wallpapertip_background-wallpaper_3795 (1) (1).jpg"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tituloDeLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloDeLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloDeLibroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         numero_autores=Integer.parseInt(JOptionPane.showInputDialog(null,"              INGRESE LA CANTIDAD DE AUTORES :\n\n(En caso de no tener Autores ingrese el nombre de la Editorial)"));
        
        REGISTRO_DE_AUTORES f2=new REGISTRO_DE_AUTORES();
        f2.setVisible(true); 
        //this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FormularioDeInicio regreso=new FormularioDeInicio();
        regreso.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Pelicula l1=new Pelicula();
        Ficheros ficheroTrabajo=new Ficheros();
         
        l1.setTitulo(tituloDeLibro.getText());
        l1.setEstreno(Integer.parseInt(edicion.getText()));
        l1.setIdioma(idioma.getText());
        l1.setDuracion(nPaginas.getText());
        l1.setDirectores(listaAutores);
        l1.setSinopsis(descripcion.getText());
            l1.setCopias(l1.getCopias()+1);
                System.out.println(l1);
                if(Entrada.eleccion==1) {
                    arbol=new ArbolBinarioBusqueda<>();
                    arbol=ficheroTrabajo.leerFicheroABB(arbol);
                    
                }if (Entrada.eleccion==2) {
                    arbol=new AVL<>();
                    arbol=ficheroTrabajo.leerFicheroAVL(arbol);
                    
                }if (Entrada.eleccion==3) {
                    arbol=new MVias<>();
                    arbol=ficheroTrabajo.leerFicheroMV(arbol);
                }if (Entrada.eleccion==4) {
                    arbol=new ArbolB<>();
                    arbol=ficheroTrabajo.leerFicheroAB(arbol);
                }
                arbol.insertar(codigo,l1);
                System.out.println(arbol.recorridoInorden());
                switch (Entrada.eleccion) {
                    case 1:
                        ficheroTrabajo.escribirFicheroABB(arbol);
                        break;
                    case 2:
                        ficheroTrabajo.escribirFicheroAVL(arbol);
                        break;
                    case 3:
                        ficheroTrabajo.escribirFicheroMV(arbol);
                        break;
                    case 4:
                        ficheroTrabajo.escribirFicheroAB(arbol);
                        break;
                    default:
                        break;
                }
           FormularioDeInicio regreso=new FormularioDeInicio();
        regreso.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    public void limpiarVentana(){
        tituloDeLibro.setText(null);
        edicion.setText(null);
        idioma.setText(null);
        nPaginas.setText(null);
        descripcion.setText(null);
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
            java.util.logging.Logger.getLogger(REGISTRODELIBROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(REGISTRODELIBROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(REGISTRODELIBROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REGISTRODELIBROS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new REGISTRODELIBROS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codigoDeLibro;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JTextField edicion;
    private javax.swing.JTextField idioma;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nPaginas;
    private javax.swing.JTextField tituloDeLibro;
    // End of variables declaration//GEN-END:variables
}