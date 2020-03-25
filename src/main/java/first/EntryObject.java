package first;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "entries")
public class EntryObject {

    @XmlElement
    private List<EntryElement> entry = new ArrayList<EntryElement>();

    public void addEntry(EntryElement entry) {
        this.entry.add(entry);
    }
}
