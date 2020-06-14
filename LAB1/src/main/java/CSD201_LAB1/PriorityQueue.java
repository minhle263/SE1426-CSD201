/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

import CSD201_LAB1.DoubleLinkList.node;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author truong
 */
public class PriorityQueue {
    DoubleLinkList list=new DoubleLinkList();
    public void add(String email,int point){
        node newNode=list.createNode(email, point);
        if(list.isEmpty()){
            list.head.right=newNode;
            newNode.left=list.head;
            newNode.right=list.tail;
            list.tail.left=newNode;
        }else{
            if(newNode.getPoint()<list.tail.left.getPoint())
            {
                list.tail.left.right=newNode;
                newNode.left=list.tail.left;
                newNode.right=list.tail;
                list.tail.left=newNode;
            }else if(newNode.getPoint()>list.head.right.getPoint()){
                list.head.right.left=newNode;
                newNode.right=list.head.right;
                newNode.left=list.head;
                list.head.right=newNode;
                
            }else{
                node currentNode=list.head.right;
                while(currentNode.getPoint()>=newNode.getPoint()){
                    currentNode=currentNode.right;
                }
                newNode.right=currentNode;
                newNode.left=currentNode.left;
                currentNode.left.right=newNode;
                currentNode.left=newNode;
            }
        }
        
    }
    public node SearchByEmail(String email){
        node currentNode=list.head.right;
        while(!(currentNode.getEmail().contentEquals(email))&&(currentNode!=list.tail)){
            currentNode=currentNode.right;
        }
        return currentNode;
    }
    public void delete(String email){
        node currentNode=SearchByEmail(email);
        if(currentNode==list.tail){
            System.err.println("can't find");
        }else{
            delete(currentNode);
            System.out.println("delete"+email+"from queue");
            
            
        }
    }
    public void delete(node currentNode){
        currentNode.left.right=currentNode.right;
        currentNode.right.left=currentNode.left;
        currentNode=null;
    }
    public void update(String email,int newPoint){
        node currentNode=SearchByEmail(email);
        if(currentNode==list.tail){
            System.err.println("cant't find by email");
        }else{
            delete(currentNode);
            add(email, newPoint);
            System.out.println("update"+email+"new point"+newPoint);
        }
    }
    public void printAll(){
        node currentNode=list.head;
        while(currentNode.right!=null){
            if(currentNode!=list.head){
                System.out.println(currentNode.getEmail()+""+currentNode.getPoint());
            }
            currentNode=currentNode.right;
        }
    }
    public int getPoint(String email){
        node currentNode=SearchByEmail(email);
        if(currentNode!=list.tail){
            return currentNode.getPoint();
        }
        return 0;
    }
    public void getTop(){
        if(list.isEmpty()){
            System.err.println("data not empty");
        }else{
            System.out.println(list.head.right.getPoint());
        }
    }
    public void deleteTop(){
        if(list.isEmpty()){
            System.out.println("data is empty");
        }else{
            node currentNode=list.head.right;
            currentNode.left.right=currentNode.right;
            currentNode.right.left=currentNode.left;
            currentNode=null;
            System.out.println("delete suceess");
        }
    }
    public void exportCSV(String path)throws IOException{
        FileWriter writer=new FileWriter(path);
        writer.append("Email,Point\n");
        node currentNode=list.head.right;
        while(currentNode!=list.tail){
            String rawData=String.format("%s,%d\n", currentNode.getEmail(),currentNode.getPoint());
            writer.append(rawData);
            currentNode=currentNode.right;
        }
        writer.flush();
        writer.close();
        System.out.println("save data to csv");
    }
}
