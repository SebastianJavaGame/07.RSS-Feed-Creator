package scislak.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import scislak.program.WebPageFrame;

public class ReadWebPage {
    public enum TypeMarker {TITLE, H1};
    
    public static String readHtmlToString(String htmlUrl)throws MalformedURLException, IOException {

        BufferedReader br = null;
        StringBuilder sb;
        
        try {

            URL url = new URL(htmlUrl);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        } finally {

            if (br != null) {
                br.close();
            }
        }
        
        return sb.toString();
    }
    
    public static String getTextFromMarker(TypeMarker marker){
        return getTextFromMarkerFromPosition(marker, 0);
    }
    
    public static String getTextFromMarkerFromPosition(TypeMarker marker, int position){
        String markerStart = "<" +marker.toString().toLowerCase() +">";
        String markerEnd = "</" +markerStart.substring(1);
        
        int start = WebPageFrame.getDocument().indexOf(markerStart, position);
        start += markerStart.length();
        int end = WebPageFrame.getDocument().indexOf(markerEnd);

        return WebPageFrame.getDocument().substring(start, end);
    }
}