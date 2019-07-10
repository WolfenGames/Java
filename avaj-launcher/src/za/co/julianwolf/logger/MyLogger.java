package za.co.julianwolf.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public final class MyLogger{
	private static MyLogger logger = new MyLogger();
	private ArrayList<String> aStrings = new ArrayList<String>();

	private MyLogger(){
	}

	public static MyLogger getLogger()
	{
		return logger;
	}

	public void log(String logVal)
	{
		aStrings.add(logVal);
	}

	public void ConsoleLog(String logVal)
	{
		System.console().printf("%s\n", logVal);
	}

	public void PrintToFile()
	{
		try
		{
			if (aStrings.size() == 0)
				return;
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Simulation.txt"));
			for (String s : aStrings) {
				bufferedWriter.write(s);
				bufferedWriter.write("\n");
			}
			bufferedWriter.close();
		} catch (Exception e)
		{
			this.ConsoleLog("Failed to print to file :: " + e);
		}
	}
}
