package jackson;

import exceptions.QueryException;
import jackson.imdb.Movie;
import jackson.imdb.Query;
import jackson.tracktv.TrackTV;
import jackson.tvrage.Show;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import rest.RestClient;

import java.io.IOException;

/**
 * Created by Florin on 5/24/2014.
 */

@Service
public class Parser {

    @Autowired
    RestClient restClient;

    @Autowired
    ObjectMapper objectMapper;

    private static final int PORT_IMDB = 8082;
    private static final int PORT_TRACKTV = 8081;
    private static final int PORT_TVRAGE = 8083;

    /**
     *
     * Metoda care-mi returneaza un obiect din raspunsul dat ca parametru.
     *
     * @param data
     * Raspunsul de la serverul "search-provider-with-callback".
     *
     * @return
     * O lista cu obiectele mapate.
     *
     */

    public Show[] parseTVRageData(String data) {

        Show[] shows = null;

        try {
            shows = objectMapper.readValue(data, Show[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return shows;

    }

    /**
     *
     * Metoda care interogheaza si mapeaza raspunsul
     * dat de serverul "search-provider-with-pooling".
     *
     * @param query
     * Query-ul introdus de utilizator.
     *
     * @return
     * Un vector cu filmele care au fost gasite.
     *
     */

    public Movie[] getIMDBData(String query) {

        ResponseEntity<String> responseEntity = null;

        /**
         *
         * Trimitem cererea catre server si extragem link-ul catre rezultate.
         *
         */

        try {
            responseEntity = restClient.jsonToObject("http://localhost:" + PORT_IMDB + "/movies/" + query);
        } catch (QueryException e) {
            e.printStackTrace();
        }

        if (responseEntity == null)
            return null;

        Query queryJSONObject = null;
        try {
            queryJSONObject = objectMapper.readValue(responseEntity.getBody(), Query.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         *
         * Pana aici am extras link-ul cu rezultate si urmeaza sa
         * interoghez serverul pana cand imi da rezultatele.
         * Se fac maxim 7 request-uri pentru ca utilizatorul sa nu astepte prea mult.
         *
         */

        int requestNumber = 0;

        while(true) {

            try {
                responseEntity = restClient.jsonToObject(queryJSONObject.getDetail());
            } catch (QueryException e) {
                e.printStackTrace();
            }

            if (responseEntity == null)
                return null;

            requestNumber++;

            if (responseEntity.getStatusCode().value() == 200)
                break;
            else if (requestNumber == 7)
                return null;

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        String body = responseEntity.getBody();

        /**
         *
         * Mapam rezultatele intr-un obiect.
         *
         */

        Movie[] movies = null;

        try {
            movies = objectMapper.readValue(body, Movie[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;

    }

    /**
     *
     * Metoda care interogheaza si mapeaza raspunsul
     * dat de serverul "syncwebserver".
     *
     * @param query
     * Query-ul introdus de utilizator.
     *
     * @return
     * Raspunsul dat de server .
     *
     */

    public TrackTV getTrackTVData(String query) {

        ResponseEntity<String> responseEntity = null;

        /**
         *
         * Interogam serverul si extragem rezultatele.
         *
         */

        try {
            responseEntity = restClient.jsonToObject("http://localhost:" + PORT_TRACKTV + "/tracktv?query=" + query);
        } catch (QueryException e) {
            e.printStackTrace();
        }

        if (responseEntity == null)
            return null;

        /**
         *
         * Mapam rezultatele folosind jackson.
         *
         */

        TrackTV trackTV = null;
        // eliminam caractere ciudate care strica maparea jackson
        String body = responseEntity.getBody().replaceAll("[^\\x20-\\x7e]", "");

        try {
            trackTV = objectMapper.readValue(body, TrackTV.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trackTV;

    }

    /**
     *
     * Metoda care interogheaza serverul "search-provider-with-callback".
     *
     * @param query
     * Query-ul introdus de utilizator.
     *
     */

    public void getTVRageData(String query) {

        ResponseEntity<String> responseEntity = null;

        /**
         *
         * Trimitem cererea catre server.
         * Cererea este trimisa de maxim 7 ori in caz ca server-ul nu vrea sa ne raspunda.
         *
         */

        int requestNumber = 0;

        while(true) {

            try {
                responseEntity = restClient.jsonToObject("http://localhost:" + PORT_TVRAGE + "/tvrage/query/" +
                        query + "?callback=http://localhost:8080/callback?queried_for=" + query);
            } catch (QueryException e) {
                e.printStackTrace();
            } catch (HttpServerErrorException e) {
                e.printStackTrace();
            }

            requestNumber++;

            if (responseEntity == null)
                return;

            if (responseEntity.getStatusCode().value() == 200)
                break;
            else if (requestNumber == 7)
                break;

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
