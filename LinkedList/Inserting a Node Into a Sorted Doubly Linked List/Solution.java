import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if(head==null){
            head= newNode;
        }
        if(head.next==null){
            if(head.data<=data){
            head.next=newNode;
            newNode.prev=head;
            }
            else{
                newNode.next=head;
                head.prev=newNode;
                head=newNode;
            }
        }
        else{
            DoublyLinkedListNode currentNode = head;
            DoublyLinkedListNode nextNode = head.next;
            while(currentNode!=null){
                if(currentNode.data<=data){
                    if(currentNode.next==null){
                        currentNode.next=newNode;
                        break;
                    }
                    else if(data<=nextNode.data){
                        nextNode = currentNode.next;
                        currentNode.next=newNode;
                        newNode.next=nextNode;
                        break;
                    }
                }
                else{
                    currentNode.next=newNode.next;
                    newNode.next=currentNode;
                }
                currentNode=currentNode.next;
            }
        }
        return head;
    }
}