package org.example.dao;

import org.example.entity.Clients;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ClientsDAO {

    public static void create(Clients clientToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(clientToCreate);
        tx.commit();
    }

    public static Clients findById(int id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Clients client = entityManager.find(Clients.class, id);
        return client;
    }

    public static List<Clients> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Clients c");
        return findAllQuery.getResultList();
    }

    public static void delete(Clients client) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(client);
        tx.commit();
    }

    public static void deleteCustomerById(int id) {
        Clients clientToDelete = findById(id);
        delete(clientToDelete);
    }


    public static void deleteCustomerByIdV2(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        System.out.println("deleteCustomerByIdV2 : "+id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Query deleteQuery = entityManager.createQuery("delete from Customer c where c.id= :id");
        deleteQuery.setParameter("id", id);
        System.out.println(id);
        int result = deleteQuery.executeUpdate();
        entityManager.clear();// <------------
        System.out.println(result);

        tx.commit();
    }


    public static void update(int id, Clients newClientsData) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Clients clientToUpdate = entityManager.find(Clients.class, id);
        clientToUpdate.setNotNullData(newClientsData);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(clientToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public static List<Clients> findByFirstName(String firstName) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query queryToFindClientsByFirstName = entityManager.createQuery("select c from Customer c where c.firstName = :firstName");
        queryToFindClientsByFirstName.setParameter("firstName", firstName);
        return queryToFindClientsByFirstName.getResultList();
    }
}



