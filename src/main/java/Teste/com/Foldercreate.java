package Teste.com;

import java.io.File;

public class Foldercreate {
	
		
		 public static void main(String[] args) {
		        createFolder("src/test/resources/testdata");
		    }

		    public static void createFolder(String folderPath) {
		        File folder = new File(folderPath);

		        if (!folder.exists()) {
		            if (folder.mkdirs()) {
		                System.out.println("Folder created successfully!");
		            } else {
		                System.out.println("Failed to create the folder!");
		            }
		        } else {
		            System.out.println("Folder already exists!");
		        }
		    }
		}
		
