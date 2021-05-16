/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;
//Noura Alsuliman 439019013

/**
 *
 * @author nourasul
 */
public class Store {
   /* STORE CLASS FUNCTIONS AND DATA FIELDS SHOULD BE HERE */
    
    /* AFTER COMPLETING THE REQUIREMENTS ALL ERRORS SHOULD BE RESOLVED */
public Queue<Order> newOrders=new Queue();
public Queue<Order> processedOrders=new Queue();
public Queue<Order>removedOrders=new Queue();
public DLL<Item> items=new DLL<Item>();
public Stack<Order> stack=new Stack();

public  double sales=0;


public Store(){
    
}

public void addTaxes(Order order){
    Node<Item> cur=order.items.getHead();
    while(cur !=null){
        if (cur.getItem().taxIncluded==false){
            //Tax=10RS
            
          cur.getItem().setItem_price(cur.getItem().getItem_price()+10);
          cur.getItem().taxIncluded=true;
      cur=cur.getNext();
    }
        else
            cur=cur.getNext();
            }
}
public void printProfitableItems(){
 Node<Item> cur=items.getHead();
 while(cur!= null){
     double dif=cur.getItem().getItem_price()-cur.getItem().getItem_cost();//3750-1800
     if(dif>= cur.getItem().getItem_cost()/2){
       
    
         System.out.println(cur.getItem());
       cur=cur.getNext();
     }
     else
         cur=cur.getNext();
    }
}
public void printProcessedOrders(){
     int size=processedOrders.size();
     for(int i=0;i<size;i++){
         Order o=processedOrders.dequeue();
         stack.push(o);
         processedOrders.enqueue(o);
         
         
     }
     while(! stack.isEmpty())
        stack.pop().items.print();
     
}
    public void resetOrders(){
        
        while(!newOrders.isEmpty())
            newOrders.dequeue();
        
        while(! processedOrders.isEmpty())
            processedOrders.dequeue();
        
        while(! removedOrders.isEmpty() )
            removedOrders.dequeue();
    }
    public void addNewOrder(Order order ){
        newOrders.enqueue(order); 
    } 
    
    
    public double calculateSales(){
        double total=0;
        int size=processedOrders.size();
        
       for(int i=0;i<size;i++){
            Order order=processedOrders.dequeue();
            total+=order.getSales();
            processedOrders.enqueue(order);
        }
       return total;
    }
    public void processOrder(){
        Order order=newOrders.dequeue();
        processedOrders.enqueue(order); //first order in newOrders queue
      
       sales+=order.getSales();//total
     
      // order.printOrder();
        //System.out.println("order#"+order.getOrderNumber()+"now is processed \n");
    }
   /*
    public void processOrder(){ 

    Order order=newOrders.dequeue();
        processedOrders.enqueue(order);
              while(!processedOrders.isEmpty() ){
                  sales+=order.getItem().getItem_price();
              }
    }
    */
    
public BST<Integer,Item> generateItemsTree(){
 BST<Integer,Item> bst=new BST<>();
 Node<Item>cur=items.getHead();
 
 while(cur !=null){
   bst.insert(cur.getItem().getItem_num(), cur.getItem());
   cur=cur.getNext();
 }
return bst;
//or the return type is void and we call bst.inOrder();  at the end of the method
}
     public int toSortedArray(BSTNode p,Item[] a, int i) {
    if(p==null) 
        return i;
    i=toSortedArray(p.getLeft(),a,i);
    if(p.getData() !=null)
        a[i++]=(Item) p.getData();
      i=toSortedArray(p.getRight(),a,i);
      return i; //LPR
    }
     
    public Item binarySearchItems(Item[]ar,int target,int low,int high){
   if(low>high)
       return null;
   else{
       int mid=(low+high)/2;
       if(target==ar[mid].getItem_num()) 
           return ar[mid];//founde it
       
       else if(target<ar[mid].getItem_num())
           
           return binarySearchItems(ar,target,low,mid-1);
       else
           
           return binarySearchItems(ar,target,mid+1,high);
   }
 /*
  public  boolean binarySearchItems(Item[]ar,int target,int low,int high){
   if(low>high)
       return false;
   else{
       int mid=(low+high)/2;
       if(target==ar[mid].getItem_num()) 
           return true;//founde it
       else if(target<ar[mid].getItem_num())
           return binarySearchItems(ar,target,low,mid-1);
       else
           return binarySearchItems(ar,target,mid+1,high);
   }
  }
*/
   
  }

