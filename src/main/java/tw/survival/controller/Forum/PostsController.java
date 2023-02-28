package tw.survival.controller.Forum;


import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import tw.survival.model.Forum.PostsBean;
import tw.survival.service.Forum.PostsService;

@Controller
//@RequestMapping()  統括/post 假如以下所有的Api路徑前都有"/post"字串可以寫在它裡面
public class PostsController {

	@Autowired
	private PostsService pService;
	
	@GetMapping("/posts.main")
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
		List<PostsBean> postList = pService.getAllPosts1();
		model.addAttribute("List", postList);
		return "Forum/showPostsPage";
	}
	
	@DeleteMapping("/post/edit")
	public String deletePost(@Param("id") Integer id) {
		pService.deletePost(id);
		return "redirect:/posts/getAll";
	}
	
	@DeleteMapping("/post/delete")
	public String deletePost1(@Param("id") Integer id) {
		pService.deletePost(id);
		return "redirect:/posts/getAll";
	}
	
	@GetMapping("/post/edit")
	public String postEditPage(@RequestParam("id") Integer id, Model model){
		PostsBean post = pService.findPostById(id);
		model.addAttribute("postsBean", post);
		return "Forum/editPostPage";
	}

	@PutMapping("/post/edit")
//	@InitBinder
	public String postUpdate(@ModelAttribute(name = "editPost") PostsBean editPost) {
		
		editPost.setFinalAdded(new Date());
	
		
		pService.updatePost(editPost);
		return "redirect:/posts/getAll";
	}
	
	
	
	
	
}
