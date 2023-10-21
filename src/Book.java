
public class Book {
	
	private Integer isbn;
	private String title;
	private String author;
	
	public Book(Integer isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	private String mname;
	private Integer idm;
	
	public String getMname() {
		return mname;
	}
	
	public Integer getIdm() {
		return idm;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public void setIdm(Integer idm) {
		this.idm = idm;
	}
	
	public String getStatus() {
		if(mname == null && idm == null) {
			return "Available";
		}
		return "Rented by " + mname + " - " + idm;
	}
	
	public boolean status() {
		if(mname == null && idm == null) {
			return true;
		}
		return false;
	}
}
