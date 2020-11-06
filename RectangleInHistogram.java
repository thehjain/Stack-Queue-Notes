//Here we have given a histogram in form of an array
//and we have to find the maximum area that can be
//formed by rectangle in histogram.

//Basic approach is using two loops and check every rectangle
//area.

//Another efficeint approach is using divide and conquer and
//segment tree to get time complexity of O(nlogn).But still it
//is not very much efficient.

//Fastest and best approach is using stack. We can get the time
//complexity of O(n).

public int largestRectangleArea(int[] heights) {
	int n = heights.length;
	if (n == 0) return 0;
	int maxArea = 0, area = 0;
	int i = 0;
	Deque<Integer> stack = new LinkedList<>();
	while (i < n) {
		if (stack.isEmpty() || heights[stack.peekFirst()] <= heights[i])
			stack.offerFirst(i++);
		else {
			int top = stack.pollFirst();
			if (stack.isEmpty())
				area = heights[top] * i;
			else
				area = heights[top] * (i - stack.peekFirst() - 1);
			maxArea = Math.max(maxArea, area);
		}
	}
	while (!stack.isEmpty()) {
		int top = stack.pollFirst();
		if (stack.isEmpty())
			area = heights[top] * i;
		else
			area = heights[top] * (i - stack.peekFirst() - 1);
		maxArea = Math.max(maxArea, area);
	}
	return maxArea;
}


//Problem is available on leetcode and geeksforgeeks