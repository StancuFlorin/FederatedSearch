package controllers;

import jackson.Parser;
import jackson.imdb.Movie;
import jackson.tracktv.TrackTV;
import jackson.tvrage.Show;
import jpa.models.MovieModel;
import jpa.models.QueryModel;
import jpa.service.MovieService;
import jpa.service.QueryService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import rest.Response;
import util.Util;

import java.util.ArrayList;
import java.util.Date;
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
    QueryService queryService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Response response;

    @Autowired
    Util util;

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String search(@RequestParam String query, @RequestParam(required = false) String page, ModelMap model) {

        int pageNumber = 0;
        try {
            pageNumber = Integer.parseInt(page);
        } catch (NumberFormatException e) {
            pageNumber = 0;
        }

        List<MovieModel> movieModelList = new ArrayList<MovieModel>();
        QueryModel queryModel = queryService.find(query);

        /**
         * Daca exista in baza de date.
         */

        if (queryModel != null) {

            Date date = new Date();
            Long minutes = (date.getTime() - queryModel.getDate().getTime()) / (1000 * 60);

            /**
             * Si sunt mai vechi de 15 minute.
             */

            if (minutes > 15) {

                queryService.remove(queryModel);
                queryModel = null;

            }

        }

        /**
         * Daca nu mai exista in baza de date.
         * Daca au exista candva, au fost sterse de instructiunea de mai sus.
         */

        if (queryModel == null) {

            /**
             * Luam datele de la servere.
             */

            parser.getTVRageData(query);

            TrackTV trackTV = parser.getTrackTVData(query);
            List<MovieModel> movieModelListTrackTV = new ArrayList<MovieModel>();
            if (trackTV != null)
                for (MovieModel movieModel : trackTV.toJPAModel())
                    movieModelListTrackTV.add(movieModel);

            Movie[] movies = parser.getIMDBData(query);
            List<MovieModel> movieModelListIMDB = new ArrayList<MovieModel>();
            if (movies != null)
                for (Movie movie : movies)
                    movieModelListIMDB.add(movie.toJPAModel());

            String data = response.get(query);
            List<MovieModel> movieModelListTVRage = new ArrayList<MovieModel>();
            if (data != null) {

                Show[] shows = parser.parseTVRageData(data);
                for (Show show : shows)
                    movieModelListTVRage.add(show.toJPAModel());

            }

            /**
             * Facem merge pe obiectele din rezultate.
             */

            movieModelList = util.mergeModels(movieModelListTrackTV, movieModelListIMDB);
            movieModelList = util.mergeModels(movieModelList, movieModelListTVRage);

            /**
             * Apoi le salvam in baza de date pentru cache.
             */

            queryModel = new QueryModel();
            queryModel.setQuery(query);
            queryModel.setDate(new Date());

            queryModel.setMovies(movieModelList);
            queryService.save(queryModel);

        } else {

            /**
             * Daca exista in baza de date si inca sunt valide.
             */

            movieModelList = queryModel.getMovies();
            if (movieModelList == null)
                movieModelList = new ArrayList<MovieModel>();

        }

        /**
         * Urmeaza sa facem paginarea.
         */

        int itemsPage = 10;

        if (pageNumber <= 1)
            pageNumber = 0;
        else
            pageNumber--;

        int start = itemsPage * pageNumber;
        int end = itemsPage * (pageNumber + 1);
        if (end > movieModelList.size())
            end = movieModelList.size();

        if (start > end)
            start = end;

        int items = movieModelList.size();
        int pages = items / itemsPage;
        if (items % itemsPage != 0)
            pages++;

        List<MovieModel> shortMovieModelList = movieModelList.subList(start, end);

        model.addAttribute("title", "Search");
        model.addAttribute("pages", pages);
        model.addAttribute("query", query);
        model.addAttribute("page", (pageNumber + 1) +  "");
        model.addAttribute("movies", shortMovieModelList);

        return "list";

    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        model.addAttribute("title", "Search");

        return "search";

    }

}
