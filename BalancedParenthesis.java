//Here we have give the string containing difference kind of
//parenthesis and brackets.

//We have to check if is present in right way or it makes
//any sense. It can be easily done using stack.


boolean isValid(String s) {

	Deque<Character> stack = new ArrayDeque<>();

	for (int i = 0; i < s.length(); i++) {
		char x = s.charAt(i);

		if (x == '(' || x == '[' || x == '{') {
			// Push the element in the stack
			stack.push(x);
			continue;
		}
		if (stack.isEmpty())
			return false;
		char check;
		switch (x) {
		case ')':
			check = stack.pop();
			if (check == '{' || check == '[')
				return false;
			break;

		case '}':
			check = stack.pop();
			if (check == '(' || check == '[')
				return false;
			break;

		case ']':
			check = stack.pop();
			if (check == '(' || check == '{')
				return false;
			break;
		}
	}
	return (stack.isEmpty());
}

//Problem is available both on leetcode and geeksforgeeks