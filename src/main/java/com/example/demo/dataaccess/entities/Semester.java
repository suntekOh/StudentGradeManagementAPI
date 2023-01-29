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
 * The persistent class for the semester database table.
 * 
 */
@Entity
@NamedQuery(name="Semester.findAll", query="SELECT s FROM Semester s")
public class Semester implements Serializable {
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

	private String name;

	@Column(name = "updated_utc")		
	private Timestamp updatedDateTimeUtc;

	private String updatedUser;

	//bi-directional many-to-one association to Personcourse
	@OneToMany(mappedBy="semester")
	private List<Personcourse> personcourses;

	public Semester() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Personcourse> getPersoncourses() {
		return this.personcourses;
	}

	public void setPersoncourses(List<Personcourse> personcourses) {
		this.personcourses = personcourses;
	}

	public Personcourse addPersoncours(Personcourse personcours) {
		getPersoncourses().add(personcours);
		personcours.setSemester(this);

		return personcours;
	}

	public Personcourse removePersoncours(Personcourse personcours) {
		getPersoncourses().remove(personcours);
		personcours.setSemester(null);

		return personcours;
	}

}