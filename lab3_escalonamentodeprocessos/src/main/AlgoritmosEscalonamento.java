package main;

import java.util.ArrayList;
import java.util.Collections;

import escalonadores.FCFS;
import escalonadores.Priority;
import escalonadores.PriorityP;
import escalonadores.RR;
import escalonadores.SJF;
import escalonadores.SJFP;
import modelos.Estatisticas;
import modelos.Processo;

public class AlgoritmosEscalonamento {

	public static void escalonarProcessos(int algoritmo, ArrayList<Processo> processosDesordenados,
			Estatisticas arqEstatisticas) {

		// 1 - FSFC, 2 - SJF, 3 - SJFP, 4 - Priority, 5 - PriorityP, 6 - RR
		switch (algoritmo) {
		// FSFC
		case 1:
			FCFS comparatorFCFS = new FCFS();
			Collections.sort(processosDesordenados, comparatorFCFS);
			for (Processo p : processosDesordenados) {
				arqEstatisticas.tempoAtual ++;
				
				int tempoCPUAguardando = arqEstatisticas.tempoAtual - p.tempoChegada;

				// processo esta no estado pronto aguardando a execucao do predecessor
				if (p.tempoChegada <= arqEstatisticas.tempoAtual) {
					// fica so uma vez em pronto ate ser executado
					arqEstatisticas.somatorioTempoEspera += arqEstatisticas.tempoAtual - p.tempoChegada;
					arqEstatisticas.somatorioTempoResposta += arqEstatisticas.tempoAtual - p.tempoChegada;
					arqEstatisticas.tempoAtual = arqEstatisticas.tempoAtual + p.burstTime;
				} 
				// processo ainda nao chegou, deixando a CPU inutilizada
				else {
					arqEstatisticas.somatorioTempoEspera += 0;
					arqEstatisticas.somatorioTempoResposta += 0;
					arqEstatisticas.tempoAtual = arqEstatisticas.tempoAtual + tempoCPUAguardando + p.burstTime;
				}

				arqEstatisticas.somatorioThroughput += 1;

				arqEstatisticas.somatorioTurnaround += arqEstatisticas.tempoAtual - p.tempoChegada;

				// a troca de contexto sera igual a zero porque os processos vao direto para o
				// estado pronto logo no seu tempo de chegada e ficam aguardando sua vez
				// sequencialmente e sem interrupcoes
				arqEstatisticas.somatorioTrocaContexto = 0;
			}
			break;

		// SJF
		case 2:
			SJF comparatorSJF = new SJF();
			Collections.sort(processosDesordenados, comparatorSJF);
			for (Processo p : processosDesordenados) {
arqEstatisticas.tempoAtual ++;
				
				int tempoCPUAguardando = arqEstatisticas.tempoAtual - p.tempoChegada;

				// processo esta no estado pronto aguardando a execucao do predecessor
				if (p.tempoChegada <= arqEstatisticas.tempoAtual) {
					// fica so uma vez em pronto ate ser executado
					arqEstatisticas.somatorioTempoEspera += arqEstatisticas.tempoAtual - p.tempoChegada;
					arqEstatisticas.somatorioTempoResposta += arqEstatisticas.tempoAtual - p.tempoChegada;
					arqEstatisticas.tempoAtual = arqEstatisticas.tempoAtual + p.burstTime;
				} 
				// processo ainda nao chegou, deixando a CPU inutilizada
				else {
					arqEstatisticas.somatorioTempoEspera += 0;
					arqEstatisticas.somatorioTempoResposta += 0;
					arqEstatisticas.tempoAtual = arqEstatisticas.tempoAtual + tempoCPUAguardando + p.burstTime;
				}

				arqEstatisticas.somatorioThroughput += 1;

				arqEstatisticas.somatorioTurnaround += arqEstatisticas.tempoAtual - p.tempoChegada;

				// a troca de contexto sera igual a zero porque os processos vao direto para o
				// estado pronto logo no seu tempo de chegada e ficam aguardando sua vez
				// sequencialmente e sem interrupcoes
				arqEstatisticas.somatorioTrocaContexto = 0;
			}
			break;

		// SJFP
		case 3:
			
			for (Processo p : processosDesordenados)
				System.out.println("PROCESSO " + p.idProcesso + ": \tTempo de chegada = " + p.tempoChegada
						+ "\tBurst time = " + p.burstTime + "\t Prioridade = " + p.prioridade);
			break;

		// Priority
		case 4:
			Priority comparatorPriority = new Priority();
			Collections.sort(processosDesordenados, comparatorPriority);
			for (Processo p : processosDesordenados) {
arqEstatisticas.tempoAtual ++;
				
				int tempoCPUAguardando = arqEstatisticas.tempoAtual - p.tempoChegada;

				// processo esta no estado pronto aguardando a execucao do predecessor
				if (p.tempoChegada <= arqEstatisticas.tempoAtual) {
					// fica so uma vez em pronto ate ser executado
					arqEstatisticas.somatorioTempoEspera += arqEstatisticas.tempoAtual - p.tempoChegada;
					arqEstatisticas.somatorioTempoResposta += arqEstatisticas.tempoAtual - p.tempoChegada;
					arqEstatisticas.tempoAtual = arqEstatisticas.tempoAtual + p.burstTime;
				} 
				// processo ainda nao chegou, deixando a CPU inutilizada
				else {
					arqEstatisticas.somatorioTempoEspera += 0;
					arqEstatisticas.somatorioTempoResposta += 0;
					arqEstatisticas.tempoAtual = arqEstatisticas.tempoAtual + tempoCPUAguardando + p.burstTime;
				}

				arqEstatisticas.somatorioThroughput += 1;

				arqEstatisticas.somatorioTurnaround += arqEstatisticas.tempoAtual - p.tempoChegada;

				// a troca de contexto sera igual a zero porque os processos vao direto para o
				// estado pronto logo no seu tempo de chegada e ficam aguardando sua vez
				// sequencialmente e sem interrupcoes
				arqEstatisticas.somatorioTrocaContexto = 0;
			}
			break;

		// PriorityP
		case 5:
			PriorityP comparatorPriorityP = new PriorityP();
			Collections.sort(processosDesordenados, comparatorPriorityP);
			for (Processo p : processosDesordenados)
				System.out.println("PROCESSO " + p.idProcesso + ": \tTempo de chegada = " + p.tempoChegada
						+ "\tBurst time = " + p.burstTime + "\t Prioridade = " + p.prioridade);
			break;
		// RR
		case 6:
			
			for (Processo p : processosDesordenados)
				System.out.println("PROCESSO " + p.idProcesso + ": \tTempo de chegada = " + p.tempoChegada
						+ "\tBurst time = " + p.burstTime + "\t Prioridade = " + p.prioridade);
			break;

		default:
			System.out.println(
					"Número do algoritmo não encontrado!\n1 - FCFS\n2 - SJF\n3 - SJFP\n4 - Priority\n5 - PriorityP\n6 - Round Robin");
			break;
		}

	}

}