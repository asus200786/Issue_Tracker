package by.epam.epamlab.model.beans;

import java.io.Serializable;

import by.epam.epamlab.model.enums.RolesUser;

public class User implements Serializable {

	private static final long serialVersionUID = 201404240248L;

	private int idUser;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private RolesUser role;
	private String password;

	public User() {
		super();
	}

	public User(int idUser, String firstName, String lastName,
			String emailAddress, String password, String role) {
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

	public RolesUser getRole() {
		return role;
	}

	public void setRole(RolesUser role) {
		this.role = role;
	}

	public void setRole(String role) {
		this.role = RolesUser.valueOf(role.toUpperCase());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", role=" + role + ", password=" + password + "]";
	}

}
