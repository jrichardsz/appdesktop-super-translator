package com.rnasystems.projects.translator.common.util;

import java.io.*;
import java.net.*;

public class ImageDownloader{

	public static String download(String urlImagen) throws IOException{
		 URL url = new URL(urlImagen);
		 InputStream in = new BufferedInputStream(url.openStream());
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 byte[] buf = new byte[1024];
		 int n = 0;
		 while (-1!=(n=in.read(buf)))
		 {
		    out.write(buf, 0, n);
		 }
		 out.close();
		 in.close();
		 byte[] response = out.toByteArray();
		 
		 File temp = File.createTempFile("captcha", ".jpg"); 
		 
		 FileOutputStream fos = new FileOutputStream(temp);
		 fos.write(response);
		 fos.close();	
		 
		 return temp.getAbsolutePath();
	}
	   
}
