package rest;


import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

/**
 * Created by fstancu on 5/26/2014.
 */

@Component
public class CallbackQueueResponse {

    private MultiValueMap<String, String> showInfos = new LinkedMultiValueMap<String, String>();

    public CallbackQueueResponse() {}

    public void add(String query, String response) {

        synchronized (CallbackQueueResponse.class) {

            List<String> queryList = this.showInfos.get(query);
            if (queryList != null) {
                queryList.add(response);
            } else {
                queryList =  new LinkedList<String>();
                queryList.add(response);
                this.showInfos.put(query, queryList);
            }
        }

    }

    public String get(String query) {

        String response = null;

        synchronized (CallbackQueueResponse.class) {

            List<String> responseList = (List<String>) showInfos.get(query);

            if (responseList == null)
                return null;

            Iterator<String> responseStringIterator = responseList.iterator();

            while (responseStringIterator.hasNext()) {

                response = responseStringIterator.next();
                responseStringIterator.remove();
                break;

            }

        }

        return response;

    }

}
