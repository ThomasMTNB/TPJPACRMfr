
package org.example;

import junit.framework.TestCase;
import org.example.dao.ClientsDAO;
import org.example.dao.OrdersDAO;
import org.example.entity.Clients;
import org.example.entity.Orders;
import org.example.entity.Orders;
import org.example.utils.ClientsState;
import org.example.utils.OrdersState;
import org.junit.Test;

import java.util.List;

public class OrdersDAOTest extends TestCase {

    public class OrderTest {

        @Test
        public void createAndFindOrderById() {

            Clients client = new Clients();
            client.setCompanyName("Sopra Steria");
            client.setFirstName("Marion");
            client.setLastName("Perez");
            client.setPhone("0786842676");
            client.setEmail("marioncanelle2@gmail.com");
            client.setAddress("1234 rue de la mairie");
            client.setZipCode("31700");
            client.setCity("Blagnac");
            client.setCountry("France");
            client.setState(ClientsState.ACTIVE);
            ClientsDAO.create(client);

            Orders order = new Orders();
            order.setTypePresta("Formation Test");
            order.setDesignation("Angular");
            order.setNbDays(5);
            order.setUnitPrice(950F);
            order.setState(OrdersState.CONFIRMED);
            order.setClients(client);
            OrdersDAO.create(order);
            assertTrue(true);

            Orders order1 = OrdersDAO.findById(order.getId());
            assertEquals("Formation Test", order1.getTypePresta());

            OrdersDAO.delete(order);
            ClientsDAO.delete(client);
        }

        @Test
        public void DontFindOrderById() {

            Orders order2 = OrdersDAO.findById(0);
            assertNull(order2);
        }


        @Test
        public void delete() {

            Clients client = new Clients();
            client.setCompanyName("Sopra Steria");
            client.setFirstName("Marion");
            client.setLastName("Perez");
            client.setPhone("0786842676");
            client.setEmail("marioncanelle2@gmail.com");
            client.setAddress("1234 rue de la mairie");
            client.setZipCode("31700");
            client.setCity("Blagnac");
            client.setCountry("France");
            client.setState(ClientsState.ACTIVE);
            ClientsDAO.create(client);

            Orders order = new Orders();
            order.setTypePresta("Formation Test");
            order.setDesignation("Angular");
            order.setNbDays(5);
            order.setUnitPrice(950F);
            order.setState(OrdersState.CONFIRMED);
            order.setClients(client);
            OrdersDAO.create(order);

            List<Orders> orders = OrdersDAO.findAll();
            int listLenght = orders.size();

            OrdersDAO.delete(order);

            orders = OrdersDAO.findAll();
            assertEquals(listLenght - 1, orders.size());
        }



         @Test
    public void updateOrder() {

        Clients client = new Clients();
        client.setCompanyName("Sopra Steria");
        client.setFirstName("Marion");
        client.setLastName("Perez");
        client.setPhone("0786842676");
        client.setEmail("marioncanelle2@gmail.com");
        client.setAddress("1234 rue de la mairie");
        client.setZipCode("31700");
        client.setCity("Blagnac");
        client.setCountry("France");
        client.setState(ClientsState.ACTIVE);
        ClientsDAO.create(client);

        Orders order = new Orders();
        order.setTypePresta("Formation Test");
        order.setDesignation("Angular");
        order.setNbDays(5);
        order.setUnitPrice(950F);
        order.setState(OrdersState.CONFIRMED);
        order.setClients(client);
        OrdersDAO.create(order);

        Orders newOrderData = new Orders();
        newOrderData.setUnitPrice(999.99F);
        OrdersDAO.update(order.getId(), newOrderData);

        Orders updatedOrder = OrdersDAO.findById(order.getId());
        assertEquals(new Float(999.99F), updatedOrder.getUnitPrice());

        ClientsDAO.delete(client);
    }


        @Test
        public void findOrderByTypePrestation() {

            Clients client = new Clients();
            client.setCompanyName("Sopra Steria");
            client.setFirstName("Marion");
            client.setLastName("Perez");
            client.setPhone("0786842676");
            client.setEmail("marioncanelle2@gmail.com");
            client.setAddress("1234 rue de la mairie");
            client.setZipCode("31700");
            client.setCity("Blagnac");
            client.setCountry("France");
            client.setState(ClientsState.ACTIVE);
            ClientsDAO.create(client);

            Orders order1 = new Orders();
            order1.setTypePresta("Formation Test");
            order1.setDesignation("Angular");
            order1.setNbDays(5);
            order1.setUnitPrice(950F);
            order1.setState(OrdersState.CONFIRMED);
            order1.setClients(client);
            OrdersDAO.create(order1);

            Orders order2 = new Orders();
            order2.setTypePresta("Coaching Test");
            order2.setDesignation("Jakarta EE");
            order2.setNbDays(10);
            order2.setUnitPrice(1200F);
            order2.setState(OrdersState.OPTION);
            order2.setClients(client);
            OrdersDAO.create(order2);



            List<Orders> coachingTestPresta = OrdersDAO.findByTypePresta("Coaching Test");
            assertEquals(2, coachingTestPresta.size());

            OrdersDAO.delete(order1);
            OrdersDAO.delete(order2);

            ClientsDAO.delete(client);
        }



    }

}
