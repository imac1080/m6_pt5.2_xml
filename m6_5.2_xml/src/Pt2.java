
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
	//s

	public int menuPrincipal() {
		Scanner teclat = new Scanner(System.in);
		int opcio = 0;
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("1. AFEGIR CURS");
		System.out.println("2. GENERAR XML");
		System.out.println("3. LLEGIR XML");
		System.out.println("4. AFEGIR ALUMNE");
		System.out.println("5. ELIMINAR ALUMNE");
		System.out.println("6. SORTIR");
		System.out.print("Escull una opcio:");
		opcio = teclat.nextInt();

		return opcio;
	}

	public static void main(String[] args) throws IOException {
		Pt2 x = new Pt2();
		Curs[] cursos = new Curs[0];
		String ruta = "cursos.xml";
		int o = 0;
		File cd = new File(ruta);
//		x.carregarDades(cd); // Carreguem les dades que han estat guardades anteriorment
		do {
			o = x.menuPrincipal();
			Scanner dades = new Scanner(System.in);
			switch (o) {
			case 1:
				System.out.println("digues el id del curs");
				String idCurs = dades.nextLine();
				System.out.println("digues el nom del tutor");
				String nomTutor = dades.nextLine();
				System.out.println("digues el cognom del tutor");
				String cognomTutor = dades.nextLine();
				Alumne[] alumesArrayVar = new Alumne[0];
				int identificador = persones.size();
				identificador++;
				int edat;
				if (dades.hasNextInt()) {
					edat = dades.nextInt();
					x.persones.put(identificador, new Persona(id, cognom, edat));
					System.out.println("La persona" + id + " " + cognom + " ha estat creada");
					System.out.println("HIHAN " + x.persones.size() + " PERSONES");
				} else
					System.out.println("Error no s'ha creat, error de edat");
				break;
			case 2:
				try {
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.newDocument();
					// root element
					Element rootElement = doc.createElement("persones");
					doc.appendChild(rootElement);
					for (int i = 1; i <= persones.size(); i++) {
						Element departamento = doc.createElement("persona");
						rootElement.appendChild(departamento);
						// nombre
						Element nombre = doc.createElement("nombre");
						departamento.appendChild(nombre);
						nombre.appendChild(doc.createTextNode(persones.get(i).getNombre()));
						// apellido
						nombre = doc.createElement("apellido");
						departamento.appendChild(nombre);
						nombre.appendChild(doc.createTextNode(persones.get(i).getApellido()));
						// edad
						nombre = doc.createElement("edad");
						departamento.appendChild(nombre);
						nombre.appendChild(doc.createTextNode(String.valueOf(persones.get(i).getEdad())));
					}

					// write the content into xml file
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(new File("persones.xml"));
					transformer.transform(source, result);
					// Output to console for testing
					StreamResult consoleResult = new StreamResult(System.out);
					transformer.transform(source, consoleResult);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("guardat a persones.xml");
				break;
			case 3:
				try {
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(new File("persones.xml"));
					// root element
					System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					NodeList nList = doc.getElementsByTagName("persona");
					System.out.println("----------------------------");
					for (int temp = 0; temp < nList.getLength(); temp++) {
						Node nNode = nList.item(temp);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode;
							System.out.println("\nCurrent Element :" + nNode.getNodeName());
							System.out.println("Nom de la persona : "
									+ eElement.getElementsByTagName("nombre").item(0).getTextContent());
							System.out.println("Cognom de la persona : "
									+ eElement.getElementsByTagName("apellido").item(0).getTextContent());
							System.out.println("Edat de la persona : "
									+ eElement.getElementsByTagName("edad").item(0).getTextContent());
							System.out.println("----------------------");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Llegit a persones.xml");
				break;
			}
		} while (o < 5);
		System.out.println("S'HA ACABAT");
	}
}
