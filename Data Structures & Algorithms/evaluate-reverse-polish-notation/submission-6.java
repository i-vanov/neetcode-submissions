class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String s : tokens) {
                if (s.equals("+")) {
                    deque.push(deque.pop() + deque.pop());
                } else if (s.equals("-")) {
                    int b = deque.pop();
                    int a = deque.pop();
                    deque.push(a - b);
                } else if (s.equals("*")) {
                    deque.push(deque.pop() * deque.pop());
                } else if (s.equals("/")) {
                    int b = deque.pop();
                    int a = deque.pop();
                    deque.push(a / b);
                } else {
                    deque.push(Integer.parseInt(s));
                }
        }
        return deque.pop();
    }
}
