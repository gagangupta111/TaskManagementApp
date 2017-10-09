package com.tests;

import com.taskmanagementapp.model.TMAModel;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllTestByMethods {

    public static void main(String[] args) throws IOException {

        TMAModel tmaModel = new TMAModel(new Date(), 1234, "gagan", new Date(), "gupta", "gagan");

        List<TMAModel> list = new ArrayList<TMAModel>();
        list.add(tmaModel);
        tmaModel = new TMAModel(new Date(), 222, "gagan", new Date(), "gupta", "gagan");
        list.add(tmaModel);
        tmaModel = new TMAModel(new Date(), 333, "gagan", new Date(), "gupta", "gagan");
        list.add(tmaModel);
        tmaModel = new TMAModel(new Date(), 444, "gagan", new Date(), "gupta", "gagan");
        list.add(tmaModel);
        tmaModel = new TMAModel(new Date(), 555, "gagan", new Date(), "gupta", "gagan");
        list.add(tmaModel);

        ObjectMapper objectMapper = new ObjectMapper();
        String arrayToJson = objectMapper.writeValueAsString(list);
        String arrayToJson1 = objectMapper.writeValueAsString(tmaModel);
        String json = objectMapper.writeValueAsString("sample");

        System.out.println(arrayToJson1);
    }

}
