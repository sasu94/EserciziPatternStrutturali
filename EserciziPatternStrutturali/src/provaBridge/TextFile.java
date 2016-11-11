package provaBridge;

public class TextFile {
	String s;
	Implementatore i;

	public TextFile(Implementatore i) {
		this.i = i;
	}

	public void setContent(String s) {
		this.s = s;
	}

	public void saveFile() {
		i.saveFile(s);
	}
}
