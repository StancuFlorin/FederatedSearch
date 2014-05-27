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
     * IMDB server
     * Server-ul ruleaza pe portul 8082
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

        // extragem link-ul catre rezultate

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

        // extragem rezultatele

        while(true) {

            try {
                responseEntity = restClient.jsonToObject(queryJSONObject.getDetail());
            } catch (QueryException e) {
                e.printStackTrace();
            }

            if (responseEntity == null)
                return null;

            if (responseEntity.getStatusCode().value() == 200)
                break;

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        String body = responseEntity.getBody();
        body = body.replace("–", "-");

        // parsam rezultatele

        Movie[] movies = null;

        try {
            movies = objectMapper.readValue(body, Movie[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;

    }

    public TrackTV getTrackTVData(String query) {

        ResponseEntity<String> responseEntity = null;

        // extragem rezultatele

        try {
            responseEntity = restClient.jsonToObject("http://localhost:" + PORT_TRACKTV + "/tracktv?query=" + query);
        } catch (QueryException e) {
            e.printStackTrace();
        }

        if (responseEntity == null)
            return null;

        // parsam rezultatele

        TrackTV trackTV = null;
        String body = responseEntity.getBody().replaceAll("[^\\x20-\\x7e]", "");

        try {
            trackTV = objectMapper.readValue(body, TrackTV.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trackTV;

    }

    public void getTVRageData(String query) {

        ResponseEntity<String> responseEntity = null;

        // trimitem cererea

        while(true) {

            try {
                responseEntity = restClient.jsonToObject("http://localhost:" + PORT_TVRAGE + "/tvrage/query/" +
                        query + "?callback=http://localhost:8080/callback?queried_for=" + query);
            } catch (QueryException e) {
                e.printStackTrace();
            } catch (HttpServerErrorException e) {
                e.printStackTrace();
            }

            if (responseEntity == null)
                return;

            if (responseEntity.getStatusCode().value() == 200)
                break;

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
