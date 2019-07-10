package za.co.julianwolf.singleton;

import java.util.Random;
import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.logger.MyLogger;

public final class WeatherProvider
{
	private static WeatherProvider weatherprovider = null;
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider(){}

	public static WeatherProvider getProvider(){
		if (weatherprovider == null)
			weatherprovider = new WeatherProvider();
		return weatherprovider;
	}

	public String getCurrentWeather(Coordinates coordinates){
		Random OneSeedyBoy = new Random();
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		long weatherseed = (long)Math.pow((longitude * latitude - height), 2) * OneSeedyBoy.nextInt(500);

		Random rand = new Random(weatherseed);
		int n = rand.nextInt(4);
		return (weather[n]);
	}
}
