package tw.survival.controller.Forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tw.survival.model.Forum.PostsBean;
import tw.survival.service.Forum.PostsService;

@Controller
public class PostsController {

	@Autowired
	private PostsService pService;
	
	@GetMapping("/forum.main")
	public String mainPage() {
		return "Forum/index";
	}
	
	@GetMapping("/formToAdd")
	public String addPost(Model model) {
		PostsBean newPost = new PostsBean();
		model.addAttribute("PostsBean", newPost);
		return "Forum/addPostForm";
	}
	
	@PostMapping("/posts/post")
	public String insertPost(@ModelAttribute PostsBean post, Model model) {
		pService.insertPost(post);
		
		PostsBean newPost = new PostsBean();
		model.addAttribute("PostsBean", newPost);
		return "Forum/addPostForm";
		
	}
	
	
	
	
	
}
