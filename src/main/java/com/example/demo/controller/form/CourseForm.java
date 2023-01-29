package com.example.demo.controller.form;

import jakarta.validation.constraints.NotBlank;

public class CourseForm {
	@NotBlank	
	private String code;
	@NotBlank
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
