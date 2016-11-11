package provaProvy;

import java.util.List;

public class ConcreteList extends StrutturaDati {
	@Override
	public void add(String s) {
		this.s.add(s);

	}

	@Override
	public List<String> getList() {
		return s;

	}
}
