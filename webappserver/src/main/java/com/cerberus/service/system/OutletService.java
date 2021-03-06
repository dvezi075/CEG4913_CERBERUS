package com.cerberus.service.system;

import com.cerberus.persistence.DAO.ConnectionEventDAO;
import com.cerberus.persistence.DAO.EventDAO;
import com.cerberus.persistence.DAO.OutletDAO;
import com.cerberus.persistence.DAO.OutletOperationModeDAO;
import com.cerberus.persistence.DAO.SocketAssignmentDAO;
import com.cerberus.persistence.DAO.SocketDAO;
import com.cerberus.persistence.DAO.SocketOperationStatusDAO;
import com.cerberus.persistence.beans.ConnectionEvent;
import com.cerberus.persistence.beans.Event;
import com.cerberus.persistence.beans.Outlet;
import com.cerberus.persistence.beans.OutletOperationMode;
import com.cerberus.persistence.beans.Socket;
import com.cerberus.persistence.beans.SocketAssignment;
import com.cerberus.persistence.beans.SocketOperationStatus;
import com.cerberus.persistence.filter.SocketAssignmentFilter;
import com.cerberus.persistence.filter.SocketFilter;

public class OutletService {

	private final OutletDAO outletDAO;
	private final ConnectionEventDAO connectionEventDAO;
	private final EventDAO eventDAO;
	private final SocketOperationStatusDAO socketOperationStatusDAO;
	private final SocketDAO socketDAO;
	private final OutletOperationModeDAO outletOperationModeDAO;
	private final SocketAssignmentDAO socketAssignmentDAO;
	
	public OutletService(){
		outletDAO = new OutletDAO();
		connectionEventDAO = new ConnectionEventDAO();
		eventDAO = new EventDAO();
		socketOperationStatusDAO = new SocketOperationStatusDAO();
		socketDAO = new SocketDAO();
		outletOperationModeDAO = new OutletOperationModeDAO();
		socketAssignmentDAO = new SocketAssignmentDAO();
	}
	
	//***************************************************
	//Outlet
	//***************************************************
	
	public Integer insertOutlet(Outlet outlet){
		return outletDAO.save(outlet);
	}
	
	public Outlet updateOutlet(Outlet outlet){
		return outletDAO.merge(outlet);
	}
	
	public void deleteOutlet(Outlet outlet){
		outletDAO.delete(outlet);
	}
	
	//***************************************************
	//ConnectionEvent
	//***************************************************
	
	public Integer insertConnectionEvent(ConnectionEvent connectionEvent){
		return connectionEventDAO.save(connectionEvent);
	}
	
	public ConnectionEvent updateConnectionEvent(ConnectionEvent connectionEvent){
		return connectionEventDAO.merge(connectionEvent);
	}
	
	public void deleteConnectionEvent(ConnectionEvent connectionEvent){
		connectionEventDAO.delete(connectionEvent);
	}
	
	//***************************************************
	//Event
	//***************************************************
	
	public Integer insertEvent(Event event){
		return eventDAO.save(event);
	}
	
	public Event updateEvent(Event event){
		return eventDAO.merge(event);
	}
	
	public void deleteEvent(Event event){
		eventDAO.delete(event);
	}
	
	//***************************************************
	//SocketOperationStatus
	//***************************************************
	
	public Integer insertSocketOperationStatus(SocketOperationStatus socketOperationStatus){
		return socketOperationStatusDAO.save(socketOperationStatus);
	}
	
	public SocketOperationStatus updateSocketOperationStatus(SocketOperationStatus socketOperationStatus){
		return socketOperationStatusDAO.merge(socketOperationStatus);
	}
	
	public void deleteSocketOperationStatus(SocketOperationStatus socketOperationStatus){
		socketOperationStatusDAO.delete(socketOperationStatus);
	}
	
	//***************************************************
	//Socket
	//***************************************************
	
	public Integer insertSocket(Socket socket){
		return socketDAO.save(socket);
	}
	
	public Socket updateSocket(Socket socket){
		return socketDAO.merge(socket);
	}
	
	public void deleteSocket(Socket socket){
		socketDAO.delete(socket);
	}
	
	//***************************************************
	//OutletOperationMode
	//***************************************************
	
	public Integer insertOutletOperationMode(OutletOperationMode outletOperationMode){
		return outletOperationModeDAO.save(outletOperationMode);
	}
	
	public OutletOperationMode updateOutletOperationMode(OutletOperationMode outletOperationMode){
		return outletOperationModeDAO.merge(outletOperationMode);
	}
	
	public void deleteOutletOperationMode(OutletOperationMode outletOperationMode){
		outletOperationModeDAO.delete(outletOperationMode);
	}
	
	//***************************************************
	//SocketAssignment
	//***************************************************
	
	public Integer insertSocketAssignment(SocketAssignment socketAssignment){
		return socketAssignmentDAO.save(socketAssignment);
	}
	
	public SocketAssignment updateSocketAssignment(SocketAssignment socketAssignment){
		return socketAssignmentDAO.merge(socketAssignment);
	}
	
	public void deleteSocketAssignment(SocketAssignment socketAssignment){
		socketAssignmentDAO.delete(socketAssignment);
	}
	
	public Socket getSocketBySocketId(Integer socketId){
		return socketDAO.getByFilter(SocketFilter.getById(socketId));
	}
	
	public Socket getSocketBySerialNumber(Long serialNumber) {
		return socketDAO.getByFilter(SocketFilter.getBySerialNum(serialNumber));
	}
	
	public SocketAssignment getSocketAssignmentBySocketId(Integer socketId){
		return socketAssignmentDAO.getByFilter(SocketAssignmentFilter.getBySocketId(socketId));
	}

}
