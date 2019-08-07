package historia;


import java.util.ArrayList;

public class ConjuntoArchivos {
	String name;
	ArrayList<Archivo> archivos;
	
	public ConjuntoArchivos(String name) {
		this.archivos = new ArrayList<Archivo>();

		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Archivo> getArchivos() {
		return archivos;
	}
	
	public void setArchivos(ArrayList<Archivo> archivos) {
		this.archivos = archivos;
	}
	
	public Archivo getArchivo(int index) {
		return archivos.get(index);
	}
	
	public void setArchivo(Archivo a) {
		
		archivos.add(a);
		
	}
	
	
	

}
