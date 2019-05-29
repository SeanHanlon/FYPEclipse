package parser;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import REST.Trail.model.Trail;
import REST.Trail.persistence.PersistenceUtil;



public class Parser {

	public static void main(String argv[]) {
		
		ArrayList<Trail> trails = new ArrayList<Trail>();

		try {
			File xmlFile = new File("tdata.xml");

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(xmlFile);
			
			XPath xp = XPathFactory.newInstance().newXPath();
			//xPath = "//root/row/TrailId"
			String expression = "/root/row";
			NodeList xTrail = (NodeList) xp.compile(expression).evaluate(doc,
					XPathConstants.NODESET);
			
			for(int i=0;i<xTrail.getLength();i++)
			{
				Node nNode = xTrail.item(i);
				System.out.println("\nCurrent Element: "+nNode.getNodeName());
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					String name, county, format, grade, climb;
					double length, time, startLat, startLong, finLat, finLong;
					Element eElement = (Element) nNode;
					System.out.println("Trail ID: "+eElement.getElementsByTagName("TrailId").item(0).getTextContent());
					System.out.println("Trail Name: "+eElement.getElementsByTagName("TrailName").item(0).getTextContent());
					System.out.println("County: "+eElement.getElementsByTagName("County").item(0).getTextContent());
					System.out.println("Format: "+eElement.getElementsByTagName("Format").item(0).getTextContent());
					System.out.println("Length: "+eElement.getElementsByTagName("Length").item(0).getTextContent());
					System.out.println("Climb: "+eElement.getElementsByTagName("Climb").item(0).getTextContent());
					System.out.println("Grade: "+eElement.getElementsByTagName("Grade").item(0).getTextContent());
					System.out.println("Time: "+eElement.getElementsByTagName("Time").item(0).getTextContent());
					System.out.println("StartLat: "+eElement.getElementsByTagName("StartLatitute").item(0).getTextContent());
					System.out.println("StartLong: "+eElement.getElementsByTagName("StartLongitude").item(0).getTextContent());
					System.out.println("FinLat: "+eElement.getElementsByTagName("FinishLatitude").item(0).getTextContent());
					System.out.println("FinLong: "+eElement.getElementsByTagName("FinishLongitude").item(0).getTextContent());
					
					if(eElement.getElementsByTagName("TrailName").item(0).getTextContent().isEmpty() || 
							eElement.getElementsByTagName("County").item(0).getTextContent().isEmpty()||
							eElement.getElementsByTagName("Format").item(0).getTextContent().isEmpty()||
							eElement.getElementsByTagName("Length").item(0).getTextContent().isEmpty()||
							eElement.getElementsByTagName("Climb").item(0).getTextContent().isEmpty()||
							eElement.getElementsByTagName("Grade").item(0).getTextContent().isEmpty()||
							eElement.getElementsByTagName("Time").item(0).getTextContent().isEmpty()||
							eElement.getElementsByTagName("StartLatitute").item(0).getTextContent().isEmpty()||
							eElement.getElementsByTagName("StartLongitude").item(0).getTextContent().isEmpty()||
							eElement.getElementsByTagName("FinishLatitude").item(0).getTextContent().isEmpty()||
							eElement.getElementsByTagName("FinishLongitude").item(0).getTextContent().isEmpty())
					{
						System.out.println("Hi");
					}
					else
					{
						name = eElement.getElementsByTagName("TrailName").item(0).getTextContent();
						county = eElement.getElementsByTagName("County").item(0).getTextContent();
						format = eElement.getElementsByTagName("Format").item(0).getTextContent();
						length = Double.parseDouble(eElement.getElementsByTagName("Length").item(0).getTextContent());
						climb = eElement.getElementsByTagName("Climb").item(0).getTextContent();
						grade = eElement.getElementsByTagName("Grade").item(0).getTextContent();
						time = Double.parseDouble(eElement.getElementsByTagName("Time").item(0).getTextContent());
						startLat = Double.parseDouble(eElement.getElementsByTagName("StartLatitute").item(0).getTextContent());
						startLong = Double.parseDouble(eElement.getElementsByTagName("StartLongitude").item(0).getTextContent());
						finLat = Double.parseDouble(eElement.getElementsByTagName("FinishLatitude").item(0).getTextContent());
						finLong = Double.parseDouble(eElement.getElementsByTagName("FinishLongitude").item(0).getTextContent());
						
						Trail trail = new Trail(name, county, format, length, climb, grade, time, startLat, startLong,
								finLat, finLong);
						PersistenceUtil.persist(trail);
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
