package kaviney;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GreetingController {

    @GetMapping("/uzsakymai")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "uzsakymai";
    }    
    
    @GetMapping("/paruosimas")
    public String paruosimas(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "paruosimas";
    }   
    
    @GetMapping("/produktai")
    public String produktai(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "produktai";
    }     
    
    @GetMapping("/patiekalai")
    public String patiekalai(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "patiekalai";
    }  
    
    @GetMapping("/tiekejai")
    public String tiekejai() {

        return "tiekajai";
    }     
    
    @GetMapping("/patiekalas")
    public String patiekalas(@RequestParam Integer id) {

        return "patiekalas";
    }
    
    @GetMapping("/info")
    public String info() {
    	return "info";
    }
    
    @GetMapping("/inforaides001")
    public String inforaides() {
    	return "info";
    } 
    
    @RequestMapping("/simple")
    public @ResponseBody String greeting() {
        return "Hello Simple";
    }   
    
    @GetMapping("/ind")
    public String ind(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }     

}
