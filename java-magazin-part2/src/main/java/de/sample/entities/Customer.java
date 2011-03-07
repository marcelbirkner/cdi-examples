package de.sample.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int customerId;
    
    private String firstName;
    private String lastName;

	@Temporal( TemporalType.DATE )
	@Column(name="creation_time")
	private Date creationTime;

	public Customer() {
		setCreationTime(new DateTime().toDate());
	}
    
    public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getCreationTime() {
		return creationTime;
	}
}