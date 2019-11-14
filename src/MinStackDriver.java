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
            results+= (st.isEmpty()) + " IsEmpty should be: true, Actual: " + st.isEmpty() +
                    "\n";


        } catch(Exception e){
            //what happens if code throws an error

           results+="ERROR: " + e + "\n";

        }

        int keepGoing = 0;

        //create min stack for peek and pop tests
        MinStack testMinStack = new MinStack();

        //loop for peek and pop tests, two settings: one for pop and one for push
        while(fr.hasNextLine() && keepGoing < 2) {
            String nextLine = fr.nextLine();
        //test.txt format: element expectedMin expectedSize expectedEmpty, \n in between sets of tests (push and pop)
            String element;
            String expectedMin;
            String expectedSize;
            String expectedEmpty;

            //if there's a break, count up
            if(nextLine.equals("")) {
                keepGoing++;
            } else {
                String[] nums = nextLine.split(" ");
                element = nums[0];
                expectedMin = nums[1];
                expectedSize = nums[2];
                expectedEmpty = nums[3];


                results += "\nElement: " + element + " min: " + expectedMin + " size: " + expectedSize + " empty: " +
                        expectedEmpty;


                if (keepGoing == 0) {
                    //push/size/isEmpty test --> reading in an element to push, an expected min, isEmpty, and size
                    results += "\n\nPush elements from file, check both size and IsEmpty, peek to make sure values " +
                            "match: " + "\n";

                    try {
                        //code we want to test


                        testMinStack.push(element);

                        //test peek returns pushed element
                        results += (testMinStack.peek().compareTo(element) == 0) + " Peek should be: " + element +
                                " Actual: " + testMinStack.peek() + "\n";

                        //test if min returns expected element
                        results += (testMinStack.min().compareTo(expectedMin) == 0) + " min should be: " + expectedMin +
                                ", " + " Actual: " + testMinStack.min() + "\n";

                        //test size after push
                        results += ((testMinStack.size() + "").equals(expectedSize)) + " Size should be: " +
                                expectedSize + " Actual: " + testMinStack.size() + "\n";

                        //test isEmpty after push
                        results += ((testMinStack.isEmpty() + "").equals(expectedEmpty)) + " IsEmpty should return " +
                                expectedEmpty + " Actual: " + testMinStack.isEmpty() + "\n";

                    } catch (Exception e) {
                        //what happens if code throws an error

                        results += "ERROR: " + e + "\n";

                    }

                } else if (keepGoing == 1) {
                    //reading in an element to pop, an expected min, and an expected peek value 3 times
                    results += "\n\nPop elements from stack, check both size and IsEmpty, peek to make sure values " +
                            "match: " + "\n";
                    try {

                        Comparable popped = testMinStack.pop();

                        //test if pop returns expected element
                        results += (popped.compareTo(element) == 0) + " popped should be: " + element + ", " +
                                "Actual: " + popped + "\n";

                        if (!testMinStack.isEmpty()) {
                            //test if min returns expected element
                            results += (testMinStack.min().compareTo(expectedMin) == 0) + " min should be: " +
                                    expectedMin + ", " + "Actual: " + testMinStack.min() + "\n";
                        }

                        //test size after pop
                        results += ((testMinStack.size() + "").equals(expectedSize)) + " Size should be: " +
                                expectedSize + " Actual: " + testMinStack.size() + "\n";

                        //test isEmpty after pop
                        results += ((testMinStack.isEmpty() + "").equals(expectedEmpty)) + " IsEmpty should return " +
                                expectedEmpty + " Actual: " + testMinStack.isEmpty() + "\n";


                    } catch (Exception e) {
                        //what happens if code throws an error

                        results += "ERROR: " + e + "\n";

                    }

                }
            }
        }


        //trying to catch exceptions
        results += "\n\nCatching empty MinStack exceptions: \n";

        try{
            //code we want to test
            MinStack exceptionMinStack = new MinStack();
            exceptionMinStack.push("one");
            exceptionMinStack.pop();

            //try to pop from an empty MinStack
            exceptionMinStack.pop();
            results += "ERROR: Popped from an empty MinStack\n";

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
            MinStack exceptionMinStack = new MinStack();

            //try to peek at an empty MinStack
            exceptionMinStack.peek();
            results += "ERROR: Peeked at an empty MinStack\n";

        } catch(Exception e){
            //check if it's the right exception
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
