package org.fssle.sample.controller;

import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {

    private HomeController homeController = new HomeController();
    private ModelMap modelMap;

    @Test
    public void should_render_with_default_products() {
        modelMap = new ModelMap();
        homeController.index(modelMap);

        assertThat(modelMap.get("message"), notNullValue());
    }
}
