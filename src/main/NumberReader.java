package main;

public class NumberReader {
	private int readCount;

	public NumberReader() {
		this.readCount = 0;
	}

	public int getReadCount() {
		return readCount;
	}

	public void addReadCount() {
		readCount++;
	}

	public void decReadCount() {
		readCount--;
	}
}
