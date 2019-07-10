package za.co.julianwolf.classes;

import za.co.julianwolf.classes.Coordinates;
import za.co.julianwolf.singleton.WeatherProvider;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider
			.getProvider()
			.getCurrentWeather(coordinates);
	}
}
