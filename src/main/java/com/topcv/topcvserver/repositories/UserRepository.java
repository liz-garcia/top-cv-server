package com.topcv.topcvserver.repositories;

import com.topcv.topcvserver.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for performing CRUD operations on User entities. Extends Spring Data's
 * MongoRepository to leverage built-in functionality.
 */
public interface UserRepository extends MongoRepository<User, String> {
  // Currently no need for custom methods; use the built-in findAll() method
}
