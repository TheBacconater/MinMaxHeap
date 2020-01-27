package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(6);
        MinHeap heap2 = new MinHeap(6);
/*
        heap.insert(9);
        heap.insert(8);
        heap.insert(6);
        heap.insert(5);
        heap.insert(2);
        heap.insert(1);
        heap.display();
        heap.remove(8);
        heap.display();

 */

        heap2.insert(9);
        heap2.insert(8);
        heap2.insert(6);
        heap2.insert(5);
        heap2.insert(2);
        heap2.insert(1);
        heap2.display();
        heap2.remove(1);
        heap2.display();


    }


    static class MaxHeap {

        int heapCapacity;
        int heapSize;
        ArrayList<Integer> heapArr = new ArrayList();

        public MaxHeap(int size) {
         heapArr = new ArrayList<Integer>(size);
            heapSize = 0;
            heapCapacity = size;
            heapArr.add(Integer.MAX_VALUE);

        }

        private void display() {

            for(int i = 1; i < heapArr.size(); i++) {
                System.out.println(heapArr.get(i));
            }
            System.out.println();
        }

        private int parentNode(int index) {

            return index/2;
        }

        private int leftNode(int index) {

            return (2 * index);
        }

        private int rightNode (int index) {

            return (2 * index + 1);
        }

        private void swap(int firstIndex, int secondIndex) {

            int temp = heapArr.get(firstIndex);
            heapArr.set(firstIndex,heapArr.get(secondIndex));
            heapArr.set(secondIndex,temp);


        }

        private void insert(int x) {

            heapSize++;
            heapArr.add(x);
            bubbleUp(heapSize);


        }

        private void bubbleUp(int index) {
            if(index > heapSize) {
                System.out.println("Sorry not possible");
            }
            int parentIndex = parentNode(index);
            int currentIndex = index;

            while(currentIndex > 0 && heapArr.get(parentIndex) < heapArr.get(currentIndex)) {
                swap(currentIndex,parentIndex);
                currentIndex = parentIndex;
                parentIndex = parentNode(parentIndex);

            }
        }

        private void sinkDown(int index) {

            if(index > heapSize) {
                System.out.println("Sorry not possible");
            }

            int smallest = index;
            int leftChild = leftNode(index);
            int rightChild = rightNode(index);

            if(leftChild < heapSize && heapArr.get(smallest) < heapArr.get(leftChild)) {
                smallest = leftChild;
            }
            else if (rightChild < heapSize && heapArr.get(smallest) < heapArr.get(rightChild)) {
                smallest = rightChild;
            }

            if(smallest != index) {
                swap(index,smallest);
                sinkDown(smallest);
            }

        }

        private void remove(int val) {



            int valIndex = Integer.MAX_VALUE;
            for(int i = 1; i < heapArr.size(); i++) {

                if(heapArr.get(i) == val) {
                    valIndex = i;
                }
            }
            if(valIndex == Integer.MAX_VALUE) {
               System.out.println("Sorry no value found");
            }

            if(valIndex == 1) {
                heapArr.set(1, heapArr.get(heapSize-1));
                sinkDown(1);
            }
            else if(valIndex == heapSize) {
                heapArr.remove(valIndex);
            }
            else {
                heapArr.set(valIndex,heapArr.remove(heapSize));
                sinkDown(valIndex);
                }

            heapSize = heapSize -1;
            }


        private int extractMax() {
            if(heapSize==1) {
                    return heapArr.get(1);
            }
            int temp = heapArr.get(1);
            heapArr.set(1,heapArr.remove(heapSize-1));
            heapSize = heapSize-1;
           sinkDown(1);
            return temp;
        }

        private int getMax() {
            return heapArr.get(1);
        }
    }



    static class MinHeap {

        int heapCapacity;
        int heapSize;
        ArrayList<Integer> heapArr = new ArrayList();

        public MinHeap(int size) {
            heapArr = new ArrayList<Integer>(size);
            heapSize = 0;
            heapCapacity = size;
            heapArr.add(Integer.MIN_VALUE);

        }

        private void display() {

            for(int i = 1; i < heapArr.size(); i++) {
                System.out.println(heapArr.get(i));
            }
            System.out.println();
        }

        private int parentNode(int index) {

            return index/2;
        }

        private int leftNode(int index) {

            return (2 * index);
        }

        private int rightNode (int index) {

            return (2 * index + 1);
        }

        private void swap(int firstIndex, int secondIndex) {

            int temp = heapArr.get(firstIndex);
            heapArr.set(firstIndex,heapArr.get(secondIndex));
            heapArr.set(secondIndex,temp);


        }

        private void insert(int x) {

            heapSize++;
            heapArr.add(x);
            minBubbleUp(heapSize);


        }

        private void minBubbleUp(int index) {
            if(index > heapSize) {
                System.out.println("Sorry not possible");
            }
            int parentIndex = parentNode(index);
            int currentIndex = index;

            while(currentIndex > 0 && heapArr.get(parentIndex) > heapArr.get(currentIndex)) {
                swap(currentIndex,parentIndex);
                currentIndex = parentIndex;
                parentIndex = parentNode(parentIndex);

            }
        }

        private void minSinkDown(int index) {

            if(index > heapSize) {
                System.out.println("Sorry not possible");
            }

            int smallest = index;
            int leftChild = 2 * index;
            int rightChild = 2 * index + 1;

            if(rightChild < heapSize && heapArr.get(smallest) > heapArr.get(rightChild)) {
                smallest = rightChild;
            }
            else if (leftChild < heapSize && heapArr.get(smallest) > heapArr.get(leftChild)) {
                smallest = leftChild;
            }

            if(smallest != index) {
                swap(index,smallest);
                minSinkDown(smallest);
            }

        }

        private void remove(int val) {


//System.out.println(" E" + heapArr.get(heapSize));
            int valIndex = Integer.MAX_VALUE;
            for(int i = 1; i < heapArr.size(); i++) {

                if(heapArr.get(i) == val) {
                    valIndex = i;
                }
            }
            if(valIndex == Integer.MAX_VALUE) {
                System.out.println("Sorry no value found");
            }

            if(valIndex == 1) {
                heapArr.set(1, heapArr.remove(heapSize));
                minSinkDown(1);
            }
            else if(valIndex == heapSize) {
                heapArr.remove(valIndex);
            }
            else {
                heapArr.set(valIndex,heapArr.remove(heapSize));
                minSinkDown(1);
            }

            heapSize = heapSize -1;
        }


        private int extractMin() {
            if(heapSize==1) {
                return heapArr.get(1);
            }
            int temp = heapArr.get(1);
            System.out.println(heapArr.get(heapSize) + " E");
            heapArr.set(1,heapArr.remove(heapSize));
            minSinkDown(1);
            heapSize = heapSize-1;
            return temp;
        }

        private int getMin() {
            return heapArr.get(1);
        }
    }



        }



    

