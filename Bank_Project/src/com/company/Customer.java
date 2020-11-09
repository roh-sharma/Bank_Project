package com.company;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double> transactionLIst;

    public Customer(String customerName,double amount) {
        this.customerName = customerName;
        this.transactionLIst =new ArrayList<Double>();
        addTransaaction(amount);
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> gettransactionLIst() {
        return transactionLIst;
    }
    public void addTransaaction(double amount){
        this.transactionLIst.add(amount);
    }

}
