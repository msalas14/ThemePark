import java.util.Arrays;

public class MyArrayList {
    private int[] data;
    private int size;

    public MyArrayList()//
    {
        size = 0;
        data = new int[4];
    }
    public MyArrayList(int[] arr)
    {
        data = arr;
        size = arr.length;
    }

    public void add(int n)
    {
        if(data.length>size) //compare default capacity to arraylist size
        {//add elements to "empty" list
            data[size] = n;
            size++;
        }
        else
        {//add elements to end of existing list
            size++;
            data= Arrays.copyOf(data, size);
            data[size-1] = n;
        }
    }

    public boolean remove(int index)
    {
        if(index<0||index>size-1||size==0) //check for a valid index
        {
            return false; //element cannot be removed because index is not in the range or there are no elements in the arraylist
        }
        else {
            int[] temp = Arrays.copyOfRange(data, 0, index); //place elements before the index in a temporary array
            int[] temp1 = Arrays.copyOfRange(data, index + 1, size);//place elements after the index in a temporary array
            size--; //decrease current size of arraylist
            data = Arrays.copyOf(temp, size); // data is now equivalent to the first part of the previous array with empty elements for the rest of the array with one less in length
            int c = 0; //counting variable for current element of second temporary array
            for (int i = index; i < size; i++) { //for loop to go through the empty elements in data array and elements of second temporary array
                data[i] = temp1[c]; //set each empty element to the value of the current element of the second array
                c++; //increase counting variable
            }
            return true; //element is removed
        }
    }
    public boolean remov(int n )
    {
        if (n<0||n>=size)
        {
            return false;
        }
        for(int i = n; i< size-1; i++)
        {
            data[i] = data[i+1];
        }
        size--;
        return true;
    }
    public String toString()
    {
        String arrayListString = "";//"{";
        if(size>0) {
            for (int i = 0; i < size - 1; i++) {
                arrayListString += data[i] + ", ";

            }
            arrayListString += data[size - 1];
        }
        //arrayListString+="}";
        return arrayListString;
    }
    public int getSize()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public int indexOf(int n)
    {
        for(int i = 0; i<size; i++)
        {
            if(data[i]==n)
            {
                return i;
            }
        }
        return -1;
    }

}
