package airline;

import airline.Models.FlightSearchCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class MockSearchCriteriaRepository {

    /*public static void main(String[] args) {
        readTestData("testSearchFlightsWithSourceAndDestination");
    }*/

    public FlightSearchCriteria readTestData(String testName) {
        try {

            File fXmlFile = new File("/home/swinee/Vapasi/Airline/src/test/java/MockSearchCriteria");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            FlightSearchCriteria searchCriteria = new FlightSearchCriteria();
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("TestCase");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE &&
                        nNode.getAttributes().item(0).getNodeValue().equals(testName)) {

                    Element eElement = (Element) nNode;
                    searchCriteria.setSource(eElement.getElementsByTagName("source").item(0).getTextContent());
                    searchCriteria.setDestination(eElement.getElementsByTagName("destination").item(0).getTextContent());
                    searchCriteria.setNoOfPassengers(Integer.parseInt(eElement.getElementsByTagName("noOfPassengers").item(0).getTextContent()));
                    searchCriteria.setDepartureDate(eElement.getElementsByTagName("departureDate").item(0).getTextContent());
                    searchCriteria.setTravelClass(eElement.getElementsByTagName("travelClass").item(0).getTextContent());
                }
                return searchCriteria;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

