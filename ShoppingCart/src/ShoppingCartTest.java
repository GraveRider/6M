import lt.infobalt.itakademija.javalang.exam.shopingcart.ShoppingCart;
import lt.infobalt.itakademija.javalang.exam.shoppingcart.BaseShoppingCartDecoratorTest;

public class ShoppingCartTest extends BaseShoppingCartDecoratorTest {

    @Override
    protected ShoppingCart getDecoratedShoppingCart(ShoppingCart shoppingCart, double discountRate, double taxRate) {
        return new DecoratedCart(shoppingCart, discountRate, taxRate);
    }

    @Override
    protected ShoppingCart getDiscountAppliedShoppingCart(ShoppingCart shoppingCart, double discountRate) {
        return new DiscountCart(shoppingCart, discountRate);
    }

    @Override
    protected ShoppingCart getTaxAppliedShoppingCart(ShoppingCart shoppingCart, double taxRate) {
        return new TaxCart(shoppingCart, taxRate);
    }

    @Override
    protected ShoppingCart getLockedFromModificationShoppingCart(ShoppingCart shoppingCart) {
        return new LockedCart(shoppingCart);
    }
}
