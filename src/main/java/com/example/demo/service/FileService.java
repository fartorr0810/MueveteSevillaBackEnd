package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	public void init();
	public byte[] save(MultipartFile file) throws IOException;
	public void deleteAll();
    public Stream<Path> loadAll();
	public String borrarFile(String file);
	public Resource load(String file);
	
	
	
}
