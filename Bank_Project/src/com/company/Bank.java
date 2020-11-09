package com.company;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branchList;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branchList = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findpostion(branchName) < 0) {
            this.branchList.add(new Branch(branchName));
            System.out.println(branchName + " is succesfuly added to "+bankName+".");
            return true;
        } else {
            System.out.println("Sorry! branch with name " + branchName + " already exist in our records.");
            return false;
        }

    }

    public int findpostion(String name) {
        for (int i = 0; i < branchList.size(); i++) {
            String currentBranchName = branchList.get(i).getBranchName();
            if (currentBranchName.equalsIgnoreCase(name)) {
                return i;
            }

        }
        return -1;
    }
    public Branch findBranch(String branchName){
        if (findpostion(branchName)>=0){
           return branchList.get(findpostion(branchName));
        }
        else
            return  null;
    }

    public void printAllBranches() {
        int counter=1;
        for (int i = 0; i < branchList.size(); i++) {
            System.out.println("["+counter+"]"+"\t"+branchList.get(i).getBranchName().toUpperCase());
        counter++;
        }
    }
    public  boolean addCustomer(String branchName,String customerName,double initial){
        Branch branch=findBranch(branchName);
        if (branch!=null){
            branch.addCustomer(customerName,initial);
            return  true;
        }
        else
        {
            System.out.println(branchName+"do not exist in our bank records.");
            return false;
        }

    }
    public  boolean addCustomerTransaction(String branchName,String customerName,double initial){
        Branch branch=findBranch(branchName);
        if (branch!=null){
            branch.addTransaction(customerName,initial);
            return  true;
        }
        else
        {
            System.out.println(branchName+"do not exist in records of "+bankName);
            return false;
        }

    }
    public void printParticluarBranchCustomers(String branchName){
        int counter=1;
        Branch branch=findBranch(branchName);
        branch.printCustomerList();
       }
    }

