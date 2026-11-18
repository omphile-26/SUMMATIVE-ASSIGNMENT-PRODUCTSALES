/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.productsales.ProductSales;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {

        ProductSales sales = new ProductSales();

        int expected = 2;
        int actual = sales.GetSalesOverLimit();

        assertEquals(expected, actual);
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {

        ProductSales sales = new ProductSales();

        int expected = 4;
        int actual = sales.GetSalesUnderLimit();

        assertEquals(expected, actual);
    }
}