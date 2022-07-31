package CourseWork.week1;

import CourseWork.week1.SingelyLinkedList.Node;

// public class week1 {
//     public class node {
//         int data;
//         node next;

//         node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     node head = null;
//     node tail = null;

//     public void addNode(int data) {
//         node newNode = new node(data);
//         if (head == null) {
//             head = tail = newNode;
//             return;
//         }
//         tail.next = newNode;
//         tail = newNode;
//     }

//     public void printList() {
//         for (node i = head; i != null; i = i.next) {
//             System.out.println(i.data);
//         }
//     }

//     public static void main(String[] args) {
//      int lists=3;
//      node[] arr = new node[lists];
 
//      arr[0] = new node(1);
//      arr[0].next = new node(3);
//      arr[0].next.next = new node(5);
//      arr[0].next.next.next = new node(7);
  
//      arr[1] = new node(2);
//      arr[1].next = new node(4);
//      arr[1].next.next = new node(6);
//      arr[1].next.next.next = new node(8);
  
//      arr[2] = new node(0);
//      arr[2].next = new node(9);
//      arr[2].next.next = new node(10);
//      arr[2].next.next.next = new node(11);

//     }

// }
public class week1 {

     SingelyLinkedList[] arr;
     
     week1(SingelyLinkedList[] arr) {
     this.arr = arr;
     }
     
     SingelyLinkedList MergeAll() {
     SingelyLinkedList FinalOutputList = arr[0];
     SingelyLinkedList mergedList;
     for (int i = 1; i < arr.length; i++) {
     mergedList = MergeTwo(FinalOutputList, arr[i]);
     FinalOutputList = mergedList;
     }
     return FinalOutputList;
     }
     
     SingelyLinkedList MergeTwo(SingelyLinkedList a, SingelyLinkedList b) {
     
     SingelyLinkedList result = new SingelyLinkedList();
     Node first_itterator = a.head;
     Node second_itterator = b.head;
     while (first_itterator != null) {
     result.addNode(first_itterator.data);
     first_itterator = first_itterator.next;
     }
     while (second_itterator != null) {
     result.addNode(second_itterator.data);
     second_itterator = second_itterator.next;
     }
     return sortLinkedList(result);
     }
     
     SingelyLinkedList sortLinkedList(SingelyLinkedList list) {
     Node current = list.head, index = null;
     int temp;
     
     if (list.head == null) {
     return null;
     } else {
     while (current != null) {
     index = current.next;
     
     while (index != null) {
     if (current.data > index.data) {
     temp = current.data;
     current.data = index.data;
     index.data = temp;
     }
     index = index.next;
     }
     current = current.next;
     }
     }
     return list;
     }
     
     void Median() {
     int median = MergeAll().getSize() / 2;
     System.out.println("Median: " + MergeAll().getDataAtAnyPos(median));
     }
     
     public static void main(String[] args) {
     SingelyLinkedList[] arr = new SingelyLinkedList[3];
     SingelyLinkedList L1 = new SingelyLinkedList();
     SingelyLinkedList L2 = new SingelyLinkedList();
     SingelyLinkedList L3 = new SingelyLinkedList();

     L1.addNode(2);
     L1.addNode(4);
     L1.addNode(7);
     L1.addNode(5);
     L1.addNode(10);

     L2.addNode(3);
     L2.addNode(2);
     L2.addNode(7);
     L2.addNode(9);

     L3.addNode(12);
     L3.addNode(5);
     L3.addNode(6);
     L3.addNode(9);
     
     arr[0] = L1;
     arr[1] = L2;
     arr[2] = L3;
     week1 w = new week1(arr);
     w.Median();
     
     }
     }