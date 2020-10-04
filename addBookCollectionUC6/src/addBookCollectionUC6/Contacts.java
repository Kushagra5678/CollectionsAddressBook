package addBookCollectionUC6;


public class Contacts {
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private String zip;
	private String phoneNo;
	private String email;
	
public Contacts(String firstName,String lastName,String address,String state,
		String zip,String phoneNo,String email) {
	this.firstName=firstName;
	this.lastName=lastName;
	this.address=address;
	this.state=state;
	this.zip=zip;
	this.phoneNo=phoneNo;
	this.email=email;
}

//public Contacts() {
//}

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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}

public String getPhoneNumber() {
	return phoneNo;
}

public void setPhoneNumber(String phoneNo) {
	this.phoneNo = phoneNo;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ",state=" + state + ", zip=" + zip + ", phoneNo=" + phoneNo + ", email=" + email + "]";
}



}
