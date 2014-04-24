package by.epam.epamlab.model.beans;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 201404240248L;

	private int idUser;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private UserInRole role;
	private String password;
	private String passwordComfirmation;
	
	public User() {
		super();
	}

	public User(int idUser, String firstName, String emailAddress,
			String password) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public UserInRole getRole() {
		return role;
	}

	public void setRole(UserInRole role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordComfirmation() {
		return passwordComfirmation;
	}

	public void setPasswordComfirmation(String passwordComfirmation) {
		this.passwordComfirmation = passwordComfirmation;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", role=" + role + ", password=" + password
				+ ", passwordComfirmation=" + passwordComfirmation + "]";
	}

}
