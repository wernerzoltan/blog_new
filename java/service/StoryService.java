package final_blog.final_blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import final_blog.final_blog.entity.Story;
import final_blog.final_blog.repo.StoryRepository;
import final_blog.final_blog.repo.UserRepository;

@Service
public class StoryService {
	
	private StoryRepository storyRepo;
	private UserRepository userRepo;
	
	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}
	
	@Autowired
	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	public List<Story> getStories() {
		return storyRepo.findAll();
	}
	
	public Story getStory(){
		return storyRepo.findFirstByOrderByPostedDesc();
	}

	public Story getSpecificStory(String title) {
		return storyRepo.findByTitle(title);
	}

	public List<Story> getStoriesByCategoryName(String category) {
		return storyRepo.findAllByCategoryIgnoreCaseOrderByPostedDesc(category);
	}
	
	public List<Story> getFirstByCategoryName(String category) {
		return storyRepo.findFirstByCategoryIgnoreCaseOrderByPostedDesc(category);
	}

	public List<Story> getAllByLimited4() {
		return storyRepo.findAllLimitedTo4();
	}
	
	public String getCountCategories(String category) {
		return storyRepo.countCategories(category);
	}
	
	
	public void save(Story story) {
		Date date = new Date();
		story.setPosted(date); //dátumot hozzáadjuk
	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		System.out.println("szöveg: " + currentPrincipalName);
		story.setUser(userRepo.findByFullName(currentPrincipalName)); 
	
		storyRepo.save(story);
		//SQL-ben ezt kellett ehhez futtatni: CREATE SEQUENCE hibernate_sequence START 1;
	}
	
	public void delete(Story story) {
		storyRepo.delete(story);
	}

}