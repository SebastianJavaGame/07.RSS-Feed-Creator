package scislak.page;

import java.io.Serializable;

public class PageInfo implements Serializable{
    private String title;
    private String link;
    private String category;
    private String comments;
    private String author;
    private String date;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
    	if(title == null)
    		return;
    	
    	if(!title.isEmpty())
    		this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
    	if(description == null)
    		return;
    	
    	if(!description.isEmpty())
    		this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link){
    	if(link == null)
    		return;
    	
    	if(!link.isEmpty())
    		this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
    	System.out.println("getdate" + date);
        this.date = date;
    }

	public String getCategory() {
		return category;
	}

	public String getComments() {
		return comments;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
