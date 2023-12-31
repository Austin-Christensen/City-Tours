package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.model.Landmark;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/landmarks")
public class LandmarkController {

    private final LandmarkDao landmarkDao;

    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @GetMapping()
    public List<Landmark> listAllLandmarks(){
        List<Landmark> landmarkList = landmarkDao.listAllLandmarks();

        if (landmarkList == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No landmark found");
        }else{
            return landmarkList;
        }
    }

    @GetMapping("/name/{name}")
    public List<Landmark> getLandmarksByName(@PathVariable String name){
        List<Landmark> landmarksByName = landmarkDao.getLandmarksByName(name);

        if (landmarksByName == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No landmark found");

        }else{
            return landmarksByName;
        }
    }

    @GetMapping("/city/{cityId}")
    public List<Landmark> getLandmarkByCity(@PathVariable int cityId){
        List<Landmark> landmarksByCity = landmarkDao.getLandmarkByCity(cityId);

        if (landmarksByCity == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No landmark found");

        }else{
            return landmarksByCity;
        }
    }

    @GetMapping("/country/{country}")
    public List<Landmark> getLandmarkByCountry(@PathVariable String country){
        List<Landmark> landmarksByCountry = landmarkDao.getLandmarkByCountry(country);

        if (landmarksByCountry == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No landmark found");

        }else{
            return landmarksByCountry;
        }
    }

    @GetMapping("/venue/{venueType}")
    public List<Landmark> getLandmarkByVenueType(@PathVariable String venueType){
        List<Landmark> landmarksByVenueType = landmarkDao.getLandmarkByVenueType(venueType);

        if (landmarksByVenueType == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No landmark found");

        }else{
            return landmarksByVenueType;
        }
    }

    @GetMapping("/id/{landmarkId}")
    public Landmark getLandmarkById(@PathVariable int landmarkId){
        Landmark landmarkById = landmarkDao.getLandmarkById(landmarkId);

        if (landmarkById == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No landmark found");

        }else{
            return landmarkById;
        }
    }

    @GetMapping("/venue")
    public List<String> getVenueTypeList(){
        List<String> landmarksByVenueType = landmarkDao.getVenueTypeList();

        if (landmarksByVenueType == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No landmark found");

        }else{
            return landmarksByVenueType;
        }
    }

    @GetMapping("/itinerary/{itineraryId}")
    public List<Landmark> getLandmarksByItineraryId(@PathVariable int itineraryId){
        List<Landmark> landmarksByItinerary = landmarkDao.getLandmarksByItineraryId(itineraryId);

        if (landmarksByItinerary == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No landmark found");

        }else{
            return landmarksByItinerary;
        }
    }


}
