import lt.infobalt.itakademija.javalang.exam.shopingcart.ShoppingCart;

public class DecoratedCart extends ShoppingCartDecorator {

    private double discountRate;
    private double taxRate;

    public DecoratedCart(ShoppingCart shoppingCart, double discountRate, double taxRate) {
        super(shoppingCart);
        this.discountRate = discountRate;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateTotalPrice() {
        double price = super.calculateTotalPrice() - super.price * discountRate;
        return price += price * taxRate;


    }
}
