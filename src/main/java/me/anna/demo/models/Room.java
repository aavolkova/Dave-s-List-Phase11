package me.anna.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;



    @NotNull
    @Size(min=1, max=100, message = "Enter your descriptions.")
    private String description;

    @NotNull
    @Size(min=1, max=100, message = "Enter your rules.")
    private String rules;

    // Default value: room is available
    private boolean isRented;


    private String cable = "none";

    private boolean wifi;

    private boolean privateBathroom;



//    private String wifi;            // (yes/no),   bolean?
//    private String cable;           // (none/basic/premium) bolean?
//    private String privateBathroom; // (yes/no)bolean?




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public boolean getIsRented() {
        return isRented;
    }

    public void setIsRented(boolean rented) {
        isRented = rented;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }



    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isPrivateBathroom() {
        return privateBathroom;
    }

    public void setPrivateBathroom(boolean privateBathroom) {
        this.privateBathroom = privateBathroom;
    }


}
