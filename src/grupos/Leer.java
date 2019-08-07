package grupos;


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

import utilidades.PropertyManager;

public class Leer {

    private static ArrayList<ArchivoInfoGrupo> archivos = new ArrayList<ArchivoInfoGrupo>();
    private static String desc;
    private static String rutagrupo;
    private static int puntero;
    private static int grupoE;
    
    private static PropertyManager resource = new PropertyManager("configuraciones/configuraciones.properties",true);

    public static ArrayList<ArchivoInfoGrupo> lectura(int cantgrupos, String ruta) {
    	
    	Log.log("Leer.lectura :: Iniciando lectura de archivos.");

        for (int j = 1; j < cantgrupos + 1; j++) {
            try {

                ArchivoInfoGrupo a = new ArchivoInfoGrupo();
                String linea;
                rutagrupo = ruta + j + ".txt";
                
                File f = new File(rutagrupo);

                BufferedReader entrada = new BufferedReader(new FileReader(f));
                if (f.exists()) {

                    linea = entrada.readLine();
                    puntero = 1;
                    a.setProceso(linea.replace(";", ""));

                    linea = entrada.readLine();
                    puntero++;
                    String[] result = linea.split(",");

                    if (result.length == 1) {
                        a.setNomDir1(result[0].replace(";", ""));
                        a.setNomDir2("");

                    } else {
                        a.setNomDir1(result[0]);
                        a.setNomDir2(result[1].replace(";", ""));
                    }


                    linea = entrada.readLine();
                    puntero++;
                    a.setNomCli(linea.replace(";", ""));

                    linea = entrada.readLine();
                    puntero++;
                    desc = new String();

                    while (!linea.endsWith(";")) {
                        desc = desc.concat(linea).concat(" ");
                        linea = entrada.readLine();
                        puntero++;

                    }
                    desc = desc.concat(linea);
                    a.setDescProdC(desc.replace(";", ""));

                    linea = entrada.readLine();
                    puntero++;
                    a.setNomProducto(linea.replace(";", ""));

                    linea = entrada.readLine();
                    puntero++;
                    desc = new String();
                    while (!linea.endsWith(";")) {
                        desc = desc.concat(linea).concat(" ");
                        linea = entrada.readLine();
                        puntero++;

                    }
                    desc = desc.concat(linea);
                    a.setDescrProdL(desc.replace(";", ""));

                    linea = entrada.readLine();
                    puntero++;
                    while (!linea.contains("iter") && !linea.contains("sprint")) {
                        Integrantes i = new Integrantes();
                        String[] result2 = linea.split(",");
                        i.setNombre(result2[0]);
                        String roles = result2[1].replace(";", "");
                        for (int c = 2; c < result2.length; c++) {
                            roles = roles.concat(", " + result2[c].replace(";", ""));
                        }

                        i.setRoles(roles);
                        a.addInteg(i);
                        linea = entrada.readLine();
                        puntero++;
                    }
                    int c = 0;
                    String sema = "";
                    while (linea != null) {

                        String[] result3 = linea.split("iter");
                        result3[1] = result3[1].substring(2).replace(";", "");
                        int z = 0;
                        int tam = result3[1].length();
                        for (int k = 0; k < (9 - tam); k++) {
                            if (z == 0) {
                                result3[1] = result3[1] + "&nbsp;";
                                z = 1;
                            } else {
                                result3[1] = "&nbsp;" + result3[1];
                                z = 0;
                            }
                        }
                        if (a.existFase(result3[0].replace(",", ""))) {
                            a.changeFaseiters(c - 1, (a.getFaseiters(c - 1) + 1));

                            sema = sema + "/" + result3[1];
                        } else {
                            if (c != 0) {

                                a.addSems(sema);
                            }
                            sema = "";
                            a.addFase(result3[0].replace(",", ""));
                            a.addFaseiters(1);
                            sema = result3[1];


                            c++;
                        }
                       
                        linea = entrada.readLine();
                        puntero++;
                    }
                    a.addSems(sema);


                    archivos.add(a);

                }

            } catch (Exception e) {
            	Log.log("Leer.lectura :: Error en el archivo " + rutagrupo + " en la l�nea " + String.valueOf(puntero) + ".");
            }

        }
        return archivos;
    }
    	
