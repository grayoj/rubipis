package com.boardend.boardend.models;

import javax.persistence.*;

@Entity
@Table(name = "business_delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "drop_address")
    private String dropAddress;

    @Column(name = "pickup_address")
    private String pickupAddress;

    @Column(name = "package_name")
    private String packageName;

    @Column(name = "package_type")
    private String packageType;

    @Column(name = "rider")
    private String deliveryRider;

    @Column(name = "delivered")
    private boolean delivered;

    public Delivery() {

    }

    public Delivery(String dropAddress, String pickupAddress,
                    String packageName, String packageType,
                    String deliveryRider,
                    boolean delivered) {
        this.dropAddress = dropAddress;
        this.pickupAddress = pickupAddress;
        this.packageName = packageName;
        this.packageType = packageType;
        this.deliveryRider = deliveryRider;
        this.delivered = delivered;
    }

    public long getId() {
        return id;
    }

    public String getDropAddress() {
        return dropAddress;
    }

    public void setDropAddress(String dropAddress) {
        this.dropAddress = dropAddress;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getDeliveryRider() {
        return deliveryRider;
    }

    public void setDeliveryRider(String deliveryRider) {
        this.deliveryRider = deliveryRider;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean isDelivered) {
        this.delivered = isDelivered;
    }

    @Override
    public String toString() {
        return "business_delivery [" +
                "id=" + id + ", " +
                "drop_address=" + dropAddress + ", " +
                "pickup_address=" + pickupAddress + ", " +
                "packageName=" + packageName + ", " +
                "packageType=" + packageType + ", " +
                "rider=" + deliveryRider + "]";
    }

}