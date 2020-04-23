package blackjack;

//import Teclado;

public class BlackJack {
	private ListaJugadores jugadores;
	private static BlackJack miBlackJack;
	
	private BlackJack() {
		this.jugadores=new ListaJugadores();
	}
	public static BlackJack getmiBlackJack() {
		if (miBlackJack==null) {
			miBlackJack=new BlackJack();
		}
		return miBlackJack;
	}
	public void jugar() {
		boolean comenzarJuego=false;
		int intentos=3;
		int idJugador=1;
		System.out.println("-------------------------------------");
		System.out.println("Bienvenido al BlackJack!");
		System.out.println("-------------------------------------");
		while (!comenzarJuego && intentos!=0) {
			boolean todoOk=false;
			if (this.numJugadores()<=6) {
				System.out.println("Pulsa 1 para anadir un jugador");
			}
			else {
				System.out.println("No puedes anadir mas jugadores, limite alcanzado");
			}
			System.out.println("Pulsa 2 para comenzar el juego");
			String entrada="";
			try {
				entrada = Teclado.getTeclado().leerString();
				todoOk=true;
				intentos=3;
			} catch (CaracterIncorrectoException e) {
				System.out.println("Has introducido un valor incorrecto");
				intentos--;
				if (intentos==0) {
					System.out.println("Intentos agotados, no se inicia el juego");
				}
				else {
					System.out.println("Vuelve a intentarlo, aun te quedan "+intentos+" intentos");
				}
			}
			if (todoOk==true) {
				if (entrada.equals("1") && this.numJugadores()<=6){
					this.anadirJugador(idJugador);
					idJugador++;
				}
				if (entrada.equals("2")) {
					if (this.numJugadores()==0) {
					System.out.println("No hay jugadores suficientes para comenzar el juego");
				}
				else {
					comenzarJuego=true;
					jugadores.jugar();
				}
			}
			}
		} //fin todoOK
		} //fin metodo
		
	public void anadirJugador(int pIdJugador) {
		jugadores.anadirJugador(pIdJugador);
		
	}
	public int numJugadores() {
		return(this.jugadores.size());
	}
}
