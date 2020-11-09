package com.company;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.ArrayList;

public class Branch {
    private String branchName;

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    private ArrayList<Customer> customerList;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customerList = new ArrayList<Customer>();
    }

    public boolean addCustomer(String customerName, double amount) {
        if (findpostion(customerName) < 0) {
            this.customerList.add(new Customer(customerName, amount));
            System.out.println(customerName + " is succesfuly added.");
            return true;
        } else {
            System.out.println("Sorry! Customer with name " + customerName + " already exist in our records.");
            return false;
        }

    }
    public boolean addTransaction(String customerName,double amount){
        int postion=findpostion(customerName);
        if (findpostion(customerName) >= 0){
            this.customerList.get(postion).addTransaaction(amount);
            System.out.println("Transaction related to "+customerName+" is succesfuly updated");
            return true;
        }
        else{
            System.out.println(customerName+"do not exit in records of "+branchName);
            return false;

        }


    }

    public int findpostion(String name) {
        for (int i = 0; i < customerList.size(); i++) {
            String currentCustomer = customerList.get(i).getCustomerName();
            if (currentCustomer.equalsIgnoreCase(name)) {
                return i;
            }

        }
        return -1;
    }
    public void printCustomerList(){
        int counter=1;
        for(int i=0;i<customerList.size();i++){
            System.out.println("["+counter+"]"+customerList.get(i).getCustomerName().toUpperCase()+"\t\t"+"{"+customerList.get(i).gettransactionLIst()+"}");
        counter++;
        }
    }

}
