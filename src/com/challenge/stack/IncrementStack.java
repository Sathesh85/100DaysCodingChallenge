package com.challenge.stack;

public class IncrementStack {
	
	public static void main(String[] args) {
		IncrementStack s = new IncrementStack(3);
		s.push(1);
		s.push(2);
		System.out.println(s.pop());
		s.push(2);
		s.push(3);
		s.push(4);
		s.increment(5, 100);
		s.increment(2, 100);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

	}

	int[] stack;
	int currSize = -1;
	int maxSize;

	public IncrementStack(int maxSize) {
		stack = new int[maxSize];
		this.maxSize = maxSize;
	}

	public void push(int x) {
		if (currSize < maxSize-1) {
			stack[++currSize] = x;
		}
	}

	public int pop() {
		if (currSize >= 0) {
			int val = stack[currSize];
			stack[currSize--] = 0;
			return val;
		} else {
			return -1;
		}

	}

	public void increment(int k, int val) {
		if (currSize >= 0) {
			int temp = (k>currSize)? currSize%k : k-1;
			while (temp >= 0) {
				stack[temp] = stack[temp] + val;
				temp--;
			}

		}
	}

}
