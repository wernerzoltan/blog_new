package final_blog.final_blog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import final_blog.final_blog.entity.Story;
import final_blog.final_blog.service.StoryService;


@Controller
public class HomeController {
	
	private StoryService storyService;
	
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	

	@RequestMapping("/{title}")
	public String searchForUser(@PathVariable(value = "title") String title, Model model) throws Exception {
		if (title == null)
			throw new Exception("Nincs ilyen címmel sztorink!");
		model.addAttribute("story", storyService.getSpecificStory(title));
		model.addAttribute("limit4", storyService.getAllByLimited4());
		
		model.addAttribute("countJava", storyService.getCountCategories("java"));
		model.addAttribute("countAngular", storyService.getCountCategories("angular"));
		model.addAttribute("countSql", storyService.getCountCategories("sql"));
		model.addAttribute("countGis", storyService.getCountCategories("gis"));
		model.addAttribute("countTech", storyService.getCountCategories("tech"));
		model.addAttribute("countData", storyService.getCountCategories("data"));
		return "story";
	}
	
	
	@RequestMapping("/")
	public String home4(Model model, Locale locale) {
		model.addAttribute("limit4", storyService.getAllByLimited4());
		
		model.addAttribute("tech2", storyService.getFirstByCategoryName("tech"));
		model.addAttribute("data2", storyService.getFirstByCategoryName("data"));
		model.addAttribute("java2", storyService.getFirstByCategoryName("java"));
		model.addAttribute("angular2", storyService.getFirstByCategoryName("angular"));
		model.addAttribute("gis2", storyService.getFirstByCategoryName("gis"));
		model.addAttribute("sql2", storyService.getFirstByCategoryName("sql"));
		
		model.addAttribute("countJava", storyService.getCountCategories("java"));
		model.addAttribute("countAngular", storyService.getCountCategories("angular"));
		model.addAttribute("countSql", storyService.getCountCategories("sql"));
		model.addAttribute("countGis", storyService.getCountCategories("gis"));
		model.addAttribute("countTech", storyService.getCountCategories("tech"));
		model.addAttribute("countData", storyService.getCountCategories("data"));
		return "index";
	}

	@RequestMapping("/java")
	public String java(Model model, Locale locale)  {
		model.addAttribute("java", storyService.getStoriesByCategoryName("java"));
		model.addAttribute("limit4", storyService.getAllByLimited4());
		model.addAttribute("javaAll", storyService.getStoriesByCategoryName("java"));
		
		model.addAttribute("countJava", storyService.getCountCategories("java"));
		model.addAttribute("countAngular", storyService.getCountCategories("angular"));
		model.addAttribute("countSql", storyService.getCountCategories("sql"));
		model.addAttribute("countGis", storyService.getCountCategories("gis"));
		model.addAttribute("countTech", storyService.getCountCategories("tech"));
		model.addAttribute("countData", storyService.getCountCategories("data"));
		return "java";
	}

	@RequestMapping("/gis")
	public String gis(Model model, Locale locale)  {
		model.addAttribute("gis", storyService.getStoriesByCategoryName("gis"));
		model.addAttribute("limit4", storyService.getAllByLimited4());
		model.addAttribute("gisAll", storyService.getStoriesByCategoryName("gis"));
		
		model.addAttribute("countJava", storyService.getCountCategories("java"));
		model.addAttribute("countAngular", storyService.getCountCategories("angular"));
		model.addAttribute("countSql", storyService.getCountCategories("sql"));
		model.addAttribute("countGis", storyService.getCountCategories("gis"));
		model.addAttribute("countTech", storyService.getCountCategories("tech"));
		model.addAttribute("countData", storyService.getCountCategories("data"));
		return "gis";
	}
	
