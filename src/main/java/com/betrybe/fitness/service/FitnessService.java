package com.betrybe.fitness.service;

import com.betrybe.fitness.database.FakeFitnessDatabase;
import com.betrybe.fitness.dto.WorkoutCreationDto;
import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.model.Workout;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fitness service.
 */
@Service
public class FitnessService implements FitnessServiceInterface {

  private FakeFitnessDatabase fakeFitnessDatabase;

  @Autowired
  public FitnessService(FakeFitnessDatabase fakeFitnessDatabase) {
    this.fakeFitnessDatabase = fakeFitnessDatabase;
  }


  @Override
  public WorkoutDto saveWorkout(WorkoutCreationDto newWorkoutDto) {
    Workout workout = new Workout();

    workout.setName(newWorkoutDto.name());
    workout.setRepetitions(newWorkoutDto.repetitions());
    workout.setSecretTechnique(newWorkoutDto.secretTechnique());

    Workout savedWorkout = fakeFitnessDatabase.saveWorkout(workout);

    return new WorkoutDto(savedWorkout.getId(), savedWorkout.getName(),
        savedWorkout.getRepetitions());

  }

  @Override
  public Optional<WorkoutDto> getWorkout(Long id) {
    Optional<Workout> workout = fakeFitnessDatabase.getWorkout(id);

    if (workout.isEmpty()) {
      return Optional.empty();
    }

    WorkoutDto workoutDto = new WorkoutDto(workout.get().getId(), workout.get().getName(),
        workout.get().getRepetitions());

    return Optional.of(workoutDto);

  }

  @Override
  public List<WorkoutDto> getAllWorkouts() {
    List<Workout> workouts = fakeFitnessDatabase.getAllWorkouts();

    if (workouts.isEmpty()) {
      return Collections.emptyList();
    }
    return workouts.stream()
        .map(workout -> new WorkoutDto(workout.getId(), workout.getName(),
            workout.getRepetitions()))
        .collect(Collectors.toList());
  }
}
