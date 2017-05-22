import lt.infobalt.itakademija.javalang.exam.shopingcart.ShoppingCart;

public class DiscountCart extends ShoppingCartDecorator {

    double discountRate;

    public DiscountCart(ShoppingCart shoppingCart, double discountRate) {
        super(shoppingCart);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice() {
        return super.calculateTotalPrice() - super.price * discountRate;
    }
}
