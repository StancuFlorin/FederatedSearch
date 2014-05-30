package controllers;

import jackson.tvrage.Show;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import rest.CallbackQueueResponse;

import java.io.IOException;

/**
 * Created by fstancu on 5/26/2014.
 */

@Controller
@RequestMapping("/callback")
public class CallbackController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CallbackQueueResponse callbackQueueResponse;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String index(@RequestBody String showInfos, @RequestParam String queried_for, ModelMap model) {

        Show[] shows = null;

        /**
         * Parsam raspunsul primit de la serverul
         * "search-provider-with-callback".
         */

        try {
            shows = objectMapper.readValue(showInfos, Show[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Punem raspunsul intr-o coada.
         */

        callbackQueueResponse.add(queried_for, showInfos);

        return "Thanks!";

    }

}
