package main;

import java.util.concurrent.Semaphore;

public class Escritor extends Thread {
	private int idThread;
	private Semaphore mutexWriter;

	public Escritor(int idThread, Semaphore mutexWriter) {
		this.idThread = idThread;
		this.mutexWriter= mutexWriter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				mutexWriter.acquire();
				escreverDados();
				mutexWriter.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void escreverDados() throws InterruptedException {
		System.out.println("Thread Escritora #" + idThread + " Escrevendo dados...");
		Thread.sleep((long)(Math.random() * 1000));
	}
}
