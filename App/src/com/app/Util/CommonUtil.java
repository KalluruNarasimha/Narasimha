package com.app.Util;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Component
public class CommonUtil {
	@Autowired
	private JavaMailSender mailsender;
	public boolean sendEmail(String to,String sub,String txt,final CommonsMultipartFile cmf){
		boolean isSent=false;
		try{
			MimeMessage message=mailsender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(txt);
			helper.setFrom("knarasimha388@gmail.com");
			if(cmf!=null){
				helper.addAttachment(cmf.getOriginalFilename(),new InputStreamSource(){
					public InputStream getInputStream() throws IOException{
						return cmf.getInputStream();
					}
				});
			}
			mailsender.send(message);
			isSent=true;
		}catch(Exception e){
			e.printStackTrace();
			isSent=false;
		}
		return isSent;
	}

}
