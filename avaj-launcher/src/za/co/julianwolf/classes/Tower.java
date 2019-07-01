package za.co.julianwolf.classes;

import za.co.julianwolf.interfaces.Flyable;
import java.util.List;

public class Tower
{
	private List<Flyable> observers;
	public void register(Flyable flyable)
	{
		if (!observers.contains(flyable))
			observers.add(flyable);
	};

	public void unregister(Flyable flyable)
	{
		if (observers.contains(flyable))
			observers.remove(flyable);
	};
	public void conditionsChanged()
	{
		
	}
}