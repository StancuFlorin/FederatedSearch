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
    MovieService movieService;

    @Autowired
    QueryService queryService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Response response;

    @RequestMapping(method = RequestMethod.POST)
    public String search(@RequestParam String name, ModelMap model) {

        List<MovieModel> movieModelList = new ArrayList<MovieModel>();;

        QueryModel queryModel = queryService.find(name);

        if (queryModel == null) {

            parser.getTVRageData(name);

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

            String data = response.get(name);
            List<MovieModel> movieModelListTVRage = new ArrayList<MovieModel>();
            if (data != null) {

                Show[] shows = parser.parseTVRageData(data);
                for (Show show : shows)
                    movieModelListTVRage.add(show.toJPAModel());

            }

            // urmeaza sa fac interclasarea

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

            Iterator<MovieModel> movieModelListIterator = movieModelList.iterator();
            while (movieModelListIterator.hasNext()) {

                MovieModel movieModel = movieModelListIterator.next();

                Iterator<MovieModel> movieModelListTVRageIterator = movieModelListTVRage.iterator();
                while (movieModelListTVRageIterator.hasNext()) {

                    MovieModel movieModelTVRage = movieModelListTVRageIterator.next();

                    if (movieModel.equals(movieModelTVRage)) {
                        movieModel.merge(movieModelTVRage);
                        movieModelListTVRageIterator.remove();
                        break;
                    }

                }

            }

            movieModelList.addAll(movieModelListTVRage);

            // sfarsit de interclasare

            queryModel = new QueryModel();
            queryModel.setQuery(name);
            queryModel.setDate(new Date());

            queryModel.setMovies(movieModelList);
            queryService.save(queryModel);

        } else {

            movieModelList = queryModel.getMovies();
            if (movieModelList == null)
                movieModelList = new ArrayList<MovieModel>();

        }

        model.addAttribute("title", "Search");
        model.addAttribute("query", name);
        model.addAttribute("movies", movieModelList);

        return "list";

    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        model.addAttribute("title", "Search");

        return "search";

    }

}
