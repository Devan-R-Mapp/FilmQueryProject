package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Actor {
	private String lastName;
	private String firstName;
	private int id;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(firstName);
		builder.append(" ");
		builder.append(lastName);
		return builder.toString();
	}
	public Actor( int id, String lastName, String firstName) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
