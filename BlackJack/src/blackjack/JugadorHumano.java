package blackjack;

//import Teclado;

public class JugadorHumano extends Jugador{
	//ATRIBUTOS
	
	//CONSTRUCTORA
	
	public JugadorHumano(int pIdJugador) {
		super(pIdJugador);
	}
	//METODOS
	protected void queQuieresHacer() {
		boolean juego=false;
		while (juego==false) {
			//JUEGO
			System.out.println("Que quieres hacer?");
			System.out.println("Pulsa 1 para pedir carta");
			System.out.println("Pulsa 2 para plantarte");
			String entrada="";
			try {
				entrada = Teclado.getTeclado().leerString();
			} catch (CaracterIncorrectoException e) {
				System.out.println("Has introducido un valor incorrecto");
				System.out.println("Vuelve a intentarlo, recuerda que solo puedes introducir los valores 1 o 2");
			}
			if (entrada.equals("1")) {
				//PIDE CARTA
				super.pedirCarta();
				int puntuacion=super.calcularPuntuacionTotal();
				System.out.println("Puntuacion= "+puntuacion);
				if(puntuacion>21) {
					System.out.println("Te has pasado");
					juego=true;
				}
			}
			else if (entrada.equals("2")) {
				//SE PLANTA
				this.plantarse();
				juego=true;
			}
		}
	}
	protected void imprimeQuienSoy() {
		System.out.println("Hola jugador "+super.getID());
	}
	protected void plantarse() {
		System.out.println("Te has plantado");
	}
}
