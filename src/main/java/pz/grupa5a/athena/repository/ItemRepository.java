package pz.grupa5a.athena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pz.grupa5a.athena.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
