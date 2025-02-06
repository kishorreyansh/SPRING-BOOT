package com.restapi.springbootrestdemo.controllers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.restapi.springbootrestdemo.helper.FileUploadHelper;



@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		
		System.out.println("File Original Name : "+file.getOriginalFilename());
		System.out.println("File Size : "+file.getSize());
		System.out.println("File Content Type : "+file.getContentType());
		System.out.println("File Name : "+file.getName());
		
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
			}
			
			if(!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG Content Type Allowed");
			}
			
			//File Upload Logic
			boolean f = fileUploadHelper.uploadFile(file);
			if(f) {
				//Static Message
				//return ResponseEntity.ok("File Uploaded Successfully");
				
				// Dynamic Message
				return ResponseEntity.ok(org.springframework.web.servlet.support.ServletUriComponentsBuilder
						.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went WRONG. Try Again !!!");
	}
}
