package com.wndxf.invitation.web.template;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * @author wy
 */
@Controller
public class Phone {

    @Autowired
    private Producer captchaProducer;

    @RequestMapping(value = "/testphone", method = RequestMethod.GET)
    public String verificationCode(@RequestParam("path") String path) throws IOException {
        return path;
    }

}
