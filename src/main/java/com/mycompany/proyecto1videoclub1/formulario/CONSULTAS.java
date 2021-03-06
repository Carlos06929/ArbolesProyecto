/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1videoclub1.formulario;

import com.mycompany.proyecto1videoclub1.GestionCeldas;
import com.mycompany.proyecto1videoclub1.Pelicula;
import com.mycompany.proyecto1videoclub1.Director;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import ArbolesBInarios.*;
import InputOutputFicheros.Ficheros;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Usuario
 */
public class CONSULTAS extends javax.swing.JFrame implements MouseListener {

    DefaultTableModel modelo;
    JPanel contentPane;
    IArbolBusqueda<Integer, Pelicula> arbol = null;
    Ficheros ficheroTrabajo = null;
    JButton b1 = new JButton();
    JScrollPane scrollPaneTabla;
    JLabel etiqueta;

    /**
     *
     * Creates new form Consultas
     */
    public CONSULTAS() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("AÑO ESTRENO");
        modelo.addColumn("IDIOMA");
        modelo.addColumn("SINOPSIS");
        modelo.addColumn("DURACION");
        modelo.addColumn("COPIAS");
        modelo.addColumn("GENERO");
        modelo.addColumn("DIRECTOR");

        
        
        
        
        this.Tabla_peliculas.setModel(modelo);
        
        
        
        
        
        
//        Tabla_libros.getColumnModel().getColumn(5).setPreferredWidth(10);
//        Tabla_libros.getColumnModel().getColumn(1).setPreferredWidth(120);
       
