package com.xmlbasedspringproject.app;

import java.beans.ConstructorProperties;

public class StudentInvoke {
	private int id;
	private HelloWorld helloWorld;
	private JavaWorld javaWorld;
	
	@ConstructorProperties({"id","helloWorld","javaWorld"})
	public StudentInvoke(int id, HelloWorld helloWorld, JavaWorld javaWorld) {
		super();
		this.id = id;
		this.helloWorld = helloWorld;
		this.javaWorld = javaWorld;
	}

	public StudentInvoke() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public JavaWorld getJavaWorld() {
		return javaWorld;
	}

	public void setJavaWorld(JavaWorld javaWorld) {
		this.javaWorld = javaWorld;
	}



}
