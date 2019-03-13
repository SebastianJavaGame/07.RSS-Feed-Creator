package scislak.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import scislak.page.MemoryInfos;
import scislak.page.PageInfo;

public class SaveXMLFile {
    public static String createXMLDocument() throws ParserConfigurationException, FileNotFoundException, XMLStreamException, IOException{
        List<PageInfo> messages = MemoryInfos.getINFOS();
        
        StringWriter out = new StringWriter();
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(out);
        
        writer.writeStartDocument();
        if(!MemoryInfos.getLinkType().isEmpty()){
            writer.writeCharacters("\n");
            writer.writeDTD("<?xml-stylesheet type=\""+ MemoryInfos.getType()+"\" href=\"" + MemoryInfos.getLinkType()+"\" media=\"screen\"?>");
        }
        writer.writeCharacters("\n");
        writer.writeCharacters("\t");
        writer.writeStartElement("rss");
        writer.writeCharacters("\n");
        writer.writeCharacters("\t");
        writer.writeEndElement();
        writer.writeEndDocument();
        
        writer.close();
        out.close();
        return out.toString();
    }
}
