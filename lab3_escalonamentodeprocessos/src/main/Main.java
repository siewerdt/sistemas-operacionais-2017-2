package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import modelos.Estatisticas;
import modelos.Processo;

public class Main {

	public static void main(String[] args) {
		
		//o .csv deve estar na pasta principal do projeto
		String arquivoCSV = args[0];
		//1 - FSFC, 2 - SJF, 3 - SJFP, 4 - Priority, 5 - PriorityP, 6 - RR
		int algEscalonamento = Integer.parseInt(args[1]); 
		int quantum = 0;
		// quantum = Integer.parseInt(args[2]);
		
		//lendo arquivo csv
		BufferedReader br = null;
		String linha = "";
		String caractereSeparador = ",";
		
		ArrayList<Processo> processos = new ArrayList<Processo>();

		System.out.println("\nAntes de rodar o algoritmo:\n");
		
		try {
			br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {
				String processo[] = linha.split(caractereSeparador);
				
				Processo p = new Processo(Integer.parseInt(processo[0]), Integer.parseInt(processo[1]), Integer.parseInt(processo[2]), Integer.parseInt(processo[3]));
				processos.add(p);
				System.out.println("PROCESSO " + p.idProcesso + 
						": \tTempo de chegada = " + p.tempoChegada + 
						"\tBurst time = " + p.burstTime + 
						"\tPrioridade = " + p.prioridade);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Estatisticas arquivoEstatisticas = new Estatisticas(algEscalonamento, quantum);
		
		AlgoritmosEscalonamento.escalonarProcessos(algEscalonamento, processos, arquivoEstatisticas);
		
		System.out.println("\nTerminou de rodar o algoritmo!\n");
		
		arquivoEstatisticas.gerarRelatorioEstatistico();

	}	

}