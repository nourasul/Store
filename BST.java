/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Noura Suliman Alsuliman ,439019013 ,376
package store;

/**
 *
 * @author nourasul
 */
public class BST <Key extends Comparable<? super Key>, T> {

    private BSTNode<Key, T> root; // Root of the BST
    int size; // Number of nodes in the BST

    BST() {
        root = null;
        size = 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * @return The number of records in the dictionary.
     */
    public int size() {
        return size;
    }

    /**
     * Insert a record into the tree.
     *
     * @param k Key value of the record.
     * @param e The record to insert.
     */
    
    
    public void insert(Key k, T e) {
        root = inserthelp(root, k, e);
        size++;
    }

    /**
     * @return The current subtree, modified to contain the new item
     */
    private BSTNode<Key, T> inserthelp(BSTNode<Key, T> rt, Key k, T e) {
        if (rt == null) {
            return new BSTNode<Key, T>(k, e);
        }
        if (rt.getKey().compareTo(k) > 0) {//if(k<rt.getkey())
            rt.setLeft(inserthelp(rt.getLeft(), k, e));
        } else {
            rt.setRight(inserthelp(rt.getRight(), k, e));
        }
        return rt;
    }

    public T find(Key k) {
        return findhelp(root, k);
    }

    private T findhelp(BSTNode<Key, T> rt, Key k) {
        if (rt == null) {
            return null;
        }
        if (rt.getKey().compareTo(k) > 0) {
            return findhelp(rt.getLeft(), k);
        } else if (rt.getKey().compareTo(k) == 0) {
            return rt.getData();
        } else {
            return findhelp(rt.getRight(), k);
        }
    }

    private BSTNode<Key, T> getmin(BSTNode<Key, T> rt) {
        if (rt.getLeft() == null) {
            return rt;
        }
        return getmin(rt.getLeft());
    }

    private BSTNode<Key, T> deletemin(BSTNode<Key, T> rt) {
        if (rt.getLeft() == null) {
            return rt.getRight();
        }

        rt.setLeft(deletemin(rt.getLeft()));
        return rt;
    }

    public T remove(Key k) {
        T temp = findhelp(root, k);   // First find it
        if (temp != null) {
            root = removehelp(root, k); // Now remove it
            size--;
        }
        return temp;
    }

    private BSTNode<Key, T> removehelp(BSTNode<Key, T> rt, Key k) {
        if (rt == null) {
            return null;
        }
        if (rt.getKey().compareTo(k) > 0) {//if( k<rt.getkey() )
            rt.setLeft(removehelp(rt.getLeft(), k));
        } else if (rt.getKey().compareTo(k) < 0) {
            rt.setRight(removehelp(rt.getRight(), k));
        } else { // Found it 
            if (rt.getLeft() == null) {
                return rt.getRight();
            } else if (rt.getRight() == null) {
                return rt.getLeft();
            } else { // Two children
                BSTNode<Key, T> temp = getmin(rt.getRight());
                rt.setData(temp.getData());
                rt.setKey(temp.getKey());
                rt.setRight(deletemin(rt.getRight()));
            }
        }
        return rt;
    }

    public BSTNode getRoot() {
        return root;
    }

    public boolean isInternal(BSTNode t) {
        if (t != null) {
            if (t.getLeft() != null) {
                return true;
            }
            if (t.getRight() != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void inOrder(BSTNode p) {
        if (p != null) {
            inOrder(p.getLeft());
                System.out.print(p.getData() + " ");
            inOrder(p.getRight());
        }
    }

    //------------------Lab Exercises--------------------------------
    
    public int size(BSTNode p){
        int counter=0;
        if(p!= null){
       counter= size(p.getRight())+size(p.getLeft())+1;
       }
       return counter;
    
    }
    public BSTNode setRoot(BSTNode p) {
        
        root=p;
        return root;
    }

    public BSTNode parent(BSTNode r, BSTNode t) {//root, Node that i want to return the parent
    BSTNode p=null;
        if(t==root)
         return null;
     else{
         if(r.getRight()==t || r.getLeft()==t)
             return r;
         else{
             if(r.getRight()!=null && r.getLeft() !=null){
        p=  parent(r.getRight(),t);
        p=parent(r.getLeft(),t);
    
    }
     
    } 
        
    }
   return p;
    }
   
    public int toSortedArray(BSTNode p, int[] a, int i) {
    if(p==null) 
        return i;
    i=toSortedArray(p.getLeft(),a,i);
    if(p.getData() !=null)
        a[i++]=(int)p.getData();
      i=toSortedArray(p.getRight(),a,i);
      return i; //LPR
    }
    public Integer getMax(BSTNode p){
        if(p==null)
            return null;
        BSTNode temp=p;
        while(temp.getRight() !=null)
        temp=temp.getRight();
        return (int)temp.getData();
    }
 
    void printSingles(BSTNode node) {
  if(node==null)
      return;
  if(node.getRight()==null &&node.getLeft()!=null)
            System.out.println(node.getLeft().getData());
  
    if(node.getRight()!=null &&node.getLeft()==null)
            System.out.println(node.getRight().getData());
          
    printSingles(node.getLeft());
     printSingles(node.getRight());
    }
public void DeletLeaf(){
    root=leavesDelet(root);
}
    public BSTNode leavesDelet(BSTNode root) {
       if(root==null)
      return null;
       
   if(root.getLeft() !=null)   
     if(root.getLeft().getRight()==null &&root.getLeft().getLeft()==null)
         root.setLeft(null); 
   
     leavesDelet(root.getLeft());
     
        if(root.getRight() !=null)   
     if(root.getRight().getLeft()==null &&root.getRight().getRight()==null)
         root.setRight(null); 
        leavesDelet(root.getRight());
        
        return root;
    }
public void IncrementByOne(BSTNode n){
    if(n==null)
        return;
    IncrementByOne(n.getLeft());
    
    if(n.getData() !=null)
    n.setData( (int)n.getData()+1 );
    
     IncrementByOne(n.getRight());
}
    
     
    //---------------//Below methods used to print BST------------------------
    
  

    public void depth(BSTNode<Key, T> n, int d) {
        if (n != null) {
            n.setDepth(d);
            if (n.getLeft() != null) {
                depth(n.getLeft(), d + 1);
            }
            if (n.getRight() != null) {
                depth(n.getRight(), d + 1);
            }
        }
    }

    public int rank(BSTNode<Key, T> n, int r) {
        if (n != null) {
            if (n.getLeft() != null) {
                r = rank(n.getLeft(), r);
            }
            n.setRank(r++);
            if (n.getRight() != null) {
                r = rank(n.getRight(), r);
            }
            return r;
        }
        return r;
    }

}
