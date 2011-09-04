package org.fssle.sample.controller;

import org.fssle.sample.mail.MailErrors;
import org.fssle.sample.mail.MailService;
import org.fssle.sample.mail.MailShareForm;
import org.fssle.sample.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MailController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private MailService mailService;

    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @RequestMapping(value = "/mail-share-{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") String productId,
            ModelMap modelMap) {
        String imageUrl = productsService.getProduct(productId).getUrl();
        modelMap.put("imageShare", mailService.createMailPresenter(imageUrl));
        return "mail/share_dialog";
    }

    @RequestMapping(value = "/mail-share-{id}", method = RequestMethod.POST)
    public String post(@PathVariable("id") String productId,
                       MailShareForm mailShareForm, ModelMap modelMap) {
        MailErrors errors = mailService.validate(mailShareForm);
        if(errors.getErrorCount()>0){
            modelMap.put("imageShare", mailService.createMailPresenter(mailShareForm, errors));
            return "mail/share_failure";
        }
        mailService.send(mailShareForm);
        modelMap.put("to", mailShareForm.getTo());
        return "mail/share_success";
    }
}