	@RequestMapping("/angular")
	public String r(Model model, Locale locale)  {
		model.addAttribute("angular", storyService.getStoriesByCategoryName("angular"));
		model.addAttribute("limit4", storyService.getAllByLimited4());
		model.addAttribute("angularAll", storyService.getStoriesByCategoryName("angular"));
		
		model.addAttribute("countJava", storyService.getCountCategories("java"));
		model.addAttribute("countAngular", storyService.getCountCategories("angular"));
		model.addAttribute("countSql", storyService.getCountCategories("sql"));
		model.addAttribute("countGis", storyService.getCountCategories("gis"));
		model.addAttribute("countTech", storyService.getCountCategories("tech"));
		model.addAttribute("countData", storyService.getCountCategories("data"));
		return "angular";
	}
	
	@RequestMapping("/data")
	public String data(Model model, Locale locale)  {
		model.addAttribute("data", storyService.getStoriesByCategoryName("data"));
		model.addAttribute("limit4", storyService.getAllByLimited4());
		model.addAttribute("dataAll", storyService.getStoriesByCategoryName("data"));
		
		model.addAttribute("countJava", storyService.getCountCategories("java"));
		model.addAttribute("countAngular", storyService.getCountCategories("angular"));
		model.addAttribute("countSql", storyService.getCountCategories("sql"));
		model.addAttribute("countGis", storyService.getCountCategories("gis"));
		model.addAttribute("countTech", storyService.getCountCategories("tech"));
		model.addAttribute("countData", storyService.getCountCategories("data"));
		return "data";
	}	

	@RequestMapping("/sql")
	public String sql(Model model, Locale locale)  {
		model.addAttribute("sql", storyService.getStoriesByCategoryName("sql"));
		model.addAttribute("limit4", storyService.getAllByLimited4());
		model.addAttribute("sqlAll", storyService.getStoriesByCategoryName("sql"));
		
		model.addAttribute("countJava", storyService.getCountCategories("java"));
		model.addAttribute("countAngular", storyService.getCountCategories("angular"));
		model.addAttribute("countSql", storyService.getCountCategories("sql"));
		model.addAttribute("countGis", storyService.getCountCategories("gis"));
		model.addAttribute("countTech", storyService.getCountCategories("tech"));
		model.addAttribute("countData", storyService.getCountCategories("data"));
		return "sql";
	}
	
	@RequestMapping("/tech")
	public String tech(Model model, Locale locale)  {
		model.addAttribute("tech", storyService.getStoriesByCategoryName("tech"));
		model.addAttribute("limit4", storyService.getAllByLimited4());
		model.addAttribute("techAll", storyService.getStoriesByCategoryName("tech"));
		
		model.addAttribute("countJava", storyService.getCountCategories("java"));
		model.addAttribute("countAngular", storyService.getCountCategories("angular"));
		model.addAttribute("countSql", storyService.getCountCategories("sql"));
		model.addAttribute("countGis", storyService.getCountCategories("gis"));
		model.addAttribute("countTech", storyService.getCountCategories("tech"));
		model.addAttribute("countData", storyService.getCountCategories("data"));
		
		return "tech";
	}
	

	@RequestMapping("/createposts") 
	public String createposts(Model model) {
		model.addAttribute("story", new Story());
		model.addAttribute("limit4", storyService.getAllByLimited4());
		
		model.addAttribute("countJava", storyService.getCountCategories("java"));
		model.addAttribute("countAngular", storyService.getCountCategories("angular"));
		model.addAttribute("countSql", storyService.getCountCategories("sql"));
		model.addAttribute("countGis", storyService.getCountCategories("gis"));
		model.addAttribute("countTech", storyService.getCountCategories("tech"));
		model.addAttribute("countData", storyService.getCountCategories("data"));
		
		return "createposts";
	}

	
	//@RequestMapping(value = "/create", method = RequestMethod.POST)
	@PostMapping("/create")
	public String postSubmit(@ModelAttribute Story story) {
		storyService.save(story);
		
		
		return "created";
	}
	

	
}