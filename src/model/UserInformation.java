package model;

import java.sql.Timestamp;

public class UserInformation {
	private String  firstName, lastName, email, company, address;
	private int id, phoneNumber;
	private Timestamp created;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private int userRoleId;

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public UserInformation(int id, int userRoleId, String firstName, String lastName,
			int phoneNumber, String email, String address, String company, Timestamp created) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.address = address;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.created = created;
		this.userRoleId = userRoleId;
	}

	public UserInformation(int id, int userRoleId, String firstName, String lastName,
			int phoneNumber, String email, String address, String company) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.address = address;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.userRoleId = userRoleId;
	}

	public UserInformation(int userRoleId, String firstName, String lastName, int phoneNumber,
			String email, String address, String company) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userRoleId = userRoleId;
	}
}
