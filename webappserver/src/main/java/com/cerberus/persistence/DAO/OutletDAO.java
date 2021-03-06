package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.Outlet;

public class OutletDAO extends GenericDAO<Outlet, Integer> {

	/***/
	public Outlet getById(Integer id){
		return getById(Outlet.class, id);
	}
	
	/***/
	public List<Outlet> getAll(){
		return getAll(Outlet.class);
	}
	
}
