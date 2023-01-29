package com.example.demo.dataaccess.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


/**
 * The persistent class for the personcourse database table.
 * 
 */
@Entity
@NamedQuery(name="Personcourse.findAll", query="SELECT p FROM Personcourse p")
public class Personcourse implements Serializable {
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

	private short score;

	@Column(name = "updated_utc")		
	private Timestamp updatedDateTimeUtc;

	private String updatedUser;

	private short year;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="courseId")
	private Course course;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="personId")
	private Person person;

	//bi-directional many-to-one association to Semester
	@ManyToOne
	@JoinColumn(name="semesterId")
	private Semester semester;

	public Personcourse() {
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

	public short getScore() {
		return this.score;
	}

	public void setScore(short score) {
		this.score = score;
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

	public short getYear() {
		return this.year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Semester getSemester() {
		return this.semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

}