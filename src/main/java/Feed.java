
public class Feed {
	String title;
	String description;
	String date;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Feed(String title, String description, String date) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Feed [title=" + title + ", description=" + description + ", date=" + date + "]";
	}
	
	
}
