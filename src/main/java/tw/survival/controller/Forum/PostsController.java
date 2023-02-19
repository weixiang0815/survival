package tw.survival.controller.Forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	@GetMapping("/posts/getAll")
	public String showAllPosts(Model model) {
		List<PostsBean> postList = pService.getAllPosts();
		model.addAttribute("List", postList);
		return "Forum/showPostsPage";
	}
	
	@DeleteMapping("/post/delete")
	public String deletePost(@Param("id") Integer id) {
		pService.deletePost(id);
		return "Forum/showPostsPage";
	}
	
	@GetMapping("/post/edit")
	public String postEditPage(@Param("id") Integer id, Model model){
		PostsBean post = pService.findPostById(id);
		model.addAttribute("editPost", post);
		return "Forum/editPostsPage";
	}
	
	@PutMapping("/post/update")
	public String postUpdate(@ModelAttribute("editPost") PostsBean editPost) {
		pService.updatePost(editPost);
		return "Forum/showPostsPage";
	}
	
	
	
	
	
}
