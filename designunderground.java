import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        int totalTime;
        int tripCount;

        Route(int totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    private Map<Integer, CheckIn> checkInMap;
    private Map<String, Route> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.remove(id);

        String route = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        Route data = routeMap.getOrDefault(route, new Route(0, 0));
        data.totalTime += travelTime;
        data.tripCount++;

        routeMap.put(route, data);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        Route data = routeMap.get(route);
        return (double) data.totalTime / data.tripCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id, stationName, t);
 * obj.checkOut(id, stationName, t);
 * double param_3 = obj.getAverageTime(startStation, endStation);
 */