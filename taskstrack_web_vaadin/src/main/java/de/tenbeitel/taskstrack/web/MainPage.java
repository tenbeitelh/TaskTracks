package de.tenbeitel.taskstrack.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.tenbeitel.taskstrack.service.TestService;

/**
 * This UI is the application entry point. A UI may either represent a browser window (or tab) or
 * some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("standard_theme")
@SpringUI(path = "/test")
public class MainPage extends UI {

  private static final long serialVersionUID = 1L;

  @Autowired
  private TestService testService;

  @Override
  protected void init(VaadinRequest vaadinRequest) {
    final VerticalLayout layout = new VerticalLayout();

    final TextField name = new TextField();
    name.setCaption("Type your name here:");

    final Button button = new Button("Click Me");
    button.addClickListener(e -> {
      layout.addComponent(new Label("Thanks " + name.getValue() + ", it works!"));
      testService.test();
    });

    layout.addComponents(name, button);
    layout.setMargin(true);
    layout.setSpacing(true);

    setContent(layout);
  }

  @WebServlet(urlPatterns = "/*", name = "MainPageServlet", asyncSupported = true)
  @VaadinServletConfiguration(ui = MainPage.class, productionMode = false)
  public static class MainPageServlet extends VaadinServlet {
  }

  @WebListener
  public static class MyContextLoaderListener extends ContextLoaderListener {
  }
}
