package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	private int idCarro;
	private Semaphore semaforo;
	private static int sentido;

	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			carroCruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	private String retornaSentido() {
		//pegar o sentido do carro de acordo com o numero.
		switch (this.sentido) {
		case 0:
			return "Norte - Sul";
		case 1:
			return "Sul - Norte";
		case 2:
			return "Leste - Oeste";
		case 3:
			return "Oeste - Leste";
		default:
			this.sentido = 0;
			return "Direção não encontrada";
		}
		
	}
	
	private void carroCruzamento() {
		//varivel para tempo de cruzamento, colocar tempo em randomico para verificar diferentes ordens
		int tempo = (int) (Math.random() * 1000 + 1);
		//pausar a thread		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Exibir carro que cruzou e o sentido
		System.out.println("O " + idCarro + "º carro cruzou de " + retornaSentido());
		this.sentido ++;
	}
}
