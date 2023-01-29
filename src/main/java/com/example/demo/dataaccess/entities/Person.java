package com.example.demo.dataaccess.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
	private UUID id;

	@Column(name = "created_utc")	
	private Timestamp createdDateTimeUtc;

	private String createdUser;

	private String firstName;

	private String lastName;

	private String personCode;

	@Column(name = "updated_utc")	
	private Timestamp updatedDateTimeUtc;

	private String updatedUser;

	//bi-directional many-to-one association to Personstatus
	@ManyToOne
	@JoinColumn(name="personStatusId")
	private Personstatus personstatus;

	//bi-directional many-to-one association to Persontype
	@ManyToOne
	@JoinColumn(name="personTypeId")
	private Persontype persontype;

	//bi-directional many-to-one association to Personcourse
	@OneToMany(mappedBy="person")
	private List<Personcourse> personcourses;

	public Person() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Timestamp getCreatedDateTimeUtc() {
		return this.createdDateTimeUtc;
	}

	public void setCreatedDateTimeUtc(Timestamp createdDateTimeUtc) {
		this.createdDateTimeUtc = createdDateTimeUtc;
	}

	public String getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonCode() {
		return this.personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public Timestamp getUpdatedDateTimeUtc() {
		return this.updatedDateTimeUtc;
	}

	public void setUpdatedDateTimeUtc(Timestamp updatedDateTimeUtc) {
		this.updatedDateTimeUtc = updatedDateTimeUtc;
	}

	public String getUpdatedUser() {
		return this.updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public Personstatus getPersonstatus() {
		return this.personstatus;
	}

	public void setPersonstatus(Personstatus personstatus) {
		this.personstatus = personstatus;
	}

	public Persontype getPersontype() {
		return this.persontype;
	}

	public void setPersontype(Persontype persontype) {
		this.persontype = persontype;
	}

	public List<Personcourse> getPersoncourses() {
		return this.personcourses;
	}

	public void setPersoncourses(List<Personcourse> personcourses) {
		this.personcourses = personcourses;
	}

	public Personcourse addPersoncours(Personcourse personcours) {
		getPersoncourses().add(personcours);
		personcours.setPerson(this);

		return personcours;
	}

	public Personcourse removePersoncours(Personcourse personcours) {
		getPersoncourses().remove(personcours);
		personcours.setPerson(null);

		return personcours;
	}

}