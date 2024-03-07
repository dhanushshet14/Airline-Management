/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.project2;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author justi
 */
public class File1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        FileWriter fw1= new FileWriter("out1.txt");
        fw1.write("Flight 555");
        fw1.close();
    }
    
}
