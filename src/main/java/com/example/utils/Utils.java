package com.example.utils;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class Utils {

	public static void salvarImagem(String caminho, MultipartFile imagem) {
		
		File file = new File(caminho);
		
		try {
			FileUtils.writeByteArrayToFile(file,imagem.getBytes());
			//FileUtils.writeByteArrayToFile(file,imagem.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//e.printStackTrace();
		}
		
	}

}