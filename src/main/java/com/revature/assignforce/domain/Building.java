package com.revature.assignforce.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "BUILDING")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Building implements Activatable {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(allocationSize = 1, name = "buildingSeq", sequenceName = "BUILDING_SEQ")
	@GeneratedValue(generator = "buildingSeq", strategy = GenerationType.SEQUENCE)
	private int ID;

	@Column(name = "NAME", unique = true, nullable = false)
	private String name;

	@Column(name = "LOCATION")
	@JoinColumn(name="building")
	private int location;

	@Column(name = "active", insertable = false)
	private Boolean active;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "BUILDING")
	// @JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<Room> rooms;

	public Boolean getActive() {
		return active;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Building [ID=" + ID + ", name=" + name + ", location=" + location + ", active=" + active + ", rooms="
				+ rooms + "]";
	}

}