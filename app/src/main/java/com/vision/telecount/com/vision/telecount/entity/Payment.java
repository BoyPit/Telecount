package com.vision.telecount.com.vision.telecount.entity;

import java.util.Objects;

public class Payment {
    private User user;
    private Group group;
    private int cash;

    public Payment(){

    }

    public Payment(User user, Group group, int cash) {
        this.user = user;
        this.group = group;
        this.cash = cash;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return cash == payment.cash &&
                Objects.equals(user, payment.user) &&
                Objects.equals(group, payment.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, group, cash);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "user=" + user +
                ", group=" + group +
                ", cash=" + cash +
                '}';
    }
}
