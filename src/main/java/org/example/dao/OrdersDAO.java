package org.example.dao;

import org.example.entity.Orders;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class OrdersDAO {

    public static void create(Orders order) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(order);
        tx.commit();
    }

    public static Orders findById(int id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Orders order = entityManager.find(Orders.class, id);

        return order;
    }

    public static List<Orders> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select p from Payment p");
        return findAllQuery.getResultList();
    }

    public static void delete(Orders order) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(order);
        tx.commit();
    }

    public static void deleteById(int id) {
        Orders p = findById(id);
        delete(p);
    }


    public static List findByTypePresta (String typePresta) {


    }




    public static void update(int id, Orders data) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Orders orderToUpdate = entityManager.find(Orders.class, id);
        orderToUpdate.setNotNullData(data);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(orderToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}

