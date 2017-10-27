package modelos;

import java.io.PrintWriter;

public class Estatisticas {
	
	public PrintWriter writer;
	
	public int numeroAlgoritmo;
	public String nomeAlgoritmo;
	public int quantum;

	// tempo levado para terminar todos os processos passados na entrada
	public int tempoAtual;

	// quantidade de processos terminados por unidade de tempo
	public int somatorioThroughput; 

	// tempo transcorrido desde o momento que o processo entra e o instante em que ele termina sua execucao
	public int somatorioTurnaround;

	// soma dos periodos de tempo em que o processo estava no seu estado pronto
	public int somatorioTempoEspera; 

	// intervalo entre a chegada ao sistema e o inicio de sua (primeira) execucao
	public int somatorioTempoResposta; 

	// quantidade de vezes que um process eh trocado por outro na execucao
	// (considerando que cada troca de contexto leva 1 unidade de tempo)
	public int somatorioTrocaContexto;

	public int qtdeProcessosExecutados;
	
	public Estatisticas(int numeroAlgoritmo, int quantum) {
		this.numeroAlgoritmo = numeroAlgoritmo;
		this.nomeAlgoritmo = (numeroAlgoritmo == 1) ? "First-Come-First-Served" :
			((numeroAlgoritmo == 2) ? "Shortest-Job-First" :
				((numeroAlgoritmo == 3) ? "Shortest-Job-First Preemptive" : 
					((numeroAlgoritmo == 4) ? "Priority" :
						((numeroAlgoritmo == 5) ? "Priority Preemptive" :
							((numeroAlgoritmo == 6) ? "Round Robin" : "-----INVÁLIDO-----") ) )	) );
		this.quantum = quantum;
		this.tempoAtual = 0;
	}
	
	public void gerarRelatorioEstatistico() {
		
		String nomeArquivo = "estatisticas_" + nomeAlgoritmo + ".txt";
		
		try {
			writer = new PrintWriter(nomeArquivo, "UTF-8");
			
			writer.println("a. Algoritmo: " + nomeAlgoritmo + ((numeroAlgoritmo == 6) ? " - Quantum: " + quantum : ""));
			
			writer.println("\nb. Tempo total de processamento: " + tempoAtual);
			
			int percentualUtilizacaoCPU = (tempoAtual - somatorioTrocaContexto) / tempoAtual;
			writer.println("\nc. Percentual de utilizacao da CPU: " + percentualUtilizacaoCPU);
			
			int mediaThroughput = somatorioThroughput / tempoAtual;
			writer.println("\nd. Media throughput: " + mediaThroughput);
			
			int mediaTurnaround = somatorioTurnaround / tempoAtual;
			writer.println("\ne. Media turnaround: " + mediaTurnaround);
			
			int mediaTempoEspera = somatorioTempoEspera / tempoAtual;
			writer.println("\nf. Media tempo de espera: " + mediaTempoEspera);
			
			int mediaTempoResposta = somatorioTempoResposta / tempoAtual;
			writer.println("\ng. Media tempo de resposta: " + mediaTempoResposta);
			
			int mediaTrocaContexto = somatorioTrocaContexto / tempoAtual;
			writer.println("\nh. Media troca de contexto: " + mediaTrocaContexto);
			
			writer.println("\ni. Numero de processos executados: " + qtdeProcessosExecutados);
			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}