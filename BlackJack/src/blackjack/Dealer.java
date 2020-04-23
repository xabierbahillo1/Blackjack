package blackjack;
import java.util.Scanner;

public class Dealer extends Jugador {

	public Dealer() {
		super(7);
	}
	protected void queQuieresHacer() {
		boolean juego=false;
		while (juego==false) {
			   try {
		            //PARA DURANTE TRES SEGUNDOS EL PROGRAMA PARA PODER IR VIENDOLO
		            Thread.sleep(3*1000);
		         } catch (Exception e) {
		            System.out.println(e);
		         }
			int puntuacion=super.calcularPuntuacionTotal();
			if (puntuacion<=16) {
				System.out.println("El dealer pide carta");
				super.pedirCarta();
				System.out.println("La puntuacion del dealer es de "+this.calcularPuntuacionTotal());
			}
			else {
				if (puntuacion>21) {
					System.out.println("El Dealer se ha pasado");
				}
				else {
					this.plantarse();
				}
				juego=true;
			}
		} //fin while
	}
	protected void imprimeQuienSoy() {
		System.out.println("Es el turno del dealer");
	}
	protected void plantarse() {
		System.out.println("El dealer se ha plantado");
	}
}
