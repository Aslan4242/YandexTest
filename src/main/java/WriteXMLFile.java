import java.io.File;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {


   public static void generateXML(String res) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("test");
            doc.appendChild(rootElement);

            Element firstname = doc.createElement("name");
            firstname.appendChild(doc.createTextNode("yandex"));
            rootElement.appendChild(firstname);

            Element lastname = doc.createElement("date");
            Date date = new Date();
            lastname.appendChild(doc.createTextNode(String.valueOf(date)));
            rootElement.appendChild(lastname);

            Element nickname = doc.createElement("result");
            nickname.appendChild(doc.createTextNode(res));
            rootElement.appendChild(nickname);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            String fileName = "result_"+String.valueOf(date).replace(" ", "_").replace(":", "-")+".xml";
            StreamResult result = new StreamResult(new File("C:\\Users\\Aslan\\IdeaProjects\\YandexTest\\src\\main\\java\\results\\"+fileName));


            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}