package historia;


public class Archivo {
	String name;
	int iteracion;
	int fase;
	int disiplina;
	
	boolean existe;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIteracion() {
		return iteracion;
	}
	public void setIteracion(int iteracion) {
		this.iteracion = iteracion;
	}
	public int getFase() {
		return fase;
	}
	public void setFase(int fase) {
		this.fase = fase;
	}
	public int getDisiplina() {
		return disiplina;
	}
	public void setDisiplina(int disiplina) {
		this.disiplina = disiplina;
	}
	public boolean isExiste() {
		return existe;
	}
	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	

}
