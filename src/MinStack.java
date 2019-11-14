public class MinStack {
    private Stack<Comparable> stack;
    private Stack<Comparable> min;

    public MinStack(){
        stack = new Stack<>();
        min = new Stack<>();

    }

    //returns void, takes in an element and puts it at the top of the stack, and if it is min, puts it in the min stack
    public void push(Comparable element){
        if(min.isEmpty() || min.peek().compareTo(element) >= 0) {
            min.push(element);
        }
        stack.push(element);
    }

    //returns comparable, no parameters, pops off the top of the stack, and if it is min, pops it in the min stack
    public Comparable pop(){
        if(stack.peek().compareTo(min.peek()) == 0){
            min.pop();
        }
        return stack.pop();
    }


    //returns whether or not the stack is empty, no parameters
    public boolean isEmpty(){
        return stack.isEmpty() && min.isEmpty();
    }

    //returns the int size value, no parameters
    public int size(){
        return stack.size();
    }

    //returns the int min value, no parameters
    public Comparable min(){
        return min.peek();
    }

    //returns the data of the top element on the stack, no parameters
    public Comparable peek(){
        return stack.peek();
    }




}
