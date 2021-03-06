package com.cerberus.message;

import com.cerberus.logic.constants.SocketStatus;
import com.cerberus.workflow.messageHandling.MessageWorkflow;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusMessage extends Message {

	private final SocketStatus status;

	@JsonCreator
	public StatusMessage(@JsonProperty("socketId") long socketId, @JsonProperty("timestamp") long timestamp,
			@JsonProperty("status") SocketStatus status) {
		super(socketId, timestamp);
		this.status = status;
	}

	public SocketStatus getStatus() {
		return status;
	}

	@Override
	@JsonIgnore
	public MessageWorkflow getWorkflow() {
		// TODO Auto-generated method stub
		return null;
	}

}
