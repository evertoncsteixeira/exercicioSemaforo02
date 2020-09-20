package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCarro;

public class Principal {

	public static void main(String[] args) {
		//Pegar numero de permissoes para cruzamento
				int permissoes = 1;
				Semaphore semaforo = new Semaphore(permissoes);
				//rodar as 4 thread para simular os carros 
				for (int i = 1; i < 5; i++ ){
					Thread tCarro = new ThreadCarro(i, semaforo);
					tCarro.start();
				}
	}

}
