import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;

public class MinStackDriver {
    public static void main(String[] args)
            throws IOException{
        Scanner s = new Scanner(System.in);
        String results = "_________Stack Tests_________"+
                "\n\nTests in format expected: actual: passed:true/false\n\n";


        //Tests
        // in try catch blocks so even if the test errors
        // we always write a log!


        results += "Empty Constructor test: \n";
        //Empty Constructor Test
        try{
            //code we want to test


           Stack st = new Stack();
           results+= (st.size() == 0) + " Size should be: 0, Actual: " + st.size() +
                   "\n";


        } catch(Exception e){
            //what happens if code throws an error

           results+="ERROR: " + e + "\n";

        }

        //push/size/isEmpty test
        results += "\nPush 2 elements, check both size and IsEmpty, peek to make sure values match: \n";

        try{
            //code we want to test
            Stack<String> pushStack = new Stack<>();
            pushStack.push("element");


            //test size after push
            results+= (pushStack.size() == 1) + " Size should be: 1, Actual: " + pushStack.size() +
                    "\n";

            //test isEmpty after push
            results+= (!pushStack.isEmpty()) + " IsEmpty should return false, Actual: " + pushStack.isEmpty() +
                    "\n";

            //test peek returns pushed element
            results += (pushStack.peek().equals("element")) + " Peek should be: \"element\", Actual: "
                    + pushStack.peek() + "\n";

            //add another element
            pushStack.push("element2");

            //test size after 2nd push
            results+= (pushStack.size() == 2) + " Size should be: 2, Actual: " + pushStack.size() +
                    "\n";

            //test isEmpty after 2nd push
            results+= (!pushStack.isEmpty()) + " IsEmpty should return false, Actual: " + pushStack.isEmpty() +
                    "\n";

            //test peek returns pushed element
            results += (pushStack.peek().equals("element2")) + " Peek should be: \"element2\", Actual: "
                    + pushStack.peek() + "\n\n";

        }catch(Exception e){
            //what happens if code throws an error

            results+="ERROR: " + e + "\n";

        }


        //test peek/pop/size/isEmpty
        results += "\n\nPop 2 elements, check both size and IsEmpty, peek to make sure values match: \n";
        try{
            //code we want to test
            Stack<String> popStack = new Stack<>();
            popStack.push("one");
            popStack.push("two");
            String popped = popStack.pop();


            //pop one element, see if it returns
            results+= (popped.equals("two")) + " Popped element should be: \"two\", Actual: " + popped +
                    "\n";

            //test size after pop
            results+= (popStack.size() == 1) + " Size should be: 1, Actual: " + popStack.size() +
                    "\n";

            //test isEmpty after pop
            results+= (!popStack.isEmpty()) + " IsEmpty should return false, Actual: " + popStack.isEmpty() +
                    "\n";

            //test peek returns pushed pop
            results += (popStack.peek().equals("one")) + " Peek should be: \"one\", Actual: "
                    + popStack.peek() +"\n";

            //remove another element
            popped = popStack.pop();


            //pop one element, see if it returns
            results+= (popped.equals("one")) + " Popped element should be: \"one\", Actual: " + popped +
                    "\n";

            //test size after 2nd pop
            results+= (popStack.size() == 0) + " Size should be: 0, Actual: " + popStack.size() +
                    "\n";

            //test isEmpty after 2nd pop
            results+= (popStack.isEmpty()) + " IsEmpty should return true, Actual: " + popStack.isEmpty() +
                    "\n";
        } catch(Exception e){
            //what happens if code throws an error

            results+="ERROR: " + e + "\n";

        }

        results += "\n\nCatching empty stack exceptions: \n";

        try{
            //code we want to test
            Stack<String> exceptionStack = new Stack<>();
            exceptionStack.push("one");
            exceptionStack.pop();

            //try to pop from an empty stack
            exceptionStack.pop();
            results += "ERROR: Popped from an empty stack\n";

        } catch(Exception e){
            //check if it's the right exception
            if(e instanceof EmptyStackException) {
                results += "true Caught empty stack exception for pop\n";
            } else {
                results += "ERROR: " + e + "\n";
            }

        }

        try{
            //code we want to test
            Stack<String> exceptionStack = new Stack<>();

            //try to peek at an empty stack
            exceptionStack.peek();
            results += "ERROR: Peeked at an empty stack\n";

        } catch(Exception e){
            //what happens if code throws an error
            if(e instanceof EmptyStackException) {
                results += "true Caught empty stack exception for peek\n";
            } else {
                results += "ERROR: " + e + "\n";
            }

        }







        System.out.println("enter log name");
        BufferedWriter writer = new BufferedWriter(new FileWriter(s.nextLine()));
        writer.write(results);

        writer.close();
    }
}
