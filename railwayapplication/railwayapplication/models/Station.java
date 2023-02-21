package com.kamble.railwayapplication.models;

import com.kamble.railwayapplication.enums.StationName;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
public class Station {
    private StationName name;
    private double distanceFromDelhi;

    public Station(StationName name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return name == station.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name=" + name +
                '}';
    }
}

