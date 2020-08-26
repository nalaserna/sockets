package distribuidos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import java.util.logging.Level;

public class sockets {
	
	public static void main(String[] args) {
		
		
		//IP y puerto del servidor
		final String HOST="192.168.238.128";
		final int PUERTO= 8000;
		DataInputStream in;
		//DataOutputStream out;
		
		
		try {
			Socket sc = new Socket (HOST,PUERTO);
			
			in = new DataInputStream (sc.getInputStream());
			OutputStream out = sc.getOutputStream();
			
			File input_file= new File("./golden.jpg");
			BufferedImage image = ImageIO.read(input_file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);
			out.write(baos.toByteArray());
			out.flush();

			
			sc.close();
			
		} catch	(IOException ex) {
			Logger.getLogger(sockets.class.getName()).log(Level.SEVERE, null, ex);
			
		}
	} 
}