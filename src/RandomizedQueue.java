import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private class RandomizedQueueIterator implements Iterator<Item> {
		
		private Item[] iterator;
		private int index;
		private RandomizedQueueIterator(Item[] queue,int size){
			iterator = (Item[])new Object[size];
			for (int i=0; i<size; i++) {
				iterator[i]=queue[i];
			}
			StdRandom.shuffle(iterator);
			index=0;
		}
		@Override
		public boolean hasNext() {
			return (index<iterator.length);
		}

		@Override
		public Item next() {
			if (hasNext()) {
				Item item = iterator[index++];
				return item;
			}
			else {
				throw new java.util.NoSuchElementException();
			}
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
		

	}

	private Item[] array; 
	private int size,capacity;
	
	
    // construct an empty randomized queue
    public RandomizedQueue() {
    	capacity=10;
    	size=0;
    	array = (Item[])new Object[10];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
    	return (size==0);
    }

    // return the number of items on the randomized queue
    public int size() {
    	return size;
    }

    // add the item
    public void enqueue(Item item) {
    	if (item==null)
    		throw new IllegalArgumentException();
    	if (size==capacity)
    		DoubleSize();
    	array[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
    	if (isEmpty())
    		throw new java.util.NoSuchElementException();
    	int randomIndex = StdRandom.uniform(size-1);
    	Item dummy = array[randomIndex];
    	array[randomIndex] = array[size-1];
    	size--;
    	if (size <= capacity/4)
    		CropSize();
    	return dummy;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	if (isEmpty())
    		throw new java.util.NoSuchElementException();
    	return array[StdRandom.uniform(size-1)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
    	return new RandomizedQueueIterator(array,size);
    }
    
    private void DoubleSize() {
    		capacity*=2;
    		Item[] dummy = (Item[])new Object[capacity];
    		for (int i=0 ; i<size ; i++) {
    			dummy[i] = array[i];
    		}
    		array=dummy;
    }
    
    private void CropSize() {
    		capacity/=4;
    		Item[] dummy = (Item[])new Object[capacity];
    		for (int i=0 ; i<size ; i++) {
    			dummy[i] = array[i];
    		}
    		array=dummy;
    }

    // unit testing (required)
    public static void main(String[] args) {}

}
