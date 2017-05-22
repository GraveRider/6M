import lt.infobalt.itakademija.javalang.exam.shopingcart.ShoppingCart;

public class TaxCart extends ShoppingCartDecorator {

    private double taxRate;

    public TaxCart(ShoppingCart shoppingCart, double taxRate) {
        super(shoppingCart);
        this.taxRate = taxRate;
    }

    @Override
    public double calculateTotalPrice() {
        return super.calculateTotalPrice() + super.price * taxRate;
    }
}
