package provaProvy;

import java.util.List;

public class ProxyList extends StrutturaDati {

	@Override
	public void add(String s) {
		throw new RuntimeException();

	}

	@Override
	public List<String> getList() {
		return s;

	}

}
