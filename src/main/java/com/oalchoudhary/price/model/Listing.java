package com.oalchoudhary.price.model;

public class Listing {
    private String product_Name;
    private String product_Price;
    private String product_Quality;
    private String product_Unit;
    private String product_Stock;
    private String product_State;
    private String product_District;
    private String farmer_Name;
    private String farmer_Phone_Number;
    private String farmer_Whatsapp_Number;

    public Listing() {
    }

    public Listing(String product_Name, String product_Price, String product_Quality, String product_Unit, String product_Stock, String product_State, String product_District, String farmer_Name, String farmer_Phone_Number, String farmer_Whatsapp_Number) {
        this.product_Name = product_Name;
        this.product_Price = product_Price;
        this.product_Quality = product_Quality;
        this.product_Unit = product_Unit;
        this.product_Stock = product_Stock;
        this.product_State = product_State;
        this.product_District = product_District;
        this.farmer_Name = farmer_Name;
        this.farmer_Phone_Number = farmer_Phone_Number;
        this.farmer_Whatsapp_Number = farmer_Whatsapp_Number;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public void setProduct_Price(String product_Price) {
        this.product_Price = product_Price;
    }

    public void setProduct_Quality(String product_Quality) {
        this.product_Quality = product_Quality;
    }

    public void setProduct_Unit(String product_Unit) {
        this.product_Unit = product_Unit;
    }

    public void setProduct_Stock(String product_Stock) {
        this.product_Stock = product_Stock;
    }

    public void setProduct_State(String product_State) {
        this.product_State = product_State;
    }

    public void setProduct_District(String product_District) {
        this.product_District = product_District;
    }

    public void setFarmer_Name(String farmer_Name) {
        this.farmer_Name = farmer_Name;
    }

    public void setFarmer_Phone_Number(String farmer_Phone_Number) {
        this.farmer_Phone_Number = farmer_Phone_Number;
    }

    public void setFarmer_Whatsapp_Number(String farmer_Whatsapp_Number) {
        this.farmer_Whatsapp_Number = farmer_Whatsapp_Number;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public String getProduct_Price() {
        return product_Price;
    }

    public String getProduct_Quality() {
        return product_Quality;
    }

    public String getProduct_Unit() {
        return product_Unit;
    }

    public String getProduct_Stock() {
        return product_Stock;
    }

    public String getProduct_State() {
        return product_State;
    }

    public String getProduct_District() {
        return product_District;
    }

    public String getFarmer_Name() {
        return farmer_Name;
    }

    public String getFarmer_Phone_Number() {
        return farmer_Phone_Number;
    }

    public String getFarmer_Whatsapp_Number() {
        return farmer_Whatsapp_Number;
    }
}
