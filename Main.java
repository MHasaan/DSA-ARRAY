public class Main
{
    public static void main(String[] args)
    {
        List MyArray=new Array();
        MyArray.print();
        System.out.println("Searching element in array:");
        int returnedResult = MyArray.search(8);
        if (returnedResult == -1)
        {
            System.out.println("Not Found");
        }
        else
        {
            System.out.printf("Element Found at index: %d\n",returnedResult);
        }
    }
}

abstract class List
{
    abstract public void print();
    abstract public int search(int element);
    public void addToStart(){}
    public void addToEnd(){}
    public void addToLocation(){}
    public void delFromEnd(){}
    public void UpdateArray(){}
    public void delFromStart(){}
    public void delFromLocation(){}
    public void ArraySort(){}

}

class Array extends List{
    public  int[] PassedArray;

    public Array()
    {
        PassedArray = new int[10];
        int count = 1;
        for(int index = 0;index<PassedArray.length;index++)
        {
            PassedArray[index] = count;
            count++;
        }
    }

    @Override
    public int search(int element)
    {
        for(int index=0;index<PassedArray.length;index++)
        {
            if (PassedArray[index] == element){
                return index;
            }
        }
        return -1;
    }

    @Override
    public void print()
    {
        for (int i : PassedArray)
        {
            System.out.println(i);
        }
    }

    @Override
    public void addToStart(int element)
    {
        for(int i=PassedArray.length-2;i>=0;i--)
        {
            PassedArray[i+1] = PassedArray[i];
        }
        PassedArray[0] = element;
    }

    @Override
    public void addToEnd(int element){
        for(int i=1;i<PassedArray.length;i++)
        {
            PassedArray[i-1] = PassedArray[i];
        }
        PassedArray[PassedArray.length-1] = element;
    }

    @Override
    public void UpdateArray(int element,int location)
    {
        PassedArray[location] = element;
    }


    @Override
    public void sortArray(){                // Using bubble Sorting
        int size = PassedArray.length;
        // loop to access each array element
        for (int i = 0; i < (size-1); i++) {

            // check if swapping occurs
            boolean swapped = false;

            // loop to compare adjacent elements
            for (int j = 0; j < (size-i-1); j++) {

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
            // no swapping means the array is already sorted so no need for further comparison
            if (!swapped)
                break;
        }                                   // End of the inner loop
    }                                   // End of the outer Loop


}