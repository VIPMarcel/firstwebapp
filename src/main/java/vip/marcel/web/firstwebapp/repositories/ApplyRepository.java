package vip.marcel.web.firstwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vip.marcel.web.firstwebapp.entities.Apply;

@Repository
public interface ApplyRepository extends CrudRepository<Apply, Long> {

}
