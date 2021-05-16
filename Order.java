/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Noura Suliman Alsuliman ,439019013 ,376
package store;
//Noura Alsuliman 439019013
/**
 *
 * @author nourasul
 */
public class Order {
   private int orderNumber;
    public DLL<Item> items=new DLL<>(); //(DLL Object) items: Contains all the order’s items.
    
    
    public Order(int orderNumber){
        this.orderNumber=orderNumber;
    }
    public void setOrderNumber(int orderNumber){
        this.orderNumber=orderNumber;
        
    }
    public int getOrderNumber(){
        return orderNumber;
    }
    
    public void addItem(Item newItem){
        items.addLast(newItem);
    
    } 

     public Item removeItem(int item_num){  
         Item result;
      if(items.isEmpty())return null; 
     Node<Item> cur=items.getHead();
       
         while(cur!=null){
             if(cur.getItem().getItem_num()==item_num){
                 
             
      if(items.getHead()==items.getTail()){//only one item.
          result=cur.getItem();
           items.setHead(null);
         items.setTail(null);
         return result;
      }
      else  if(cur ==items.getHead() ){//if the item in the first node
          result=cur.getItem();
      items.setHead(cur.getNext());
      items.getHead().setPrev(null);
      return result;
       }
      else if(cur==items.getTail()){///if the item in the last node
          result=cur.getItem();
        items.setTail(cur.getPrev());  
        items.getTail().setNext(null);
        return result;
      }
       else{//if the item isn't in the first node and not in the last node 
                result=cur.getItem();
               cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());
            return result;
            } 
        }
             cur=cur.getNext();
        }
       return null;
       //    public void removeItem(int item_num){  
//      if(items.isEmpty())return; 
//     Node<Item> cur=items.getHead();
//       
//         while(cur!=null){
//             if(cur.getItem().getItem_num()==item_num){
//                 
//             
//      if(items.getHead()==items.getTail()){//only one item.
//           items.setHead(null);
//         items.setTail(null);
//      }
//      else  if(cur ==items.getHead() ){//if the item in the first node
//      items.setHead(cur.getNext());
//      items.getHead().setPrev(null);
//       }
//      else if(cur==items.getTail()){///if the item in the last node
//        items.setTail(cur.getPrev());  
//        items.getTail().setNext(null);
//      }
//       else{//if the item isn't in the first node and not in the last node 
//                
//               cur.getPrev().setNext(cur.getNext());
//            cur.getNext().setPrev(cur.getPrev());
//            } 
//        }
//             cur=cur.getNext();
//        }
//       
//    }
    }
     
    public double getSales(){
        double total=0;
         Node<Item>cur=items.getHead();
             while(cur!=null){
              total+=cur.getItem().getItem_price();
                cur=cur.getNext();
             }
             return total;
    }
    
    public Item searchByNumber(int item_num){
        Node<Item> cur=items.getHead();
        
        while(cur != null){
            if(cur.getItem().getItem_num()==item_num)
                return cur.getItem();
            cur=cur.getNext();
        }
    return null;//if we don't find any item
}
    public Item seaarchByName(String item_name){
             Node<Item> cur=items.getHead();
            // Item string=null;
             while(cur!=null){
                 if(cur.getItem().getItem_name().contains(item_name))
                     return cur.getItem();
                 
                 cur=cur.getNext();
             }
                return null; //if we don't find any item
    }
    public Item searchByPrice(double item_price){
        Node<Item> cur=items.getHead();
        while(cur !=null){
            if(cur.getItem().getItem_price()==item_price)
                return cur.getItem();
            
            cur=cur.getNext();
            
        }
        return null;//if we don't find any item
    }

   public void printOrder(){
    
       if(!items.isEmpty()){
         System.out.println("Order #"+orderNumber);
         
        items.print();
       }
       else
            System.out.println("Order #"+orderNumber+"is Empty");
     
   }
   /*
   @Override
   public String toString(){
  printOrder();
   return" ";
   }
   */
   }

