package za.co.julianwolf;

import java.io.*;

public class Simulator {
	public static void main(String[] args) {
		if (args.length == 0)
			return;
		try {
			Parse(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void Parse(String file) throws IOException {
		try {
			File f = new File(file); 
  
			BufferedReader br = new BufferedReader(new FileReader(f)); 
			
			String st; 
			while ((st = br.readLine()) != null) 
			  System.out.println(st);
			br.close();
		} catch (FileNotFoundException e) {
			System.console().printf("File not found :: %s\n", file);
		}
	}
}