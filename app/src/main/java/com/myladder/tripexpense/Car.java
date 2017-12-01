package com.myladder.tripexpense;

/**
 * Created by Manu on 12/1/2017.
 */

import com.google.common.base.MoreObjects;

public class Car {

    private long Id;
    private String Name;
    private int Price;

    public Car(long Id, String Name, int Price) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(Car.class)
                .add("id", Id)
                .add("name", Name)
                .add("price", Price)
                .toString();
    }
}