package com.cerberus.server.persistence.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private UserSetting setting;
	private UserType type;
	private Login login;
	private PersonalInformation information;
	private Date createdDate;
	private User createdUser;
	private Date lastUpdatedDate;
	private User lastUpdatedUser;
	
	public User(	Integer id, 
					UserSetting setting, 
					UserType type, 
					Login login, 
					PersonalInformation information,
					Date createdDate,
					User createdUser,
					Date lastUpdatedDate,
					User lastUpdatedUser) {
		super();
		this.id = id;
		this.setting = setting;
		this.type = type;
		this.login = login;
		this.information = information;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.lastUpdatedDate = lastUpdatedDate;
		this.lastUpdatedUser = lastUpdatedUser;
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

	@Column(name="USER_SETTING_ID", nullable=false)
	public UserSetting getSetting() {
		return setting;
	}
	public void setSetting(UserSetting setting) {
		this.setting = setting;
	}

	@Column(name="USER_TYPE_ID", nullable=false)
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}

	@Column(name="LOGIN_ID", nullable=false)
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

	@Column(name="PERSONAL_INFORMATION_ID", nullable=false)
	public PersonalInformation getInformation() {
		return information;
	}
	public void setInformation(PersonalInformation information) {
		this.information = information;
	}
	
	@Column(name="CREATED_DATE", nullable=false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="CREATED_USER_ID", nullable=false)
	public User getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}
	
	@Column(name="LAST_UPDATED_DATE", nullable=false)
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	@Column(name="LAST_UPDATED_USER_ID", nullable=false)
	public User getLastUpdatedUser() {
		return lastUpdatedUser;
	}
	public void setLastUpdatedUser(User lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}	
	
}
