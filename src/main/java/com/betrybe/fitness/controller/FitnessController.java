package com.betrybe.fitness.controller;

import com.betrybe.fitness.dto.WorkoutCreationDto;
import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.service.FitnessServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


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

  /**
   * Gets all workouts.
   *
   * @return the all workouts
   */
  @GetMapping("/workouts")
  public ResponseEntity<List<WorkoutDto>> getAllWorkouts() {
    List<WorkoutDto> workoutDto = fitnessServiceInterface.getAllWorkouts();

    return ResponseEntity.ok(workoutDto);
  }

  /**
   * Create workout response entity.
   *
   * @param workoutCreationDto the workout creation dto
   * @return the response entity
   */
  @PostMapping("/workouts")
  public ResponseEntity<WorkoutDto> createWorkout(
      @RequestBody WorkoutCreationDto workoutCreationDto) {
    WorkoutDto create =
        fitnessServiceInterface.saveWorkout(workoutCreationDto);
    return ResponseEntity.status(201).body(create);
  }

  @DeleteMapping("/workouts/{id}")
  public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
    fitnessServiceInterface.deleteWorkout(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/workouts/{id}")
  public ResponseEntity<WorkoutDto> updateWorkout(@PathVariable Long id, @RequestBody WorkoutCreationDto workoutDto) {
    WorkoutDto updatedWorkout = fitnessServiceInterface.updateWorkout(id, workoutDto);
    if (updatedWorkout == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updatedWorkout);
  }

}
