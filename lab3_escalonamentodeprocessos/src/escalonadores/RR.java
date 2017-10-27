package escalonadores;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import modelos.Processo;

public class RR {

	Queue<Processo> fila = new PriorityQueue<Processo>();
	ArrayList<Processo> resultadoProcessos = new ArrayList<Processo>();
	int quantum = 0;
	int tempoPassado = -1;

	public void selecionarQuantum(int n) {
		this.quantum = n;
	}

	// This method gets the first element of the queue, and then increments
	// tempoPassado variable according to process burst time or quantum.
	// Then the executing is recorded on a results array, called listaProcessos.

	public void executarProcesso() {

		if (this.fila.peek() == null)
			this.tempoPassado = this.tempoPassado + this.quantum;

		else {
			Processo processo = this.fila.poll();

			if (this.tempoPassado == -1) // First process to arrive at the processor.
				this.tempoPassado = processo.tempoChegada;

			if (processo.burstTime <= this.quantum) {
				this.tempoPassado = this.tempoPassado + processo.burstTime;
				this.resultadoProcessos.push(processo);
			}

			else {
				this.tempoPassado = this.tempoPassado + this.quantum;
				Processo tempProc = new Processo(processo.tempoChegada, processo.idProcesso, this.quantum,
						processo.prioridade);
				this.resultadoProcessos.push(tempProc);
			}
		}
	}

	public ArrayList<Processo> executar(ArrayList<Processo> listaOrdenada) {
		Processo p1 = listaOrdenada.pop();
		this.fila.offer(p1);
		this.executarProcesso();
		while (this.fila.peek() != null) {

			int i = 0;
			boolean chegouProcesso = false;
			int processosARetirar = 0;

			while (!chegouProcesso) {
				if (listaOrdenada[i].tempoChegada <= this.tempoPassado && i < listaOrdenada.length()) {
					processosARetirar++;
					i++;
				} else {
					chegouProcesso = true;
				}
			}
			while (processosARetirar > 0) {
				this.fila.offer(listaOrdenada.pop()); // Puts all the processes that have arived on the queue
				processosARetirar--;
			}

			this.executarProcesso();

		}
	}
}