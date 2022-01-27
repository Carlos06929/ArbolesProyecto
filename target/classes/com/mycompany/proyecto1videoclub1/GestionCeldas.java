/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1videoclub1;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Usuario
 */
public class GestionCeldas extends DefaultTableCellRenderer {
    private String tipo="text";

	//se definen por defecto los tipos de datos a usar
	private Font normal = new Font( "Verdana",Font.PLAIN ,12 );
	private Font bold = new Font( "Verdana",Font.BOLD ,12 );
	//etiqueta que almacenará el icono a mostrar
	private JLabel label = new JLabel();
	//iconos disponibles para ser mostrados en la etiqueta dependiendo de la columna que lo contenga
	private ImageIcon iconoVer = new ImageIcon("iconos/ojo.png");
        

	
	
	public GestionCeldas(){
		
	}
        
	
	

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
		/*
		 * Este metodo controla toda la tabla, podemos obtener el valor que contiene
		 * definir que celda está seleccionada, la fila y columna al tener el foco en ella.
		 * 
		 * cada evento sobre la tabla invocará a este metodo
		 */
		
		//definimos colores por defecto
        Color colorFondo = null;
        Color colorFondoPorDefecto=new Color( 255, 255, 255);
        Color colorFondoSeleccion=new Color(0,0,0);
    	
        /*
         * Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección
         */
        if (selected) {                
            this.setBackground(colorFondoPorDefecto );   
        }
        else
        {
        	//Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(Color.white);
        }
                
        
        
            label.setOpaque(true);
            label.setBackground(colorFondoPorDefecto);
            label.setForeground(colorFondoSeleccion);
            label.setIcon(iconoVer);
            label.setHorizontalAlignment( JLabel.LEFT );
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            label.setText("(Ver Contenido)");
//            return boton;
            return label;
       
        
}
}