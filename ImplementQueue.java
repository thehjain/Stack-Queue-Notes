//Implementation of Queue using array and linked list


class ImplementQueue {
	public static void main(String[] args) {

		Queue queue = new Queue(5);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println(queue.dequeue()
		                   + " dequeued from queue\n");

		System.out.println("Front item is "
		                   + queue.front());

		System.out.println("Rear item is "
		                   + queue.rear());

	}
}

class Queue {

	int front, rear, size;
	int[] arr;
	int capacity;

	Queue(int capacity) {
		arr = new int[capacity];
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1;
	}

	boolean isFull(Queue queue) {
		return (queue.size == queue.capacity);
	}

	boolean isEmpty( Queue que) {
		return (que.size == 0);
	}

	int dequeue() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		int item = this.arr[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;
		return item;
	}

	int front() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		return this.arr[this.front];
	}

	int rear() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		return this.arr[this.rear];
	}

	void enqueue(int item) {
		if (isFull(this)) {
			return;
		}
		this.rear = (this.rear + 1) % this.capacity;
		this.arr[this.rear] = item;
		this.size = this.size + 1;
		System.out.println(item + " enqueued to queue");
	}


}


//Queue implementation using Linked List

class Node {
	int key;
	Node next;
	Node(int key) {
		this.key = key;
		this.next = null;
	}
}

class Queue {
	Node front, rear;

	Queue() {
		this.rear = this.front = null;
	}

	void enqueue(int key) {
		Node temp = new Node(key);
		if (this.rear == null) {
			this.front = this.rear = temp;
			return;
		}
		this.rear.next = temp;
		this.rear = temp;
	}

	void dequeue() {
		if (this.front == null)
			return;
		Node temp = this.front;
		this.front = this.front.next;
		if (this.front == null)
			this.rear = null;
	}

}

class ImplementQueue {

	public static void main(String[] args) {

		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		System.out.println("Queue Front : " + q.front.key);
		System.out.println("Queue Rear : " + q.rear.key);

	}

}

//Problem is available on geeksforgeeks