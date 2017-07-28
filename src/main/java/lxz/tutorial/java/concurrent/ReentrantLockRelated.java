package lxz.tutorial.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockRelated {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.unlock();
	}
}
