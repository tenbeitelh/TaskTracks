package de.tenbeitel.taskstrack.service;

import org.springframework.stereotype.Service;

import com.vaadin.spring.annotation.UIScope;

@Service
@UIScope
public class TestServiceImpl implements TestService {

  @Override
  public void test() {
    // TODO Auto-generated method stub
    System.out.println("Test");
  }

}
