package de.tenbeitel.tasktrack.web.app;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import de.tenbeitel.tasktrack.web.perspective.main.HomePage;

/**
 * Application object for your web application. If you want to run this application without
 * deploying, run the Start class.
 *
 */
public class TaskTrackApplication extends WebApplication {
  /**
   * @see org.apache.wicket.Application#getHomePage()
   */
  @Override
  public Class<? extends WebPage> getHomePage() {
    return HomePage.class;
  }

  /**
   * @see org.apache.wicket.Application#init()
   */
  @Override
  public void init() {
    super.init();
    // getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    // add your configuration here

    final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    // Scan package for annotated beans
    ctx.scan("org.wicketTutorial.ejbBean");
    ctx.refresh();
    getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx));
  }
}
