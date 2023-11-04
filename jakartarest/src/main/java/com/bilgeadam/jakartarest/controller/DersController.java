package com.bilgeadam.jakartarest.controller;


import java.util.ArrayList;

import com.bilgeadam.jakartarest.model.Ders;
import com.bilgeadam.jakartarest.model.DersDTO;
import com.bilgeadam.jakartarest.repository.DersRepository;

import jakarta.ejb.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/ders")
@Singleton
public class DersController {

    private DersRepository repo = new DersRepository();

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getall() {
        try {
            ArrayList<Ders> result = repo.getAll();
            return Response.ok().entity(result).build();
        } catch (Exception e) {
            return Response.serverError().entity("Bir hata oluştu").build();
        }
    }

    @DELETE
    @Path("/deletebyid/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletebyid(@PathParam("id") long id) {
        try {
            if (repo.deleteByID(id)) {
                return Response.ok().entity("Başarı ile silindi").build();
            } else {
                return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
        }
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Ders ders) {
        try {
            if (repo.save(ders)) {
                return Response.status(Status.CREATED).entity("Başarı ile kaydedildi").build();
            } else {
                return Response.serverError().entity("Başarı ile kaydedilemedi").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
        }
    }

    @GET
    @Path("/getbyidheader")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyidheader(@HeaderParam("id") long id) {
        try {
            Ders result = repo.getByID(id);
            if (result == null) {
                return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
            } else {
                return Response.ok().entity(result).build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
        }
    }

    @GET
    @Path("/getbyidqueryparam")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyidqueryparam(@QueryParam("id") long id) {
        try {
            Ders result = repo.getByID(id);
            if (result == null) {
                return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
            } else {
                return Response.ok().entity(result).build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Bir hata oluştu").build();
        }
    }

    @GET
    @Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbyid(@PathParam("id") long id) {
        try {
            Ders result = repo.getByID(id);
            if (result == null) {
                return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
            } else {
                return Response.ok().entity(result).build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
        }
    }

    @POST
    @Path("/savedto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveDTO(DersDTO dersDto) {
        try {
            if (repo.saveDTO(dersDto)) {
                return Response.status(Status.CREATED).entity("Başarı ile kaydedildi").build();
            } else {
                return Response.serverError().entity("Başarı ile kaydedilemedi").build();
            }
        } catch (Exception e) {
            return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
        }
    }

    @GET
    @Path("/getalldto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDTO() {
        try {
            ArrayList<DersDTO> result = repo.getAllDTO();
            return Response.ok().entity(result).build();
        } catch (Exception e) {
            return Response.serverError().entity("Bir hata oluştu").build();
        }
    }
}
