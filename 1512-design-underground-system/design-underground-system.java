class UndergroundSystem {

   private Map<Integer, CheckInData> checkInMap;
    private Map<String, TripData> checkOutMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        checkOutMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData checkInData = checkInMap.get(id);
        String entryStation = checkInData.stationName;
        int entryTime = checkInData.time;

        int timeTaken = t - entryTime;
        String route = entryStation + "_" + stationName;

        checkOutMap.putIfAbsent(route, new TripData(0, 0));
        TripData tripData = checkOutMap.get(route);
        tripData.totalTime += timeTaken;
        tripData.tripCount++;

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "_" + endStation;
        TripData tripData = checkOutMap.get(route);
        return (double) tripData.totalTime / tripData.tripCount;
    }

    private static class CheckInData {
        String stationName;
        int time;

        CheckInData(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class TripData {
        int totalTime;
        int tripCount;

        TripData(int totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */