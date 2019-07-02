package za.co.julianwolf;

import java.io.*;
import java.util.UUID;

import za.co.julianwolf.classes.Tower;
import za.co.julianwolf.classes.WeatherTower;
import za.co.julianwolf.factory.AircraftFactory;
import za.co.julianwolf.interfaces.Flyable;

public class Simulator {
	static WeatherTower wt;
	public static void main(String[] args) {
		
		UUID guid = UUID.randomUUID();
		String s = guid.toString();
		
		System.console().printf("%s\n", s);
		if (args.length == 0)
		return;
		try {
			Parse(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void Parse(String file) throws IOException {
		AircraftFactory fac = new AircraftFactory(){};
		try {
			File f = new File(file); 
  
			BufferedReader br = new BufferedReader(new FileReader(f)); 
			
			String st; 
			while ((st = br.readLine()) != null)
			{
				String[] split = st.split(" ");
				Flyable newFlyable;
				if (split.length == 5 && (newFlyable = fac.newAircraft(split[0], split[1], atoi(split[2]), atoi(split[3]), atoi(split[4]))) != null)
					wt.register(newFlyable);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.console().printf("File not found :: %s\n", file);
		}
	}

	public static int atoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
		str = str.trim();
		char flag = '+'; 
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		double result = 0;
	 
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		if (flag == '-')
			result = -result;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) result;
	}
}