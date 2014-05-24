package controllers;

import jackson.Parser;
import jackson.imdb.Movie;
import jackson.tracktv.TrackTV;
import jackson.tvrage.Show;
import jpa.models.MovieModel;
import jpa.service.MovieService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fstancu on 5/22/2014.
 */

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    Parser parser;

    @Autowired
    MovieService movieService;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.POST)
    public String search(@RequestParam String name, ModelMap model) {

        TrackTV trackTV = parser.getTrackTVData(name);
        List<MovieModel> movieModelListTrackTV = new ArrayList<MovieModel>();
        if (trackTV != null)
            for (MovieModel movieModel : trackTV.toJPAModel())
                movieModelListTrackTV.add(movieModel);

        Movie[] movies = parser.getIMDBData(name);
        List<MovieModel> movieModelListIMDB = new ArrayList<MovieModel>();
        if (movies != null)
            for (Movie movie : movies)
                movieModelListIMDB.add(movie.toJPAModel());
/*
        for (MovieModel movieModel : movieModelList)
            movieService.save(movieModel);
*/

        // urmeaza sa fac interclasarea

        List<MovieModel> movieModelList = new ArrayList<MovieModel>();

        Iterator<MovieModel> movieModelListTrackTVIterator = movieModelListTrackTV.iterator();
        while (movieModelListTrackTVIterator.hasNext()) {

            MovieModel movieModelTrackTV = movieModelListTrackTVIterator.next();

            Iterator<MovieModel> movieModelListIMDBIterator = movieModelListIMDB.iterator();
            while (movieModelListIMDBIterator.hasNext()) {

                MovieModel movieModelIMDB = movieModelListIMDBIterator.next();

                if (movieModelTrackTV.equals(movieModelIMDB)) {
                    movieModelTrackTV.merge(movieModelIMDB);
                    movieModelListIMDBIterator.remove();
                    break;
                }

            }

            movieModelList.add(movieModelTrackTV);

        }

        movieModelList.addAll(movieModelListIMDB);

        // sfarsit de interclasare

        model.addAttribute("title", "Search");
        model.addAttribute("query", name);
        model.addAttribute("movies", movieModelList);

        return "list";

    }

    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public Show[] callback(@RequestBody String showInfos, ModelMap model) {

        Show[] shows = null;

        try {
            shows = objectMapper.readValue(showInfos, Show[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(showInfos);

        return shows;

    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        model.addAttribute("title", "Search");

        return "search";

    }

}
