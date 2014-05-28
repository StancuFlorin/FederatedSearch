package util;

import jpa.models.MovieModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fstancu on 5/28/2014.
 */

public class Util {

    public static List<MovieModel> mergeModels(List<MovieModel> listA, List<MovieModel> listB) {

        List<MovieModel> movieModelList = new ArrayList<MovieModel>();

        Iterator<MovieModel> movieModelListTrackTVIterator = listA.iterator();
        while (movieModelListTrackTVIterator.hasNext()) {

            MovieModel movieModelTrackTV = movieModelListTrackTVIterator.next();

            Iterator<MovieModel> movieModelListIMDBIterator = listB.iterator();
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

        movieModelList.addAll(listB);

        return movieModelList;

    }

}
