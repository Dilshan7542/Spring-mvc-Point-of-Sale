import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.thogakade.config.WebAppConfig;
import org.thogakade.config.WebRootConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.Registration;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        String temp="D:\\.WORK AREA\\Spring\\thogakade\\thogakade\\src\\main\\java\\org\\thogakade\\img";
        registration.setMultipartConfig(new MultipartConfigElement("/img"));
    }
}
