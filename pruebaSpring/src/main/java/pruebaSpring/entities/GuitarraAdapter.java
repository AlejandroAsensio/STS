package pruebaSpring.entities;

public class GuitarraAdapter implements InstrumentoMusical {

	private Guitarra guitarra;

	public GuitarraAdapter() {
		this.guitarra = new Guitarra();
	}

	public void tocar() {
		this.guitarra.rasgar();
	}
}
