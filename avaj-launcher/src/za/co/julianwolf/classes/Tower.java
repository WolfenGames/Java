package za.co.julianwolf.classes;

import za.co.julianwolf.interfaces.Flyable;
import za.co.julianwolf.logger.MyLogger;

import java.util.ArrayList;

public class Tower
{
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();
	public void register(Flyable flyable)
	{
		if (flyable != null && !this.observers.contains(flyable))
		{
			this.observers.add(flyable);
			flyable.registerTower((WeatherTower)this);
			MyLogger.getLogger().log("Flyable added to weatherTower");
		}
	};

	public void unregister(Flyable flyable)
	{
		if (this.observers.contains(flyable))
			this.observers.remove(flyable);
	};
	public void conditionsChanged()
	{
		for (Flyable flyable : this.observers) {
			flyable.updateConditions();
		}
	}
}
