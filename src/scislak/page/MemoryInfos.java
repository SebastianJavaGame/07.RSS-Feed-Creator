package scislak.page;

import java.util.List;
import java.util.ArrayList;

public class MemoryInfos {
    private static List<PageInfo> INFOS = new ArrayList<PageInfo>();
    private static String title;
    private static String description;
    private static String link;
    private static String author;
    private static String date;
    private static boolean empty = true;
    
    public MemoryInfos(String title, String description, String link, String author, String date){
        this.title = title;
        this.description = description;
        this.link = link;
        this.author = author;
        this.date = date;
        empty = false;
    }
    
    public static void addToMemory(){
        if(isEmpty())
            return;
        
        PageInfo page = new PageInfo();
        page.setTitle(getTitle());
        page.setDescription(getDescription());
        page.setLink(getLink());
        page.setAuthor(getAuthor());
        page.setDate(getDate());
        
        getINFOS().add(page);
    }

    public static List<PageInfo> getINFOS() {
        return INFOS;
    }

    public static void setINFOS(List<PageInfo> aINFOS) {
        INFOS = aINFOS;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String aTitle) {
        title = aTitle;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String aDescription) {
        description = aDescription;
    }

    public static String getLink() {
        return link;
    }

    public static void setLink(String aLink) {
        link = aLink;
    }

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String aAuthor) {
        author = aAuthor;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String aDate) {
        date = aDate;
    }

    public static boolean isEmpty() {
        return empty;
    }
}
