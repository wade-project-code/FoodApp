package com.wade.foodapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Wade on 2020/2/19.
 */
public class HistoryBean implements Parcelable {

    private String Date;
    private String ID;
    private String Name;
    private String Time;

    public HistoryBean(String Date, String ID, String Name, String Time) {
        this.Date = Date;
        this.ID = ID;
        this.Name = Name;
        this.Time = Time;
    }

    protected HistoryBean(Parcel in) {
        Date = in.readString();
        ID = in.readString();
        Name = in.readString();
        Time = in.readString();
    }

    public static final Creator<HistoryBean> CREATOR = new Creator<HistoryBean>() {
        @Override
        public HistoryBean createFromParcel(Parcel in) {
            return new HistoryBean(in);
        }

        @Override
        public HistoryBean[] newArray(int size) {
            return new HistoryBean[size];
        }
    };

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Date);
        parcel.writeString(ID);
        parcel.writeString(Name);
        parcel.writeString(Time);
    }

    @Override
    public String toString() {
        return "HistoryBean{" +
                "Date='" + Date + '\'' +
                ", ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
