package ProvaComposite;

public class Not implements Component {

	@Override
	public int prezzo() {
		return 1;
	}

	@Override
	public void aggiungi(Component c) {
	}

	@Override
	public void rimuovi(Component c) {
	}

	@Override
	public String toString() {
		return "Not";
	}

}
