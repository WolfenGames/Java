package za.co.julianwolf.classes;

import za.co.julianwolf.classes.Coordinates;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates coordinates) { 
		return WeatherProvider
			.getProvider()
			.getCurrentWeather(coordinates); 
	}
}