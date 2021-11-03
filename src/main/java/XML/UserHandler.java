package XML;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler  {
	boolean bJugador = false;
	
	@Override
	public void startElement (String uri, String localName, String qName, Attributes attributes)throws SAXException {
		if (qName.equalsIgnoreCase("equipo")) {
	         String name = attributes.getValue("name");
	         System.out.println("Name : " + name);
		}
		else if (qName.equalsIgnoreCase("jugador")) {
	         bJugador = true;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("equipo")) {
			System.out.println("End Element :" + qName);
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (bJugador) {
	         System.out.println("Jugador: " + new String(ch, start, length));
	         bJugador = false;
		}
	}
}