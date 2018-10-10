/**
 * class for "item".
 */
class Item {
    /**
     * name of the item.
     */
     String nameOfItem;
    /**
     * quantity of the item.
     */
      int quantityOfItem;
    /**
     * cost of one unit of item.
     */
     float unitprice;
    /**
     * constructor for "item" class.
     * @param      name       name of the item.
     * @param      quantity   quantity of the item.
     * @param      unitprice  unit price of the item.
     */
    Item(final String name, final String quantity, final String unitprice) {
        this.nameOfItem = name;
        this.quantityOfItem = Integer.parseInt(quantity);
        this.unitprice = Float.parseFloat(unitprice);
    }
    /**
     * constructor for class "item".
     * @param      name      name of the item.
     * @param      quantity  quantity of the item.
     */
    Item(final String name, final String quantity) {
        this.nameOfItem = name;
        this.quantityOfItem = Integer.parseInt(quantity);
    }
    /**
     * Gets the name of item.
     * @return returns the name of item.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameOfItem + " ");
        sb.append(quantityOfItem + " ");
        sb.append(unitprice);
        return sb.toString();
    }
}
/**
 * Class named "shoppingcart".
 */
class ShoppingCart {
    /**
     * catalog array to store items into catalog.
     */
    private Item[] catalogArray;
    /**
     * cart array to store items into cart.
     */
    private Item[] cartArray;
    /**
     * size of the catalog.
     */
    private int sizeCatalog;
    /**
     * size of the cart.
     */
    private int sizeCart;
    /**
     * variable for 20.
     */
    private final  int twenty = 20;
    String[] validCoupons = {"IND10", "IND20", "IND30", "IND50"};
    /**
     * double variable discount.
     */
    private static double discount = 0.0;
    /**
     * boolean variable.
     */
    static private boolean couponApplied = false;
    /**
     * constructor for shopping cart class.
     */
    ShoppingCart() {
        catalogArray = new Item[twenty];
        cartArray = new Item[twenty];
        sizeCatalog = 0;
        sizeCart = 0;
    }
    /**
     * Adds an item to catalog.
     * @param      item  The item
     */
    public void addToCatalog(Item item) {
        catalogArray[sizeCatalog++] = item;
    }
    /**
     * returns true if given item is in cart.
     * @param      item  The item
     * @return returns true if given item is in cart.
     */
    public boolean inCart(Item item) {
        for (Item s : cartArray) {
            if (s != null) {
                if (s.nameOfItem.equals(item.nameOfItem)) {
                    s.quantityOfItem += item.quantityOfItem;
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Adds an item to cart.
     * @param      item  The item
     */
    public void addToCart(Item item) {
        if (!inCart(item)) {
            if (checkCatalog(item)) {
                cartArray[sizeCart++] = item;
            }
        }
    }
    /**
     * checks for an item in catalog.
     * @param      item  The item
     * @return   returns true if the item is in catalog.
     */
    private boolean checkCatalog(Item item) {
        for (Item i : catalogArray) {
            if (i != null) {
                if (i.nameOfItem.equals(item.nameOfItem)) {
                    if (item.quantityOfItem <= item.quantityOfItem) {
                        i.quantityOfItem -= item.quantityOfItem;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Removes an item from cart.
     * @param      item  The item
     */
    public void removeFromCart(Item item) {
        for (int i = 0; i < sizeCart; i++) {
            if (cartArray[i].nameOfItem.equals(item.nameOfItem)) {
                cartArray[i].quantityOfItem -= item.quantityOfItem;
            }
        }
    }
    /**
     * Shows the catalog items.
     */
    public void showCatalog() {
        for (int i = 0; i < sizeCatalog; i++) {
            System.out.println(catalogArray[i]);
        }
    }
    /**
     * Shows the cart items.
     */
    public void showCart() {
        for (int i = 0; i < sizeCart; i++) {
            if (cartArray[i].quantityOfItem != 0) {
                System.out.println(cartArray[i].nameOfItem + " " + cartArray[i].quantityOfItem);
            }
        }
    }
    /**
     * Gets the total amount.
     * @return     The total amount.
     */
    public double getTotalAmount() {
        double totalAmount = 0;
        for (int i = 0; i < sizeCart; i++) {
            totalAmount  = totalAmount + cartArray[i].quantityOfItem * getPrice(cartArray[i]);
        }
        return totalAmount;
    }
    /**
     * Gets the price.
     * @param      givenAmount  The given amount
     * @return     The price.
     */
    double getPrice(final Item givenAmount) {
        for (Item i : catalogArray) {
            if (i != null) {
                if (i.nameOfItem.equals(givenAmount.nameOfItem)) {
                    return i.unitprice;
                }
            }
        }
        return 0.0;
    }
    /**
     * variable for 100.
     */
    final int hundred = 100;
    /**
     * variable for 15.
     */
    final int fifteen = 15;
    /**
     * variable for 3.
     */
    final int three = 3;
    /**
     * applies a valid coupon.
     * @param      coupon  The coupon
     */
    void applyCoupon( final String coupon) {
        if (couponApplied) {
            return;
        }
        boolean variable = false;
        for (String s : validCoupons) {
            if (s.equals(coupon)) {
                int number = Integer.parseInt(coupon.substring(three));
                discount = getTotalAmount() * number / hundred;
                couponApplied = true;
                variable = true;
            }
        }
        if (!variable) {
            System.out.println("Invalid coupon");
            return;
        }
    }
    /**
     * prints the invoice of the user.
     */
    public void printInvoice() {
        for (Item i : cartArray) {
            if (i != null) {
                if (i.quantityOfItem != 0) {
System.out.println(i.nameOfItem + " " + i.quantityOfItem + " " +  getPrice(i));
                }
            }
        }
        double amount;
        double amountAfterDiscount = getTotalAmount() - discount;
        double tax = (amountAfterDiscount * fifteen) / hundred;
        System.out.println("Total:" + getTotalAmount());
        System.out.println("Disc%:" + discount);
        System.out.println("Tax:" + tax);
        System.out.println("Payable amount: " + getPayableAmount());
    }
    /**
     * Gets the payable amount.
     * @return     The payable amount.
     */
    public double getPayableAmount() {
        double payableAmount;
        double amountAfterDiscount = getTotalAmount() - discount;
        double tax = (amountAfterDiscount * fifteen) / hundred;
        payableAmount = amountAfterDiscount + tax;
        return payableAmount;
    }
}
