package blackjack;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaCartas {
	private ArrayList<Carta> misCartas;
	
	public ListaCartas() {
		this.misCartas= new ArrayList<Carta>();
	}
	private int sumarPuntuacion() {
		boolean terminar=false;
		int puntTotal=0;
		while (!terminar) {
			puntTotal=0;
			Iterator<Carta> itr= this.getIterador();
			while(itr.hasNext()) {
				Carta act= itr.next();
				puntTotal=act.sumarPuntuacion(puntTotal);
			}
			if (puntTotal>21 && this.hayAsSinCambiarPuntuacion()) {
				this.cambiarPrimerAsCon11();
			}
			else {
				terminar=true;
			}
		} //fin primer while
		return puntTotal;
	}
	private Iterator<Carta> getIterador(){
		return (this.misCartas.iterator());
	}
	public int obtenerPuntuacion() {
		return(sumarPuntuacion());
	}
	public void anadirCarta(Carta pCarta) {
		misCartas.add(pCarta);
	}
	public void imprimirCartas() {
		System.out.println("Tienes las siguientes cartas:");
		Iterator<Carta> itr= this.getIterador();
		while (itr.hasNext()) {
			Carta act= itr.next();
			act.imprimirCarta();
		}
	}
	public int numCartas() {
		return misCartas.size();
	}
	public void resetearCartas() {
		this.misCartas= new ArrayList<Carta>();
	}
	private boolean hayAsSinCambiarPuntuacion() {
		boolean enc=false;
		Iterator<Carta> itr= this.getIterador();
		while (itr.hasNext() && !enc) {
			Carta act= itr.next();
			if (act.esUnAs()){ //Compruebas que sea un AS
				CartaAS miAs= (CartaAS) act;
				if (!miAs.puntuacionCambiada()){
					//AS NO TIENE PUNTUACION CAMBIADA
					enc=true;
				} //fin if puntuacion
			} //fin if comprobacion
		} //fin if es un as
		return enc;
	}
	private void cambiarPrimerAsCon11() {
		boolean enc=false;
		Iterator<Carta> itr= this.getIterador();
		while (itr.hasNext() && !enc) {
			Carta act= itr.next();
			if (act.esUnAs()){ //Compruebas que sea un AS
				CartaAS miAs= (CartaAS) act;
				if (!miAs.puntuacionCambiada()){
					//AS NO TIENE PUNTUACION CAMBIADA
					miAs.cambiarPuntuaciona1();
					enc=true;
				} //fin if puntuacion
			} //fin if comprobacion
		} //fin if es un as
	}
}
