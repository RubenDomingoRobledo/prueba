package XML;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;

public class DOMParser {
	public static void main(String[]args) {
		//Crear DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//Crear documento a partir del XML
			Document partido = builder.parse(new File("C:\\Users\\Dam2\\Downloads\\partido.xml"));
			
			//Normalizamos estructura XML
			partido.getDocumentElement().normalize();
			
			//Extraer root node
			Element root = partido.getDocumentElement();
			System.out.println(root.getNodeName());
			
			//Extraer equipos
			NodeList listaElementos = partido.getElementsByTagName("equipo");
			System.out.println("-------------------------");
			
				//Recorremos la lista de equipos con un bucle
			for (int i = 0; i < listaElementos.getLength(); i++) {
				Node equipo = listaElementos.item(i);
				System.out.println("");
				
				if (equipo.getNodeType() == Node.ELEMENT_NODE) {
					//Pintamos cada equipo con sus jugadores correspondientes
					Element jugadores = (Element) equipo;
					System.out.println("Jugador: " + jugadores.getElementsByTagName("jugador"));
				}
				
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
