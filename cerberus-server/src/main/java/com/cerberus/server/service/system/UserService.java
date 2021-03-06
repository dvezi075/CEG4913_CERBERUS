package com.cerberus.server.service.system;

import java.util.List;

import com.cerberus.server.persistence.DAO.LoginDAO;
import com.cerberus.server.persistence.DAO.PersonalInformationDAO;
import com.cerberus.server.persistence.DAO.SocketAssignmentDAO;
import com.cerberus.server.persistence.DAO.SocketDAO;
import com.cerberus.server.persistence.DAO.UserDAO;
import com.cerberus.server.persistence.DAO.UserSettingDAO;
import com.cerberus.server.persistence.DAO.UserTypeDAO;
import com.cerberus.server.persistence.beans.Login;
import com.cerberus.server.persistence.beans.PersonalInformation;
import com.cerberus.server.persistence.beans.SocketAssignment;
import com.cerberus.server.persistence.beans.User;
import com.cerberus.server.persistence.beans.UserSetting;
import com.cerberus.server.persistence.beans.UserType;
import com.cerberus.server.persistence.filter.SocketAssignmentFilter;

public class UserService {
	
	SocketDAO socketDAO;
	SocketAssignmentDAO socketAssignmentDAO;
	UserDAO userDAO;
	LoginDAO loginDAO;
	PersonalInformationDAO personalInformationDAO;
	UserTypeDAO userTypeDAO;
	UserSettingDAO userSettingDAO;
	
	public UserService(){
		socketDAO = new SocketDAO();
		socketAssignmentDAO = new SocketAssignmentDAO();
		userDAO = new UserDAO();
		loginDAO = new LoginDAO();
		personalInformationDAO = new PersonalInformationDAO();
		userTypeDAO = new UserTypeDAO();
		userSettingDAO = new UserSettingDAO();
		
	}
	
	public User getUserBySocketId(Integer socketId){
		
		SocketAssignment socketAssignment = 
				socketAssignmentDAO.getByFilter(SocketAssignmentFilter.getBySocketId(socketId));
		
		return socketAssignment.getUser();

	}
	
	//***************************************************
	//USER
	//***************************************************
	
	public User getUserById(Integer userId){
		return userDAO.getById(userId);
	}
	
	public Integer insertUser(User user){
		return userDAO.save(user);
	}
	
	public User updateUser(User user){
		return userDAO.merge(user);
	}
	
	public void deleteUser(User user){
		userDAO.delete(user);
	}
	
	public List<User> getAllUser() {
		return userDAO.getAll();
	}

	//***************************************************
	//LOGIN
	//***************************************************
	
	public Integer insertLogin(Login login){
		return loginDAO.save(login);
	}
	
	public Login updateLogin(Login login){
		return loginDAO.merge(login);
	}
	
	public void deleteLogin(Login login){
		loginDAO.delete(login);
	}
	
	public Login getLoginById(Integer loginId) {
		return loginDAO.getById(loginId);
	}

	public List<Login> getAllLogin() {
		return loginDAO.getAll();
	}

	//***************************************************
	//PERSONAL INFORMATION
	//***************************************************

	public Integer insertPersonalInformation(PersonalInformation personalInformation){
		return personalInformationDAO.save(personalInformation);
	}
	
	public PersonalInformation updatePersonalInformation(PersonalInformation personalInformation){
		return personalInformationDAO.merge(personalInformation);
	}
	
	public void deletePersonalInformation(PersonalInformation personalInformation){
		personalInformationDAO.delete(personalInformation);
	}
	
	
	//***************************************************
	//USER TYPE
	//***************************************************

	public Integer insertUserType(UserType userType) {
		return userTypeDAO.save(userType);
	}
	
	public UserType getUserTypeById(Integer userTypeId){
		return userTypeDAO.getById(userTypeId);
	}	
	
	public List<UserType> getAllUserTypes() {
		return userTypeDAO.getAll();
	}

	//***************************************************
	//USER SETTING
	//***************************************************
	
	public Integer insertUserSetting(UserSetting userSetting){
		return userSettingDAO.save(userSetting);
	}
	
	public UserSetting updateUserSetting(UserSetting userSetting){
		return userSettingDAO.merge(userSetting);
	}
	
	public void deleteUserSetting(UserSetting userSetting){
		userSettingDAO.delete(userSetting);
	}
	
}
