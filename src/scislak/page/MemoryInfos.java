package scislak.page;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class MemoryInfos {
	public static final String NAME_PREFERENCE = "MemoryInfos";
	public static final String TITLE = "title";
	public static final String LINK = "link";
	public static final String AUTHOR = "author";
	public static final String LANGUAGE = "language";
	public static final String EDITOR = "editor";
	public static final String WEBMASTER = "webmaster";
	public static final String DATE = "date";
	public static final String DESCRIPTION = "description";
	
    private static List<PageInfo> INFOS = new ArrayList<PageInfo>();
    private static String title;    
    private static String link;
    private static String author;
    private static String language;
    private static String editor;
    private static String webmaster;
    private static String date;
    private static String description;
    
    private MemoryInfos(){}
    
    public static void addToMemory(PageInfo page){ 
        getINFOS().add(page);
    }
    
    public static void saveToPreference() {
    	Preferences prefs = Preferences.userRoot().node(NAME_PREFERENCE);
    	prefs.put(TITLE, title);
    	prefs.put(LINK, link);
    	prefs.put(AUTHOR, author);
    	prefs.put(LANGUAGE, language);
    	prefs.put(EDITOR, editor);
    	prefs.put(WEBMASTER, webmaster);
    	prefs.put(DESCRIPTION, description);
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

	public static String getLanguage() {
		return language;
	}

	public static String getEditor() {
		return editor;
	}

	public static String getWebmaster() {
		return webmaster;
	}

	public static void setLanguage(String language) {
		MemoryInfos.language = language;
	}

	public static void setEditor(String editor) {
		MemoryInfos.editor = editor;
	}

	public static void setWebmaster(String webmaster) {
		MemoryInfos.webmaster = webmaster;
	}
}
