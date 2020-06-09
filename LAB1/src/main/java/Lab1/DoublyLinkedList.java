/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author Admin
 */
public class DoublyLinkedList<Player> {
    /**
     * head node 
     * tail node
     * A variable for tracking size
     */
    private Node<Player> header;
    private Node<Player> tailer;
    private int size;

    /**
     * Constructor empty list
     */
    public DoublyLinkedList(){
        header = new Node<Player>(null, null, null);
        tailer = new Node<Player>(null, null, header);
        header.next = tailer;
    }
    /**
     * check if list is empty
     * @return true if size is 0; otherwise, it is false.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size(){
        return size;
    }
    
    /**
     * Adding a node to the first of the list.
     * @param newbie value to add
     */
    public void addFirst(Node<Player> newbie){
        if (isEmpty()) {
            header = new Node<Player>((Player) newbie);
        } else {
            Node<Player> temp = header;
            header = new Node<Player>(null, newbie, temp);
            header.next.previous = header;
        }
        size++;
    }
    
    /**
     * Insert a node to the last of the list.
     * @param newbie to add
     */
    public void addLast(Node<Player> newbie){
        if (isEmpty()) {
            header = new Node<Player>((Player) newbie);
        } else {
            Node<Player> temp = header;
            // Di cho den cuoi danh sach
            while (temp.next != null) {
                temp = temp.next;
            }
            header = new Node<Player>(null, temp, newbie);
        }
        size++;
    }
    public void remove (Node<Player> delete){
        
    }
}
