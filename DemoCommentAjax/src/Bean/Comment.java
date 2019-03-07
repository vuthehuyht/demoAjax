package Bean;

public class Comment {
	private String content;
	private String username;
	
	public Comment(String content, String username) {
		super();
		this.content = content;
		this.username = username;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
