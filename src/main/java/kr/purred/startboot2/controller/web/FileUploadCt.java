package kr.purred.startboot2.controller.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping ("/upload")
public class FileUploadCt
{
	@PostMapping("/upload")
	public String uploadTest (@RequestParam("file") MultipartFile file, String temp, String temp2)
	{
		System.out.println (temp);
		System.out.println (temp2);

		System.out.println (file);

		return "OK";
	}
}
