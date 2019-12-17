package pl.sda.spiring.miniblog12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spiring.miniblog12.entity.Post;
import pl.sda.spiring.miniblog12.form.NewPostForm;
import pl.sda.spiring.miniblog12.repository.PostRepository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addNewPost(NewPostForm postAddForm) {
        Post post = new  Post();
        post.setTitle(postAddForm.getTitle());
        post.setCommnent(postAddForm.getComment());
        post.setAdded(LocalDateTime.now());

     //   post.setText(postAddForm.getText());

        postRepository.save(post);
    }


    //wyszukiwanie posta po id
    public Optional<Post> getSinglePost(Long postId) {

        return postRepository.findById(postId);

        //Post one = post
    }


    //show all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
