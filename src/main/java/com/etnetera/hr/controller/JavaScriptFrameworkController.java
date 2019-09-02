package com.etnetera.hr.controller;

import com.etnetera.hr.model.ResponseModel;
import com.etnetera.hr.service.JavaScriptFrameworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Simple REST controller for accessing application logic.
 *  
 * @author Etnetera
 *
 */
@RestController
public class JavaScriptFrameworkController {
	
	private final JavaScriptFrameworkRepository repository;

	@Autowired
	public JavaScriptFrameworkController(JavaScriptFrameworkRepository repository) {
		this.repository = repository;
	}

	@Autowired
	private JavaScriptFrameworkService fmws;

	@GetMapping("/frameworks")
	public Iterable<JavaScriptFramework> findAll() {
		return fmws.findAll(repository);
	}

	@GetMapping("/frameworks/name/{name}")
	public Iterable<JavaScriptFramework> findByName(@PathVariable String name) {
		return fmws.findByName(repository, name);
	}

	@GetMapping("/frameworks/version/{version}")
	public Iterable<JavaScriptFramework> findByVersion(@PathVariable String version) {
		return fmws.findByVersion(repository, version);
	}

	@PostMapping("/framework/create")
	public ResponseEntity<ResponseModel> create(@RequestBody JavaScriptFramework model) {
		return fmws.createFramework(repository, model);
	}

	@PutMapping("/framework/update")
	public ResponseEntity<ResponseModel> update(@RequestBody JavaScriptFramework model) {
		return fmws.updateFramework(repository, model);
	}

	@DeleteMapping("/framework/delete/id/{id}")
	public ResponseEntity<ResponseModel> delete(@PathVariable Long id) {
		return fmws.deleteFramework(repository, id);
	}
}
