package com.kodilla.good.patterns.airline;

import java.util.HashSet;
import java.util.Set;

public class RoutesDataBase {
    private final Set<Route> routesDataBase = new HashSet<>();

    public RoutesDataBase() {
        this.routesDataBase.add( new Route("KRAKOW", "WARSZAWA"));
        this.routesDataBase.add( new Route("WARSZAWA", "KRAKOW"));
        this.routesDataBase.add( new Route("KRAKOW", "GDANSK"));
        this.routesDataBase.add( new Route("GDANSK", "KRAKOW"));
        this.routesDataBase.add( new Route("GDANSK", "WARSZAWA"));
        this.routesDataBase.add( new Route("WARSZAWA", "GDANSK"));
        this.routesDataBase.add( new Route("WROCLAW", "WARSZAWA"));
        this.routesDataBase.add( new Route("WARSZAWA", "WROCLAW"));
        this.routesDataBase.add( new Route("WROCLAW", "GDANSK"));
        this.routesDataBase.add( new Route("GDANSK", "WROCLAW"));
        this.routesDataBase.add( new Route("WROCLAW", "KRAKOW"));
        this.routesDataBase.add( new Route("KRAKOW", "WROCLAW"));
        this.routesDataBase.add( new Route("POZNAN", "WROCLAW"));
        this.routesDataBase.add( new Route("WROCLAW", "POZNAN"));
        this.routesDataBase.add( new Route("POZNAN", "KRAKOW"));
        this.routesDataBase.add( new Route("KRAKOW", "POZNAN"));
        this.routesDataBase.add( new Route("POZNAN", "WARSZAWA"));
        this.routesDataBase.add( new Route("WARSZAWA", "POZNAN"));
        this.routesDataBase.add( new Route("POZNAN", "GDANSK"));
        this.routesDataBase.add( new Route("GDANSK", "POZNAN"));
    }

    public Set<Route> getRoutesDataBase() {
        return routesDataBase;
    }
}
