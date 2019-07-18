package kaviney;

import org.springframework.data.repository.CrudRepository;

import kaviney.Uzsakymai;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UzsakymaiRepository extends CrudRepository<Uzsakymai, Integer> {

}
