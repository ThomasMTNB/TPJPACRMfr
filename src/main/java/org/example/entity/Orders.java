package org.example.entity;


import org.example.utils.OrdersState;

import javax.persistence.*;

@Entity
@Table (name ="orders")
public class Orders {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Clients clients;

    private String typePresta;

    private String designation;

    private Integer nbDays;

    private Float unitPrice;
    @Column (name="state" , columnDefinition = "bit")
    private OrdersState state;

    private Float totalExcludeTaxe;

    private Float totalWithTaxe;

    public Orders() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrdersState getState() {
        return state;
    }

    public void setState(OrdersState state) {
        this.state = state;
    }

    public float getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Float totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public float getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Float totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }


    public void setNotNullData(Orders newOrdersData){
        if(newOrdersData.getTypePresta() != null) {
            this.setTypePresta(newOrdersData.getTypePresta());
        }
        if(newOrdersData.getDesignation() != null) {
            this.setDesignation(newOrdersData.getDesignation());
        }

        if(newOrdersData.getNbDays() != null) {
            this.setNbDays(newOrdersData.getNbDays());
        }

        if(newOrdersData.getUnitPrice() != null) {
            this.setUnitPrice(newOrdersData.getUnitPrice());
        }

        if(newOrdersData.getState() != null) {
            this.setState(newOrdersData.getState());
        }

        if(newOrdersData.getClients() != null) {
            this.setClients(newOrdersData.getClients());
        }
    }

}
