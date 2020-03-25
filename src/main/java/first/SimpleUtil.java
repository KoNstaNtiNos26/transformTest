package first;

import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class SimpleUtil  {

    public static void transform(String pathToXsl, String pathToXmlDocument, String pathToOutput) {
        try {
            StreamSource xsl = new StreamSource(new File(pathToXsl));
            Source xml = new StreamSource(new File(pathToXmlDocument));
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xsl);
            transformer.transform(xml, new StreamResult(new File(pathToOutput)));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void marshall(EntryObject obj, String pathToFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(EntryObject.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(obj, new File(pathToFile));
    }
}
