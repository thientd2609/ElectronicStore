
package entity;

public class Order {
    private int id;
    private String date;
    private int cusId;
    private int totalmoney;

    public Order() {
    }

    public Order(int id, String date, int cusId, int totalmoney) {
        this.id = id;
        this.date = date;
        this.cusId = cusId;
        this.totalmoney = totalmoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(int totalmoney) {
        this.totalmoney = totalmoney;
    }
    
    
}
