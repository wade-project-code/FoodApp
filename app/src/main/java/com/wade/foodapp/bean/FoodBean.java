package com.wade.foodapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Wade on 2020/2/16.
 */
public class FoodBean implements Parcelable {
    private String ID;
    private String Name;
    private String Address;
    private String Tel;
    private String HostWords;
    private String Price;
    private String OpenHours;
    private String CreditCard;
    private String TravelCard;
    private String TrafficGuidelines;
    private String ParkingLot;
    private String Url;
    private String Email;
    private String BlogUrl;
    private String PetNotice;
    private String Reminder;
    private String FoodMonths;
    private String FoodCapacity;
    private String FoodFeature;
    private String City;
    private String Town;
    private String Coordinate;
    private String PicURL;

    protected FoodBean(Parcel in) {
        ID = in.readString();
        Name = in.readString();
        Address = in.readString();
        Tel = in.readString();
        HostWords = in.readString();
        Price = in.readString();
        OpenHours = in.readString();
        CreditCard = in.readString();
        TravelCard = in.readString();
        TrafficGuidelines = in.readString();
        ParkingLot = in.readString();
        Url = in.readString();
        Email = in.readString();
        BlogUrl = in.readString();
        PetNotice = in.readString();
        Reminder = in.readString();
        FoodMonths = in.readString();
        FoodCapacity = in.readString();
        FoodFeature = in.readString();
        City = in.readString();
        Town = in.readString();
        Coordinate = in.readString();
        PicURL = in.readString();
    }

    public static final Creator<FoodBean> CREATOR = new Creator<FoodBean>() {
        @Override
        public FoodBean createFromParcel(Parcel in) {
            return new FoodBean(in);
        }

        @Override
        public FoodBean[] newArray(int size) {
            return new FoodBean[size];
        }
    };

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getHostWords() {
        return HostWords;
    }

    public void setHostWords(String HostWords) {
        this.HostWords = HostWords;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getOpenHours() {
        return OpenHours;
    }

    public void setOpenHours(String OpenHours) {
        this.OpenHours = OpenHours;
    }

    public String getCreditCard() {
        return CreditCard;
    }

    public void setCreditCard(String CreditCard) {
        this.CreditCard = CreditCard;
    }

    public String getTravelCard() {
        return TravelCard;
    }

    public void setTravelCard(String TravelCard) {
        this.TravelCard = TravelCard;
    }

    public String getTrafficGuidelines() {
        return TrafficGuidelines;
    }

    public void setTrafficGuidelines(String TrafficGuidelines) {
        this.TrafficGuidelines = TrafficGuidelines;
    }

    public String getParkingLot() {
        return ParkingLot;
    }

    public void setParkingLot(String ParkingLot) {
        this.ParkingLot = ParkingLot;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getBlogUrl() {
        return BlogUrl;
    }

    public void setBlogUrl(String BlogUrl) {
        this.BlogUrl = BlogUrl;
    }

    public String getPetNotice() {
        return PetNotice;
    }

    public void setPetNotice(String PetNotice) {
        this.PetNotice = PetNotice;
    }

    public String getReminder() {
        return Reminder;
    }

    public void setReminder(String Reminder) {
        this.Reminder = Reminder;
    }

    public String getFoodMonths() {
        return FoodMonths;
    }

    public void setFoodMonths(String FoodMonths) {
        this.FoodMonths = FoodMonths;
    }

    public String getFoodCapacity() {
        return FoodCapacity;
    }

    public void setFoodCapacity(String FoodCapacity) {
        this.FoodCapacity = FoodCapacity;
    }

    public String getFoodFeature() {
        return FoodFeature;
    }

    public void setFoodFeature(String FoodFeature) {
        this.FoodFeature = FoodFeature;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String Town) {
        this.Town = Town;
    }

    public String getCoordinate() {
        return Coordinate;
    }

    public void setCoordinate(String Coordinate) {
        this.Coordinate = Coordinate;
    }

    public String getPicURL() {
        return PicURL;
    }

    public void setPicURL(String PicURL) {
        this.PicURL = PicURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ID);
        parcel.writeString(Name);
        parcel.writeString(Address);
        parcel.writeString(Tel);
        parcel.writeString(HostWords);
        parcel.writeString(Price);
        parcel.writeString(OpenHours);
        parcel.writeString(CreditCard);
        parcel.writeString(TravelCard);
        parcel.writeString(TrafficGuidelines);
        parcel.writeString(ParkingLot);
        parcel.writeString(Url);
        parcel.writeString(Email);
        parcel.writeString(BlogUrl);
        parcel.writeString(PetNotice);
        parcel.writeString(Reminder);
        parcel.writeString(FoodMonths);
        parcel.writeString(FoodCapacity);
        parcel.writeString(FoodFeature);
        parcel.writeString(City);
        parcel.writeString(Town);
        parcel.writeString(Coordinate);
        parcel.writeString(PicURL);
    }

    @Override
    public String toString() {
        return "FoodBean{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Tel='" + Tel + '\'' +
                ", HostWords='" + HostWords + '\'' +
                ", Price='" + Price + '\'' +
                ", OpenHours='" + OpenHours + '\'' +
                ", CreditCard='" + CreditCard + '\'' +
                ", TravelCard='" + TravelCard + '\'' +
                ", TrafficGuidelines='" + TrafficGuidelines + '\'' +
                ", ParkingLot='" + ParkingLot + '\'' +
                ", Url='" + Url + '\'' +
                ", Email='" + Email + '\'' +
                ", BlogUrl='" + BlogUrl + '\'' +
                ", PetNotice='" + PetNotice + '\'' +
                ", Reminder='" + Reminder + '\'' +
                ", FoodMonths='" + FoodMonths + '\'' +
                ", FoodCapacity='" + FoodCapacity + '\'' +
                ", FoodFeature='" + FoodFeature + '\'' +
                ", City='" + City + '\'' +
                ", Town='" + Town + '\'' +
                ", Coordinate='" + Coordinate + '\'' +
                ", PicURL='" + PicURL + '\'' +
                '}';
    }
}
