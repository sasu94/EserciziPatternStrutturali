package provaProvy;

import java.util.ArrayList;
import java.util.List;

public abstract class StrutturaDati {
	List<String> s = new ArrayList<>();

	public StrutturaDati() {
		s.add("ciao");
		s.add("come");
		s.add("stai");

	}

	public abstract void add(String s);

	public abstract List<String> getList();

}
