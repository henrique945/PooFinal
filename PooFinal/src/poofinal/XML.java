package poofinal;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XML 
{
	void teste()
	{
		try 
		{
			File inputFile = new File("build.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
