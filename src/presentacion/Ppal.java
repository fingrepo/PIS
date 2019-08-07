package presentacion;

import index.Index;

import java.io.File;
import java.util.ArrayList;

import log.Log;
import grupos.ArchivoInfoGrupo;
import grupos.Leer;
import historia.EntradaSalida;
import utilidades.PropertyManager;

public class Ppal {

		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		PropertyManager resource = new PropertyManager("configuraciones/configuraciones.properties",true);
		String rutaPpal = resource.getString("rutaPpal");
		//String rutaPpal = args[0];
		
		Log.setRuta(rutaPpal);
	 	Log.log("Ppal.main :: Inicio de la generaci�n de la memoria organizacional.");
		
		Log.log("Ppal.main :: Leyendo archivos.");
		String rutaMaterialGrupo = rutaPpal +"/grupo";
		String rutaInfoGruposEntrada = rutaPpal + "/infoGruposEntrada";
		File f1 = new File(rutaInfoGruposEntrada);
		String[] archivosEntrada = f1.list();
		int cantGrupos = archivosEntrada.length;
		Log.log("Ppal.main :: Procesando material de " + String.valueOf(cantGrupos) + " grupos.");
		rutaInfoGruposEntrada = rutaInfoGruposEntrada +"/grupo";
		
		//Guardo en una estructura la info de los grupos
		ArrayList<ArchivoInfoGrupo> archivos = Leer.lectura(cantGrupos,rutaInfoGruposEntrada);
		
		//String rutaRaizAplicacion = args[1];
		String rutaRaizAplicacion = resource.getString("rutaRaizAplicacion");
		String ruta2 = rutaRaizAplicacion + "/templates/GrupoXX.htm";
		String ruta3 = rutaRaizAplicacion + "/templates/";
		String ruta4 = rutaRaizAplicacion + "/templates/Integrantestemplate.txt";
		String ruta5 = rutaRaizAplicacion + "/templates/FasesTemplate.txt";
		String ruta6 = rutaRaizAplicacion + "/templates/SemanasTemplate.txt";
		String ruta7 = rutaRaizAplicacion + "/templates/GraficoEsfuerzoTemplate.txt";
		
		Log.log("Ppal.main :: Creando p�gina de cada grupo.");
		//Escribo los html de todos los grupos con la info de cada uno
		Leer.escribirHTML(cantGrupos, ruta2, ruta3, ruta4,ruta5,ruta6, ruta7);
		 
		//Guardo en una estructura la memoria de cada grupo
		EntradaSalida s= new EntradaSalida(archivos);
		s.lectura(cantGrupos,rutaMaterialGrupo);
		 
		ruta4 = rutaRaizAplicacion + "/templates/MemoriaGrupoXX.htm";
		ruta3 =  rutaPpal +"/mgrupo"; 
		
		String rutaTemplates = rutaRaizAplicacion + "/templates/";
		
		Log.log("Ppal.main :: Creando p�gina del material de cada grupo.");
		//Escribo los html de todos los grupos con la mem.organizacional
		s.escribirHTMLPPAL(cantGrupos,ruta4,ruta3,rutaTemplates,rutaPpal);
		String rutaIndexTemplate = rutaRaizAplicacion + "/templates/indexTemplate.htm";
		
		//Escribo html index
		Index.escribirHTMLIndex(cantGrupos, rutaIndexTemplate, rutaTemplates, archivos);
		
		Log.log("Ppal.main :: Fin de la generaci�n de memoria organizacional.");
	}

}
