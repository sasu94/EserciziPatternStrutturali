package ProvaComposite;

public class And implements Component {

	@Override
	public int prezzo() {
		return 2;
	}

	@Override
	public void aggiungi(Component c) {

	}

	@Override
	public void rimuovi(Component c) {
	}

	@Override
	public String toString() {
		return "And";
	}
}