    public static void escribirHTML(int cantgrupos, String ruta, String ruta2, String ruta3, String ruta4, String ruta5, String ruta6) {

        try {
            boolean continua;
            for (int j = 1; j < cantgrupos + 1; j++) {
                
            	grupoE = j;
            	Log.log("Leer.escribirHTML :: Escribiendo archivo del grupo " + String.valueOf(j) + ".");
            	
            	boolean tieneGrafica = false;
            	String nombreGrafica = null;
            	String linea;

                File f = new File(ruta);
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                
                String rutaPpal = resource.getString("rutaPpal");
                
                //Chequeo si el grupo tiene archivo de grafica y guardo el nombre
                File directorioGraficas = new File(rutaPpal + "/graficasGrupos");
                String[] archivosGraficas = directorioGraficas.list();
                int index = 0;
                while (index < archivosGraficas.length ){
                	String g = archivosGraficas[index];
                	if( g.equalsIgnoreCase("grupo"+j+".jpg") || g.equalsIgnoreCase("grupo"+j+".jpeg") || g.equalsIgnoreCase("grupo"+j+".png") || g.equalsIgnoreCase("grupo"+j+".gif"))
                	{
                		tieneGrafica = true;
                	    nombreGrafica = g;
                	    break;
                	}
                	index++;
                }
                //
                FileWriter fw = new FileWriter(rutaPpal + "/grupo" + j + ".htm");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salida = new PrintWriter(bw);

                if (f.exists()) {
                    linea = entrada.readLine();
                    while (linea != null) {
                        continua = true;
                        if (linea.contains("GRUPO XX")) {
                            salida.println(linea.replace("GRUPO XX", "GRUPO " + j));
                            continua = false;
                        }
                        if (linea.contains("[nombre del proceso]")) {
                            salida.println(linea.replace("[nombre del proceso]", archivos.get(j - 1).getProceso()));
                            continua = false;
                        }
                        if (linea.contains("[nombre de director\\es]")) {
                            String segundo = "";
                            if (!archivos.get(j - 1).getNomDir2().equals("")) {
                                segundo = " ," + archivos.get(j - 1).getNomDir2();
                            }
                            salida.println(linea.replace("[nombre de director\\es]", archivos.get(j - 1).getNomDir1() + segundo));
                            continua = false;
                        }
                        if (linea.contains("[nombre del cliente]")) {
                            salida.println(linea.replace("[nombre del cliente]", archivos.get(j - 1).getNomCli()));
                            continua = false;
                        }
                        if (linea.contains("[aca va una descripcion del producto realizado]")) {
                            salida.println(linea.replace("[aca va una descripcion del producto realizado]", archivos.get(j - 1).getDescProdC()));
                            continua = false;
                        }
                        if (linea.contains("[nombre del producto]")) {
                            salida.println(linea.replace("[nombre del producto]", archivos.get(j - 1).getNomProducto()));
                            continua = false;
                        }
                        if (linea.contains("[aca va una descripcion del producto realizado.]")) {
                            salida.println(linea.replace("[aca va una descripcion del producto realizado.]", archivos.get(j - 1).getDescrProdL()));
                            continua = false;
                        }
                        if (linea.contains("INTEGRANTESTEMP")) {
                            escribirIntegrantesHTML(salida, ruta3, j - 1);
                            continua = false;
                        }

                        if (linea.contains("FASES")) {
                            escribirFasesHTML(salida, ruta4, j - 1);
                            continua = false;
                        }

                        if (linea.contains("ITERACIONES")) {
                            escribirItersHTML(salida, ruta4, j - 1);
                            continua = false;
                        }

                        if (linea.contains("SEMANAS")) {
                            escribirSemsHTML(salida, ruta5, j - 1);
                            continua = false;
                        }
                        
                        if (linea.contains("GRAFICA")) 
                        {
                          if (tieneGrafica)
                          {
                        	escribirGraficaHTML(salida, ruta6, j - 1, nombreGrafica);
                            
                          }
                          else
                          {
                        	 salida.println(linea.replace("GRAFICA", "")); 
                          }
                          continua = false;
                        }
                        
                        if (continua) {
                            salida.println(linea);

                        }
                        linea = entrada.readLine();
                    }
                }
                salida.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	Log.log("Leer.escribirHTML :: Error al escribir archivo del grupo " + String.valueOf(grupoE) + ".");
        }

    }
    
    public static void escribirGraficaHTML(PrintWriter salida, String ruta, int grupo, String nombreImagen) {

        try {
            String linea;
            boolean continua;
            

                File f = new File(ruta);
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                linea = entrada.readLine();

                while (linea != null) {
                    continua = true;
                    if (linea.contains("[NOMBRE IMAGEN]")) {
                        salida.println(linea.replace("[NOMBRE IMAGEN]", "graficasGrupos/"+nombreImagen));
                        continua = false;
                    }
                    if (continua) {
                        salida.println(linea);

                    }
                    linea = entrada.readLine();
                }

            

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

  
    public static void escribirIntegrantesHTML(PrintWriter salida, String ruta, int grupo) {

        try {
            String linea;
            boolean continua;
            for (Integrantes inter : archivos.get(grupo).getInteg()) {

                File f = new File(ruta);
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                linea = entrada.readLine();

                while (linea != null) {
                    continua = true;
                    if (linea.contains("[nombre integrante 1]")) {
                        salida.println(linea.replace("[nombre integrante 1]", inter.getNombre()));
                        continua = false;
                    }
                    if (linea.contains("[roles integrante 1]")) {
                        salida.println(linea.replace("[roles integrante 1]", inter.getRoles()));
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

    public static void escribirFasesHTML(PrintWriter salida, String ruta, int grupo) {

        try {
            String linea;
            boolean continua;
            for (String inter : archivos.get(grupo).getFases()) {

                File f = new File(ruta);
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                linea = entrada.readLine();

                while (linea != null) {
                    continua = true;
                    if (linea.contains("Fase")) {
                        salida.println(linea.replace("Fase", "Fase " + inter));
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

    public static void escribirItersHTML(PrintWriter salida, String ruta, int grupo) {

        try {
            String linea;
            boolean continua;
            for (Integer inter : archivos.get(grupo).getFaseiters()) {

                File f = new File(ruta);
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                linea = entrada.readLine();

                while (linea != null) {
                    continua = true;
                    if (linea.contains("Fase")) {
                        String iter = "";
                        for (int i = 0; i < inter.intValue(); i++) {
                            iter = iter + "&nbsp;&nbsp;iter" + (i + 1) + "&nbsp;&nbsp;";
                            if (i < inter - 1) {
                                iter = iter + "/";
                            }
                        }
                        salida.println(linea.replace("Fase", iter));
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

    public static void escribirSemsHTML(PrintWriter salida, String ruta, int grupo) {

        try {
            String linea;
            boolean continua;
            for (String inter : archivos.get(grupo).getSems()) {

                File f = new File(ruta);
                BufferedReader entrada = new BufferedReader(new FileReader(f));
                linea = entrada.readLine();

                while (linea != null) {
                    continua = true;
                    if (linea.contains("sem")) {
                        salida.println(linea.replace("sem", inter));
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


