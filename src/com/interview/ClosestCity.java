package com.interview;

import java.util.*;

public class ClosestCity {

    static class City {
        String name;
        int x;
        int y;
        public City (String name_, int x_, int y_){
            name = name_;
            x = x_;
            y =y_;
        }
        public int dist(City otherCity) {
            return Math.abs(x - otherCity.x) + Math.abs(y - otherCity.y);
        }
    }


    public static List<String> closestStraightCity(int numOfCities, List<String> cities, List<Integer> xCoordinates,
                                                   List<Integer> yCoordinates, int numOfQueries, List<String> queries){

        List<String> result = new ArrayList<>();


/***
 * xCoordinates =  (3, 2, 1)
 * yCoordinates =  (3, 2, 3)
 * cities       =  ("c1", "c2","c3")
 * */

        Map<Integer, ArrayList<City>> xToCities = new HashMap<>();
        Map<Integer, ArrayList<City>> yToCities = new HashMap<>();
        Map<String, City> cityByName = new HashMap<>();

        for(int i=0; i<cities.size();i++){
            String cityName = cities.get(i);
            int x = xCoordinates.get(i);
            int y = yCoordinates.get(i);

            City city = new City(cityName, x, y);
            xToCities.computeIfAbsent(x, v -> new ArrayList<>());
            yToCities.computeIfAbsent(y, v -> new ArrayList<>());
            xToCities.get(x).add(city);
            yToCities.get(y).add(city);
            cityByName.put(cityName, city);
        }

        Map<String, String> temp = new HashMap<>();
        for(String name : queries){
            if(temp.containsKey(name)) {
                result.add(temp.get(name));
                continue;
            }
            City city = cityByName.get(name);

            int minDist = Integer.MAX_VALUE;
            String closest = null;
            List<City> searchCities = xToCities.get(city.x);
            searchCities.addAll(yToCities.get(city.y));
            for (City otherCity : searchCities) {
                if (otherCity.equals(city)) {
                    continue;
                }
                int dist = city.dist(otherCity);
                if (closest == null || dist < minDist || (dist == minDist && otherCity.name.compareTo(closest) < 0)) {
                    minDist = city.dist(otherCity);
                    closest = otherCity.name;
                }
            }
            if (closest != null) {
                result.add(closest);
                temp.put(name, closest);
            } else {
                result.add("NONE");
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int numOfCitites = 5;
        List<String> cities = new ArrayList<>(Arrays.asList("c1", "c2","c3"));
        List<Integer> xCoordinates = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<Integer> yCoordinates = new ArrayList<>(Arrays.asList(3, 2, 3));
        int numOfQueries = 5;
        List<String> queries = new ArrayList<>(Arrays.asList("c1", "c2", "c3"));

        List<String> result = closestStraightCity(numOfCitites, cities, xCoordinates, yCoordinates, numOfQueries, queries);

        System.out.println(result);
    }
}
