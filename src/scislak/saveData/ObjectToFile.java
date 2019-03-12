package scislak.saveData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import scislak.page.PageInfo;

public class ObjectToFile {
    private static final String filename = "C:\\temp\\messages.ser";
    
    public static void writeObjectToFile(Object writer){
        FileOutputStream out = null;
        ObjectOutputStream object = null;
        
        try{
            new File("C:\\temp").mkdirs();
            out = new FileOutputStream(filename);
            object = new ObjectOutputStream(out);
            object.writeObject(writer);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally{
            if(out != null){
                try{
                    out.close();
                } catch (IOException ex) {}
            }
            if(object != null){
                try{
                    object.close();
                } catch (IOException ex) {}
            }
        }
    }
    
    public static List<PageInfo> readObjectFromFile(){
        List<PageInfo> list = null;
        FileInputStream in = null;
        ObjectInputStream object = null;

        try{
            in = new FileInputStream(filename);
            object = new ObjectInputStream(in);
            list = (List<PageInfo>) object.readObject();
        } catch (IOException | ClassNotFoundException ex) {}
        finally{
            if(in != null){
                try{
                    in.close();
                } catch (IOException ex) {}
            }
            if(object != null){
                try{
                    object.close();
                } catch (IOException ex) {}
            }
        }
        return list;
    }
}
