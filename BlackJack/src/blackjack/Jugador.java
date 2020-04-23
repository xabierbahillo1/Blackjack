package blackjack;

public abstract class Jugador {
	//Atributos
	private int idJugador;
	private ListaCartas cartasJugador;
	//Constructora
	public Jugador(int pIdJugador) {
		this.idJugador=pIdJugador;
		this.cartasJugador= new ListaCartas();
	}
	public void jugar() {
		this.imprimeQuienSoy();
		//REPARTO LAS DOS CARTAS INICIALES
		this.repartirCartasIniciales();
		if (this.calcularPuntuacionTotal()==21){
			//CASO BLACKJACK
			System.out.println("BLACKJACK!");
		}
		else {
			//QUE QUIERES HACER
			this.queQuieresHacer();
		}
	}
	protected abstract void queQuieresHacer();
	protected abstract void imprimeQuienSoy();
	private void repartirCartasIniciales() {
			Carta nueva1=Baraja.getBaraja().sacarCarta();
			Carta nueva2=Baraja.getBaraja().sacarCarta();
			this.anadirCarta(nueva1);
			this.anadirCarta(nueva2);
			this.cartasJugador.imprimirCartas();
			System.out.println("Tu puntuacion es: "+this.calcularPuntuacionTotal());
	}
	protected void pedirCarta() {
		Carta nueva=Baraja.getBaraja().sacarCarta();
		nueva.imprimirCarta();
		this.anadirCarta(nueva);
	}
	protected abstract void plantarse();
	public int calcularPuntuacionTotal() {
		return(cartasJugador.obtenerPuntuacion());
	}
	protected int getID(){
		return(this.idJugador);
	}
	private void anadirCarta(Carta pCarta) {
		this.cartasJugador.anadirCarta(pCarta);
	}
	public int getNumCartas() {
		return(cartasJugador.numCartas());
	}
	public void resetearMano() {
		this.cartasJugador.resetearCartas();
	}
}
