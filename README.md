# MinStack

Your task is to write a class that acts like a stack with one new method: ```min```.

Thus, our outline will now look like:
```java

void push(Comparable element)    //add an element
Comparable pop()                 //remove and return the top element
boolean isEmpty()   
int size()

//new method
Comparable min()                 //returns (does not remove) the smallest element in the stack currently

//not required, but common
Comparable peek()                //look at the top element without removing

```

Caveat: All operations must take constant time (e.g. you cannot "dig" though the stack to find the smallest value). You may assume that your class only work with ```Comparable``` objects.
