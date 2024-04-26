import java.util.Arrays;

public class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;
    private long startTime;
    private long endTime;

    public DynamicArray(){
        this.size = 0;
        this.capacity = 2;
        this.array = new int[capacity];
    }

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }


    public void increaseCapacity(){
        capacity *=2;
        array = Arrays.copyOf(array,capacity);
    }
    public void addArrayElement(int element){
        if (size==capacity){
            increaseCapacity();
        }
        array[size]+=element;
        size++;
    }

    public long calculateCreationTimeDynamicArray(int count){
        DynamicArray array1 = new DynamicArray();

        array1.startTimer();

        for (int i = 0;i<count;i++){
            array1.addArrayElement(i);
        }
        array1.stopTimer();
        return array1.getElapsedTime();
    }

    public void printArray(){
        for (int i = 0; i<size;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public long calculateTimeDeleteByIndex(int index){
        DynamicArray array1 = new DynamicArray();
        array1.startTimer();
        if (index >= 0 && index < array.length) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = 0;
        } else {
            System.out.println("Индекс выходит за границы размера массива");
            return -1;
        }
        size--;
        array1.stopTimer();
        return array1.getElapsedTime();
    }

    public long calculateTimeDeleteByValue(int value){
        DynamicArray array1 = new DynamicArray();
        array1.startTimer();
        boolean find = false;

        for (int i = 0;i<array.length-1;i++){
            if(array[i]==value){
                array[i] = array[i+1];
                find = true;
            }
            array[array.length-1] = 0;
        }

        if(find) {
            size--;
            array1.stopTimer();
            return array1.getElapsedTime();
        }
        else {
            return -1;
        }
    }

    public long dynamicArrayInsertByIndex(int index,int value){
        DynamicArray array1 = new DynamicArray();
        array1.startTimer();
        if (index < 0 || index > array.length) {
            System.out.println("Index out of bounds");
            return -1;
        }
        size++;
        if(size==capacity){
            increaseCapacity();
        }

        int temp = array[index];
        for (int i = index; i<size;i++){
            int temp1 = array[i+1];
            array[i+1] = temp;
            temp = temp1;

        }
        array[index] = value;
        array1.stopTimer();
        return array1.getElapsedTime();
    }

    public long getElementByIndex(int index){
        DynamicArray array1 = new DynamicArray();
        array1.startTimer();
        System.out.println("Значения элемента по заданному индексу: " + array[index]);
        array1.stopTimer();
        return array1.getElapsedTime();
    }

    public long getElementByValue(int value){
        DynamicArray array1 = new DynamicArray();
        array1.startTimer();
        for (int i = 0;i<array.length;i++){
            if (array[i]==value){
                System.out.println("Значения индекса по заданному значению : " + i);
                array1.stopTimer();
                return array1.getElapsedTime();
            }
        }
        return -1;
    }

    public long swapArrayElements(int index1,int index2){
        DynamicArray array1 = new DynamicArray();
        array1.startTimer();
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        array1.stopTimer();
        return array1.getElapsedTime();
    }

    public long deleteEvenInArray(){
        DynamicArray array1 = new DynamicArray();
        array1.startTimer();
        int[] oddNumbers = new int[size];
        int oddIndex = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] % 2 != 0) {
                oddNumbers[oddIndex] = array[i];
                oddIndex++;
            }
        }
        array = Arrays.copyOf(oddNumbers, oddIndex);
        size = oddIndex;
        array1.stopTimer();
        return array1.getElapsedTime();
    }

}
