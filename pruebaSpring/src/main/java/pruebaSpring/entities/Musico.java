package pruebaSpring.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Musico {
	/*
	 * private Trompeta trompeta;
	 * 
	 * public Musico() { this.trompeta = new Trompeta(); } public void tocar() {
	 * this.trompeta.calentar(); this.trompeta.sonar(); }
	 */
	@Autowired
	private InstrumentoMusical instrumento;


	public void tocar() {
		this.instrumento.tocar();
	}
}
