package com.example.travelguideapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.geometry.Point;

public class Attraction implements Parcelable {

    private String name;
    private String fullDescription;
    private String openingHours;
    private Point coordinates;
    private double ticketPrice;
    private double durationOfInspection;

    public Attraction(String name, String fullDescription, Point coordinates, double ticketPrice, double durationOfInspection) {
        this.name = name;
        this.fullDescription = fullDescription;
        this.coordinates = coordinates;
        this.ticketPrice = ticketPrice;
        this.durationOfInspection = durationOfInspection;
    }

    public Attraction(String name, String fullDescription, String openingHours, Point coordinates, double ticketPrice, double durationOfInspection) {
        this.name = name;
        this.fullDescription = fullDescription;
        this.openingHours = openingHours;
        this.coordinates = coordinates;
        this.ticketPrice = ticketPrice;
        this.durationOfInspection = durationOfInspection;
    }

    protected Attraction(Parcel in) {
        name = in.readString();
        fullDescription = in.readString();
        openingHours = in.readString();
        coordinates = new Point(in.readDouble(), in.readDouble());
        ticketPrice = in.readDouble();
        durationOfInspection = in.readDouble();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFullDescription() {
        return fullDescription;
    }
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getOpeningHours() {
        return openingHours;
    }
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Point getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getDurationOfInspection() {
        return durationOfInspection;
    }
    public void setDurationOfInspection(double durationOfInspection) {
        this.durationOfInspection = durationOfInspection;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(fullDescription);
        dest.writeString(openingHours);
        dest.writeDouble(coordinates.getLatitude());
        dest.writeDouble(coordinates.getLongitude());
        dest.writeDouble(ticketPrice);
        dest.writeDouble(durationOfInspection);
    }

    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel source) {
            return new Attraction(source);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };
}
