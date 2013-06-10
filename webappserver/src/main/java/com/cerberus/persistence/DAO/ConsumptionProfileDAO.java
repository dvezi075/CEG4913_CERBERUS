package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.ConsumptionProfile;

public class ConsumptionProfileDAO extends GenericDAO<ConsumptionProfile, Integer> {

	/***/
	public ConsumptionProfile getById(Integer id){
		return getById(ConsumptionProfile.class, id);
	}
	
	/***/
	public List<ConsumptionProfile> getAll(){
		return getAll(ConsumptionProfile.class);
	}
	
}
