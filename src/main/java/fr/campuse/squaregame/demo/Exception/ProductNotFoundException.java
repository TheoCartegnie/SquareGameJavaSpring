package fr.campuse.squaregame.demo.Exception;

public class ProductNotFoundException extends IndexOutOfBoundsException {
    public ProductNotFoundException(long id) {
        super(String.format("Product with id %d not found", id));
    }
}
