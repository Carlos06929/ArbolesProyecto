/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1libreria1;
import java.io.*;
/**
 *
 * @author Usuario
 */
public class MiObjectOutputStream extends ObjectOutputStream {
    protected void writeStreaHeader() throws IOException{
    
    }
    
    public MiObjectOutputStream() throws IOException {
        super();
    }
    
    public MiObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
}
