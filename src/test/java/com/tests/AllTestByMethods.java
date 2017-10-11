package com.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.taskmanagementapp.model.TMAModel;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class AllTestByMethods {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void postAndGet() throws Exception{

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://54.71.121.190:8080/taskmanagementapp/rest/tmaapi/add");
        httppost.setHeader("Accept", "application/json");
        httppost.setHeader("Content-type", "application/json");

        TMAModel tmaModel = new TMAModel();
        tmaModel.setDescription("ten");
        tmaModel.setTaskName("ten");
        tmaModel.setCreatedBy("ten");

        String json = mapper.writeValueAsString(tmaModel);
        StringEntity entity = new StringEntity(json);
        httppost.setEntity(entity);
        HttpResponse response = httpclient.execute(httppost);

        Assert.assertEquals (response.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

    }

    @Test
    public void getAllAndUpdate() throws Exception{

        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://54.71.121.190:8080/taskmanagementapp/rest/tmaapi/");

        HttpResponse response = httpclient.execute(httpGet);
        Assert.assertEquals (response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        String json_string = EntityUtils.toString(response.getEntity());
        List<TMAModel> myObjects = mapper.readValue(json_string, new TypeReference<List<TMAModel>>(){});

        HttpPost httppost = new HttpPost("http://54.71.121.190:8080/taskmanagementapp/rest/tmaapi/update");
        httppost.setHeader("Accept", "application/json");
        httppost.setHeader("Content-type", "application/json");

        TMAModel tmaModel = new TMAModel();
        tmaModel.setTaskID(myObjects.get(0).getTaskID());
        tmaModel.setDescription("ten");
        tmaModel.setTaskName("ten");
        tmaModel.setCreatedBy("ten");

        String json = mapper.writeValueAsString(tmaModel);
        StringEntity entity = new StringEntity(json);
        httppost.setEntity(entity);

        response = httpclient.execute(httppost);

        Assert.assertEquals (response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void testDelete() throws Exception{

        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://54.71.121.190:8080/taskmanagementapp/rest/tmaapi/");

        HttpResponse response = httpclient.execute(httpGet);
        Assert.assertEquals (response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        String json_string = EntityUtils.toString(response.getEntity());
        List<TMAModel> myObjects = mapper.readValue(json_string, new TypeReference<List<TMAModel>>(){});

        HttpDelete httpDelete = new HttpDelete("http://54.71.121.190:8080/taskmanagementapp/rest/tmaapi/" + myObjects.get(0).getTaskID());
        response = httpclient.execute(httpDelete);

        Assert.assertEquals (response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

    }
}