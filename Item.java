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
public class Item {
    private int item_num;
    private  String item_name;
    private double item_price;
    private double item_cost;
    int count=0;
    public boolean taxIncluded=false;
    public Item(){}

    public Item(int num,String name,double price,double cost ){
        item_num=num;
        item_name=name;
        item_price=price;
        item_cost=cost;
    }
      public Item(int num,String name,double price,double cost, boolean taxIncluded){
        item_num=num;
        item_name=name;
        item_price=price;
        item_cost=cost;
        taxIncluded=false;
    }
    public Item(int num,String name,double price){
        item_num=num;
        item_name=name;
        item_price=price;
    }
	    public int getItem_num() {
		return item_num;
	}

	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}
        public double getItem_cost() {
		return item_cost;
	}

	public void setItem_cost(double item_cost) {
		this.item_cost = item_cost;
	}
        
        @Override
        public String toString(){
            count++;
            return ("\n- Number: "+item_num+"\n- Name: "+item_name+ "\n- Price: "+item_price) ;
                
        }

}
