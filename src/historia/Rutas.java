package historia;

import java.util.Arrays;
import java.util.List;

public class Rutas {
	/*
	 * Nombres de carpetas
	 */
	public static class Disciplinas {
		public static final String requerim = "requerimientos";
		public static final String disenio = "disenio";
		public static final String implan = "implantacion";
		public static final String implem = "implementacion";
		public static final String comunic = "comunicacion";
		public static final String sqa = "sqa";
		public static final String scm = "scm";
		public static final String gestProy = "gestion";
		public static final String verificacion = "verificacion";
		public static final String investigacion = "investigacion";
	}

	/*
	 * Nombres de archivos
	 */
	public static class Documentos {
		public static final String R1 = "RQACT";
		public static final String R2 = "RQDRQ";
		public static final String R3 = "RQMOD";
		public static final String R4 = "RQRSU";
		public static final String R5 = "RQDVC";
		public static final String R6 = "RQPIU";
		public static final String R7 = "RQRCA";
		public static final String R8 = "RQALS";
		public static final String R9 = "RQGLO";
		public static final String R10 = "RQOOMDO";
		public static final String R11 = "RQOODRP";
		private static List<String> reqList = Arrays.asList(R1, R2, R3, R4, R5,
				R6, R7, R8, R9, R10, R11);
		public static List<String> getReqList(){return reqList;}

		public static final String D1 = "DSMDI";
		public static final String D2 = "DSARQ";
		public static final String D3 = "DSOOMDA";
		public static final String D4 = "DSOODDP";
		private static List<String> desList = Arrays.asList(D1, D2, D3, D4);
		public static List<String> getDesList(){return desList;}
		
		public static final String IM1 = "IMEDT";
		public static final String IM2 = "IMEI";
		public static final String IM3 = "IMPR";
		public static final String IM4 = "IMIIN";
		public static final String IM5 = "IMDT";
		public static final String IM6 = "IMIVU";
		public static final String IM7 = "IMOOPII";
		public static final String IM8 = "IMOOMIM";
		public static final String IM9 = "IMOOEJI";
		public static final String IM10 = "IMOORRP";
		public static final String IM11 = "IMOOCVU";
		private static List<String> imList = Arrays.asList(IM1, IM2, IM3, IM4,
				IM5, IM6, IM7, IM8, IM9, IM10, IM11);
		public static List<String> getImList(){return imList;}

		public static final String V1 = "VRPVV";
		public static final String V2 = "VRDAP";
		public static final String V3 = "VRPVI";
		public static final String V4 = "VRMCP";
		public static final String V5 = "VRIVD";
		public static final String V6 = "VRIVI";
		public static final String V7 = "VRIVS";
		public static final String V8 = "VRRPR";
		public static final String V9 = "VREV";
		public static final String V10 = "VRIF";
		private static List<String> verList = Arrays.asList(V1, V2, V3, V4, V5,
				V6, V7, V8, V9, V10);
		public static List<String> getVerList(){return verList;}
		
		public static final String I1 = "IPMSU";
		public static final String I2 = "IPMCA";
		public static final String I3 = "IPPS";
		public static final String I4 = "IPPLA";
		public static final String I5 = "IPVPR";
		public static final String I6 = "IPOOEDU";
		public static final String I7 = "IPOORFPA";
		private static List<String> ipList = Arrays.asList(I1, I2, I3, I4, I5,
				I6, I7);
		public static List<String> getIpList(){return ipList;}

		public static final String G1 = "GPPLA";
		public static final String G2 = "GPISP";
		public static final String G3 = "GPEM";
		public static final String G4 = "GPDRI";
		public static final String G5 = "GPRAC";
		public static final String G6 = "GPIFP";
		public static final String G7 = "GPARE";
		public static final String G8 = "GPPIT";
		public static final String G9 = "GPPDE";
		public static final String G10 = "GPICF";
		public static final String G11 = "GPPDIP";
		public static final String G12 = "GPPDP";
		public static final String G13 = "GPARD";
		public static final String G14 = "GPOODAP";
		//public static final String G15 = "RETRO";
		private static List<String> gesList = Arrays.asList(G1, G2, G3, G4, G5,
				G6, G7, G8, G9, G10, G11, G12, G13, G14);
		public static List<String> getGesList(){return gesList;}

		public static final String SQ1 = "SQAPLA";
		public static final String SQ2 = "SQADAP";
		public static final String SQ3 = "SQARTF";
		public static final String SQ4 = "SQAES";
		public static final String SQ5 = "SQAIR";
		public static final String SQ6 = "SQADV";
		public static final String SQ7 = "SQANV";
		public static final String SQ8 = "SQAIF";
		private static List<String> sqaList = Arrays.asList(SQ1, SQ2, SQ3, SQ4,
				SQ5, SQ6, SQ7, SQ8);
		public static List<String> getSQAList(){return sqaList;}

		public static final String SC1 = "SCMPLA";
		public static final String SC2 = "SCMMAC";
		public static final String SC3 = "SCMGC";
		public static final String SC4 = "SCMRV";
		public static final String SC5 = "SCMILB";
		public static final String SC6 = "SCMIF";
		private static List<String> scmList = Arrays.asList(SC1, SC2, SC3, SC4,
				SC5, SC6);
		public static List<String> getSCMList(){return scmList;}

		public static final String C1 = "COMDI";
		public static final String C2 = "COMENS";
		public static final String C3 = "COMEVS";
		private static List<String> comList = Arrays.asList(C1, C2, C3);
		public static List<String> getComList(){return comList;}
		
	}

	public static boolean Pertenece(String name, int i) {
		if (i == 0) {
			return PerteneceList(name, Documentos.reqList);
		}
		if (i == 1) {
			return PerteneceList(name, Documentos.desList);
		}
		if (i == 2) {
			return PerteneceList(name, Documentos.imList);
		}
		if (i == 3) {
			return PerteneceList(name, Documentos.verList);
		}
		if (i == 4) {
			return PerteneceList(name, Documentos.ipList);
		}
		if (i == 5) {
			return PerteneceList(name, Documentos.gesList);
		}
		if (i == 6) {
			return PerteneceList(name, Documentos.sqaList);
		}
		if (i == 7) {
			return PerteneceList(name, Documentos.scmList);
		}
		if (i == 8) {
			return PerteneceList(name, Documentos.comList);
		}

		return false;

	}

	/**
	 * Esta funcion toma un nombre de archivo, una lista con posibles codigos, y
	 * se fija si tal archivo tiene alguno de esos codigos en su nombre
	 * 
	 * @param name
	 *            Nombre del archivo
	 * @param list
	 *            Lista con codigos
	 * @return True si el nombre tiene algun codigo
	 */
	public static boolean PerteneceList(String name, List<String> list) {
		for (String codigo : list) {
			if (name.contains(codigo))
				return true;
		}
		return false;
	}

}
