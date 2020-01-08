package final_blog.final_blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import final_blog.final_blog.entity.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {
	
	//SELECT * FROM STORY
	List<Story> findAll();
	
	//SELECT * FROM STORY WHERE posted IN (SELECT max(posted) FROM story) LIMIT 1;
	Story findFirstByOrderByPostedDesc();

	//@Query(value = "SELECT * FROM story WHERE title = ?1 LIMIT 1", nativeQuery = true)
	//@Query(value = "SELECT * FROM story WHERE title = :title LIMIT 1", nativeQuery = true)
	@Query(value = "SELECT s FROM Story s WHERE s.title = ?1")
	Story findByTitle(@Param("title") String title);
	
	List<Story> findAllByCategoryIgnoreCaseOrderByPostedDesc(String category);
	
	List<Story> findFirstByCategoryIgnoreCaseOrderByPostedDesc(String category);
	
	@Query(value = "SELECT * FROM Story s ORDER BY posted desc LIMIT 4", nativeQuery = true)
	List <Story> findAllLimitedTo4();
	
	@Query(value = "SELECT COUNT(s) FROM Story s WHERE category = ?1", nativeQuery = true)
	String countCategories(@Param("category") String category);
	
}