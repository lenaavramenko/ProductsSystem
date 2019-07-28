package com.javaguru.products.repository;

import com.javaguru.products.domain.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

public class InMemoryRepositoryTest {

    private InMemoryRepository victim;
    private Product testProduct;

    @Before
    public void createFirstProduct() {
        victim = new InMemoryRepository();
        testProduct = spy(Product.class);
        testProduct.setId(999L);
    }

    @Test
    public void AddNewProductTest() {
        long startingRepositorySize = victim.getStorageSize();
        victim.add(testProduct);
        assertEquals(++startingRepositorySize, victim.getStorageSize());
    }

    @Test
    public void RemoveByIdTest() {
        victim.add(testProduct);
        long expectedRepositorySize = victim.getStorageSize() - 1;
        victim.removeProductById(testProduct.getId());
        assertEquals(expectedRepositorySize, victim.getStorageSize());
    }
}