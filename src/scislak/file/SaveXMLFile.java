package scislak.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import scislak.page.MemoryInfos;
import scislak.page.PageInfo;

public class SaveXMLFile {
    private static XMLStreamWriter writer;
    private static StringWriter out;
    
    public static String createXMLDocument() throws ParserConfigurationException, FileNotFoundException, XMLStreamException, IOException{
        List<PageInfo> messages = MemoryInfos.getINFOS();
        
        out = new StringWriter();
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        writer = factory.createXMLStreamWriter(out);
        
        writer.writeStartDocument();
        if(!MemoryInfos.getLinkType().isEmpty()){
            writer.writeCharacters("\n");
            writer.writeDTD("<?xml-stylesheet type=\""+ MemoryInfos.getType()+"\" href=\"" + MemoryInfos.getLinkType()+"\" media=\"screen\"?>");
        }
        doSpace(0);
        writer.writeStartElement("rss");
        writer.writeAttribute("version", "2.0");
        doSpace(1);
        writer.writeStartElement("channel");
        writeStart();
        writeMessages();
        doSpace(1);
        writer.writeEndElement();
        doSpace(0);
        writer.writeEndElement();
        writer.writeEndDocument();
        
        writer.close();
        out.close();
        return out.toString();
    }
    
    private static void writeStart() throws XMLStreamException{
        doSpace(2);
        writer.writeStartElement("generator");
        writer.writeCharacters("RRS Feed Creator by Sebastian Ściślak");
        writer.writeEndElement();  
        doSpace(2);
        writer.writeStartElement("title");
        writer.writeCharacters(MemoryInfos.getTitle());
        writer.writeEndElement();
        doSpace(2);
        writer.writeStartElement("link");
        writer.writeCharacters(MemoryInfos.getLink());
        writer.writeEndElement();
        doSpace(2);
        writer.writeStartElement("description");
        writer.writeCharacters(MemoryInfos.getDescription());
        writer.writeEndElement();
        doSpace(2);
        writer.writeStartElement("language");
        writer.writeCharacters(MemoryInfos.getLanguage());
        writer.writeEndElement();
        if(!MemoryInfos.getEditor().isEmpty()){
            doSpace(2);
            writer.writeStartElement("managingEditor");
            writer.writeCharacters(MemoryInfos.getEditor());
            writer.writeEndElement();
        }
        if(!MemoryInfos.getWebmaster().isEmpty()){
            doSpace(2);
            writer.writeStartElement("webMaster");
            writer.writeCharacters(MemoryInfos.getWebmaster());
            writer.writeEndElement();
        }
        if(!MemoryInfos.getAuthor().isEmpty()){
            doSpace(2);
            writer.writeStartElement("copyright");
            writer.writeCharacters(MemoryInfos.getAuthor());
            writer.writeEndElement();
        }
        if(!MemoryInfos.getUrlImage().isEmpty()){
             doSpace(2);
             writer.writeStartElement("image");
             doSpace(3);
             writer.writeStartElement("title");
             writer.writeCharacters(MemoryInfos.getTitle());
             writer.writeEndElement();
             doSpace(3);
             writer.writeStartElement("link");
             writer.writeCharacters(MemoryInfos.getLink());
             writer.writeEndElement();
             doSpace(3);
             writer.writeStartElement("url");
             writer.writeCharacters(MemoryInfos.getUrlImage());
             writer.writeEndElement();
             doSpace(3);
             writer.writeStartElement("width");
             writer.writeCharacters(MemoryInfos.getWidthImage());
             writer.writeEndElement();
             doSpace(3);
             writer.writeStartElement("height");
             writer.writeCharacters(MemoryInfos.getHeightImage());
             writer.writeEndElement();
             doSpace(2);
             writer.writeEndElement();
        }
    }
    
    private static void writeMessages() throws XMLStreamException{
        List<PageInfo> list = MemoryInfos.getINFOS();
         
        for(int i = 0; i < list.size(); i++){
            doSpace(2);
            writer.writeStartElement("item");
            doSpace(3);
            writer.writeStartElement("title");
            writer.writeCharacters(list.get(i).getTitle());
            writer.writeEndElement();
            doSpace(3);
            writer.writeStartElement("pubDate");
            writer.writeCharacters(list.get(i).getDate());
            writer.writeEndElement();
            if(!list.get(i).getLink().isEmpty()){
                doSpace(3);
                writer.writeStartElement("link");
                writer.writeCharacters(list.get(i).getLink());
                writer.writeEndElement();
            }
            if(!list.get(i).getAuthor().isEmpty()){
                doSpace(3);
                writer.writeStartElement("author");
                writer.writeCharacters(list.get(i).getAuthor());
                writer.writeEndElement();
            }
            if(!list.get(i).getComments().isEmpty()){
                doSpace(3);
                writer.writeStartElement("comments");
                writer.writeCharacters(list.get(i).getComments());
                writer.writeEndElement();
            }
            if(!list.get(i).getCategory().isEmpty()){
                doSpace(3);
                writer.writeStartElement("category");
                writer.writeCharacters(list.get(i).getCategory());
                writer.writeEndElement();
            }
            doSpace(3);
            writer.writeStartElement("description");
            writer.writeCData(list.get(i).getDescription());
            writer.writeEndElement();
            doSpace(2);
            writer.writeEndElement();
        }
    }
    
    private static void doSpace(int tabulation) throws XMLStreamException{
        writer.writeCharacters("\n");
        for(int i = 0; i < tabulation; i++)
            writer.writeCharacters("    ");
    }
    
    public static void saveXMLFile() throws IOException, ParserConfigurationException, FileNotFoundException, XMLStreamException{
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES", ".txt", ".xml"));
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            FileWriter fw = null;
        try {
            fw = new FileWriter(new File(chooser.getSelectedFile().getAbsolutePath() +".xml"));          
            fw.write(createXMLDocument());
        } catch (IOException ex) {
        }finally{
            fw.close();
        }
        }
    }
}