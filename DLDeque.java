/**
 * class implementing a double-ended ADT Queue using double-linked nodes
 * @author Talor Anderson
 * @version 1.0
 */
public class DLDeque<T> implements DequeInterface<T> {
  DNode head;
  DNode tail;
  
  public DLDeque(){
    head = null;
    tail = null;
  }
  
  public void addToFront(T newEntry){
    //create a new Node
    DNode newNode = new DNode(newEntry);
    if (isEmpty()) {
      head = newNode;
    } else {
      head.setFront(newNode);
      newNode.setBack(head);
      head = newNode;
    }
  }
  
  public void addToBack(T newEntry){
    DNode newNode = new DNode(newEntry);
    if (isEmpty()){
      tail = newNode;
    } else {
      tail.setBack(newNode);
      newNode.setFront(tail);
      tail = newNode;
    }
  }
  
  public T removeFront(){
    // if front == null, throw an exception
    if(isEmpty()){
      // throw new Exception("Queue is Empty!");
      return null;
    } else {
      // hold data in temp variable
      DNode detached = head;
      // move head
      head = detached.getBack();
      head.setFront(null);
      // delete data in DLNode(for security)
      return (T)detached.getData();
    }
  }
  
  public T removeBack() {
    // if back == null, throw an exception
    if(isEmpty()){
      //throw new Exception("Queue is Empty!");
      return null;
    } else {
    // hold data in temp variable
    DNode detached = tail;
    // move back to node"s front
    tail = detached.getFront();
    tail.setBack(null);
    // delete data in DLNode(for security)
    return (T)detached.getData();
    }
  }
  
  public T getFront(){
    if (isEmpty()){
      // throw new Exception("Queue is Empty!");
      return null;
    } else {
      return (T)head.getData();
    }
  }
  
  public T getBack(){
    if (isEmpty()){
      // throw new Exception("Queue is Empty!");
      return null;
    } else {
      return (T)tail.getData();
    }
  }
  
  public boolean isEmpty(){
    return head == null;
  }
  
  public void clear(){
    head = null;
    tail = null;
  }

}