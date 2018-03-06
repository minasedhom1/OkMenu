package com.av.okmenu.classes;

import java.util.ArrayList;

/**
 * Created by Mina on 3/6/2018.
 */

public class SyncDataResponse {
    String id,name,email,image,themeColor,themeAccentColor,refId,restaurantName,currency,currencyFormat,phone,error,message;
    ArrayList<Category> categories;
    ArrayList<Item> items;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public String getThemeAccentColor() {
        return themeAccentColor;
    }

    public String getRefId() {
        return refId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCurrencyFormat() {
        return currencyFormat;
    }

    public String getPhone() {
        return phone;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
