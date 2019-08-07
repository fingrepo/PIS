package historia;

import java.util.ArrayList;

public class ArchivoPorDiciplina {

    String name;
    ArrayList<ConjuntoArchivos> lista;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ConjuntoArchivos> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ConjuntoArchivos> lista) {
        this.lista = lista;
    }

    public ArrayList<Archivo> getArchivos(String name) {

        for (ConjuntoArchivos l : lista) {
            if (l.getName().equals(name)) {
                return l.getArchivos();
            }

        }
        return null;

    }

    public void setArchivos(String name, int iteracion, int fase, int disiplina) {
        Archivo a = new Archivo();
        a.setDisiplina(disiplina);
        a.setExiste(true);
        a.setFase(fase);
        a.setIteracion(iteracion);
        a.setName(name);

        for (ConjuntoArchivos l : lista) {
            if (name.contains(l.getName())) {
               
                l.setArchivo(a);

            }

        }

    }


   
}
