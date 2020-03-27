package ca.javateacher.petsitters.repos;

import ca.javateacher.petsitters.ents.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by iuliana.cosmina on 7/23/16.
 */
public interface PetRepo extends JpaRepository<Pet, Long> {
}
