package controllers;

import exceptions.QueryException;
import jackson.imdb.Movie;
import jackson.imdb.Query;
import jackson.tracktv.TrackTV;
import jpa.service.ShowService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import rest.RestClient;

import java.io.IOException;
import java.util.List;

/**
 * Created by fstancu on 5/22/2014.
 */

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    RestClient restClient;

    @Autowired
    ShowService showService;

    @Autowired
    ObjectMapper objectMapper;

    public Movie[] getIMDBData(String query) {

        ResponseEntity<String> responseEntity = null;

        try {
            responseEntity = restClient.jsonToObject("http://localhost:8082/movies/" + query);
        } catch (QueryException e) {
            e.printStackTrace();
        }

        Query queryJSONObject = null;
        try {
            queryJSONObject = objectMapper.readValue(responseEntity.getBody(), Query.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {

            try {
                responseEntity = restClient.jsonToObject(queryJSONObject.getDetail());
            } catch (QueryException e) {
                e.printStackTrace();
            }

            if (responseEntity.getStatusCode().value() == 200)
                break;

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        Movie[] movies = null;

        try {
            movies = objectMapper.readValue(responseEntity.getBody(), Movie[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;

    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Movie[] search(@RequestParam String name, ModelMap model) {

        // "http://localhost:8081/tracktv?query=" + name


        return getIMDBData(name);

/*
            TrackTV TrackTV = responseEntity.getBody();

            List<ShowModel> showModelList = trackTV.toJPAModel();
            if (showModelList.isEmpty())
                return null;

            for (ShowModel showModel : showModelList)
                showService.save(showModel);

            return TrackTV;
*/
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        model.addAttribute("title", "Search");

        return "search";

    }

}
