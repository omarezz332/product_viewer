package com.example.omaradel.productviewer;

public class Product_marchents {
   private String ProductMerchant_id;
    private String id_ProductMerchant;
    private String ProductMerchant_upc;
    private  String ProductMerchant_sku;
    private  String ProductMerchant_created;
    private String ProductMerchant_modified;
    private  String multiple_products_per_page;

    public Product_marchents(String productMerchant_id, String id_ProductMerchant, String productMerchant_upc, String productMerchant_sku, String productMerchant_created, String productMerchant_modified, String multiple_products_per_page) {
        ProductMerchant_id = productMerchant_id;
        this.id_ProductMerchant = id_ProductMerchant;
        ProductMerchant_upc = productMerchant_upc;
        ProductMerchant_sku = productMerchant_sku;
        ProductMerchant_created = productMerchant_created;
        ProductMerchant_modified = productMerchant_modified;
        this.multiple_products_per_page = multiple_products_per_page;
    }

    public String getProductMerchant_id() {
        return ProductMerchant_id;
    }

    public String getId_ProductMerchant() {
        return id_ProductMerchant;
    }

    public String getProductMerchant_upc() {
        return ProductMerchant_upc;
    }

    public String getProductMerchant_sku() {
        return ProductMerchant_sku;
    }

    public String getProductMerchant_created() {
        return ProductMerchant_created;
    }

    public String getProductMerchant_modified() {
        return ProductMerchant_modified;
    }

    public String getMultiple_products_per_page() {
        return multiple_products_per_page;
    }
}
