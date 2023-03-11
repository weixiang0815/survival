package tw.survival.model.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeneratedLinkUtils {
	  @Value("${app.base.url}")
	    private String appBaseUrl;

	public String generateActivationLink(String activationCode) {
        return appBaseUrl + "/activate?code=" + activationCode;
    }
}
