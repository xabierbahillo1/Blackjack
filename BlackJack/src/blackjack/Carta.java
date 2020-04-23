package blackjack;

public class Carta {
	private int numero;
	private String palo;
	private int puntuacion;
	
	public Carta(int pNumero, int pIDPalo) {
		this.numero=pNumero;
		//Calculamos el palo
		if (pIDPalo==0){
			this.palo="Picas";
		}
		else if (pIDPalo==1){
			this.palo="Corazones";
		}
		else if (pIDPalo==2){
			this.palo="Rombos";
		}
		else if (pIDPalo==3){
			this.palo="Treboles";
		}
		this.puntuacion=this.calcularPuntuacion();
	}
	private int calcularPuntuacion() {
		int puntuacion;
		if (this.numero==11||this.numero==12||this.numero==13) {
			puntuacion=10;
		}
		else if (this.numero==1) {
			puntuacion=11;
		}
		else {
			puntuacion=this.numero;
		}
		return puntuacion;
	}
	public int sumarPuntuacion(int pAct) {
		return (this.puntuacion+pAct);
	}
	public void imprimirCarta() {
		char letra;
		if (this.numero==10) {
			System.out.println("10 "+palo);
		}
		else {
			if (this.numero==11){
				letra='J';
			}
			else if (this.numero==12){
				letra='Q';
			}
			else if (this.numero==13){
				letra='K';
			}
			else {
				letra=(char) (48+numero);
			}
			System.out.println(letra+ " "+palo);
		}
	}
	protected void setPuntuacion(int pPuntuacion) {
		this.puntuacion=pPuntuacion;
	}
	protected int getPuntuacion() {
		return this.puntuacion;
	}
	public boolean esUnAs() {
		boolean respuesta=false;
		if (this instanceof CartaAS){
			respuesta=true;
		}
		return respuesta;
	}
}
