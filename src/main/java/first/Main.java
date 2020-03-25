package first;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        String pathToFile_1 = "./1.xml";
        String pathToFile_2 = "./2.xml";
        MainClassField field = new MainClassField();
        field.setDriver("com.mysql.cj.jdbc.Driver");
        field.setLogin("root");
        field.setPassword("root");
        field.setUrl("jdbc:mysql://localhost:3306/online_shop?serverTimezone=UTC&useSSL=false");
        field.setField(1000000);
        AccessDataBase accessDataBase = new AccessDataBaseImpl(field);
        GetResult<Integer> result = new CalculateSumm();
        try {
            accessDataBase.deleteAllRows();
            accessDataBase.insert();
            EntryObject entryObject = accessDataBase.getAllRows();
            SimpleUtil.marshall(entryObject, pathToFile_1);
            SimpleUtil.transform("./transform.xsl", pathToFile_1, pathToFile_2);
            System.out.println(result.calculate(pathToFile_2));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
