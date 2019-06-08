package pl.edu.wszib.projekt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.projekt.domain.ClimbingArea;

import java.util.List;

@Repository
public interface ClimbingAreaDao extends CrudRepository<ClimbingArea,Integer> {

    List<ClimbingArea> findByRoutn(String routn);

}
