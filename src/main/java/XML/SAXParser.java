package XML;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;

public class SAXParser {
	public static void main(String[] args) {
	      try {
	         File partido = new File("C:\\Users\\Dam2\\Downloads\\partido.xml");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
	         UserHandler userhandler = new UserHandler();
	         saxParser.parse(partido, userhandler);     
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	}   
}

