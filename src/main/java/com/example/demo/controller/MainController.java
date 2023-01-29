package com.example.demo.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.form.CourseForm;
import com.example.demo.dataaccess.CourseRepository;
import com.example.demo.dataaccess.entities.Course;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
	@Autowired
	private CourseRepository courseRepository;

	@PostMapping(path = "/addCourse")
	public @ResponseBody String addNewCourse(@Valid CourseForm courseForm, BindingResult result) {
	    if (result.hasErrors()) {
	        return "error";
	    }
		Course n = new Course();
		n.setCode(courseForm.getCode());
		n.setName(courseForm.getName());
		n.setCreatedUser("test1");
		n.setCreatedDateTimeUtc(getUtc());
		courseRepository.save(n);
		
		return "Saved";
	}

	@GetMapping(path = "/getAllCourses")
	public @ResponseBody Iterable<Course> getAllCourses() {
		// This returns a JSON or XML with the users
		return courseRepository.findAll();
	}

	private static Timestamp getUtc() {
		LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
		ZonedDateTime gmt = zdt.withZoneSameInstant(ZoneId.of("GMT"));
		Timestamp timestamp = Timestamp.valueOf(gmt.toLocalDateTime());
		return timestamp;
	}
}
