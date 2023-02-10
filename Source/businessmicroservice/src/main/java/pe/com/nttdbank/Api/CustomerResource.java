package pe.com.nttdbank.Api;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import pe.com.nttdbank.Application.Dtos.Customer.Request.CustomerRequestDto;
import pe.com.nttdbank.Application.Services.CustomerApplication;
import pe.com.nttdbank.Domain.Entities.Customer;

@Path("/products")
@Produces("application/json")
@Consumes("application/json")
public class CustomerResource {

    @Inject
    CustomerApplication customerApplication;

    @GET
    public Response ListCustomers() {
        List<Customer> customers = customerApplication.getAll();
        return Response.ok(customers).build();
    }

    @POST
    public Response SaveCustomer(CustomerRequestDto requestDto) {
        Boolean result = customerApplication.Create(requestDto);
        return Response.ok(result).build();
    }

}
