package com.example.demo;

/**
 * The class User
 */
public class User {
	int id;
	String uname;

	/**
	 *
	 * Sets the uid
	 * 
	 * @param id the id.
	 */
	public void setUid(int id) {

		this.id = id;

	}

	/**
	 *
	 * Sets the uname
	 *
	 * @param string the string.
	 */
	public void setUname(String string) {

		this.uname = string;

	}

	/**
	 *
	 * Gets the identifier
	 *
	 * @return the identifier
	 */
	public int getId() {

		return id;
	}

	/**
	 *
	 * Gets the uname
	 *
	 * @return the uname
	 */
	public String getUname() {

		return uname;
	}
}
