package com.github.algo.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReconstructItineraryTest {

    @Test
    void findItinerary() {
        List<List<String>> ticketList = new LinkedList<>();
        ticketList.add(Arrays.asList("JFK", "SFO"));
        ticketList.add(Arrays.asList("JFK", "ATL"));
        ticketList.add(Arrays.asList("SFO", "ATL"));
        ticketList.add(Arrays.asList("ATL", "JFK"));
        ticketList.add(Arrays.asList("ATL","SFO"));


        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> itinerary = reconstructItinerary.findItinerary(ticketList);
        System.out.println(itinerary);
    }
}