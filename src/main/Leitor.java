package main;

import java.util.concurrent.Semaphore;

public class Leitor extends Thread {
	private int idThread;
	private NumberReader numberReader;
	private Semaphore mutexWriter;
	private Semaphore mutexRead;

	public Leitor(int idThread, NumberReader readerWriter, Semaphore mutexWriter, Semaphore mutexRead) {
		this.idThread = idThread;
		this.numberReader = readerWriter;
		this.mutexWriter= mutexWriter;
		this.mutexRead = mutexRead;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				mutexRead.acquire();
				if (numberReader.getReadCount() == 0)
					mutexWriter.acquire();
				numberReader.addReadCount();
				mutexRead.release();

				lerDados();

				mutexRead.acquire();
				numberReader.decReadCount();
				if (numberReader.getReadCount() == 0)
					mutexWriter.release();
				mutexRead.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void lerDados() throws InterruptedException {
		System.out.println("Thread Leitora #" + idThread + " Lendo dados...");
		Thread.sleep((long)(Math.random() * 1000));
	}
}
