package com.restapi.springbootrestdemo.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	//Static Location Path
	/*public final String 
	UPLOAD_DIR = "C:\\Kishor\\Technical\\Spring Boot\\Spring Boot Projects\\springbootrestdemo\\src\\main\\resources\\static\\image";*/
	
	//Dynamic Path
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}
	
	public boolean uploadFile(MultipartFile multipartFile) {
		
		boolean f = false;
		
		try {
			
			//Old API Logic i..e., Stream API
			/*InputStream is = multipartFile.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);
			
			//Write on above folder
			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getContentType());
			fos.write(data);
			fos.flush();
			fos.close();*/
			
			//Alternate for above Stream API Logic
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()) , 
					StandardCopyOption.REPLACE_EXISTING);
			f = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
