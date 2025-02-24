package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pluralsight.blog.model.*;
import java.util.List;

@Controller
public class BlogController {
    private PostRepository postRepository;
    @RequestMapping("/")
    public String listPosts(ModelMap modelMap){
        List<Post> posts = postRepository.getAllPosts();
        modelMap.put("posts", posts);
        modelMap.put("title", "Blog Post 1");
        return "home";
    }
    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap){
        Post post = postRepository.findById(id);
        modelMap.put("post",post);
        return "post-details";
    }


    public BlogController(PostRepository postRepository){
        this.postRepository = postRepository;
    }




}
