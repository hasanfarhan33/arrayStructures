public class arrayStructures {
    private int[] theArray = new int[50];
    private int arraySize = 10;

    public void generateRandomArray() {
        for(int i = 0; i < arraySize; i++) {
            theArray[i] = (int)(Math.random() * 10) + 10;
        }
    }

    public void printArray() {
        System.out.println("__________");
        for(int i = 0; i < arraySize; i++) {
            System.out.print("| " + i + " |");
            System.out.println(theArray[i] + " |");
            System.out.println("__________");
        }
    }

    public int getValueAtIndex(int index) {
        if(index < arraySize) return theArray[index];
        return 0;
    }

    public boolean doesArrayContainThisValue(int searchValue) {
        boolean valueInArray = false;
        for(int i = 0; i < arraySize; i++) {
            if(theArray[i] == searchValue) {
                valueInArray = true;
            }
        }
        return valueInArray;
    }

    public void deleteIndex(int index) {
        if (index < arraySize) {
            for(int i = index; i < (arraySize - 1); i++) {
                theArray[i] = theArray[i+1];
            }
            arraySize--;
        }
    }

    public void insertValue(int value) {
        if (arraySize < 50) {
            theArray[arraySize] = value;
            arraySize++;
        }
    }

    public String linearSearchForValue(int value) {
        boolean valueInArray = false;
        String indexsWithValue = "";
        System.out.print("The value was found in the following: ");
        for(int i = 0; i < arraySize; i++) {
            if(theArray[i] == value) {
                valueInArray = true;
                System.out.print(i + " ");
                indexsWithValue += i + " ";
            }
        }
        if(!valueInArray) {
            indexsWithValue = "None";
            System.out.print(indexsWithValue);
        }
        System.out.println();
        return indexsWithValue;
    }

    public void printHorzArray(int i, int j) {
        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < arraySize; n++){
            System.out.print("| " + theArray[n] + " ");
        }
        System.out.println("|");
        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();

        if(j!=-1) {
            for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
            System.out.print(j);
        }

        if(i!=-1){
            for(int l=0; l < (5*(i - j)-1); l++)System.out.print(" ");
            System.out.print(i);
        }
        System.out.println();

    }

    public void swapValues(int indexOne, int indexTwo) {
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }

    public void bubbleSort() {
        for(int i = arraySize - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(theArray[i] > theArray[j+1]) { //CHANGE THE CONDITION TO < FOR DESCENDING ORDER
                    swapValues(j, j+1);
                    printHorzArray(i, j);
                }
                printHorzArray(i, j);
            }
        }
    }

    public void binarySearchForValue(int value) {
        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while(lowIndex <= highIndex) {
            int middleIndex = (highIndex - lowIndex) / 2;
            if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
            else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
            else {
                System.out.println("\n Found a match for " + value + " at index " + middleIndex);
                lowIndex = highIndex + 1;
            }

            printHorzArray(middleIndex, -1);
        }
    }

    public void selectionSort() {
        for(int x = 0; x < arraySize; x++) {
            int minimum = x;
            for(int y = x; y < arraySize; y++) {
                if(theArray[minimum] > theArray[y]) {
                    minimum = y;
                }
            }
            swapValues(x, minimum);
            printHorzArray(x, -1);
        }
    }

    public void insertionSort() {
        for(int i = 0; i < arraySize; i++) {
            int j = i;
            int toInsert = theArray[i];
            while((j > 0) && (theArray[j-1] > toInsert)) {
                theArray[j] = theArray[j-1];
                j--;

                printHorzArray(i, j);
            }
            theArray[j] = toInsert;
            printHorzArray(i, j);
            System.out.println("\nArray[i] = " + theArray[i] + " Array[j]= " + theArray[j] + " toInsert = " + toInsert);
        }
    }

    public static void main(String[] args) {
        arrayStructures newArray = new arrayStructures();
        newArray.generateRandomArray();
//        newArray.bubbleSort();
//        newArray.selectionSort();
        newArray.insertionSort();
//        newArray.binarySearchForValue(11);

    }
}
