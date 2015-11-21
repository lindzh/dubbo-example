package com.linda.dubbo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ByteFileGenerator {
	
	public static boolean genFile(String filename,String content){
		File file = new File(filename);
		try {
			FileUtils.writeStringToFile(file, content, "utf-8");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		ByteFileGenerator.genFile("d:/admin.txt", "admin");
		ByteFileGenerator.genFile("d:/pass.txt", "654321");
	}

}
