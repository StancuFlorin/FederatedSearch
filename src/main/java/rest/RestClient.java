package rest;

import exceptions.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fstancu on 5/23/2014.
 */

@Component
public class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> jsonToObject(String url) throws QueryException {

        ResponseEntity<String> responseEntity = null;

        try {
            responseEntity = this.restTemplate.getForEntity(url, String.class);

            int statusCode = responseEntity.getStatusCode().value();

            if (statusCode == 406)
                throw new QueryException("Query is not valid!");
            else if (statusCode == 410)
                throw new QueryException("Reference is not valid!");
            else if (statusCode == 404)
                throw new QueryException("Resource not found!");

        } catch (ResourceAccessException e) {
            throw new QueryException("Connection refused!");
        } catch (HttpClientErrorException e) {
            throw new QueryException("Resource not found!");
        }

        return responseEntity;

    }

}
