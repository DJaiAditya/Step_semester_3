package s7_assignment_problems;

class Cart {
    private int[] prices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maxSize) {
        this.cartId = cartId;
        prices = new int[maxSize];
        itemCount = 0;
    }

    public void addItem(int price) {
        if (itemCount < prices.length) {
            prices[itemCount++] = price;
        } else {
            System.out.println("Cart is full!");
        }
    }

    public int getTotal() {
        int total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}

class Main_5 {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
        System.out.println("Cart ID: " + cart.getCartId());
    }
}
