package com.virak.mytabapp;

public class Contact {
	
	//private variables
	int _id;
	String _name;
	String _phone;
	
	// Empty constructor
	public Contact(){
		
	}
	// constructor
	public Contact(int id, String name, String _phone){
		this._id = id;
		this._name = name;
		this._phone = _phone;
	}
	
	// constructor
	public Contact(String name, String _phone){
		this._name = name;
		this._phone = _phone;
	}
	// getting ID
	public int getID(){
		return this._id;
	}
	
	// setting id
	public void setID(int id){
		this._id = id;
	}
	
	// getting name
	public String getName(){
		return this._name;
	}
	
	// setting name
	public void setName(String name){
		this._name = name;
	}
	
	// getting phone number
	public String getPhoneNumber(){
		return this._phone;
	}
	
	// setting phone number
	public void setPhoneNumber(String phone){
		this._phone = phone;
	}
}
