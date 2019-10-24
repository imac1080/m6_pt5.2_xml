
import java.io.*;
import java.util.*;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Pt2 implements Serializable {
//	public void carregarDades(File f) {
//		try {
//			if (f.exists()) {
//				FileInputStream fis = new FileInputStream(f);
//				ObjectInputStream ois = new ObjectInputStream(fis);
//				persones = (HashMap<Integer, Persona>) ois.readObject(); // ERROR SI S'UTILITZA THIS
//				System.out.println("==> LES DADES DEL FITXER HA ESTAT CARREGADES\n");
//				ois.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	// s

	public int menuPrincipal() {
		Scanner teclat = new Scanner(System.in);
		int opcio = 0;
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("1. AFEGIR CURS");
		System.out.println("2. GENERAR XML");
		System.out.println("3. AFEGIR ALUMNE");
		System.out.println("4. ELIMINAR ALUMNE");
		System.out.println("5. SORTIR");
		System.out.print("Escull una opcio:");
		while (!teclat.hasNextInt()) {
			System.out.println("");
			System.out.println("==============================================");
			System.out.println("1. AFEGIR CURS");
			System.out.println("2. GENERAR XML");
			System.out.println("3. AFEGIR ALUMNE");
			System.out.println("4. ELIMINAR ALUMNE");
			System.out.println("5. SORTIR");
			System.out.print("Escull una opcio:");
			teclat.nextLine();
		}
		opcio = teclat.nextInt();
		return opcio;
	}

	static Curs[] cursos;

	public static void main(String[] args) throws IOException {
		Pt2 x = new Pt2();
		cursos = new Curs[0];
		Curs[] cursos2 = new Curs[0];
		String ruta = "cursos.xml";
		int o = 0;
		File cd = new File(ruta);
//		x.carregarDades(cd); // Carreguem les dades que han estat guardades anteriorment
		do {
			o = x.menuPrincipal();
			Scanner dades = new Scanner(System.in);
			switch (o) {
			case 1:
				boolean mesCursos = true;
				while (mesCursos) {
					System.out.println("digues el id del curs");
					String idCurs = dades.nextLine();
					System.out.println("Vols afegir el tutor?");
					String nomTutor = "", cognomTutor = "";
					if (SiNo().equals("SI")) {
						System.out.println("digues el nom del tutor");
						nomTutor = dades.nextLine();
						System.out.println("digues el cognom del tutor");
						cognomTutor = dades.nextLine();
					}
					Alumne[] alumesArrayVar = new Alumne[0];
					System.out.println("Vols afegir algun alumne?");
					while (SiNo().equals("SI")) {
						System.out.println("digues el nom del alumne");
						String nomAlumne = dades.nextLine();
						System.out.println("digues el cognom del alumne");
						String cognomAlumne = dades.nextLine();
						Alumne[] alumesArrayVar2 = new Alumne[alumesArrayVar.length + 1];
						for (int i = 0; i < alumesArrayVar.length; i++) {
							alumesArrayVar2[i] = alumesArrayVar[i];
						}
						alumesArrayVar2[alumesArrayVar2.length - 1] = new Alumne(nomAlumne, cognomAlumne);
						System.out.println("Alumne afegit!");
						alumesArrayVar = alumesArrayVar2;
						System.out.println("Vols afegir algun alumne mes?");
					}
					Modul[] modulArrayVar = new Modul[0];
					String nomProfesor = "", cognomProfesor = "";
					boolean mesModuls = true;
					while (mesModuls) {
						System.out.println("Digues el id del modul");
						String idModul = dades.nextLine();
						System.out.println("Digues el titul del modul");
						String titulModul = dades.nextLine();
						System.out.println("Digues el nom d'un professor del modul");
						nomProfesor = dades.nextLine();
						System.out.println("Digues el cognom del professor");
						cognomProfesor = dades.nextLine();
						Profe[] profeArrayVar = new Profe[1];
						profeArrayVar[0] = new Profe(nomProfesor, cognomProfesor);
						Profe[] profeArrayVar2 = new Profe[0];
						System.out.println("Vols afegir algun professor mes?");
						while (SiNo().equals("SI")) {
							System.out.println("digues el nom del professor");
							nomProfesor = dades.nextLine();
							System.out.println("digues el cognom del professor");
							cognomProfesor = dades.nextLine();
							profeArrayVar2 = new Profe[profeArrayVar.length + 1];
							for (int i = 0; i < profeArrayVar.length; i++) {
								profeArrayVar2[i] = profeArrayVar[i];
							}
							profeArrayVar2[profeArrayVar2.length - 1] = new Profe(nomProfesor, cognomProfesor);
							System.out.println("Professor afegit!");
							profeArrayVar = profeArrayVar2;
							System.out.println("Vols afegir algun professor mes?");
						}
						Uf[] ufArrayVar = new Uf[0];
						Uf[] ufArrayVar2 = new Uf[0];
						System.out.println("Vols afegir alguna unitat formativa?");
						while (SiNo().equals("SI")) {
							System.out.println("digues el numero de la unitat formativa");
							String numeroUF = dades.nextLine();
							System.out.println("digues el nom de la unitat formativa");
							String nomUF = dades.nextLine();
							ufArrayVar2 = new Uf[ufArrayVar.length + 1];
							for (int i = 0; i < ufArrayVar.length; i++) {
								ufArrayVar2[i] = ufArrayVar[i];
							}
							ufArrayVar2[ufArrayVar2.length - 1] = new Uf(numeroUF, nomUF);
							System.out.println("Unitat formativa afegit!");
							ufArrayVar = ufArrayVar2;
							System.out.println("Vols afegir alguna unitat formativa mes?");
						}
						Modul[] modulArrayVar2 = new Modul[modulArrayVar.length + 1];
						for (int i = 0; i < modulArrayVar.length; i++) {
							modulArrayVar2[i] = modulArrayVar[i];
						}
						modulArrayVar2[modulArrayVar2.length - 1] = new Modul(idModul, titulModul, profeArrayVar,
								ufArrayVar);
						System.out.println("Modul afegit!");
						modulArrayVar = modulArrayVar2;
						System.out.println("Vols afegir mes moduls?");
						if (SiNo().equals("NO")) {
							mesModuls = false;
						}
					}
					cursos2 = new Curs[cursos.length + 1];
					for (int i = 0; i < cursos.length; i++) {
						cursos2[i] = cursos[i];
					}
					cursos2[cursos2.length - 1] = new Curs(idCurs, new Profe(nomTutor, cognomTutor), alumesArrayVar,
							modulArrayVar);
					cursos = cursos2;
					System.out.println("El curs " + idCurs + " ha estat creat");
					System.out.println("Hi han " + cursos.length + " cursos");
					System.out.println("Vols afegir mes cursos?");
					if (SiNo().equals("NO")) {
						mesCursos = false;
					}
				}
				break;
			case 2:
				guardarXML();
				break;
			case 3:
				try {
					Scanner teclat = new Scanner(System.in);
					System.out.println("Digues el id del curs");
					String idCurs = teclat.nextLine();
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(new File("cursos.xml"));
					// root element
//					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					NodeList nList = doc.getElementsByTagName("curs");
					boolean cursExisteix = false;
					for (int temp = 0; temp < nList.getLength(); temp++) {
						Node nNode = nList.item(temp);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							String nodeName = nNode.getAttributes().getNamedItem("id").getNodeValue();
							if (idCurs.equals(nodeName)) {
								cursExisteix = true;
								Alumne[] alumesArrayVar = new Alumne[cursos[temp].getAlumesArray().length + 1];
//								Element eElement = (Element) nNode;
//								NodeList cElement = (NodeList) eElement.getElementsByTagName("alumne");
//								for (int temp1 = 0; temp1 < cElement.getLength(); temp1++) {
//									Element alumeElement = (Element) cElement;
//											System.out.println("Nom de la persona : "
//													+ eElement.getElementsByTagName("nombre").item(0).getTextContent());
//								}
								for (int i = 0; i < cursos[temp].getAlumesArray().length; i++) {
									alumesArrayVar[i] = cursos[temp].getAlumesArray()[i];
								}
								System.out.println("digues el nom del alumne");
								String nomAlumne = dades.nextLine();
								System.out.println("digues el cognom del alumne");
								String cognomAlumne = dades.nextLine();
								alumesArrayVar[alumesArrayVar.length - 1] = new Alumne(nomAlumne, cognomAlumne);
								cursos[temp].setAlumesArray(alumesArrayVar);
								guardarXML();
								break;
							}
						}
					}
					if (cursExisteix == false) {
						System.out.println("el curs " + idCurs + " no existeix al xml");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					Scanner teclat = new Scanner(System.in);
					System.out.println("Digues el id del curs");
					String idCurs = teclat.nextLine();
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(new File("cursos.xml"));
					// root element
//					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					NodeList nList = doc.getElementsByTagName("curs");
					boolean cursExisteix = false;
					for (int temp = 0; temp < nList.getLength(); temp++) {
						Node nNode = nList.item(temp);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							String nodeName = nNode.getAttributes().getNamedItem("id").getNodeValue();
							if (idCurs.equals(nodeName)) {
								cursExisteix = true;
							}
						}
					}
					if (cursExisteix == false) {
						System.out.println("el curs " + idCurs + " no existeix al xml");
					} else {
						boolean existeixAlumne = false;
						System.out.println("digues el nom del alumne");
						String nomAlumne = dades.nextLine();
						System.out.println("digues el cognom del alumne");
						String cognomAlumne = dades.nextLine();
						for (int temp = 0; temp < nList.getLength(); temp++) {
							Node nNode = nList.item(temp);
							if (nNode.getNodeType() == Node.ELEMENT_NODE) {
								String nodeName = nNode.getAttributes().getNamedItem("id").getNodeValue();
								if (idCurs.equals(nodeName)) {
									cursExisteix = true;
									Alumne[] alumesArrayVar = new Alumne[0];
									Element eElement = (Element) nNode;
									NodeList cElement = (NodeList) eElement.getElementsByTagName("alumne");
									for (int temp1 = 0; temp1 < cElement.getLength(); temp1++) {
										Element alumeElement = (Element) cElement.item(temp1);
										String[] nomCognom = alumeElement.getTextContent().split(", ");
										if (nomCognom[1].equals(nomAlumne) && nomCognom[0].equals(cognomAlumne)) {
											existeixAlumne = true;
											System.out.println(
													"Alumne " + nomCognom[1] + " " + nomCognom[0] + " eliminat");
										} else {
											Alumne[] alumesArrayVar2 = new Alumne[alumesArrayVar.length + 1];
											for (int i = 0; i < alumesArrayVar.length; i++) {
												alumesArrayVar2[i] = alumesArrayVar[i];
											}
											alumesArrayVar = alumesArrayVar2;
											alumesArrayVar[alumesArrayVar.length - 1] = new Alumne(nomCognom[1],
													nomCognom[0]);
										}
									}
									if (existeixAlumne == false) {
										System.out.println("No existeix l'alumne " + nomAlumne + " " + cognomAlumne);
									} else {
										cursos[temp].setAlumesArray(alumesArrayVar);
										guardarXML();
									}
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		} while (o < 5);
		System.out.println("S'HA ACABAT");

	}

	public static void guardarXML() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// root element
			Element rootElement = doc.createElement("cursos");
			doc.appendChild(rootElement);
			for (int i = 0; i < cursos.length; i++) {
				Element departamento = doc.createElement("curs");
				rootElement.appendChild(departamento);
				// attr
				Attr attr = doc.createAttribute("id");
				attr.setValue(cursos[i].getId());
				departamento.setAttributeNode(attr);
				// tutor
				if (!cursos[i].getTutor().nom.equals("")) {
					Element tutor = doc.createElement("tutor");
					departamento.appendChild(tutor);
					tutor.appendChild(
							doc.createTextNode(cursos[i].getTutor().cognom + ", " + cursos[i].getTutor().nom));
				}
				// alumnes
				if (cursos[i].getAlumesArray().length != 0) {
					Element alumnes = doc.createElement("alumnes");
					departamento.appendChild(alumnes);
					for (int j = 0; j < cursos[i].getAlumesArray().length; j++) {
						Element alumne = doc.createElement("alumne");
						alumnes.appendChild(alumne);
						alumne.appendChild(doc.createTextNode(cursos[i].getAlumesArray()[j].getCognom() + ", "
								+ cursos[i].getAlumesArray()[j].getNom()));
					}
				}
				Element moduls = doc.createElement("moduls");
				departamento.appendChild(moduls);
				for (int j = 0; j < cursos[i].getModulArray().length; j++) {
					Element modul = doc.createElement("modul");
					moduls.appendChild(modul);
					// attr modul
					Attr attrModul = doc.createAttribute("id");
					attrModul.setValue(cursos[i].getModulArray()[j].getId());
					modul.setAttributeNode(attrModul);
					// titol modul
					Element titolModul = doc.createElement("titol");
					modul.appendChild(titolModul);
					titolModul.appendChild(doc.createTextNode(cursos[i].getModulArray()[j].getTitol()));
					// profes
					Element profesModul = doc.createElement("profes");
					modul.appendChild(profesModul);
					for (int k = 0; k < cursos[i].getModulArray()[j].getProfeArray().length; k++) {
						Element profeModul = doc.createElement("profe");
						profesModul.appendChild(profeModul);
						profeModul.appendChild(
								doc.createTextNode(cursos[i].getModulArray()[j].getProfeArray()[k].getCognom() + ", "
										+ cursos[i].getModulArray()[j].getProfeArray()[k].getNom()));
					}
					// ufs
					if (cursos[i].getModulArray()[j].getUfArray().length != 0) {
						Element ufssModul = doc.createElement("ufs");
						modul.appendChild(ufssModul);
						for (int k = 0; k < cursos[i].getModulArray()[j].getUfArray().length; k++) {
							Element ufModul = doc.createElement("uf");
							ufssModul.appendChild(ufModul);
							// attr uf
							Attr attrUf = doc.createAttribute("n");
							attrUf.setValue(cursos[i].getModulArray()[j].getUfArray()[k].getN());
							ufModul.setAttributeNode(attrUf);
							ufModul.appendChild(
									doc.createTextNode(cursos[i].getModulArray()[j].getUfArray()[k].getNom()));
						}
					}
				}
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("cursos.xml"));
			transformer.transform(source, result);
			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("guardat a cursos.xml");
	}

	public static String SiNo() {
		Scanner dades = new Scanner(System.in);
		String respuesta = "";
		while (!(respuesta.equals("SI") || respuesta.equals("NO"))) {
			respuesta = dades.nextLine();
			if (!(respuesta.equals("SI") || respuesta.equals("NO"))) {
				System.out.println("Intenta posar 'SI' o 'NO'");
			}
		}
		return respuesta;
	}
}
