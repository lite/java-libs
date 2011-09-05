package org.fssle.sample.controller;

import org.fssle.sample.form.ProductForm;
import org.fssle.sample.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    ProductsService productsService;

    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "/product")
    public String index(ModelMap modelMap) {
        modelMap.put("products", productsService.createProductsPresenter());
        return "product/index";
    }

    @RequestMapping(value = "/product/{id}")
    public String show(@PathVariable("id") String productId,
                       ModelMap modelMap) {
        modelMap.put("product", productsService.createProductPresenter(productId));
        return "product/show";
    }

    @RequestMapping(value = "/product/new")
    public String add(ModelMap modelMap) {
        modelMap.put("product", productsService.createProductPresenter());
        return "product/new";
    }

    @RequestMapping(value = "/product/new", method = RequestMethod.POST)
    public String create(ProductForm productForm,
                         ModelMap modelMap) {
        productsService.insertProduct(productForm.toProduct());
        return "redirect:/product";
    }

    @RequestMapping(value = "/product/{id}/edit")
    public String edit(@PathVariable("id") String productId,
                       ModelMap modelMap) {
        modelMap.put("product", productsService.createProductPresenter(productId));
        return "product/edit";
    }

    @RequestMapping(value = "/product/{id}/edit", method = RequestMethod.POST)
    public String update(@PathVariable("id") String productId,
                         ProductForm productForm,
                         ModelMap modelMap) {
        productsService.updateProduct(productId, productForm.toProduct());
        return "redirect:/product";
    }

    @RequestMapping(value = "/product/{id}/delete")
    public String destroy(@PathVariable("id") String productId,
                          ModelMap modelMap) {
        productsService.deleteProduct(productId);
        return "redirect:/product";
    }

    @RequestMapping(value = "/product/delete")
    public String deleteAll(ModelMap modelMap) {
        productsService.deleteProducts();
        return "redirect:/product";
    }

}