        Tabla_peliculas.addMouseListener(this);
        actualizar();
        Color g1=new Color(109, 109, 109);
        //jScrollPane1.getViewport().setBackground(g1);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.getViewport().setBorder(null);
        jScrollPane1.setBorder(null);
        inicializar();
    }
    
    private void inicializar() {
    ImageIcon icono = new ImageIcon("iconos/corto.png");
    this.setIconImage(icono.getImage());
    }

    public void rellenarTabla(IArbolBusqueda<Integer, Pelicula> arbol) {

        List<Pelicula> listaValores = new LinkedList<>();
        List<Integer> listaCodigos = new LinkedList<>();
        listaCodigos = arbol.recorridoInorden();
        listaValores = arbol.llenarListaValores(listaCodigos);
      
        int i = 0;
        while (i < listaCodigos.size()) {
            llenarTabla(listaCodigos.get(i), listaValores.get(i));
            i++;
        }

    }

    public void llenarTabla(int codigo, Pelicula l1) {

        String[] vectores = new String[9];
        vectores[0] = String.valueOf(codigo);
        vectores[1] = l1.getTitulo();
        
        vectores[2] = String.valueOf(l1.getEstreno());
        vectores[3] = l1.getIdioma();
        vectores[4] = "";
        vectores[5] = String.valueOf(l1.getDuracion());
        vectores[6] = String.valueOf(l1.getCopias());
        vectores[7] = l1.getGenero();
        vectores[8] = "";
        modelo.addRow(vectores);

        Tabla_peliculas.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas());
        Tabla_peliculas.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas());

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_peliculas = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 738, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Buscar");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 659, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Eliminar");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(904, 659, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        Tabla_peliculas.setBackground(new java.awt.Color(0, 102, 102));
        Tabla_peliculas.setForeground(new java.awt.Color(255, 255, 255));
        Tabla_peliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Edicion", "Idioma", "Descripción", "N° Pagínas", "Ejemplar", "Autores"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_peliculas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Tabla_peliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabla_peliculas.setFocusable(false);
        Tabla_peliculas.setGridColor(new java.awt.Color(0, 0, 0));
        Tabla_peliculas.setRowHeight(32);
        Tabla_peliculas.setRowMargin(5);
        Tabla_peliculas.setSelectionBackground(new java.awt.Color(0, 51, 51));
        Tabla_peliculas.setSelectionForeground(new java.awt.Color(204, 204, 204));
        Tabla_peliculas.setShowGrid(true);
        jScrollPane1.setViewportView(Tabla_peliculas);
        if (Tabla_peliculas.getColumnModel().getColumnCount() > 0) {
            Tabla_peliculas.getColumnModel().getColumn(0).setPreferredWidth(15);
            Tabla_peliculas.getColumnModel().getColumn(4).setPreferredWidth(10);
            Tabla_peliculas.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1205, 612));

        jButton4.setBackground(new java.awt.Color(0, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Acualizar");
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 659, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sala.jpg"))); // NOI18N
        jLabel1.setFocusable(false);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FORMULARIO_INICIO regreso = new FORMULARIO_INICIO();
        regreso.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed


       try {
           int codigo = Integer.parseInt(JOptionPane.showInputDialog("INGRESE El CODIGO DEL LIBRO: "));
        ficheroTrabajo = new Ficheros();
        if (ENTRADA.eleccion == 1) {
            arbol = new ArbolBinarioBusqueda<>();
            arbol = ficheroTrabajo.leerFicheroABB(arbol);
           

        }
        if (ENTRADA.eleccion == 2) {
            arbol = new AVL<>();
            arbol = ficheroTrabajo.leerFicheroAVL(arbol);

        }
        if (ENTRADA.eleccion == 3) {
            arbol = new MVias<>();
            arbol = ficheroTrabajo.leerFicheroMV(arbol);
        }
        if (ENTRADA.eleccion == 4) {
            arbol = new ArbolB<>();
            arbol = ficheroTrabajo.leerFicheroAB(arbol);
        }
        if(arbol.buscar(codigo)!=null){
             arbol.eliminar(codigo);
        }else{
             JOptionPane.showMessageDialog(null, "La clave no esta registrada");
        }
        switch (ENTRADA.eleccion) {
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
        for (int i = 0; i < Tabla_peliculas.getRowCount(); i++) {
            if (Tabla_peliculas.getValueAt(i, 0).equals(String.valueOf(codigo))) {
                modelo.removeRow(i);
                break;
            }
        }
       }
       catch (Exception e){}

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        
      try {
       
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("INGRESE El CODIGO DE LA PELICULA: "));
        ficheroTrabajo = new Ficheros();
        if (ENTRADA.eleccion == 1) {
            arbol = new ArbolBinarioBusqueda<>();
            arbol = ficheroTrabajo.leerFicheroABB(arbol);
        }
        if (ENTRADA.eleccion == 2) {
            arbol = new AVL<>();
            arbol = ficheroTrabajo.leerFicheroAVL(arbol);

        }
        if (ENTRADA.eleccion == 3) {
            arbol = new MVias<>();
            arbol = ficheroTrabajo.leerFicheroMV(arbol);
        }
        if (ENTRADA.eleccion == 4) {
            arbol = new ArbolB<>();
            arbol = ficheroTrabajo.leerFicheroAB(arbol);
        }

        if (arbol.contiene(codigo)) {
//            System.out.println(Tabla_libros.getRowCount());
//            for (int i = 0; i < Tabla_libros.getRowCount(); i++) {
//             int cod2=Integer.parseInt(Tabla_libros.getValueAt(i, 0).toString());  
//                if (cod2!=codigo) {
//                    modelo.removeRow(i);
//
//                }
//            }
              modelo.setRowCount(0);
              Tabla_peliculas.setModel(modelo);
              Pelicula l1=new Pelicula();
              l1=arbol.buscar(codigo);
              String[] vectores = new String[9];
                vectores[0] = String.valueOf(codigo);
                vectores[1] = l1.getTitulo();

                vectores[2] = String.valueOf(l1.getEstreno());
                vectores[3] = l1.getIdioma();
                vectores[4] = "";
                vectores[5] = String.valueOf(l1.getDuracion());
                vectores[6] = String.valueOf(l1.getCopias());
                vectores[7] = l1.getGenero();
                vectores[8] = "";
                modelo.addRow(vectores);

                Tabla_peliculas.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas());
                Tabla_peliculas.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas());
              
        } else {
            JOptionPane.showMessageDialog(null, "EL codigo de la pelicula ingresado no existe. \n     Ingrese un Codigo valido.");
        }
       }
       catch (Exception e) {  }
 
        
        

    }//GEN-LAST:event_jButton2ActionPerformed
    public void actualizar() {
        ficheroTrabajo = new Ficheros();

        if (ENTRADA.eleccion == 1) {
            arbol = new ArbolBinarioBusqueda<>();
            arbol = ficheroTrabajo.leerFicheroABB(arbol);
          

        }
        if (ENTRADA.eleccion == 2) {
            arbol = new AVL<>();
            arbol = ficheroTrabajo.leerFicheroAVL(arbol);

        }
        if (ENTRADA.eleccion == 3) {
            arbol = new MVias<>();
            arbol = ficheroTrabajo.leerFicheroMV(arbol);
        }
        if (ENTRADA.eleccion == 4) {
            arbol = new ArbolB<>();
            arbol = ficheroTrabajo.leerFicheroAB(arbol);
        }
        System.out.println(ENTRADA.eleccion);
        System.out.println(arbol.recorridoInorden());
        rellenarTabla(arbol);

    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
                
            modelo.setRowCount(0);
            Tabla_peliculas.setModel(modelo);
        
           actualizar();
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(CONSULTAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CONSULTAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CONSULTAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CONSULTAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CONSULTAS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_peliculas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = Tabla_peliculas.rowAtPoint(e.getPoint());
        int columna = Tabla_peliculas.columnAtPoint(e.getPoint());
        ficheroTrabajo=new Ficheros();
        if (ENTRADA.eleccion == 1) {
            arbol = new ArbolBinarioBusqueda<>();
            arbol = ficheroTrabajo.leerFicheroABB(arbol);
           

        }
        if (ENTRADA.eleccion == 2) {
            arbol = new AVL<>();
            arbol = ficheroTrabajo.leerFicheroAVL(arbol);

        }
        if (ENTRADA.eleccion == 3) {
            arbol = new MVias<>();
            arbol = ficheroTrabajo.leerFicheroMV(arbol);
        }
        if (ENTRADA.eleccion == 4) {
            arbol = new ArbolB<>();
            arbol = ficheroTrabajo.leerFicheroAB(arbol);
        }
        String contenido_celda=Tabla_peliculas.getValueAt(fila,0).toString();
        Pelicula pelicula_imprimir=new Pelicula();
        pelicula_imprimir=arbol.buscar(Integer.parseInt(contenido_celda));
        
        
        if (columna == 4) {
            
            ImageIcon iconoVer = new ImageIcon("iconos/sinopsis.png");
            JOptionPane.showMessageDialog(null,pelicula_imprimir.getSinopsis().toString(), "Sinopsis",1,iconoVer);
            
        }
        if (columna == 8) {
            List<Director> lista_directores=new LinkedList();
            lista_directores=pelicula_imprimir.getDirectores();
            ImageIcon iconoVer = new ImageIcon("iconos/silla_director.png");
            String cadena="";
            for (int i = 0; i <lista_directores.size(); i++) {
                cadena=cadena+"Director # "+(i+1)+"\n";
                cadena=cadena+lista_directores.get(i).toString()+"\n";
                if  (lista_directores.size()>1){
                if (i>=0 && i<lista_directores.size()-1) {
                    cadena=cadena+"__________________________________\n";
                }
                }
            }
            JOptionPane.showMessageDialog(null,cadena, "Directores",1,iconoVer);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
