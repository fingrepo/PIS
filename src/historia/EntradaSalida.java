package historia;

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

import log.Log;

public class EntradaSalida {

    ArrayList<Disciplinas> disG;
    ArrayList<ArchivoInfoGrupo> archivos;
    private static int grupoE;

    public EntradaSalida( ArrayList<ArchivoInfoGrupo> archivos) {
    	this.archivos = archivos;
        this.disG = new ArrayList<Disciplinas>();

    }

    public void lectura(int cantgrupos, String ruta) {
        for (int j = 1; j < cantgrupos + 1; j++) {
           lecturaNGx(ruta, j);
        }
    }

    public void lecturaNGx(String ruta, int j) {

    	Disciplinas dis = new Disciplinas();

        this.disG.add(j - 1, dis);
        ArrayList<ArchivoPorDiciplina> disciplinas = dis.getDisciplinas();

        for (int i = 0; i < disciplinas.size(); i++) {
        	
        	//Nuevo
        	//Obtengo archivo txt correspondiente al grupo j
        	ArchivoInfoGrupo archGrupo = archivos.get(j-1);
        	ArrayList<String> fasesGrupo = archGrupo.getFases();
        	//Recorro fases
        	
        	 for (int k = 0; k < fasesGrupo.size(); k++) {
        		 
        	 //Obtengo cantidad iteraciones fase k
        	  ArrayList<Integer> iteracionesFase = archGrupo.getFaseiters();
        	  int cantIters = iteracionesFase.get(k).intValue();
        	 //Recorro iteraciones de cada fase
        	  for (int y = 0; y < cantIters; y++) {
        		  
        		 String rutaAux = ruta + j + "/" + disciplinas.get(i).getName() + "/" + fasesGrupo.get(k) + "/iter" + (y+1);                     
             	 File fAux = new File(rutaAux);
             	 String[] archivosAux = fAux.list();
             	
             	 Log.log(rutaAux);
                
                  if (fAux.exists()) {
                      for (String string : archivosAux) {
                        
                          if (Rutas.Pertenece(string, i)) {
                              disciplinas.get(i).setArchivos(string, (y+1), k, i);
                          }
                      }
                  }
        		  
        		  
        	  }
        		 
        		 
        	
             
        	 }




        }



    }



    public void escribirHTMLPPAL(int cantgrupos, String rutatemp, String ruta, String rutaTemplates, String rutaPpal) {

        for (int j = 1; j < cantgrupos + 1; j++) {
        	grupoE = j;
        	Log.log("EntradaSalida.escribirHTMLPPAL :: Escribiendo archivo de material del grupo " + String.valueOf(j) + ".");
            escribirHTMLPPALxGrupo(j, rutatemp, ruta, rutaTemplates,rutaPpal);
        }
    }

    public void escribirHTMLPPALxGrupo(int j, String rutatemp, String ruta, String rutaTemplates,String rutaPpal) {

       
        escribirHTML(j, rutatemp, ruta, rutaTemplates, rutaPpal);
        
    }

    public void escribirHTML(int j, String rutatemp, String ruta, String rutaTemplates,String rutaPpal) {
        try {
            boolean continua;

            String linea;

            File f = new File(rutatemp);
            BufferedReader entrada = new BufferedReader(new FileReader(f));
            
            FileWriter fw = new FileWriter(ruta + j + ".htm");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);

            String rutaFasesMemTemplate = rutaTemplates + "//FasesMemTemplate.txt";
            String linksTemplate = rutaTemplates + "//LinksTemplate.txt";
            
            if (f.exists()) {
                linea = entrada.readLine();
                while (linea != null) {
                    continua = true;
                    if (linea.contains("Entregables del Grupo")) {
                        salida.println(linea.replace("Entregables del Grupo", "Entregables del Grupo " + j));
                      
                        continua = false;
                    }
                    
                    if (linea.contains("FASESMEMTEMPLATE")) {
                        escribirNombreFasesHTML(salida, rutaFasesMemTemplate, j);
                        continua = false;
                    }
                    
                    
                    
                    for (int i = 0; i < 9; i++) {
                        ArrayList<ConjuntoArchivos> arch = disG.get(j - 1).getDisciplinas().get(i).getLista();
                        String namedis = disG.get(j - 1).getDisciplinas().get(i).getName();
                        
                        for (int k = 0; k < arch.size(); k++) {
                            String nameEntreg = arch.get(k).getName();
                          
                            if (linea.contains("LINKS"+ nameEntreg)) {
                            	
                            	escribirLinksHTML(salida, linksTemplate, j, nameEntreg, namedis, i, rutaPpal);
                                continua = false;
                            }
                        }
                        
                    }
                    
                    if (continua) {
                        salida.println(linea);

                    }

                    linea = entrada.readLine();
                }
            }
            salida.close();

        } catch (Exception e) {
        	Log.log("EntradaSalida.escribirHTML :: Escribiendo archivo de material del grupo " + String.valueOf(grupoE) + ".");
        }

    }

    public void escribirNombreFasesHTML(PrintWriter salida, String ruta, int grupo) {

    	   try {
    		   
    		   ArchivoInfoGrupo archGrupo = archivos.get(grupo-1);
              ArrayList<String> fasesGrupo = archGrupo.getFases();
    		   
               String linea;
               boolean continua;
               for (String nomFase : fasesGrupo) {

                   File f = new File(ruta);
                   BufferedReader entrada = new BufferedReader(new FileReader(f));
                   linea = entrada.readLine();

                   while (linea != null) {
                       continua = true;
                       if (linea.contains("FASE")) {
                           salida.println(linea.replace("FASE", "Fase " + nomFase));
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

    public void escribirLinksHTML(PrintWriter salida, String ruta, int grupo, String nameEntreg, String namedis, int dis, String rutaPpal) {

 	   try {
 		   
 		   ArchivoInfoGrupo archGrupo = archivos.get(grupo-1);
           ArrayList<String> fasesGrupo = archGrupo.getFases();
 		   
            String linea;
            boolean continua;
            for (int k = 0; k<fasesGrupo.size() ; k++){//String nomFase : fasesGrupo) {

            	String nomFase = fasesGrupo.get(k);
                File f = new File(ruta);
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                linea = entrada.readLine();

                while (linea != null) {
                    continua = true;
                    if (linea.contains("LINKS")) {
                    	
                    	
                      ArrayList<Integer> iteracionesFase = archGrupo.getFaseiters();
                  	  int cantIters = iteracionesFase.get(k).intValue();
                  	 //Recorro iteraciones de cada fase
                  	  for (int y = 0; y < cantIters; y++) {
                  		  
                  		String rutaArchivo = disG.get(grupo - 1).getNameArchivo(nameEntreg, (y+1), k, dis);
                  		if (rutaArchivo != "")
                  		{
	                    	String link = "<a href=\""+"grupo"+grupo+"/" + namedis + "/" +nomFase+"/" + "iter"+(y+1) + "/" + rutaArchivo + "\""+">";
	                    	//Calculo tamanio
	                    	File archivoReal = new File(rutaPpal+"/"+"grupo"+grupo+"/" + namedis + "/" +nomFase+"/" + "iter"+(y+1) + "/" + rutaArchivo);
	                    	long tamanio = archivoReal.length();
	                    	tamanio = tamanio / 1024; //tamanio en kbytes
	                    	
	                    	String tamanioString = tamanio + " Kb";
	                    	link = link + "iter"+(y+1)+ " ("+tamanioString+")</a><br>";
	                    	
	                        salida.println(link);
                  		}
                        
                  	 }
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

    
    
}
