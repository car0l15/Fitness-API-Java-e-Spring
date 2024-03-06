package com.betrybe.fitness.controller;

import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.service.FitnessServiceInterface;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Fitness controller.
 */
@RestController
@RequestMapping("/fitness")
public class FitnessController implements FitnessControllerInterface {

  private FitnessServiceInterface fitnessServiceInterface;

  /**
   * Instantiates a new Fitness controller.
   *
   * @param fitnessServiceInterface the fitness service interface
   */
  @Autowired
  public FitnessController(FitnessServiceInterface fitnessServiceInterface) {
    this.fitnessServiceInterface = fitnessServiceInterface;
  }

  /**
   * Gets welcome message.
   *
   * @return the welcome message
   */
  @GetMapping
  public String getWelcomeMessage() {
    return "Boas vindas à API de Fitness!";
  }

  /**
   * Gets workout by id.
   *
   * @param id the id
   * @return the workout by id
   */
  @GetMapping("workouts/{id}")
  public ResponseEntity<Optional<WorkoutDto>> getWorkoutById(@PathVariable Long id) {

    Optional<WorkoutDto> workoutDto = fitnessServiceInterface.getWorkout(id);

    if (workoutDto.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(workoutDto);
  }
}