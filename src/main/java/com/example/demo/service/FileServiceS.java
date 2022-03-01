package com.example.demo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceS implements FileService{
	
    private final Path root = Paths.get("carpetafotos");
    private String upload_folder = ".//src//main//resources//files//";
    
	@Override
	public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("No se puede crear la carpeta");
        }		
	}

	@Override
	public byte[] save(MultipartFile file) throws IOException {
		byte[] nombrearchivo=null;
		if(!file.isEmpty()) {
			nombrearchivo = file.getBytes();
    		Path path = Paths.get(upload_folder + LocalDateTime.now()+"_"+file.getOriginalFilename());
    		Files.write(path, nombrearchivo);
    	}
	   	return nombrearchivo;
	}

	@Override
	public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());		
	}

	@Override
	public Stream<Path> loadAll() {
        try{
            return Files.walk(this.root,1).filter(path -> !path.equals(this.root))
                    .map(this.root::relativize);
        }catch (RuntimeException | IOException e){
            throw new RuntimeException("Error al cargar");
        }
	}

	@Override
	public String borrarFile(String file) {
	       try {
	            Boolean delete = Files.deleteIfExists(this.root.resolve(file));
	                return "Borrado";
	        }catch (IOException e){
	            e.printStackTrace();
	            return "Error Borrando ";
	        }
	}

	@Override
	public Resource load(String file) {
        try {
            Path archivito = root.resolve(file);
            Resource resource = new UrlResource(archivito.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("Error de lectura");
            }
        }catch (MalformedURLException e){
            throw new RuntimeException("Error: " + e.getMessage());
        }
	}
	
}
