package com.cerberus.logic;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.message.MessageContainer;
import com.cerberus.message.WrongMessageException;
import com.cerberus.service.executor.ExecutorServiceFactory;
import com.cerberus.workflow.messageHandling.MessageWorkflow;

public class PersistenceLogic implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(PersistenceLogic.class);

	MessageContainer messageContainer;

	public PersistenceLogic (MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}

	public void run() {
		StopWatch stopwatch = new Log4JStopWatch("PersistenceLogic.run");
		LOGGER.info("[Persistence Logic]: Starting.");

		boolean messageProcessed = false;
		MessageWorkflow messageWorkflow = messageContainer.getMessage().getWorkflow();

		try {
			messageProcessed = messageWorkflow.handleReceivedMessage(messageContainer.getMessage());
		} catch(WrongMessageException e) {
			// TODO: message didn't have the appropriate workflow, wtf happened?
		}

		if (messageProcessed) {
			messageWorkflow.returnServiceFactory();
			ExecutorService executor = ExecutorServiceFactory.getResponseLogicThreadPool();
			Runnable responseLogicTask = new ResponseLogic(messageContainer);
			executor.execute(responseLogicTask);
		} else {
			// TODO: Message was not processed properly. Do we try again or
			// discard the message?
		}

		stopwatch.stop();
	}


}
