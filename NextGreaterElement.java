//Here we have given an array and we have to find
//next greater element for every element in array.
//if it is not present for any element we can put -1 for it.


//Basic approach is to use two loops and find next greater element
//for every element.

//Efficent appraoch is to use stack.


static void printNGE(int arr[], int n) {
	int i = 0;
	stack s = new stack();
	s.top = -1;
	int element, next;

	/* push the first element to stack */
	s.push(arr[0]);

	// iterate for rest of the elements
	for (i = 1; i < n; i++) {
		next = arr[i];

		if (s.isEmpty() == false) {

			// if stack is not empty, then
			// pop an element from stack
			element = s.pop();

			/* If the popped element is smaller than
			   next, then a) print the pair b) keep
			   popping while elements are smaller and
			   stack is not empty */
			while (element < next) {
				System.out.println(element + " --> " + next);
				if (s.isEmpty() == true)
					break;
				element = s.pop();
			}

			/* If element is greater than next, then
			   push the element back */
			if (element > next)
				s.push(element);
		}

		/* push next to stack so that we can find next
		   greater for it */
		s.push(next);
	}

	/* After iterating over the loop, the remaining
	           elements in stack do not have the next greater
	           element, so print -1 for them */
	while (s.isEmpty() == false) {
		element = s.pop();
		next = -1;
		System.out.println(element + " -- " + next);
	}
}

//Problem is available on geeksforgeeks