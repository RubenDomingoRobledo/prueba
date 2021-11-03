package XML;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class STAXParser {
	public static void main(String[]args) {
		boolean bJugador = false;

		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("C:\\Users\\Dam2\\Downloads\\partido.xml"));

			while(eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				switch(event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();

					if (qName.equalsIgnoreCase("equipo")) {
						System.out.println("Start Element: equipo");
						Iterator<Attribute> attributes = startElement.getAttributes();
						String name= attributes.next().getValue();
						System.out.println("Name: "+ name);
					}
					
					else if (qName.equalsIgnoreCase("jugador")) {
						bJugador= true;
					}
					break;

				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();
					if (bJugador) {
						System.out.println("Jugador: "+ characters.getData());
						bJugador = false;
					}
					break;

				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();

					if(endElement.getName().getLocalPart().equalsIgnoreCase("equipo")) {
						System.out.println("End Element : equipo");
						System.out.println();
					}
					break;
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(XMLStreamException e) {
	         e.printStackTrace();
		}
	}
}
