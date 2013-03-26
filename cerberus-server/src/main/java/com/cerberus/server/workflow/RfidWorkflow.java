package com.cerberus.server.workflow;

import java.util.logging.Logger;

import com.cerberus.server.persistence.beans.RfidTag;
import com.cerberus.server.persistence.filter.RfidTagFilter;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class RfidWorkflow extends Workflow{


	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	ServiceFactory serviceFactory;

	public RfidWorkflow() {
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	public RfidTag getRfidTagByNumber(Long number){
		return serviceFactory.getRfidService().getRfidTagByNumber(RfidTagFilter.getRfidTagByNumber(number));
	}

	@Override
	public void returnServiceFactory() {
		try {
			ServiceFactoryPool.returnServiceFactory(serviceFactory);
		} catch (Throwable e) {
			LOGGER.severe("ERROR Returning Service Factory");
			e.printStackTrace();
		}
	}



}
