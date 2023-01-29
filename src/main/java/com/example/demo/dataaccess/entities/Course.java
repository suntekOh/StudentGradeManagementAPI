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
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
	private UUID id;

	private String code;

	@Column(name = "created_utc")		
	private Timestamp createdDateTimeUtc;

	private String createdUser;

	private String name;

	@Column(name = "updated_utc")		
	private Timestamp updatedDateTimeUtc;

	private String updatedUser;

	//bi-directional many-to-one association to Personcourse
	@OneToMany(fetch = FetchType.EAGER, mappedBy="course")
	private List<Personcourse> personcourses;

	public Course() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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
		personcours.setCourse(this);

		return personcours;
	}

	public Personcourse removePersoncours(Personcourse personcours) {
		getPersoncourses().remove(personcours);
		personcours.setCourse(null);

		return personcours;
	}

}