package org.fssle.sample.controller;

import org.fssle.sample.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    ProductsService productsService;

    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value="/product")
    public String list(ModelMap modelMap) {
        modelMap.put("products", productsService.createProductsPresenter());
        return "product/list";
    }

    @RequestMapping(value="/product-{id}")
    public String show(@PathVariable("id") String productId,
                        ModelMap modelMap) {
        modelMap.put("product", productsService.getProduct(productId));
        return "product/show";
    }
}
