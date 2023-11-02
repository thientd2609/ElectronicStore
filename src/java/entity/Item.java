
package entity;

public class Item {
    private Product product;
    private int quantity;
    private double price;

    public Item() {
    }

    public Item(Product product, int quanlity, double price) {
        this.product = product;
        this.quantity = quanlity;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quanlity) {
        this.quantity = quanlity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
