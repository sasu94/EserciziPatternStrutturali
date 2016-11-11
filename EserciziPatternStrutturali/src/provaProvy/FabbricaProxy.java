package provaProvy;

public class FabbricaProxy {

	private static StrutturaDati instance;
	static String type = ProxyList.class.getName();

	public static void init(String s) {
		if (instance == null)
			if (s.equals("a"))
				type = ConcreteList.class.getName();
	}

	private FabbricaProxy() {
	}

	public static StrutturaDati getInstance() {
		if (instance == null)
			try {
				instance = (StrutturaDati) Class.forName(type).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return instance;
	}
}
