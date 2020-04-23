package blackjack;

public class CartaAS extends Carta{

	public CartaAS(int pIDPalo) {
		super(1, pIDPalo);
	}
	public void cambiarPuntuaciona1() {
		this.setPuntuacion(1);
	}
	public boolean puntuacionCambiada() {
		boolean puntuacion=false;
		if (this.getPuntuacion()==1) {
			puntuacion= true;
		}
		return puntuacion;
	}
}
