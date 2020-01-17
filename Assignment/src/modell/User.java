package modell;

public class User {
	private String firstname;
	private String lastname;
	private String username;
	private String pasword;
	//String confirmpassword;
	private String email;
	private String mobile;
	public User()
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.username=username;
		this.pasword=pasword;
		this.email=email;
		this.mobile=mobile;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	void display()
	{
		System.out.println("First name "+this.firstname);
		System.out.println("Last name "+this.lastname);
		System.out.println("User name "+this.username);
		System.out.println("Pasword "+this.pasword);
		System.out.println("E-mail name "+this.email);
		System.out.println("Mobile No. "+this.mobile);
		
	}

}
