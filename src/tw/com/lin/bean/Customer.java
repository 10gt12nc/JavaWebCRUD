package tw.com.lin.bean;

import java.io.Serializable;

public class Customer implements Serializable {

	private Integer id;
	private String username;
	private String password;
	private String password2;
	private String email;

	public Customer() {
		super();
	}

	public Customer(Integer id, String username, String password, String password2, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", password2=" + password2
				+ ", email=" + email + "]";
	}

}
