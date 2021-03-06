package com.example.fypmetroapp;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Station {
    int distance;
    String name;
    LatLng position;
    String type;
    ArrayList<Bus> buses;
    ArrayList<Station> connects_to;
    ArrayList<LRT> lines;
    int occupancy;

    public Station(int distance, String name, LatLng position, String type, ArrayList<Bus> buses) {
        this.distance = distance;
        this.name = name;
        this.position = position;
        this.type = type;
        this.buses = buses;
    }

    public Station() {
        //default constructor
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public ArrayList<LRT> getLines() {
        return lines;
    }

    public void setLines(ArrayList<LRT> lines) {
        this.lines = lines;
    }

    public ArrayList<Station> getConnects_to() {
        return connects_to;
    }

    public void setConnects_to(ArrayList<Station> connects_to) {
        this.connects_to = connects_to;
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }

    public Station addStation () {
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public LatLng getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }

    public Station setStations (String name, String type, LatLng position) {
        Station station = new Station();
        station.name = name;
        station.type = type;
        station.position = position;
        station.distance = distance;
        return station;
    }
}
