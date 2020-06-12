/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

/**
 *
 * @author TAN
 */
public class DoublyLinkedList<Player> {
    
    Node<Player> head,tail;
    private int size = 0; // kiem tra danh sach

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Node<Player> getHead() {
        return head;
    }

    public void setHead(Node<Player> head) {
        this.head = head;
    }

    public Node<Player> getTail() {
        return tail;
    }

    public void setTail(Node<Player> tail) {
        this.tail = tail;
    }

    public DoublyLinkedList(Node<Player> head, Node<Player> tail) {
        this.head = head;
        this.tail = tail;
    }
    public DoublyLinkedList(){
        head = tail = null;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    //them phan tu vao dau list
    public void addFirst(Node<Player> newNode){
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
        size++;
    }
    //them phan tu vao cuoi list
    public void addLast(Node<Player> newNode){
        newNode.setPrev(tail);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }
    
    //xoa phan dau tien vao list
    public Player removeFirst(){
        if(isEmpty()){
            System.out.println("Stack rong");
        }
        //Neu xoa khi chi con 1 phan 
        else{
            Player value = head.getInfo();
            head = head.getNext();
            size--;
            if(head == tail){
            head = tail = null;
            }
        }
        return null;
    }
    public Player remove(Node<Player> node) {
        if (isEmpty()) {
            System.out.println("Stack rong");
        } else {
            Player value = node.getInfo();
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            size--;
            if (head == tail){
                head = tail = null;
            }
        }
        return null;
    }
    public Player get(int index) {
        if (size != 0) {
            Node<Player> current = head.getNext();
            for (int i = 0; (current != null) && (i < index); i++) {
                current = current.getNext();
            }
            if (current != null) {
                return current.getInfo();
            }
        }
        return null;
    }
    public void removePos(int n) {
        if (size == 0 || n < 0) {
            return;
        }
        Node temp = head.getNext();
        for (int i = 0;i < n; i++) {
            temp = temp.getNext();
        }
        if (temp == null) {
            return;
        }
        remove(temp);
    }
}
