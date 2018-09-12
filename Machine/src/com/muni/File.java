package com.muni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class File {
public static void main(String[] args) {
	try(BufferedReader in = new BufferedReader(new FileReader("res\\Sample"))){
		String myString;
		while( (myString = in.readLine()) != null ) {
			System.out.println(" "+myString);
		}
	}catch (Exception e) {
		System.out.println("Exception happenned : "+e.getMessage());
		// TODO: handle exception
	}
	
	try( Stream<String> stream = Files.lines(Paths.get("res\\Sample"))){
		stream.filter(line -> line.contains(" "))
		.map(String::trim)
		.forEach(System.out::println);
	} catch(Exception e) {
		
	}
}
}
