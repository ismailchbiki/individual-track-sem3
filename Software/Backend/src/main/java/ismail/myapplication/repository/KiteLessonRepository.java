package ismail.myapplication.repository;

import ismail.myapplication.repository.entity.KiteLesson;
import org.springframework.data.jpa.repository.JpaRepository;

// this interface extends from PagingAndSortingRepository which extends from CrudRepository
public interface KiteLessonRepository extends JpaRepository<KiteLesson, Long> {

    // 2 ways to write custom queries:
    // - JPQL
    // - Native Query

    //This is an example of JPQL
    /*@Query("FROM KiteLesson WHERE KiteLesson.type=:type")
    List<KiteLesson> findByType(String type);*/

    //This is an example of Native Query
    /*@Query(value = " select * FROM KiteLesson WHERE KiteLesson.type=:type")
    public List<KiteLesson> findByType(String type);*/
}
