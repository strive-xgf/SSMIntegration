package com.xgf.bean;

public class Person {
    private Integer id;
    private String name;
    private Double money;

    public Person() {
    }

    public Person(Integer id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
