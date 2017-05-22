import lt.infobalt.itakademija.javalang.exam.shopingcart.ShoppingCart;
import lt.infobalt.itakademija.javalang.exam.shopingcart.ShoppingItem;

import java.util.Collection;
import java.util.Iterator;

public abstract class ShoppingCartDecorator implements ShoppingCart {

    protected double price;
    private ShoppingCart shoppingCart;

    public ShoppingCartDecorator(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void addShoppingItem(ShoppingItem shoppingItem) {
        shoppingCart.addShoppingItem(shoppingItem);
    }

    @Override
    public void removeShoppingItem(ShoppingItem shoppingItem) {
        for (Iterator<ShoppingItem> i = shoppingCart.getShoppingCartItems().iterator(); i.hasNext(); ) {
            if (i.next().equals(shoppingItem)) {
                i.remove();
            }
        }
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.getShoppingCartItems().clear();
    }

    @Override
    public Collection<ShoppingItem> getShoppingCartItems() {
        return shoppingCart.getShoppingCartItems();
    }

    @Override
    public double calculateTotalPrice() {
        for (ShoppingItem item : getShoppingCartItems()) {
            price += item.getPrice();
        }
        return price;
    }

}
