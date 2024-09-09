/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhnd.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author PHUCHAU
 */
public class MyContextServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1. Select context scope
        ServletContext context = sce.getServletContext();
        context.log("Do you see me!!!");
        //2. Get sitemap path
        String sitemapPath = context.getInitParameter("SITEMAP_PATH");
        //3. Load properties
        InputStream is = null;
        try {
            Properties sitemap = new Properties();
            is = context.getResourceAsStream(sitemapPath);
            sitemap.load(is);
            //4. store sitemap to context
            context.setAttribute("SITEMAP", sitemap);
        } catch(IOException e) {
            context.log("MyContextServletListener_IO" + e.getMessage());
        } finally {
            if(is!=null) {
                try {
                    is.close();
                } catch(IOException e) {
                    context.log("MyContextServletListener_IO" + e.getMessage());
                }
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Again");
    }
}
