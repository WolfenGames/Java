package za.co.julianwolf.interfaces;

import za.co.julianwolf.classes.WeatherTower;

public interface Flyable
{
	void	updateConditions();
	void	registerTower(WeatherTower weatherTower);
}