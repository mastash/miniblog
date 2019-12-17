package pl.sda.spiring.miniblog12;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.spiring.miniblog12.entity.Post;
import pl.sda.spiring.miniblog12.form.NewPostForm;
import pl.sda.spiring.miniblog12.service.PostService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


//show all posts
    @GetMapping("/posts")
    public String showAllPosts(Model model) {
        List<Post> allPosts = postService.getAllPosts();

        model.addAttribute("posts", allPosts);
        return "post/showPosts";
    }


//show post by Id
    @GetMapping("/post")
    public String showPostId(Model model,
                             @RequestParam(required = false, name = "postId")
                                     String postId) {

        Long postIdLong;
        try {
            postIdLong = Long.parseLong(postId);
        } catch (NumberFormatException e) {
            return "post/postNotFound";
        }
        Optional<Post> postOptional = postService.getSinglePost(postIdLong);
        if(postOptional.isPresent() == false){
            return "post/postNotFound";
        }

        model.addAttribute("post", postOptional.get());
        return "post/showPostId";
    }
//        public String showPostId(Model model, @RequestParam(Long postId) {
//        long postIdLong;
//        postIdLong = Long.parseLong(postId);
//        model.addAttribute("postId", postId);
//        Optional<Post> postOptional = postService.getSinglePost(postIdLong);
//        if (postOptional.isPresent()==false) {
//            return "post/postNotFound";
//        }
//        model.addAttribute("post", postOptional.get());
//        return "post/showPostId";



    @GetMapping("/post/add")
    public String showAddNewPost(Model model) {
        model.addAttribute("newPostForm", new NewPostForm());
        return "post/addNewPostForm";
    }

    @PostMapping("/post/add")
    public String handleNewPostForm(@ModelAttribute @Valid NewPostForm newPostForm,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "post/addNewPostForm";
        }

        postService.addNewPost(newPostForm);
        return "redirect:/";
    }

}