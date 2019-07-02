package za.co.julianwolf.singleton;

import za.co.julianwolf.classes.Coordinates;

public final class WeatherProvider
{
	private static final WeatherProvider weatherProvider = new WeatherProvider();
	private String weather;
	private WeatherProvider(){}
	public static WeatherProvider getProvider() { return weatherProvider; }
	public String getCurrentWeather(Coordinates coordinates) { return weather; };
}