package com.java8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStreamFeature {

	public static void main(String args[])  throws Exception{

		
		File file = new File("c://temp//file.txt");
		  
		//Create the file
		if (file.exists()){
		System.out.println("File is created!");
		}else{
		System.out.println("File already exists.");
		}
		 
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write("Writing into file");
		writer.write("Writing -part 1");
		writer.write("Writing -part 2");
		writer.write("Writing -part 3");
		writer.close();
		
		String fileName = file.toString();

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
		 
			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
