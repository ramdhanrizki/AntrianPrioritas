/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ramdhan
 */
public class MinHeap {
   private String[] data; 
   private int heapSize; 

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }
   
   public MinHeap(int size) {
       data = new String[size];
       heapSize = 0;
   }
   
   public String getMinimum() {
       if(isEmpty())
           throw new HeapException("Heap Kosong");
       else 
           return data[0];
   }
   
   private int getLeftChildIndex(int nodeIndex) {
       return 2 * nodeIndex + 1; 
   }
   
   private int getRightChildIndex(int nodeIndex) {
       return 2 * nodeIndex + 2; 
   }
   
   private int getParentIndex(int nodeIndex) {
       return (nodeIndex -1) /2; 
   }
   
    private boolean isEmpty() {
        return (heapSize == 0);
    }
   
   public void insert(String value) {
       if(heapSize == data.length)
           throw new HeapException("Heap Sudah Penuh");
       else {
           heapSize++; 
           data[heapSize-1] = value; 
           siftUp(heapSize-1);
       }
   } 

    private void siftUp(int nodeIndex) {
       int parentIndex;
       String tmp; 
       if(nodeIndex !=0) {
           parentIndex  = getParentIndex(nodeIndex);
           if(data[parentIndex].compareTo(data[nodeIndex]) > 0) {
               tmp = data[parentIndex]; 
               data[parentIndex] = data[nodeIndex]; 
               data[nodeIndex] = tmp; 
               siftUp(parentIndex);
           }
       }
    }
    
   private void siftDown(int nodeIndex) {
       int leftChildIndex,rightChildIndex,minIndex;
       String tmp; 
       leftChildIndex = getLeftChildIndex(nodeIndex);
       rightChildIndex = getRightChildIndex(nodeIndex);
       if(rightChildIndex >= heapSize){
           if(leftChildIndex >= heapSize)
               return; 
           else 
               minIndex = leftChildIndex;
       } 
       else {
           if(data[leftChildIndex].compareTo(data[rightChildIndex]) <= 0)
               minIndex = leftChildIndex; 
           else
               minIndex = rightChildIndex; 
       }
       
       if(data[nodeIndex].compareTo(data[minIndex]) > 0) {
           tmp = data[minIndex];
           data[minIndex] = data[nodeIndex];
           data[nodeIndex] = tmp; 
           siftDown(minIndex);
       }
   }
   
   public String getMin(){
       if(isEmpty()) {
           throw new HeapException("Heap Kosong"); 
       }
       else {
           String ambil = data[0];
           data[0] = data[heapSize-1];
           heapSize--; 
           if(heapSize>0)
               siftDown(0);
           return ambil; 
       }

   }
   
   public class HeapException extends RuntimeException {
       public HeapException(String message) {
           super(message);
       }
   }
   
}
