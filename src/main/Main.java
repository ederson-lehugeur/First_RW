package main;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		NumberReader numberReader = new NumberReader();
		Semaphore mutexWriter = new Semaphore(1);
		Semaphore mutexRead = new Semaphore(1);

		Leitor leitor1 = new Leitor(1, numberReader, mutexWriter, mutexRead);
		Leitor leitor2 = new Leitor(2, numberReader, mutexWriter, mutexRead);
		Leitor leitor3 = new Leitor(3, numberReader, mutexWriter, mutexRead);
		Leitor leitor4 = new Leitor(4, numberReader, mutexWriter, mutexRead);
		Leitor leitor5 = new Leitor(5, numberReader, mutexWriter, mutexRead);
		Leitor leitor6 = new Leitor(6, numberReader, mutexWriter, mutexRead);
		Leitor leitor7 = new Leitor(7, numberReader, mutexWriter, mutexRead);
		Leitor leitor8 = new Leitor(8, numberReader, mutexWriter, mutexRead);
		Leitor leitor9 = new Leitor(9, numberReader, mutexWriter, mutexRead);
		Leitor leitor10 = new Leitor(10, numberReader, mutexWriter, mutexRead);
		Leitor leitor11 = new Leitor(11, numberReader, mutexWriter, mutexRead);
		Leitor leitor12 = new Leitor(12, numberReader, mutexWriter, mutexRead);
		Escritor escritor1 = new Escritor(1, mutexWriter);
		Escritor escritor2 = new Escritor(2, mutexWriter);
		Escritor escritor3 = new Escritor(3, mutexWriter);
		Escritor escritor4 = new Escritor(4, mutexWriter);
		Escritor escritor5 = new Escritor(5, mutexWriter);

		escritor1.start();
		escritor2.start();
		leitor1.start();
		escritor3.start();
		leitor2.start();
		leitor3.start();
		leitor4.start();
		leitor5.start();
		escritor4.start();
		leitor6.start();
		leitor7.start();
		leitor8.start();
		leitor9.start();
		escritor5.start();
		leitor10.start();
		leitor11.start();
		leitor12.start();
	}
}
