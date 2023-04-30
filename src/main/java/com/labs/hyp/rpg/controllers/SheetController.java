package com.labs.hyp.rpg.controllers;


import com.labs.hyp.rpg.models.Sheet;
import com.labs.hyp.rpg.services.SheetServices;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;

import java.net.URI;
import java.util.List;

@Path("/sheet")
@Tag(name = "Sheet - Controller")
@RequiredArgsConstructor
@RequestScoped
public class SheetController {

    private final SheetServices sheetServices;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Buscar todas fichas")
    @Path("get-all")
    @APIResponse(responseCode = "400", description = "Erro ao buscar")
    public RestResponse<List<Sheet>> getAll() {
        return RestResponse.ok(sheetServices.getAll(), MediaType.APPLICATION_JSON);

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Adicionar um Paciente")
    @Path("get/{id}")
    @APIResponse(responseCode = "401", description = "Ficha não encontrada")
    public RestResponse<Sheet> get(Long id) {
        return RestResponse.ok(sheetServices.get(id),MediaType.APPLICATION_JSON);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Adicionar uma nova ficha")
    @Path("insert")
    @APIResponse(responseCode = "400", description = "Erro ao adicionar")
    public RestResponse<Void> insert(Sheet sheet,@Context UriInfo uriInfo) {
        sheetServices.insert(sheet);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }

    @PUT
    @Transactional
    @Operation(summary = "Atualizar uma ficha")
    @Path("update")
    @APIResponse(responseCode = "400", description = "Erro ao atualizar")
    public RestResponse<Void> update(@RequestBody Sheet sheet,@Context UriInfo uriInfo) {
        sheetServices.update(sheet);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }

    @DELETE
    @Transactional
    @Operation(summary = "Deletar ficha")
    @Path("delete")
    @APIResponse(responseCode = "400", description = "Erro ao deletar")
    public RestResponse<Void> delete(Long id) {
        sheetServices.delete(id);
        return RestResponse.noContent();
    }


}