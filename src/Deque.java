import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
	
	private class DequeIterator implements Iterator<Item> {
		
		ListNode<Item> current;
		
		public DequeIterator(ListNode<Item> node) {
			this.current=node;
		}

		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			if (hasNext()) {
			Item i = current.getValue();
			current=current.getNext();
			return i;
			}
			else
				throw new java.util.NoSuchElementException();
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}


	private class ListNode<T> {
	    private T value;
	    private ListNode<T> next;
	    private ListNode<T> prev;
	    public ListNode(T val) {
	    	this.value=val;
	    	this.setNext(null);
	    	this.setPrev(null);
	    }
		public ListNode<T> getNext() {
			return next;
		}
		public void setNext(ListNode<T> next) {
			this.next = next;
		}
		public ListNode<T> getPrev() {
			return prev;
		}
		public void setPrev(ListNode<T> prev) {
			this.prev = prev;
		}
		public T getValue() {
			return value;
		}   
	}
	
	private ListNode<Item> head;
	private ListNode<Item> tail;
	private int size;

    public Deque() {
    	this.head=null;
    	this.tail=null;
    	size=0;
    }
    
    public boolean isEmpty() {
    	return (size==0);
    }

    public int size() {
    	return size;
    }

    public void addFirst(Item item) {
    	if (item==null)
    		throw new IllegalArgumentException();
    	ListNode<Item> node = new ListNode<Item>(item);
    	if (size==0) {
    		head=node;
    		tail=node;
    		size++;
    	}
    	else {
    		node.setNext(head);
    		head.setPrev(node);
    		head=node;
    		size++;
    	}
    }

    public void addLast(Item item) {
    	if (item==null)
    		throw new IllegalArgumentException();
    	ListNode<Item> node = new ListNode<Item>(item);
    	if (size==0) {
    		head=node;
    		tail=node;
    		size++;
    	}
    	else {
    		node.setPrev(tail);
    		tail.setNext(node);
    		tail=node;
    		size++;
    	}
    }

    public Item removeFirst() {
    	if(size==0)
    		throw new java.util.NoSuchElementException();
    	ListNode<Item> dummy = head;
    	head=head.getNext();
    	if (head!=null)
    	head.setPrev(null);
    	size--;
    	return dummy.getValue();
    }

    public Item removeLast() {
    	if(size==0)
    		throw new java.util.NoSuchElementException();
    	ListNode<Item> dummy = tail;
    	tail=tail.getPrev();
    	if(tail!=null)
    	tail.setNext(null);
    	size--;
    	return dummy.getValue();
    }

	public Iterator<Item> iterator() {
		
		return new DequeIterator(head);
	}


    // unit testing (required)
    public static void main(String[] args) {
    	Deque<Integer> dq = new Deque<Integer>();
    	dq.addLast(1);
    	dq.addFirst(0);
    	dq.addLast(2);
    	dq.addFirst(10);
    	dq.addLast(3);
    	dq.addFirst(20);
    	dq.addLast(4);
    	dq.addFirst(30);
    	while (!dq.isEmpty()) {
    		System.out.println(dq.removeLast());
    		System.out.println(dq.removeFirst());
    	}
    	
    }


}
