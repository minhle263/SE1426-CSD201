/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

/**
 *
 * @author Dell
 */
public class DoublyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E element, Node<E> prev, Node<Infor> n){
            element=i;
            prev=p;
            next=n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public void setPrev(Node<E> p){
            prev=p;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next=n;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size=0;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Node<E> getHeader() {
        return header.getNext();
    }

    public void setHeader(Node<E> header) {
        this.header = header;
    }

    public Node<E> getTrailer() {
        return trailer.getPrev();
    }

    public void setTrailer(Node<E> trailer) {
        this.trailer = trailer;
    }

    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer= new Node<>(null, header, null);
        header.setNext(trailer);
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E getFirst(){
        if(isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }
    public E getLast(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }
    
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest= new Node<>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    private Infor delete(Node<E> node){
        Node<E> predecessor= node.getPrev();
        Node<E> successor= node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    public void addFirst(Infor newNode){
        addBetween(e,header,header.getNext());
    }
    public void addLast(Infor newNode){
        addBetween(e,trailer.getPrev(),trailer);
    }
    public Infor deleteFirst(){
        if(isEmpty()){
            Syste.out.println("Empty");
        }
        return delete(header.getNext());
    }
    public Infor deleteLast(){
        if(isEmpty()){
            System.out.println("Empty");
        }
        return delete(trailer.getPrev());
    }
}
