package peaksoft.springbootlessonjava13.api;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootlessonjava13.entity.Post;
import peaksoft.springbootlessonjava13.service.PostService;

@Controller
@RequiredArgsConstructor
@RequestMapping("post/{userId}")
public class PostApi {
    private final PostService postService;
    @GetMapping
    public String getAll(Model model, @PathVariable Long userId){
        model.addAttribute("posts",
                            postService.getAllPostByUserId(userId));
        return "/allPosts";
    }

    @GetMapping("/new")
    public String create(Model model,@PathVariable Long userId){
        model.addAttribute("newPost", new Post());
        model.addAttribute("userId",userId);
        return "/newPost";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("newPost") Post post,
                       @PathVariable Long userId){
        postService.savePost(userId,post);
        return "redirect:/post/"+ userId;
    }

    @GetMapping("/search")
    public String search(@RequestParam String word,Model model ){
        model.addAttribute("posts",postService.searchPost(word));
        model.addAttribute("word",word);
        return"/searchResult";
    }

}
