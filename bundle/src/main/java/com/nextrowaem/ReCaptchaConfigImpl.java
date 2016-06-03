package com.nextrowaem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Dictionary;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;

import org.osgi.service.component.ComponentContext;


@Component(
	metatype = true,
	immediate = true,
	label = "BootFrom ReCaptcha",
	description = "Configures reCaptcha public and private keys"
)
@Service
public class ReCaptchaConfigImpl implements ReCaptchaService {
	private Logger log = LoggerFactory.getLogger(ReCaptchaConfigImpl.class);
	@Property(label = "Public ReCaptcha Key")
	protected static final String RECAPTCHA_PUBLIC_KEY = "recaptchaPublicKey";
	String recaptchaPublicKey;
	
	@Property(label = "Private ReCaptcha Key")
	protected static final String RECAPTCHA_PRIVATE_KEY = "recaptchaPrivateKey";
	String recaptchaPrivateKey;
	
	protected ComponentContext componentContext;
	
	
	@SuppressWarnings("unchecked")
	@Activate
	public final void activate(ComponentContext componentContext) {
		this.componentContext = componentContext;
		log.info("####activated");
		
		final Dictionary<String, Object> props = componentContext.getProperties();
		this.recaptchaPublicKey = PropertiesUtil.toString(props.get(RECAPTCHA_PUBLIC_KEY), "");
		this.recaptchaPrivateKey = PropertiesUtil.toString(props.get(RECAPTCHA_PRIVATE_KEY), "");
	}


	public String getRecaptchaPublicKey() {
		log.info("@@@get"+ recaptchaPublicKey);
		return recaptchaPublicKey;
	}


	public void setRecaptchaPublicKey(String recaptchaPublicKey) {
		this.recaptchaPublicKey = recaptchaPublicKey;
	}


	public String getRecaptchaPrivateKey() {
		return recaptchaPrivateKey;
	}


	public void setRecaptchaPrivateKey(String recaptchaPrivateKey) {
		this.recaptchaPrivateKey = recaptchaPrivateKey;
	}


	


	
}