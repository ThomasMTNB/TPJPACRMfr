package org.example;

import junit.framework.TestCase;
import org.example.dao.ClientsDAO;
import org.example.entity.Clients;
import org.example.utils.ClientsState;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class ClientsDAOTest {


    @Test
    public void createClients() {
        Clients client = new Clients();
        client.setFirstName("Tommy");
        client.setLastName("Jean");
        client.setAddress("Pasloin");
        client.setCity("Laba");
        client.setCountry("Terre");
        client.setEmail("jesuisdanslajoie");
        client.setCompanyName("Sopra");
        client.setPhone("12345");
        client.setZipCode("69");
        client.setState(ClientsState.ACTIVE);

        ClientsDAO.create(client);


        assertTrue( true );

    }



    @Test
    public void findById(){
        Clients client = new Clients();
        client.setFirstName("Tommy");
        client.setLastName("Jean");
        client.setAddress("Pasloin");
        client.setCity("Laba");
        client.setCountry("Terre");
        client.setEmail("jesuisdanslajoie");
        client.setCompanyName("Sopra");
        client.setPhone("12345");
        client.setZipCode("69");
        client.setState(ClientsState.ACTIVE);

        ClientsDAO.create(client);

        Clients customer1 = ClientsDAO.findById(client.getId());
        assertEquals("Tommy", customer1.getFirstName());
    }

    @Test
    public void dontFindById() {
        Clients client = ClientsDAO.findById(5);
        assertNull(client);
    }


    @Test
    public void findAll() {


        List<Clients> clients = ClientsDAO.findAll();
        assertEquals(5, clients.size());
    }


    @Test
    public void deleteCustomer(){
        Clients client = new Clients();
        client.setFirstName("Tommy");
        client.setLastName("Jean");
        client.setAddress("Pasloin");
        client.setCity("Laba");
        client.setCountry("Terre");
        client.setEmail("jesuisdanslajoie");
        client.setCompanyName("Sopra");
        client.setPhone("12345");
        client.setZipCode("69");
        client.setState(ClientsState.ACTIVE);

        ClientsDAO.create(client);

        List<Clients> customers = ClientsDAO.findAll();
        assertEquals(7, customers.size());

        ClientsDAO.delete(client);

        customers = ClientsDAO.findAll();
        assertEquals(0, customers.size());
    }

    @Test
    public void deleteClientsById() {
        Clients client1 = new Clients();
        client1.setFirstName("Tommy");
        client1.setLastName("Jean");
        client1.setAddress("Pasloin");
        client1.setCity("Laba");
        client1.setCountry("Terre");
        client1.setEmail("jesuisdanslajoie");
        client1.setCompanyName("Sopra");
        client1.setPhone("12345");
        client1.setZipCode("69");
        client1.setState(ClientsState.ACTIVE);

        ClientsDAO.create(client1);

        Clients client2 = new Clients();
        client2.setFirstName("Tommy");
        client2.setLastName("Jean");
        client2.setAddress("Pasloin");
        client2.setCity("Laba");
        client2.setCountry("Terre");
        client2.setEmail("jesuisdanslajoie");
        client2.setCompanyName("Sopra");
        client2.setPhone("12345");
        client2.setZipCode("69");
        client2.setState(ClientsState.ACTIVE);

        ClientsDAO.create(client2);


        ClientsDAO.delete(ClientsDAO.findById(client2.getId()));

        assertNotNull(ClientsDAO.findById(client1.getId()));
        assertNull(ClientsDAO.findById(client2.getId()));



    }



    @Test
    public void updateClient(){
        Clients client = new Clients();
        client.setFirstName("Tommy");
        client.setLastName("Jean");
        client.setAddress("Pasloin");
        client.setCity("Laba");
        client.setCountry("Terre");
        client.setEmail("jesuisdanslajoie");
        client.setCompanyName("Sopra");
        client.setPhone("12345");
        client.setZipCode("69");
        client.setState(ClientsState.ACTIVE);

        ClientsDAO.create(client);

        /*****************/

        Clients newClientsData = new Clients();
        newClientsData.setFirstName("Jean-Paul");
        newClientsData.setLastName("Belmondo");

        ClientsDAO.update(client.getId(), newClientsData);

        /*****************/

        Clients updatedCustomer = ClientsDAO.findById(client.getId());
        assertEquals("Jean-Paul", updatedCustomer.getFirstName());
        assertEquals("Belmondo", updatedCustomer.getLastName());

    }

    @Test
    public void selectWhere(){
        Clients client1 = new Clients();
        client1.setFirstName("Alain");
        client1.setLastName("Delon");
        ClientsDAO.create(client1);

        Clients client2 = new Clients();
        client2.setFirstName("Alain");
        client2.setLastName("Prost");
        ClientsDAO.create(client2);

        Clients client3 = new Clients();
        client3.setFirstName("Marie");
        client3.setLastName("Dupont");
        ClientsDAO.create(client3);

        /*****************/

        List<Clients> alains = ClientsDAO.findByFirstName("Alain");

        /*****************/

        assertEquals(2, alains.size());

        for(Clients c : alains){
            if(! c.getFirstName().equals("Alain")){
                assertTrue(false);
            }
        }
    }
}