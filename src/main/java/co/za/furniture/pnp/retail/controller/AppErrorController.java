package co.za.furniture.pnp.retail.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class AppErrorController implements ErrorController {

    private static final Logger logger = LogManager.getLogger(AppErrorController.class);
    @RequestMapping("/")
    public String handleError() {
        logger.error("404 Error, Page Not Found! ");
        return "error/index";
    }

    @Override
    public String getErrorPath() {
        return "/error/index";
    }
}
