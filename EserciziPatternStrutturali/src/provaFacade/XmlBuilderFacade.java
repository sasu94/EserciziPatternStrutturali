package provaFacade;

import java.io.IOException;

import main.Builder;
import main.Director;

public class XmlBuilderFacade {
	public void convertXml(String path, Builder b) {
		Director d = new Director(path, b);
		try {
			d.parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
