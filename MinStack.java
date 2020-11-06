//Here we have to design Special kind of stack
//which will getMin() operation in O(1).

//Approach is to don't store elements in stack
//in normal way.


// We define a variable minEle that stores the current minimum element in the stack.
//  Now the interesting part is, how to handle
//  the case when minimum element is removed.
//  To handle this, we push “2x – minEle” into the
//  stack instead of x
//  so that previous minimum element can be retrieved
//  using current minEle and
//  its value stored in stack. Below are detailed steps
//  and explanation of working.

import java.util.*;

class MinStack {

	public static void main(String[] args) {

		MyStack s = new MyStack();
		s.push(3);
		s.push(5);
		s.getMin();
		s.push(2);
		s.push(1);
		s.getMin();
		s.pop();
		s.getMin();
		s.pop();
		s.peek();

	}
}

class MyStack {

	Stack<Integer> s;
	Integer minEle;

	MyStack() {
		s = new Stack<>();
	}

	void getMin() {
		if (s.isEmpty())
			System.out.println("Stack is Empty");
		else
			System.out.println("Minimum Element " + minEle);
	}

	void peek() {
		if (s.isEmpty()) {
			System.out.println("Stack Underflow");
			return;
		}
		Integer temp = s.peek();
		System.out.print("Top most element of stack is ");
		if (temp < minEle)
			System.out.println(minEle);
		else
			System.out.println(temp);
	}

	void pop() {
		if (s.isEmpty()) {
			System.out.println("Stack Underflow ");
			return;
		}
		System.out.print("Top Element removed is ");
		Integer temp = s.pop();
		if (temp < minEle) {
			System.out.println(minEle);
			minEle = 2 * minEle - temp;
		} else
			System.out.println(temp);
	}

	void push(Integer temp) {
		if (s.isEmpty()) {
			minEle = temp;
			s.push(temp);
			System.out.println("Number Inserted " + temp);
			return;
		}
		if (temp < minEle) {
			s.push(2 * temp - minEle);
			minEle = temp;
		} else
			s.push(temp);
		System.out.println("Number Inserted " + temp);
	}

}

//Problem is available on geeksforgeeks