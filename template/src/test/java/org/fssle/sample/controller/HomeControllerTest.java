package org.fssle.sample.controller;

import org.fssle.sample.controller.HomeController;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {
    @Test
    public void should_render_with_default() {

        ModelMap modelMap = new ModelMap();
        HomeController homeController = new HomeController();
        homeController.index(modelMap);

        assertThat(modelMap.get("message"), notNullValue());
    }
}
