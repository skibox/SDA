package Lista4.zadanie10;

public class Author {
	private String name;
	private String email;
	private char gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public Author(String name, String email, char gender) {
		setName(name);
		setEmail(email);
		setGender(gender);
	}
	
	@Override
	public String toString() {
		return "Author[name = " + getName() + ", email = " + getEmail() + ", gender = " + getGender();
	}
}
