package za.co.julianwolf;

public class Simulator
{
	public static void main(String[] args) {
		if (args.length == 0)
			return;
		Parse(args[0]);
	}

	private static void Parse(String file)
	{
		System.console().printf("FILE :: %s", file);
	}
}