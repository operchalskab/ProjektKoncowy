package pl.edu.wszib.projekt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.projekt.domain.SelectedRout;

import java.util.List;

@Repository
public interface SelectedRoutDao extends CrudRepository<SelectedRout, Integer> {

    List<SelectedRout> findByRout(String rout);

}
