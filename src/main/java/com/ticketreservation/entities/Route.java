package com.ticketreservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "route")
@Getter
@Setter
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long routeId;

    private String routeName;
    private String startStop;
    private String endStop;
    private int price;

    @OneToMany(mappedBy = "route")
    @JsonIgnore
    private Set<Bus> busses;

    public Route() {
    }

    public Route(Long routeId,String routeName, String startStop, String endStop, int price) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.startStop = startStop;
        this.endStop = endStop;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", routeName='" + routeName + '\'' +
                ", startStop='" + startStop + '\'' +
                ", endStop='" + endStop + '\'' +
                ", price=" + price +
                '}';
    }
}
