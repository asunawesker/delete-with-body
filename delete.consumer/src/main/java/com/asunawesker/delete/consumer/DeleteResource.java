package com.asunawesker.delete.consumer;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api")
public class DeleteResource {

    @GET
    @Path("ping")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping(){
        return Response.ok("{\"ping\":\"Hello World\"}").build();
    }

    @DELETE
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEntity() throws IOException {
        String url = "http://localhost:8090/delete";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpDelete delete = new HttpDelete(url);

            StringEntity entity = new StringEntity("{\"name\":\"foo\",\"value\":1}", ContentType.APPLICATION_JSON);
            delete.setEntity(entity);

            HttpClientResponseHandler handler = response -> {
                try (HttpEntity httpEntity = response.getEntity()) {
                    return EntityUtils.toString(httpEntity);
                }
            };

            String responseBody = client.execute(delete, handler).toString();

            return Response.ok(responseBody).build();
        }
    }

}
