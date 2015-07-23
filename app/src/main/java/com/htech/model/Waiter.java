package com.htech.model;

import java.util.Comparator;

/**
 * This is waiter model class
 */
public class Waiter implements Comparable<Waiter> {
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String latitude;
    private String longitude;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public int compareTo(Waiter another) {
        return name.compareTo(another.name);
    }

    /*
     * Sort by address
     */
    public static Comparator<Waiter> COMPARE_BY_ADDRESS = new Comparator<Waiter>() {
        public int compare(Waiter one, Waiter other) {
            return one.address.compareTo(other.address);
        }
    };
     /*
      * Sort by phone number
      */
    public static Comparator<Waiter> COMPARE_BY_PHONE = new Comparator<Waiter>() {
        public int compare(Waiter one, Waiter other) {
            return one.phone.compareTo(other.phone);
        }
    };
}
