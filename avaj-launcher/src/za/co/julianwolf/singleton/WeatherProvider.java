package za.co.julianwolf.singleton;

import za.co.julianwolf.classes.Coordinates;

public class WeatherProvider
{
	private WeatherProvider weatherProvider;
	private String weather;
	private WeatherProvider(){}
	public WeatherProvider getProvider() { return this.weatherProvider; }
	public String getCurrentWeather(Coordinates coordinates) { return ""; };
}