package blackjack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Baraja {
	private ArrayList<Carta> cartas;
	private static Baraja miBaraja;
	private Baraja() {
		this.construirBaraja();
	}
	public static Baraja getBaraja() {
		if (miBaraja==null) {
			miBaraja=new Baraja();
		}
		return miBaraja;
	}
	public Carta sacarCarta() {
		//SIEMPRE VA A HABER CARTAS YA QUE TENEMOS UN LIMITE DE 7 USUARIOS POR PARTIDA, CON LO CUAL ES IMPOSIBLE QUEDARSE SIN CARTAS
		return(this.cartas.remove(0)); //Saca la primera carta
	}
	public void resetearBaraja() {
		this.construirBaraja();
	}
	private void construirBaraja() {
		cartas= new ArrayList<Carta>();
		for(int j=0;j<4;j++) {
			//CREO PRIMERO EL AS
			CartaAS laCartaAS= new CartaAS(j);
			cartas.add(laCartaAS);
			//CREO EL RESTO DE CARTAS
			for (int k=2;k<=13;k++) {
				Carta laCarta= new Carta(k,j);
				cartas.add(laCarta);
			} //fin for k
		} //fin for j
	}
	public void barajear() {
		Collections.shuffle(cartas);
	}
	private Iterator<Carta> getIterador(){
		return (this.cartas.iterator());
	}
	public void imprimirBaraja() {
		Iterator<Carta> itr=this.getIterador();
		while (itr.hasNext()) {
			itr.next().imprimirCarta();
		}
	}
}
