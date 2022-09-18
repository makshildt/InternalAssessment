public class Test {
    //print the word maks
    public static void main(String[] args) {
        System.out.println(calc(2, 2, "+"));
        
    }
    
    //calculator for adding and subtracting integers
    public static int calc(int a, int b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else {
            return 0;
        }
    }

    //create binary sorting algorithm
    public static int[] sort(int[] arr) {
        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            sorted[i] = min;
            arr[minIndex] = arr[i];
        }
        return sorted;
    }

    //create a circular linked list
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public static Node createCircularLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        current.next = head;
        return head;
    }
}
