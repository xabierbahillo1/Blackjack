package blackjack;
import java.util.ArrayList;
import java.util.Iterator;

//import Teclado;

public class ListaJugadores {
	private ArrayList<Jugador> misJugadores;
	
	public ListaJugadores() {
		misJugadores= new ArrayList<Jugador>();

	}
	private Iterator<Jugador> getIterador(){
		return(this.misJugadores.iterator());
	}
	public void jugar() {
		Dealer repartidor= new Dealer();
		misJugadores.add(repartidor); //Anado al dealer
		boolean finDelJuego=false;
		while (!finDelJuego) {
			System.out.println("Barajeando las cartas...");
			Baraja.getBaraja().barajear(); //Barajeo las cartas		
			Iterator<Jugador> itr=this.getIterador();
			while (itr.hasNext()) {
				Jugador j=itr.next();
				j.jugar(); //Mando jugar a cada jugador en la lista
			}
			Jugador ganador= this.obtenerGanador(); //Calculo el ganador
			if (ganador==null) {
				//YA ESTA TRATADO, O HAY EMPATE O SE HAN PASADO TODOS Y YA SE HA IMPRIMIDO POR PANTALLA EL RESULTADO
			}
			else {
				if (ganador.getID()==7) {
					System.out.println("El ganador es el dealer");
				}
				else {
					System.out.println("El ganador es el jugador: "+ganador.getID());
				}
			}
			System.out.println("----------------------------------------");
			System.out.println("�Quieres jugar otra partida?");
			System.out.println("Pulsa 1 para jugar otra partida");
			System.out.println("Pulsa cualquier otro boton para salir del juego");
			String entrada=Teclado.getTeclado().leerStringSinRestriccion();
			if (entrada.equals("1")) {
				this.resetearJuego();
				System.out.println("----------------------------------------");
				System.out.println("Iniciando una nueva partida...");
				  try {
			            //PARA DURANTE CUATRO SEGUNDOS EL PROGRAMA PARA PODER IR VIENDOLO
			            Thread.sleep(4*1000);
			         } catch (Exception e) {
			            System.out.println(e);
			         }
				 System.out.println("----------------------------------------");
			}
			else {
				System.out.println("Has salido del juego");
				finDelJuego=true;
			}
		} //fin del while
	}
	
	private Jugador obtenerGanador() {
		System.out.println("----------------------------------------");
		System.out.println("Calculando ganador...");
		 try {
	            //PARA DURANTE DOS SEGUNDOS EL PROGRAMA PARA PODER IR VIENDOLO
	            Thread.sleep(2*1000);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
		Iterator<Jugador> itr=this.getIterador();
		//TRATAMIENTO EMPATE
		boolean posibleEmpate=false;
		ArrayList<Jugador> empate= new ArrayList<Jugador>();
		//------------------
		int cantMax=0;
		int numCartMax=0;
		Jugador jMax=null;;
		while (itr.hasNext()) {
			Jugador act= itr.next();
			int cantAct= act.calcularPuntuacionTotal();
			int numCartAct= act.getNumCartas();
			if (cantAct<22 && cantAct>cantMax){ //NUEVO GANADOR
				cantMax=cantAct;
				numCartMax=numCartAct;
				jMax=act;
				if (posibleEmpate=true){
					posibleEmpate=false;
					empate= new ArrayList<Jugador>();
				}
			}
			else if (cantAct==cantMax && cantAct<22) { //CASO MISMA PUNTUACION, POSIBILIDAD DE EMPATE
				if (numCartAct<numCartMax) { //tiene menos cartas que el anterior ganador
					cantMax=cantAct;
					numCartMax=numCartAct;
					jMax=act;
					if (posibleEmpate=true){ //si antes de eso habia posibilidad de empate (ej: dos estaban ya empatados)
						posibleEmpate=false;
						empate= new ArrayList<Jugador>(); //NO HAY EMPATE AL FINAL
					}
				}
				else if (numCartAct>numCartMax) {
					//NO HACE NADA (NO GANA AL JUGADOR QUE ESTA ARRIBA PORQUE TIENE MAS CARTAS)
				}
				else if (cantAct==cantMax) { //TIENE MISMA PUNTUACION Y MISMAS CARTAS QUE GANADOR, HAY EMPATE
					empate.add(act);
					empate.add(jMax); //AÑADE EL NUEVO JUGADOR QUE ESTA EMPATADO A UN ARRAY
				}
			}
		}
		if (jMax==null) { //SE HAN PASADO TODOS
			System.out.println("Se han pasado todos los usuarios");
		}
		if (empate.size()!=0) { //HAY EMPATE
			//Trata el empate
			System.out.println("Han empatado los siguientes usuarios");
			Iterator<Jugador> it=empate.iterator();
			while (it.hasNext()) {
				int idact=it.next().getID();
				if (idact==7) { //ha empatado dealer
					System.out.println("Dealer");
				}
				else { //ha empatado otro jugador
					System.out.println("Jugador: "+idact);
				}
			}
			jMax=null;
		}
		return jMax;
	}
	public void anadirJugador(int pIdJugador) {
		if (this.size()<=6) {
			Jugador nuevoJugador= new JugadorHumano(pIdJugador);
			this.misJugadores.add(nuevoJugador);
			System.out.println("Anadido jugador "+pIdJugador);
		}
		else {
			System.out.println("Maximo de Jugadores alcanzados");
		}
	}
	private void resetearJuego() {
		Baraja.getBaraja().resetearBaraja(); //RESETEA LA BARAJA
		//RESETEA LA MANO DE TODOS LOS JUGADORES
		Iterator<Jugador> itr= this.getIterador();
		while (itr.hasNext()) {
			itr.next().resetearMano();
		}
	}
	public int size() {
		return(this.misJugadores.size());
	}
}
