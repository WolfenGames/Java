package za.co.julianwolf;

import java.io.*;

import za.co.julianwolf.classes.WeatherTower;
import za.co.julianwolf.factory.AircraftFactory;
import za.co.julianwolf.interfaces.Flyable;
import za.co.julianwolf.logger.MyLogger;

public class Main {
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
		AircraftFactory fac = new AircraftFactory();
		WeatherTower wt = new WeatherTower();
		try
		{
			File f = new File(file);
			BufferedReader br = new BufferedReader(new FileReader(f));

			String st;
			while ((st = br.readLine()) != null)
			{
				String[] split = st.split(" ");
				Flyable newFlyable;
				if (split.length == 5 && (newFlyable = fac.newAircraft(split[0],
																		split[1],
																		Integer.parseInt(split[2]),
																		Integer.parseInt(split[3]),
																		Integer.parseInt(split[4]))) != null)
					wt.register(newFlyable);
			}
			br.close();
		} catch (FileNotFoundException e) {
			MyLogger.getLogger().ConsoleLog("File not found :: " + file);
		}
		MyLogger.getLogger().PrintToFile();
	}
}
