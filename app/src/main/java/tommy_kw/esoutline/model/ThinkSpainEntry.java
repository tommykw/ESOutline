package tommy_kw.esoutline.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by tomita on 15/06/29.
 */
@Root(name = "item", strict = false)
public class ThinkSpainEntry {
    @Namespace(prefix = "author")
    @Element(name = "name")
    public String auhtorName;

    @Element(name = "title")
    public String title;

    @Element(name = "link")
    public String link;

    @Element(name = "description")
    public String description;

    @Namespace(prefix = "enclosure")
    @Element(name = "url")
    public String imageUrl;

    @Element(name = "category")
    public String category;

    @Element(name = "pubDate")
    public String pubDate;

    @Element(name = "guid")
    public String guid;
}
