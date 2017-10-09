package com.tmaapi.rest;

import com.taskmanagementapp.model.Search;
import com.taskmanagementapp.model.TMAModel;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/tmaapi")
public class JSONService {

    HibernateService hibernateService = new HibernateService();
    String doesNotExist = "Does not exist!" ;
    String pleaseSendAdd = "Does not exist! Please Send Add request!";
    String doNotAddTaskID = "Please do not add taskId, it will be auto generated!";
    String success = "Updated successfully!";
    ObjectMapper objectMapper = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws IOException {

        List list   =   hibernateService.getAll();
        return Response.status(200).entity(objectMapper.writeValueAsString(list)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") long id) throws IOException {

        TMAModel tmaModel = hibernateService.get(id);

        if (tmaModel == null){

            return Response.status(400).entity(objectMapper.writeValueAsString(doesNotExist)).build();

        }
        return Response.status(200).entity(objectMapper.writeValueAsString(tmaModel)).build();

    }

    //DELETE
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) throws IOException {

        TMAModel tmaModel = hibernateService.get(id);

        if (tmaModel == null){
            return Response.status(400).entity(objectMapper.writeValueAsString(doesNotExist)).build();
        }else return Response.status(200).entity(objectMapper.writeValueAsString(tmaModel)).build();

    }

    // UPDATE
    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCountry(TMAModel tmaModel) throws IOException {

        TMAModel retrieved = hibernateService.get(tmaModel.getTaskID());

        if (retrieved == null){
            return Response.status(400).entity(objectMapper.writeValueAsString(pleaseSendAdd)).build();
        }

        hibernateService.update(tmaModel);
        return Response.status(200).entity(objectMapper.writeValueAsString(success)).build();

    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(TMAModel tmaModel) throws IOException {

        if (tmaModel.getTaskID() != 0){
            return Response.status(400).entity(objectMapper.writeValueAsString(doNotAddTaskID)).build();
        }

        hibernateService.add(tmaModel);
        return Response.status(201).entity(objectMapper.writeValueAsString(tmaModel)).build();

    }

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listFilters(Search search) throws IOException {

        List list = null;

        if (search.getCreatedBy() != null && !"".equalsIgnoreCase(search.getCreatedBy()) ){

            list = hibernateService.searchByCreatedBy(search);

        }else if (search.getCreationTimeStamp() != null){

            list = hibernateService.searchByCreationTimeStamp(search);

        }else if (search.getTaskEndDate() != null){

            list = hibernateService.searchByTaskEndDate(search);

        }

        return Response.status(200).entity(objectMapper.writeValueAsString(list)).build();

    }

}
