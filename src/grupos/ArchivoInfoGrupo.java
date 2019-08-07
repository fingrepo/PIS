package grupos;

import java.util.ArrayList;
import java.util.Collection;

 

public class ArchivoInfoGrupo {

    private String Proceso;
    private String nomDir1;
    private String nomDir2;
    private String nomCli;
    private String descProdC;
    private String nomProducto;
    private String descrProdL;
    private Collection<Integrantes> integ = new ArrayList<Integrantes>();
    private ArrayList<String> fases = new ArrayList<String>();
    private ArrayList<Integer> faseiters = new ArrayList<Integer>();
    private ArrayList<String> sems = new ArrayList<String>();

    public String getProceso() {
        return Proceso;
    }

    public void setProceso(String proceso) {
        Proceso = proceso;
    }

    public String getNomDir1() {
        return nomDir1;
    }

    public void setNomDir1(String nomDir1) {
        this.nomDir1 = nomDir1;
    }

    public String getNomDir2() {
        return nomDir2;
    }

    public void setNomDir2(String nomDir2) {
        this.nomDir2 = nomDir2;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getDescProdC() {
        return descProdC;
    }

    public void setDescProdC(String descProdC) {
        this.descProdC = descProdC;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getDescrProdL() {
        return descrProdL;
    }

    public void setDescrProdL(String descrProdL) {
        this.descrProdL = descrProdL;
    }

    public Collection<Integrantes> getInteg() {
        return integ;
    }

    public void addInteg(Integrantes i) {
        this.integ.add(i);
    }

    public void setInteg(Collection<Integrantes> integ) {
        this.integ = integ;
    }

    public Integer getFaseiters(int i) {
        return faseiters.get(i);
    }
  public ArrayList<Integer> getFaseiters() {
        return faseiters;
    }

    
    public void addFaseiters(int i) {
        this.faseiters.add(i);
    }
    
    
    
    public void changeFaseiters(int index,int i) {
        this.faseiters.set(index,i);
    }

    public void setFaseiters(ArrayList<Integer> faseiters) {
        this.faseiters = faseiters;
    }

    public ArrayList<String> getFases() {
        return fases;
    }

    public void addFase(String i) {
        this.fases.add(i);
    }
    
    public boolean existFase(String i) {
        boolean res=false;
        for (int j=0;j<fases.size();j++){
            if (fases.get(j).equals(i))
                res=true;
        }
        return res;
    }

    public void setFases(ArrayList<String> fases) {
        this.fases = fases;
    }

    public ArrayList<String> getSems() {
        return sems;
    }

    public void addSems(String i) {
        this.sems.add(i);
    }

    public void setSems(ArrayList<String> sems) {
        this.sems = sems;
    }
}
