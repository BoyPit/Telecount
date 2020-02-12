package com.vision.telecount.com.vision.telecount.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private String label;
    private String description;
    private int fund;
    private List<User> users;
    private List<Payment> payments;

    public Group(){

    }

    public Group(String label, String description, int fund, List<User> users, List<Payment> payments) {
        this.label = label;
        this.description = description;
        this.fund = fund;
        this.users = users;
        this.payments = payments;
    }

    public void addUser(User u){
        users.add(u);
        if (!u.getGroups().contains(this))
            u.addGroup(this);
    }

    public void addPayment(Payment p){
        payments.add(p);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getFund() {
        return fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Payment> getPayments(User u) {
        List<Payment> userPayments = new ArrayList<>();
        for(Payment p: payments)
        {
            userPayments.add(p);
        }
        return userPayments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return fund == group.fund &&
                Objects.equals(label, group.label) &&
                Objects.equals(users, group.users) &&
                Objects.equals(payments, group.payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, fund, users, payments);
    }

    @Override
    public String toString() {
        return "Group{" +
                "label='" + label + '\'' +
                ", fund=" + fund +
                ", users=" + users +
                ", payments=" + payments +
                '}';
    }
}
