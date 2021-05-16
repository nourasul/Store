/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Noura Suliman Alsuliman ,439019013 ,376
package store;

/**
 *
 * @author nourasul
 */
public class Queue<E> {
    private DLL<E> buf;

	public Queue() {
		buf = new DLL<E>();
	}

	public void enqueue(E e) {
		buf.addLast(e);
	}

	public E dequeue() {
		return buf.removeFirst();
	}

	public E first() {
		return buf.first();
	}

	public int size() {
		return buf.size();
	}

	public boolean isEmpty() {
		return buf.isEmpty();
	}

	public void print() {
		buf.print();
	}
}
