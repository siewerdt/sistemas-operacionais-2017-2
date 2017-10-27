package modelos;

public class Processo {

	public int tempoChegada;
	public int idProcesso;
	public int burstTime;
	public int prioridade;
	public int estado; //0 - novo, 1 - pronto, 2 - em execucao, 3 - em espera, 4 - terminado
	
	public Processo(int tempoChegada, int idProcesso, int burstTime, int prioridade) {
		this.tempoChegada = tempoChegada;
		this.idProcesso = idProcesso;
		this.burstTime = burstTime;
		this.prioridade = prioridade;
		this.estado = 0;
	}
	
}