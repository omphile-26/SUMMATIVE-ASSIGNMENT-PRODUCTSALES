/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsales;

/**
 *
 * @author deepl
 */
public class ProductSales implements IProductSales {

    private final int SALES_LIMIT = 500;

    private final int[][] productSales = {
            {300, 150, 700},
            {250, 200, 600}
    };

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {

        int total = 0;

        for (int[] row : productSales) {
            for (int value : row) {
                total += value;
            }
        }

        return total;
    }

    @Override
    public int GetSalesOverLimit() {

        int count = 0;

        for (int[] row : productSales) {
            for (int value : row) {

                if (value > SALES_LIMIT) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public int GetSalesUnderLimit() {

        int count = 0;

        for (int[] row : productSales) {
            for (int value : row) {

                if (value <= SALES_LIMIT) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public int GetProductsProcessed() {
        return productSales.length;
    }

    @Override
    public double GetAverageSales() {

        int products = 0;

        for (int[] row : productSales) {
            products += row.length;
        }

        return (double) GetTotalSales() / products;
    }
}