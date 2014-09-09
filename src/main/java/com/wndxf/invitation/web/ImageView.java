package com.wndxf.invitation.web;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.model.Users;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author wy
 */
@Controller
public class ImageView {

    @Autowired
    private Producer captchaProducer;

    @RequestMapping(value = "/code", method=RequestMethod.GET)
    public String verificationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.flush();
        }catch (Exception e){

        }finally {
            out.close();
        }
        return null;
    }

    @RequestMapping(value = "/qrCode", method=RequestMethod.GET)
    public String qrCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String qrtext = request.getParameter("qrtext");

        ByteArrayOutputStream out = QRCode.from(qrtext).to(
                ImageType.PNG).stream();

        response.setContentType("image/png");
        response.setContentLength(out.size());

        OutputStream outStream = response.getOutputStream();

        outStream.write(out.toByteArray());

        outStream.flush();
        outStream.close();
        return null;
    }

}
