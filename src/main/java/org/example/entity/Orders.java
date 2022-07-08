package org.example.entity;


import javax.persistence.*;

@Entity
@Table (name ="orders")
public class Orders {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Clients clients;
    @Column (name="typePresta")
    private String typePresta;
    @Column (name="designation")
    private String designation;
    @Column (name="nbDays")
    private int nbDays;
    @Column (name="unitPrice")
    private float unitPrice;
    @Column (name="state")
    private byte state;
    @Column (name="totalExcludeTaxe")
    private float totalExcludeTaxe;
    @Column (name="totalWithTaxe")
    private float totalWithTaxe;

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

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public float getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(float totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public float getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(float totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }


}
