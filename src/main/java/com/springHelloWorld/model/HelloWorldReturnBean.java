package com.springHelloWorld.model;

public class HelloWorldReturnBean {

	private String message;

	public HelloWorldReturnBean(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
