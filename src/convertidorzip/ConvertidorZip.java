/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorzip;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaias
 */
public class ConvertidorZip {

    /**
     * @param args the command line arguments
     */
    //Directorio a comprimir
    static String directorio = "C:\\Users\\Isaias\\Desktop\\archivoszip";
    //Directorio donde se guarda el comprimido.
    static String nombreComprimido = "C:\\Users\\Isaias\\Desktop\\archivoszip\\XmlComprimido.zip";

    public static void main(String args[]) {
        List<File> fileList = new ArrayList<File>();
        File directorio = new File("C:\\Users\\Isaias\\Desktop\\archivoszip");
        if (directorio.isDirectory()) {
            for (File f : directorio.listFiles()) {
                //Aqui podemos hacer validaciones para incluir o excluir archivos
                System.out.println(f.getAbsolutePath());
                fileList.add(f);
            }
        } else {
            System.out.println("La direccion : [" + directorio + "] No es un directorio o no existe");
            System.out.println("No se pudo comprimir");
        }
        System.out.println("****************************************************************");
        System.out.println("Comprimiendo en el directorio: " + nombreComprimido);
        ZipUtilidades.getInstance().comprimirArchivos(fileList, nombreComprimido);
        System.out.println("****************************************************************");
    }

}
