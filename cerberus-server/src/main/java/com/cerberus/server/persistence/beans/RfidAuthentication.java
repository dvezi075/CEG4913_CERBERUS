package com.cerberus.server.persistence.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RFID_AUTHENTICATION")
public class RfidAuthentication implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Integer id;
	Integer rfidTagId;
	User owner;
	
	public RfidAuthentication(Integer rfidTagId, User owner) {
		super();
		this.rfidTagId = rfidTagId;
		this.owner = owner;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="RFID_TAG_ID", nullable=false)
	public Integer getRfidTagId() {
		return rfidTagId;
	}
	public void setRfidTagId(Integer rfidTagId) {
		this.rfidTagId = rfidTagId;
	}
	
	@Column(name="USER_ID", nullable=false)
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
}