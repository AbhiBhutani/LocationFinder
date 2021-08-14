
 package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class LocationController {

    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/locations")
    List<Location> newLocations(@RequestBody List<Location> locations)  {
        return repository.saveAll(locations);
    }

    @GetMapping("/locations/{startPostCode}{endPostCode}")
    List<String> getLocationNames(@PathVariable Integer startPostCode, @PathVariable Integer endPostCode) {
        List<Integer> allPostCodes = IntStream.range(startPostCode, endPostCode)
                                        .boxed()
                                        .collect(Collectors.toList());
        return repository.findAll().stream()
                .filter(location -> allPostCodes.contains(location.getPostCode()))
                .map(Location::getName)
                .collect(Collectors.toList());
    }
}
