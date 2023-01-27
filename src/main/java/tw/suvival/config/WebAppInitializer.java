package tw.suvival.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 相當於 web.xml 的 Java 程式組態
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override // 用來註冊相當於 applicationContext.xml (beans.config.xml) 的 Java 程式組態
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootAppConfig.class };
//		return null;
	}

	@Override // 用來註冊相當於 mvc-servlet.xml 的 Java 程式組態
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebAppConfig.class };
//		return null;
	}

	@Override // 設定 DispatcherServlet 的 url-pattern
	protected String[] getServletMappings() {
		return new String[] { "/" };
//		return null;
	}

	@Override
	protected Filter[] getServletFilters() {
//		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//		characterEncodingFilter.setEncoding("UTF-8");
//		characterEncodingFilter.setForceEncoding(true);
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
		return new Filter[] { characterEncodingFilter };
	}

}