  public void removeOrder(int order_number){
      int s=newOrders.size();
      for(int i=0;i<s;i++){
    Order order=newOrders.dequeue();
    
    if(order.getOrderNumber()==order_number)
        removedOrders.enqueue(order);
    else
        newOrders.enqueue(order);
      }
      
      
  }
  public void printAllOrders(Queue<Order> orders){
      int s=orders.size();
      for(int i=0;i<s;i++){
          Order deqOrder=orders.dequeue();
          
          deqOrder.printOrder();
          
          orders.enqueue(deqOrder);
      }
      
  } public void inOrder(BSTNode p) {
        if (p != null) {
            inOrder(p.getLeft());
                System.out.print(p.getData() + " ");
            inOrder(p.getRight());
        }
    }
//      public void printInorder(){//print generateItemsTree()
//           BST<Integer,Item> bst=new BST<>();
//          bst.inOrder(generateItemsTree().getRoot());
//           
//      }
    
 

    public static void main(String[] args) {
        
           Store store = new Store();
             store.items.addLast(new Item(111,"iPhone X",3750,1800));
           store.items.addLast(new Item(133,"Bose Headphone",1099,700));
           store.items.addLast(new Item(122,"iPhone X Max",5550,2700));
           store.items.addLast(new Item(231,"Samsung Galaxy Note 10",2500,1400));
            store.items.addLast(new Item(131,"Apple AirPods",599,500));
         

           
           
           
           store.items.addLast(new Item(111,"iPhone X",3750));
           store.items.addLast(new Item(133,"Bose Headphone",1099));
           store.items.addLast(new Item(122,"iPhone X Max",5550));
          store.items.addLast(new Item(231,"Samsung Galaxy Note 10",2500));
          store.items.addLast(new Item(131,"Apple AirPods",599));
          
        

       //Bonus:   
           BST x= store.generateItemsTree();
       //Q2 Bonus    
        Item[]ar=new Item[x.size()];
         store.toSortedArray(x.getRoot(), ar, 0);
         
         System.out.println("binarySearchItems: search of item number 133: "+ store.binarySearchItems(ar,133, 0, ar.length-1));
 System.out.println("binarySearchItems: search of item number 499: "+ store.binarySearchItems(ar,499, 0, ar.length-1));

//Q1Bonus    
        System.out.println("generateItemsTree: ");
      store.inOrder(x.getRoot());
          
          
          
          
          
        Order o4 = new Order(4);
        o4.addItem(new Item(111,"iPhone X",3750));
        o4.addItem(new Item(133,"Bose Headphone",1099));
        store.addNewOrder(o4);//add o4 to store class in items 
  
        
        Order o5 = new Order(5);
        o5.addItem(new Item(111,"iPhone X Max",5550));
        store.addNewOrder(o5);
        
//        System.out.println();
//        System.out.println("Search by name: ");
////        System.out.println(o5.seaarchByName("iPhone X"));
////        System.out.println();
     
        
        Order o1 = new Order(1);
        o1.addItem(new Item(111,"iPhone X",3750));
        o1.addItem(new Item(122,"iPhone X Max",5550));
        o1.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
        store.addNewOrder(o1);
        
//        System.out.println("Remove Item iphone x max: ");       
//       System.out.println(  o1.removeItem(231));
//         System.out.println();    
         
        Order o2 = new Order(2);
        o2.addItem(new Item(122,"iPhone X Max",5550));
        o2.addItem(new Item(131,"Apple AirPods",599));
        store.addNewOrder(o2);

        
        Order o3 = new Order(3);
        o3.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
        store.addNewOrder(o3);
               
        store.removeOrder(5);
       // store.processOrder(); to make sure that printProcessedOrders works
         store.processOrder();
         
        System.out.println("New:");
        store.printAllOrders(store.newOrders);
        System.out.println("Processed:");//o5
        store.printAllOrders(store.processedOrders);
        System.out.println("Removed:");
        store.printAllOrders(store.removedOrders);
        //Task1
             System.out.println("--------------");
             System.out.println("printProfitableItems()");
            store.printProfitableItems();
            System.out.println("--------------");
            //Task 3
            System.out.println();
            System.out.println("printProcessedOrders: ");
            store.printProcessedOrders();//o4,o1
        
        //Task2:
          System.out.println();
            System.out.println("Taxes: ");
        store.addTaxes(o4);
     
        
        
        
        
        
        
        
        
        
        
//        System.out.println("sales: "+store.sales);
//        System.out.println("Calculate sales: "+store.calculateSales());
        
//      BST bst=store.generateItemsTree();
//      bst.inOrder(bst.getRoot());

//    System.out.println("generateItemsTree(): ");
//      store.printInorder();



//        System.out.println();
//        System.out.println("print remove item");
//      o1.removeItem(122);
//      o1.printOrder();;
//  


    }

}
