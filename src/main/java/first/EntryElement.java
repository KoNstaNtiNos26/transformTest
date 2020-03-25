package first;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "entry")
public class EntryElement{

    @XmlElement(name = "field")
    private int field;


    public void setField(int value) {
        this.field = value;
    }
}
