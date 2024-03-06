package com.betrybe.fitness.controller;

import com.betrybe.fitness.service.FitnessServiceInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Fitness controller.
 */
@RestController
@RequestMapping("/fitness")
public class FitnessController implements FitnessControllerInterface {

  private FitnessServiceInterface fitnessServiceInterface;

  public FitnessController(FitnessServiceInterface fitnessServiceInterface) {
    this.fitnessServiceInterface = fitnessServiceInterface;
  }

}
