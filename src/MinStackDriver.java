import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;

public class MinStackDriver {
    public static void main(String[] args)
            throws IOException{
        Scanner s = new Scanner(System.in);
        String results = "_________MinStack Tests_________"+
                "\n\nTests in format expected: actual: passed:true/false\n\n";


        //Tests
        // in try catch blocks so even if the test errors
        // we always write a log!

        //read in new file for tests
        File testFile = new File("tests.txt");

        Scanner fr = new Scanner(testFile);



        results += "Empty Constructor test: \n";
        //Empty Constructor Test
        try{
            //code we want to test


           MinStack st = new MinStack();
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
            MinStack<Integer> pushMinStack = new MinStack<>();
            for(int i = 0; i < 4; i++) {
                int pushed = fr.nextInt();
                int expectedMin = fr.nextInt();
                fr.nextLine();
                pushMinStack.push(pushed);

                //test size after push
                results += (pushMinStack.size() == i + 1) + " Size should be: 1, Actual: " + pushMinStack.size() +
                        "\n";

                //test isEmpty after push
                results += (!pushMinStack.isEmpty()) + " IsEmpty should return false, Actual: " + pushMinStack.isEmpty() +
                        "\n";

                //test if min returns expected element
                results += (pushMinStack.min().compareTo(expectedMin) == 0) + " Peek should be: \"element\", Actual: "
                        + pushMinStack.peek() + "\n";

                //test peek returns pushed element
                results += (pushMinStack.peek().compareTo(pushed) == 0) + " Peek should be: \"element\", Actual: "
                        + pushMinStack.peek() + "\n";
            }




        } catch(Exception e){
            //what happens if code throws an error

            results+="ERROR: " + e + "\n";

        }


        //test peek/pop/size/isEmpty
        results += "\n\nPop 2 elements, check both size and IsEmpty, peek to make sure values match: \n";
        try{
            //code we want to test
            MinStack<String> popMinStack = new MinStack<>();
            popMinStack.push("one");
            popMinStack.push("two");
            String popped = popMinStack.pop();


            //pop one element, see if it returns
            results+= (popped.equals("two")) + " Popped element should be: \"two\", Actual: " + popped +
                    "\n";

            //test size after pop
            results+= (popMinStack.size() == 1) + " Size should be: 1, Actual: " + popMinStack.size() +
                    "\n";

            //test isEmpty after pop
            results+= (!popMinStack.isEmpty()) + " IsEmpty should return false, Actual: " + popMinStack.isEmpty() +
                    "\n";

            //test peek returns pushed pop
            results += (popMinStack.peek().equals("one")) + " Peek should be: \"one\", Actual: "
                    + popMinStack.peek() +"\n";

        } catch(Exception e){
            //what happens if code throws an error

            results+="ERROR: " + e + "\n";

        }

        results += "\n\nCatching empty MinStack exceptions: \n";

        try{
            //code we want to test
            MinStack<String> exceptionMinStack = new MinStack<>();
            exceptionMinStack.push("one");
            exceptionMinStack.pop();

            //try to pop from an empty MinStack
            exceptionMinStack.pop();
            results += "ERROR: Popped from an empty MinStack\n";

        } catch(Exception e){
            //check if it's the right exception
            if(e instanceof EmptyStackException) {
                results += "true Caught empty MinStack exception for pop\n";
            } else {
                results += "ERROR: " + e + "\n";
            }

        }

        try{
            //code we want to test
            MinStack<String> exceptionMinStack = new MinStack<>();

            //try to peek at an empty MinStack
            exceptionMinStack.peek();
            results += "ERROR: Peeked at an empty MinStack\n";

        } catch(Exception e){
            //what happens if code throws an error
            if(e instanceof EmptyStackException) {
                results += "true Caught empty MinStack exception for peek\n";
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
