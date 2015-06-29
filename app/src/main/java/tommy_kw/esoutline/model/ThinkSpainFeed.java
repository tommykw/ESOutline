package tommy_kw.esoutline.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;

import java.util.List;

/**
 * Created by tomita on 15/06/29.
 */
public class ThinkSpainFeed {
    @ElementList(name = "item", inline = true)
    public List<ThinkSpainFeed> items;
}
