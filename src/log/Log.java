package log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class Log {

	private static String archivo;

    public static void setRuta(String ruta){
    	archivo = ruta + "//log.txt";
    }
    
	public static void log(String registro){
        try {
        	Date now = new Date();
        	registro = now.toString() + " :: " + registro;
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
            PrintWriter salida = new PrintWriter(bw);
            salida.println(registro);
            salida.close();
        } catch (Exception e) {
            System.out.println("Log.print :: Error al escribir en log " + e.toString());
        }
	}
}