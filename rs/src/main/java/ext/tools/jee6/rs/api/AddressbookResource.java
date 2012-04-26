/**
 *
 */
package ext.tools.jee6.rs.api;

import ext.demo.jee6.api.xml.AddressXml;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author  dstrauss
 */
@Path("/ab")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public interface AddressbookResource {
    @PUT
    AddressXml createAddress(AddressXml a);
    @GET
    @Path("/{id:[01-9]+}")
    AddressXml getAddressById(@PathParam("id") long id);
    @POST
    @Path("/{id:[01-9]+}")
    AddressXml updateAddress(@PathParam("id") long id, AddressXml a);
    @GET
    @Path("/list")
    List<AddressXml> getAllAddresses();
}
