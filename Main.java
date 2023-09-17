public class Main {
    public static void main(String[] args) 
    {
        List MyArray = new Array();

        MyArray.print();
        System.out.println("Searching element in array:");

        int returnedResult = MyArray.search(8);
        if (returnedResult == -1) 
        {
            System.out.println("Not Found");
        } else 
        {
            System.out.printf("Element Found at index: %d\n", returnedResult);
        }

        System.out.println("\n\n");

        MyArray.addToStart(5);

        MyArray.print();

        System.out.println("\n\n");

        MyArray.addToLocation( 6 , 1);

        MyArray.print();

        System.out.println("\n\n");

        MyArray.addToEnd(10);

        MyArray.print();

    }
}

abstract class List 
{
    abstract public void print();

    abstract public int search(int element);

    public void ArraySort() {}

    public void addToStart(int element) {}

    public void addToEnd(int element) {}

    public void UpdateArray(int element, int location) {}

    public void addToLocation(int element , int location) {}

    public void delFromEnd() {}

    public void delFromStart() {}

    public void delFromLocation() {}

 

}

class Array extends List {
    public int[] PassedArray;

    public Array() 
    {
        PassedArray = new int[10];
        int count = 1;
        for (int index = 0; index < PassedArray.length; index++) {
            PassedArray[index] = count;
            count++;
        }
    }

    @Override
    public int search(int element) 
    {
        for (int index = 0; index < PassedArray.length; index++) {
            if (PassedArray[index] == element) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public void print() 
    {
        for (int i : PassedArray) {
            System.out.println(i);
        }
    }

    @Override
    public void addToStart(int element) 
    {
        this.addToLocation(element,0);
    }

    @Override
    public void addToEnd(int element) 
    {
        for (int i = 1; i < PassedArray.length; i++) {
            PassedArray[i - 1] = PassedArray[i];
        }
        PassedArray[PassedArray.length - 1] = element;
    }

    @Override
    public void UpdateArray(int element, int location) 
    {
        PassedArray[location] = element;
    }

    @Override
    public void ArraySort() 
    { // Using bubble Sorting
        int size = PassedArray.length;
        // loop to access each array element
        for (int i = 0; i < (size - 1); i++) {

            // check if swapping occurs
            boolean swapped = false;

            // loop to compare adjacent elements
            for (int j = 0; j < (size - i - 1); j++) {

                // compare two array elements
                if (PassedArray[j] > PassedArray[j + 1]) {
                    // swapping occurs if elements
                    // are not in the intended order
                    int temp = PassedArray[j];
                    PassedArray[j] = PassedArray[j + 1];
                    PassedArray[j + 1] = temp;

                    swapped = true;
                }
            }
            // no swapping means the array is already sorted so no need for further
            // comparison
            if (!swapped)
                break;
        } // End of the inner loop
    } // End of the outer Loop

    public void addToLocation(int element , int location)
    {
        for(int i=PassedArray.length-1; i > location; i--)
        {
            PassedArray[i] = PassedArray[i-1];
        }

        PassedArray[location] = element;
    }

}