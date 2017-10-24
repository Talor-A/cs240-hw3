/**
 * class implementing a double-ended ADT Queue using single-linked nodes
 * @author Talor Anderson
 * @version 1.0
 */
public class SLDeque<T> implements DequeInterface<T> {
  SNode front = null;
  SNode back =  null;
  public void addToFront(T newEntry) {
    SNode newNode = new SNode(newEntry, front);
    front = newNode;
  }
  
  public void addToBack(T newEntry) {
    SNode newNode = new SNode(newEntry, null);
    back.setLink(newNode);
    back = newNode;
  }
  
  public T removeFront() {
    if (front == null) return null;
    T frontData = (T)front.getData();
    if (front == back) {
      front = null;
      back = null;
      return frontData;
    } else {
      front.setData(null);
      front = front.getLink();
      return frontData;
    }
  }
  
  public T removeBack() {
    if(back == null) return null;
    T backData = (T) back.getData();
    if(back == front) {
      front = null;
      back = null;
    } else {
      SNode testNode = front.getLink();
      boolean stop = false;
      while(!stop){
        if(testNode.getLink() == back){
          stop = true;
        } else {
          testNode = testNode.getLink();
        }
      }
      back = testNode;
      back.setLink(null);
    }
    return backData;
  }
  
  public T getFront(){
    return (T)front.getData();
  }
  
  public T getBack(){
    return (T)back.getData();
  }
  
  public boolean isEmpty(){
    return front == null;
  }
  
  public void clear(){
    front = null;
    back = null;
  }

}