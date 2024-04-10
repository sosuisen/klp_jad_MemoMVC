package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	public StringProperty bodyText = new SimpleStringProperty();
	public StringProperty titleText = new SimpleStringProperty();
	
	private String filePath = "memo.txt";
	
	private void load() {
		try {
			String data = Files.readString(Path.of(filePath));
			String[] lines = data.split("\n", 2);
			if (lines.length >= 2) {
				titleText.set(lines[0]);
				bodyText.set(lines[1]);				
			}
			else {
				System.out.println("Invalid file format: " + filePath);				
			}
		} catch (NoSuchFileException e) {
			System.out.println("File not found: " + filePath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			String data = titleText.getValue() + "\n" + bodyText.getValue();
            Files.writeString(Path.of(filePath), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void clear() {
		bodyText.set("");
		titleText.set("");
	}
	
	public Model() {
		load();
	}
	
}
