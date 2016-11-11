package provaBridge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileSystem implements Implementatore {

	@Override
	public void saveFile(String s) {
		ArrayList<String> l = new ArrayList<String>();
		l.add(s);
		try {
			Files.write(Paths.get("src/provaBridge/file.txt"), l);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
