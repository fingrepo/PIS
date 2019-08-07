package historia;

import java.util.ArrayList;

public class Disciplinas {

    ArrayList<ArchivoPorDiciplina> disciplinas;
    
     public Disciplinas() {

        this.disciplinas = new ArrayList<ArchivoPorDiciplina>();

        // Creo archivos
        ArchivoPorDiciplina req = new ArchivoPorDiciplina();
        req.setName(Rutas.Disciplinas.requerim);
        ArchivoPorDiciplina dis = new ArchivoPorDiciplina();
        dis.setName(Rutas.Disciplinas.disenio);
        ArchivoPorDiciplina implem = new ArchivoPorDiciplina();
        implem.setName(Rutas.Disciplinas.implem);
        ArchivoPorDiciplina verif = new ArchivoPorDiciplina();
        verif.setName(Rutas.Disciplinas.verificacion);
        ArchivoPorDiciplina implan = new ArchivoPorDiciplina();
        implan.setName(Rutas.Disciplinas.implan);
        ArchivoPorDiciplina gest = new ArchivoPorDiciplina();
        gest.setName(Rutas.Disciplinas.gestProy);
        ArchivoPorDiciplina sqa = new ArchivoPorDiciplina();
        sqa.setName(Rutas.Disciplinas.sqa);
        ArchivoPorDiciplina scm = new ArchivoPorDiciplina();
        scm.setName(Rutas.Disciplinas.scm);
        ArchivoPorDiciplina comunic = new ArchivoPorDiciplina();
        comunic.setName(Rutas.Disciplinas.comunic);
        //ArchivoPorDiciplina inves = new ArchivoPorDiciplina();
        //inves.setName(Rutas.getInvestigacion());

        this.disciplinas.add(0, req);
        this.disciplinas.add(1, dis);
        this.disciplinas.add(2, implem);
        this.disciplinas.add(3, verif);
        this.disciplinas.add(4, implan);
        this.disciplinas.add(5, gest);
        this.disciplinas.add(6, sqa);
        this.disciplinas.add(7, scm);
        this.disciplinas.add(8, comunic);
       // this.disciplinas.add(9, inves);

        // Requerimientos

        ConjuntoArchivos r1 = new ConjuntoArchivos(Rutas.Documentos.R1);
        ConjuntoArchivos r2 = new ConjuntoArchivos(Rutas.Documentos.R2);
        ConjuntoArchivos r3 = new ConjuntoArchivos(Rutas.Documentos.R3);
        ConjuntoArchivos r4 = new ConjuntoArchivos(Rutas.Documentos.R4);
        ConjuntoArchivos r5 = new ConjuntoArchivos(Rutas.Documentos.R5);
        ConjuntoArchivos r6 = new ConjuntoArchivos(Rutas.Documentos.R6);
        ConjuntoArchivos r7 = new ConjuntoArchivos(Rutas.Documentos.R7);
        ConjuntoArchivos r8 = new ConjuntoArchivos(Rutas.Documentos.R8);
        ConjuntoArchivos r9 = new ConjuntoArchivos(Rutas.Documentos.R9);
        ConjuntoArchivos r10 = new ConjuntoArchivos(Rutas.Documentos.R10);
        ConjuntoArchivos r11 = new ConjuntoArchivos(Rutas.Documentos.R11);
        
       // ConjuntoArchivos r12 = new ConjuntoArchivos(Rutas.getR12());
       // ConjuntoArchivos r13 = new ConjuntoArchivos(Rutas.getR13());
       // ConjuntoArchivos r14 = new ConjuntoArchivos(Rutas.getR14());

        ArrayList<ConjuntoArchivos> lista1 = new ArrayList<ConjuntoArchivos>();

        lista1.add(0, r1);
        lista1.add(1, r2);
        lista1.add(2, r3);
        lista1.add(3, r4);
        lista1.add(4, r5);
        lista1.add(5, r6);
        lista1.add(6, r7);
        lista1.add(7, r8);
        lista1.add(8, r9);
        lista1.add(9, r10);
        lista1.add(10, r11);
     //   lista1.add(11, r12);
      //  lista1.add(12, r13);
     //   lista1.add(13, r14);

        req.setLista(lista1);

        // Dise�o

        ConjuntoArchivos d1 = new ConjuntoArchivos(Rutas.Documentos.D1);
        ConjuntoArchivos d2 = new ConjuntoArchivos(Rutas.Documentos.D2);
        ConjuntoArchivos d3 = new ConjuntoArchivos(Rutas.Documentos.D3);
        ConjuntoArchivos d4 = new ConjuntoArchivos(Rutas.Documentos.D4);

        ArrayList<ConjuntoArchivos> lista2 = new ArrayList<ConjuntoArchivos>();

        lista2.add(0, d1);
        lista2.add(1, d2);
        lista2.add(2, d3);
        lista2.add(3, d4);

        dis.setLista(lista2);

        // Implementacion

        ConjuntoArchivos im1 = new ConjuntoArchivos(Rutas.Documentos.IM1);
        ConjuntoArchivos im2 = new ConjuntoArchivos(Rutas.Documentos.IM2);
        ConjuntoArchivos im3 = new ConjuntoArchivos(Rutas.Documentos.IM3);
        ConjuntoArchivos im4 = new ConjuntoArchivos(Rutas.Documentos.IM4);
        ConjuntoArchivos im5 = new ConjuntoArchivos(Rutas.Documentos.IM5);
        ConjuntoArchivos im6 = new ConjuntoArchivos(Rutas.Documentos.IM6);
        ConjuntoArchivos im7 = new ConjuntoArchivos(Rutas.Documentos.IM7);
        ConjuntoArchivos im8 = new ConjuntoArchivos(Rutas.Documentos.IM8);
        ConjuntoArchivos im9 = new ConjuntoArchivos(Rutas.Documentos.IM9);
        ConjuntoArchivos im10 = new ConjuntoArchivos(Rutas.Documentos.IM10);
        ConjuntoArchivos im11 = new ConjuntoArchivos(Rutas.Documentos.IM11);

        ArrayList<ConjuntoArchivos> lista3 = new ArrayList<ConjuntoArchivos>();

        lista3.add(0, im1);
        lista3.add(1, im2);
        lista3.add(2, im3);
        lista3.add(3, im4);
        lista3.add(4, im5);
        lista3.add(5, im6);
        lista3.add(6, im7);
        lista3.add(7, im8);
        lista3.add(8, im9);
        lista3.add(9, im10);
        lista3.add(10, im11);

        implem.setLista(lista3);

        // Verificacion

        ConjuntoArchivos v1 = new ConjuntoArchivos(Rutas.Documentos.V1);
        ConjuntoArchivos v2 = new ConjuntoArchivos(Rutas.Documentos.V2);
        ConjuntoArchivos v3 = new ConjuntoArchivos(Rutas.Documentos.V3);
        ConjuntoArchivos v4 = new ConjuntoArchivos(Rutas.Documentos.V4);
        ConjuntoArchivos v5 = new ConjuntoArchivos(Rutas.Documentos.V5);
        ConjuntoArchivos v6 = new ConjuntoArchivos(Rutas.Documentos.V6);
        ConjuntoArchivos v7 = new ConjuntoArchivos(Rutas.Documentos.V7);
        ConjuntoArchivos v8 = new ConjuntoArchivos(Rutas.Documentos.V8);
        ConjuntoArchivos v9 = new ConjuntoArchivos(Rutas.Documentos.V9);
        ConjuntoArchivos v10 = new ConjuntoArchivos(Rutas.Documentos.V10);

        ArrayList<ConjuntoArchivos> lista4 = new ArrayList<ConjuntoArchivos>();

        lista4.add(0, v1);
        lista4.add(1, v2);
        lista4.add(2, v3);
        lista4.add(3, v4);
        lista4.add(4, v5);
        lista4.add(5, v6);
        lista4.add(6, v7);
        lista4.add(7, v8);
        lista4.add(8, v9);
        lista4.add(9, v10);

        verif.setLista(lista4);

        // Implantacion

        ConjuntoArchivos i1 = new ConjuntoArchivos(Rutas.Documentos.I1);
        ConjuntoArchivos i2 = new ConjuntoArchivos(Rutas.Documentos.I2);
        ConjuntoArchivos i3 = new ConjuntoArchivos(Rutas.Documentos.I3);
        ConjuntoArchivos i4 = new ConjuntoArchivos(Rutas.Documentos.I4);
        ConjuntoArchivos i5 = new ConjuntoArchivos(Rutas.Documentos.I5);
        ConjuntoArchivos i6 = new ConjuntoArchivos(Rutas.Documentos.I6);
        ConjuntoArchivos i7 = new ConjuntoArchivos(Rutas.Documentos.I7);

        ArrayList<ConjuntoArchivos> lista5 = new ArrayList<ConjuntoArchivos>();

        lista5.add(0, i1);
        lista5.add(1, i2);
        lista5.add(2, i3);
        lista5.add(3, i4);
        lista5.add(4, i5);
        lista5.add(5, i6);
        lista5.add(6, i7);

        implan.setLista(lista5);

        // Gestion

        ConjuntoArchivos g1 = new ConjuntoArchivos(Rutas.Documentos.G1);
        ConjuntoArchivos g2 = new ConjuntoArchivos(Rutas.Documentos.G2);
        ConjuntoArchivos g3 = new ConjuntoArchivos(Rutas.Documentos.G3);
        ConjuntoArchivos g4 = new ConjuntoArchivos(Rutas.Documentos.G4);
        ConjuntoArchivos g5 = new ConjuntoArchivos(Rutas.Documentos.G5);
        ConjuntoArchivos g6 = new ConjuntoArchivos(Rutas.Documentos.G6);
        ConjuntoArchivos g7 = new ConjuntoArchivos(Rutas.Documentos.G7);
        ConjuntoArchivos g8 = new ConjuntoArchivos(Rutas.Documentos.G8);
        ConjuntoArchivos g9 = new ConjuntoArchivos(Rutas.Documentos.G9);
        ConjuntoArchivos g10 = new ConjuntoArchivos(Rutas.Documentos.G10);
        ConjuntoArchivos g11 = new ConjuntoArchivos(Rutas.Documentos.G11);
        ConjuntoArchivos g12 = new ConjuntoArchivos(Rutas.Documentos.G12);
        ConjuntoArchivos g13 = new ConjuntoArchivos(Rutas.Documentos.G13);
        ConjuntoArchivos g14 = new ConjuntoArchivos(Rutas.Documentos.G14);
        //ConjuntoArchivos g15 = new ConjuntoArchivos(Rutas.Documentos.G15);
       // ConjuntoArchivos g15 = new ConjuntoArchivos(Rutas.getG15());
       // ConjuntoArchivos g16 = new ConjuntoArchivos(Rutas.getG16());
       // ConjuntoArchivos g17 = new ConjuntoArchivos(Rutas.getG17());
       // ConjuntoArchivos g18 = new ConjuntoArchivos(Rutas.getG18());
      //  ConjuntoArchivos g19 = new ConjuntoArchivos(Rutas.getG19());
      //  ConjuntoArchivos g20 = new ConjuntoArchivos(Rutas.getG20());

        ArrayList<ConjuntoArchivos> lista6 = new ArrayList<ConjuntoArchivos>();

        lista6.add(0, g1);
        lista6.add(1, g2);
        lista6.add(2, g3);
        lista6.add(3, g4);
        lista6.add(4, g5);
        lista6.add(5, g6);
        lista6.add(6, g7);
        lista6.add(7, g8);
        lista6.add(8, g9);
        lista6.add(9, g10);
        lista6.add(10, g11);
        lista6.add(11, g12);
        lista6.add(12, g13);
        lista6.add(13, g14);
        //lista6.add(14, g15);
        //lista6.add(14, g15);
        //lista6.add(15, g16);
       // lista6.add(16, g17);
       // lista6.add(17, g18);
       // lista6.add(18, g19);
       // lista6.add(19, g20);

        gest.setLista(lista6);

        // SQA

        ConjuntoArchivos sq1 = new ConjuntoArchivos(Rutas.Documentos.SQ1);
        ConjuntoArchivos sq2 = new ConjuntoArchivos(Rutas.Documentos.SQ2);
        ConjuntoArchivos sq3 = new ConjuntoArchivos(Rutas.Documentos.SQ3);
        ConjuntoArchivos sq4 = new ConjuntoArchivos(Rutas.Documentos.SQ4);
        ConjuntoArchivos sq5 = new ConjuntoArchivos(Rutas.Documentos.SQ5);
        ConjuntoArchivos sq6 = new ConjuntoArchivos(Rutas.Documentos.SQ6);
        ConjuntoArchivos sq7 = new ConjuntoArchivos(Rutas.Documentos.SQ7);
        ConjuntoArchivos sq8 = new ConjuntoArchivos(Rutas.Documentos.SQ8);
      //  ConjuntoArchivos sq9 = new ConjuntoArchivos(Rutas.getSQ9());

        ArrayList<ConjuntoArchivos> lista7 = new ArrayList<ConjuntoArchivos>();

        lista7.add(0, sq1);
        lista7.add(1, sq2);
        lista7.add(2, sq3);
        lista7.add(3, sq4);
        lista7.add(4, sq5);
        lista7.add(5, sq6);
        lista7.add(6, sq7);
        lista7.add(7, sq8);
       // lista7.add(8, sq9);

        sqa.setLista(lista7);

//SCM

        ConjuntoArchivos sc1 = new ConjuntoArchivos(Rutas.Documentos.SC1);
        ConjuntoArchivos sc2 = new ConjuntoArchivos(Rutas.Documentos.SC2);
        ConjuntoArchivos sc3 = new ConjuntoArchivos(Rutas.Documentos.SC3);
        ConjuntoArchivos sc4 = new ConjuntoArchivos(Rutas.Documentos.SC4);
        ConjuntoArchivos sc5 = new ConjuntoArchivos(Rutas.Documentos.SC5);
        ConjuntoArchivos sc6 = new ConjuntoArchivos(Rutas.Documentos.SC6);


        ArrayList<ConjuntoArchivos> lista8 = new ArrayList<ConjuntoArchivos>();

        lista8.add(0, sc1);
        lista8.add(1, sc2);
        lista8.add(2, sc3);
        lista8.add(3, sc4);
        lista8.add(4, sc5);
        lista8.add(5, sc6);


        scm.setLista(lista8);

//COMUNICACION

        ConjuntoArchivos c1 = new ConjuntoArchivos(Rutas.Documentos.C1);
        ConjuntoArchivos c2 = new ConjuntoArchivos(Rutas.Documentos.C2);
        ConjuntoArchivos c3 = new ConjuntoArchivos(Rutas.Documentos.C3);

        ArrayList<ConjuntoArchivos> lista9 = new ArrayList<ConjuntoArchivos>();

        lista9.add(0, c1);
        lista9.add(1, c2);
        lista9.add(2, c3);

        comunic.setLista(lista9);

    
    /*
    //INVESTIGACION

        ConjuntoArchivos inv1 = new ConjuntoArchivos(Rutas.getINV1());
        ConjuntoArchivos inv2 = new ConjuntoArchivos(Rutas.getINV2());
        ConjuntoArchivos inv3 = new ConjuntoArchivos(Rutas.getINV3());
        ConjuntoArchivos inv4 = new ConjuntoArchivos(Rutas.getINV4());

        ArrayList<ConjuntoArchivos> lista10 = new ArrayList<ConjuntoArchivos>();

        lista10.add(0, inv1);
        lista10.add(1, inv2);
        lista10.add(2, inv3);
        lista10.add(3, inv4);

        inves.setLista(lista10);
        */

    }
    

    public ArrayList<ArchivoPorDiciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<ArchivoPorDiciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    /*
     * Retorna el nombre real del archivo de nombre generico name
     */
    public String getNameArchivo(String name, int iter, int fase, int disc) {

        
        ArrayList <Archivo> archivos = disciplinas.get(disc).getArchivos(name);
        String nom = "";
        for (Archivo arch:archivos){
        	
        	
        	if ((arch.disiplina == disc) && (arch.fase == fase) && (arch.iteracion == iter) && (arch.existe))
        	    nom = arch.name;
        	
        }

        return nom;
    }
    
   
   
   
}
