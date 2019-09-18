import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Launcher {
	public static void main(String[] args) throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8011);
		Context appContext = tomcat.addWebapp("/app", new File("").getAbsolutePath());
		appContext.setReloadable(true);
		Tomcat.addServlet(appContext, "read-servlet", new ReadServlet());
		Tomcat.addServlet(appContext, "create-servlet", new CreateServlet());
		Tomcat.addServlet(appContext, "update-servlet", new UpdateServlet());
		Tomcat.addServlet(appContext, "delete-servlet", new DeleteServlet());
		appContext.addServletMappingDecoded("/*", "read-servlet");
		appContext.addServletMappingDecoded("/create", "create-servlet");
		appContext.addServletMappingDecoded("/update", "update-servlet");
		appContext.addServletMappingDecoded("/delete", "delete-servlet");
		tomcat.start();
		tomcat.getServer().await();
	}

}
