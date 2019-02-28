package scislak.program;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RSSFeedCreator {

    public static void main(String[] args) {
        initLook();
        new CreateRSSFrame();
    }  
    
    private static void initLook(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RSSFeedCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RSSFeedCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RSSFeedCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RSSFeedCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
