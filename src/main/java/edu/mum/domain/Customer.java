package edu.mum.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import edu.mum.validation.EmptyOrSize;
import edu.mum.validation.NullMinNumber;
@Entity
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
	
	@Column(length = 16)
	@NotEmpty
	private String firstName;
	
	@Column(length = 16)
	@EmptyOrSize(min=5, max = 9, message= "{EmptyOrSize}")
	private String lastName;
	
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })  
    private List<Address> addresses = new ArrayList<Address>();
	
//	@NullMinNumber(value=6)
	@Pattern(regexp="\\d{3}-\\d{3}-\\d{4}", message="{customer.validation.numb}")
 	private String customerNumber;
	
	@Email
	private String email;
	
	
	@Valid
    @OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST} )
    @JoinColumn(name="customer_id")
	private List<Room> rooms = new ArrayList<Room>();
	
	
	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getNumber() {
		return this.customerNumber;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
		
}
