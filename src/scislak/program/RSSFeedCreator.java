package scislak.program;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RSSFeedCreator {

    public static void main(String[] args) {
        WebPageFrame frame = new WebPageFrame("Google");
        RSSFeedCreator rss = new RSSFeedCreator();
        rss.work(frame);
        System.out.println(ReadWebPage.getTextFromMarker(ReadWebPage.TypeMarker.TITLE));
    }
    
    private void work(WebPageFrame frame){
        try {
            frame.setDocument(ReadWebPage.readHtmlToString("http://sebastianscislak.cba.pl/"));
        } catch (IOException ex) {
            Logger.getLogger(RSSFeedCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
