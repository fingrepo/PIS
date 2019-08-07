package index;


import grupos.ArchivoInfoGrupo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import utilidades.PropertyManager;

public class Index {

	private static PropertyManager resource = new PropertyManager("configuraciones/configuraciones.properties",true);
    public static void escribirHTMLIndex(int cantgrupos, String rutaIndexTemplate, String rutaTemplates, ArrayList<ArchivoInfoGrupo> archivos) {

        try {
            boolean continua;
            
                
               	String linea;

                File f = new File(rutaIndexTemplate);
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                
                String rutaPpal = resource.getString("rutaPpal");
                String anio = resource.getString("anio");
                String rutaGrupoIndexTemplate = rutaTemplates + "/GrupoIndexTemplate.txt";
                
                FileWriter fw = new FileWriter(rutaPpal + "/index" + ".htm");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salida = new PrintWriter(bw);

                if (f.exists()) {
                    linea = entrada.readLine();
                    while (linea != null) {
                        continua = true;
                        if (linea.contains("AniO")) {
                            salida.println(linea.replace("AniO", anio));
                            continua = false;
                        }
                        if (linea.contains("CANTGRUPOS")) {
                            salida.println(linea.replace("CANTGRUPOS", ""+cantgrupos));
                            continua = false;
                        }
                       
                        if (linea.contains("GRUPO_INDEX_TEMPLATE")) {
                            escribirGruposHTML(salida, rutaGrupoIndexTemplate,cantgrupos, archivos, rutaPpal);
                            continua = false;
                        }
                       
                        if (continua) {
                            salida.println(linea);

                        }
                        linea = entrada.readLine();
                    }
                }
                salida.close();
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
   
  
    public static void escribirGruposHTML(PrintWriter salida, String ruta, int cantgrupos, ArrayList<ArchivoInfoGrupo> archivos, String rutaPpal) {

        try {
            String linea;
            boolean continua;
            for (int j = 1; j < cantgrupos + 1; j++){
            	
            	ArchivoInfoGrupo archGrupo = archivos.get(j-1);
            	String rutaGrupo = rutaPpal + "/grupo"+j;
            	
                File f = new File(ruta);
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                linea = entrada.readLine();

                while (linea != null) {
                    continua = true;
                    
                    if (linea.contains("RUTA_INFO_G")) {
                    	
                    	
                        salida.println(linea.replace("RUTA_INFO_G", "grupo"+j+".htm"));
                        continua = false;
                    }
                    
                    
                   
                    if (linea.contains("GRUPO")) {
                        salida.println(linea.replace("GRUPO", "Grupo "+j));
                        continua = false;
                    }
                    
                    if (linea.contains("TIPO_PROCESO")) {
                        salida.println(linea.replace("TIPO_PROCESO", archGrupo.getProceso()));
                        continua = false;
                    }
                    
                    if (linea.contains("ORGANIZACION")) {
                    	
                    	String nomCliente = archGrupo.getNomCli();
                    	String[] partes = nomCliente.split(",");
                    	String reemplazo = "";
                    	if (partes != null && partes.length > 1)
                    	{
                    		reemplazo = partes[1];
                    	}
                        salida.println(linea.replace("ORGANIZACION", reemplazo));
                        continua = false;
                    }
                    if (linea.contains("NOM_CLIENTE")) {
                    	String nomCliente = archGrupo.getNomCli();
                    	String[] partes = nomCliente.split(",");
                    	String reemplazo = "";
                    	if (partes != null)
                    	{
                    		reemplazo = partes[0];
                    	}
                        salida.println(linea.replace("NOM_CLIENTE", reemplazo));
                        continua = false;
                    }
                    if (linea.contains("NOM_DIRECTOR")) {
                    	String nomDir1 = archGrupo.getNomDir1();
                    	String nomDir2 = archGrupo.getNomDir2();
                    	String reemplazo = nomDir1;
                    	if (nomDir2 != null && nomDir2 != "")
                    		reemplazo = reemplazo + ", "+nomDir2;
                    	
                    	
                        salida.println(linea.replace("NOM_DIRECTOR", reemplazo));
                        continua = false;
                    }
                    
                    if (linea.contains("NOM_PRODUCTO")) {
                        salida.println(linea.replace("NOM_PRODUCTO", archGrupo.getNomProducto()));
                        continua = false;
                    }
                    
                    if (linea.contains("RUTA_MG")) {
                        salida.println(linea.replace("RUTA_MG", "mgrupo"+j+".htm"));
                        continua = false;
                    }
                    
                    if (linea.contains("RUTA_PRESENTACIONES")) {
                    	escribirRutaPresentaciones(salida, rutaGrupo, j);
                        continua = false;
                    }
                    
                    if (linea.contains("RUTA_PRODUCTO")) {
                    	escribirRutaProducto(salida, rutaGrupo, j);
                        continua = false;
                    }
                    
                    if (continua) {
                        salida.println(linea);

                    }
                    
                    linea = entrada.readLine();
                }

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public static void escribirRutaPresentaciones(PrintWriter salida, String ruta, int grupo) {

        File f = new File(ruta);
        String[] listaDirectorio = f.list();
        boolean encontreArchivo = false;
        for(String arch:listaDirectorio)
        {
        	if (arch.equals("presentaciones.rar") ){
        		encontreArchivo = true;
        	    break;
        	}
        }
        String linea = "";
        if ( encontreArchivo )
        {
        	
        	File archivoReal = new File(ruta+"/"+"presentaciones.rar");
        	long tamanio = archivoReal.length();
        	tamanio = tamanio / 1024; //tamanio en kbytes
        	tamanio = tamanio / 1024; //tamanio en mbytes
        	if (tamanio == 0)
        		tamanio++;
        	String tamanioString = tamanio + " Mb";
        	linea = "</br></br><a href=\"grupo"+grupo+"/presentaciones.rar\">presentaciones (" + tamanioString + ")</a>";             	
        	
        } else {
            for(String arch:listaDirectorio)
            {
            	if (arch.equals("presentaciones.zip") ){
            		encontreArchivo = true;
            	    break;
            	}
            }
            if ( encontreArchivo )
            {
            	File archivoReal = new File(ruta+"/"+"presentaciones.zip");
            	long tamanio = archivoReal.length();
            	tamanio = tamanio / 1024; //tamanio en kbytes
            	tamanio = tamanio / 1024; //tamanio en mbytes
            	if (tamanio == 0)
            		tamanio++;
            	String tamanioString = tamanio + " Mb";
            	linea = "</br></br><a href=\"grupo"+grupo+"/presentaciones.zip\">presentaciones (" + tamanioString + ")</a>";              	         	
            }
        }
        salida.println(linea);
        
        // Escribe línea para descargar material si existe el archivo material.zip en la carpeta
        f = new File(ruta);
        listaDirectorio = f.list();
        linea = "";        	
        encontreArchivo = false;
        for(String arch:listaDirectorio)
        {
        	if (arch.equals("material.zip") ){
        		encontreArchivo = true;
        	    break;
        	}
        }
        if ( encontreArchivo )
        {
        	File archivoReal = new File(ruta+"/"+"material.zip");
        	long tamanio = archivoReal.length();
        	tamanio = tamanio / 1024; //tamanio en kbytes
        	tamanio = tamanio / 1024; //tamanio en mbytes
        	if (tamanio == 0)
        		tamanio++;
        	String tamanioString = tamanio + " Mb";
        	linea = "</br></br><a href=\"grupo"+grupo+"/material.zip\">zip (" + tamanioString + ")</a>";           	
        }
        salida.println(linea);
    }

    public static void escribirRutaProducto(PrintWriter salida, String ruta, int grupo) {

        File f = new File(ruta);
        String[] listaDirectorio = f.list();
        boolean encontreArchivo = false;
        for(String arch:listaDirectorio)
        {
        	if (arch.equals("producto.rar") ){
        		encontreArchivo = true;
        	    break;
        	}
        }
        String linea = "";
        if ( encontreArchivo )
        {
        	
        	File archivoReal = new File(ruta+"/"+"producto.rar");
        	long tamanio = archivoReal.length();
        	tamanio = tamanio / 1024; //tamanio en kbytes
        	tamanio = tamanio / 1024; //tamanio en mbytes
        	if (tamanio == 0)
        		tamanio++;
        	String tamanioString = tamanio + " Mb";
        	linea = "</br></br><a href=\"grupo"+grupo+"/producto.rar\">producto (" + tamanioString + ")</a>";             	
        	
        } else {
            for(String arch:listaDirectorio)
            {
            	if (arch.equals("producto.zip") ){
            		encontreArchivo = true;
            	    break;
            	}
            }
            if ( encontreArchivo )
            {
            	File archivoReal = new File(ruta+"/"+"producto.zip");
            	long tamanio = archivoReal.length();
            	tamanio = tamanio / 1024; //tamanio en kbytes
            	tamanio = tamanio / 1024; //tamanio en mbytes
            	if (tamanio == 0)
            		tamanio++;
            	String tamanioString = tamanio + " Mb";
            	linea = "</br></br><a href=\"grupo"+grupo+"/producto.zip\">producto (" + tamanioString + ")</a>";              	         	
            }
        }
        salida.println(linea);
        
    }
    
    
    
}


