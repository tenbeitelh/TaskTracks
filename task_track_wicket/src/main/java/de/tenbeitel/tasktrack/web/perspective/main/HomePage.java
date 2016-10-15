package de.tenbeitel.tasktrack.web.perspective.main;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.tenbeitel.tasktrack.service.TaskService;

public class HomePage extends WebPage {
  private static final long serialVersionUID = 1L;

  @SpringBean
  private TaskService taskService;

  public HomePage(final PageParameters parameters) {
    super(parameters);

    add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

    taskService.testMethod("Test");
  }
}
