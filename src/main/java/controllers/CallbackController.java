package controllers;

import jackson.tvrage.Show;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import rest.Response;

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
    Response response;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String index(@RequestBody String showInfos, @RequestParam String queried_for, ModelMap model) {

        Show[] shows = null;

        try {
            shows = objectMapper.readValue(showInfos, Show[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.add(queried_for, showInfos);
        System.out.println("Query: " + queried_for);

        return "Thanks!";

    }

}