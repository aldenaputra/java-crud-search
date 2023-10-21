
public class Librarian {

	public String name;
	public Integer id;
	public String password;
	
	public Librarian(String name, Integer id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
