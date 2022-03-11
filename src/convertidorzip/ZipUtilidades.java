/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Isaias
 */
public class ZipUtilidades {
    
    
    private static ZipUtilidades instance;
        //Singleton
	public static ZipUtilidades getInstance() {
		if (instance == null) {
			instance = new ZipUtilidades();
		}
		return instance;
	}

	/**
	 * Agregar archivos al zip
	 * 
	 * @param zipfilename
	 * @param file
	 * @param zos
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void agregarAlZip(File zipfilename, File file, ZipOutputStream zos)
			throws FileNotFoundException, IOException {

		FileInputStream fis = new FileInputStream(file);
		String zipFilePath = file.getName();
                System.out.println(zipFilePath);
		System.out.println("Agregando '" + zipFilePath + "' al archivo zip");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		zos.closeEntry();
		fis.close();
	}

	/**
         * Agrega la lista de File para ser zipiados
	 * @param fileList
	 * @param zipfileName
	 */

	public void comprimirArchivos(List<File> fileList, String zipfileName) {
		File zip = new File(zipfileName);
		try {
			FileOutputStream fos = new FileOutputStream(zip);
			ZipOutputStream zos = new ZipOutputStream(fos);
			for (File file1 : fileList) {
				if (!file1.isDirectory()) { 
					agregarAlZip(zip, file1, zos);
				}
			}
			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
