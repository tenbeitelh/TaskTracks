package de.tenbeitel.tasktrack.service;

import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
  public void testMethod(String test) {
    System.out.println("Testing string: " + test);
  }
}
