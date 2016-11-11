package provaBridge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;

public class DropBox implements Implementatore {
	private static final String ACCESS_TOKEN = "1dxSmic5db0AAAAAAAAAKcUawPoGDgb-Iuvt02qCpxpJojPl6aEG5VkXq8q5MuaK";

	@Override
	public void saveFile(String s) {
		DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
		DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

		ArrayList<String> l = new ArrayList<String>();
		l.add(s);
		try {
			Files.write(Paths.get("src/provaBridge/file.txt"), l);

			InputStream in = new FileInputStream("src/provaBridge/file.txt");

			FileMetadata metadata = client.files()
					.uploadBuilder("/"
							+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + ".txt")
					.uploadAndFinish(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UploadErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
