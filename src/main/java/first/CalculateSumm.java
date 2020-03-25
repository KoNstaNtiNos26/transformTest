package first;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.File;

public class CalculateSumm implements GetResult<Integer> {

    public Integer calculate(String pathToFile) {
        int result = 0;
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setValidating(false);
            newInstance.setNamespaceAware(false);
            DocumentBuilder documentBuilder = newInstance.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(pathToFile));
            NodeList elementsByTagName = document.getElementsByTagName("entry");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                String value = elementsByTagName.item(i).getAttributes().getNamedItem("field").getNodeValue();
                if(value == null) System.out.println("hi");
                if(!"".equals(value)) {
                    System.out.println(value);
                    result += Integer.parseInt(value);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
