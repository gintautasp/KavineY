package kaviney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

import kaviney.Uzsakymai;
import kaviney.UzsakymaiRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/restfull") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UzsakymaiRepository uzsakymaiRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String naujasUzsakymas (@RequestParam String pav
			, @RequestParam Integer trukme_ruosimo
			, @RequestParam Integer trukme_kaitinimo
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Uzsakymai n = new Uzsakymai();
		n.setPav(pav);
		n.setTrukme_ruosimo(trukme_ruosimo);
		n.setTrukme_kaitinimo(trukme_kaitinimo);
		n.setBusena( "uzsakytas" );
		uzsakymaiRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/changestatus") // Map ONLY GET Requests
	public @ResponseBody String keistiBusena (@RequestParam String busena
			, @RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Uzsakymai> found = uzsakymaiRepository.findById( id );
		
		// variantas trynimuiui
		// uzsakymaiRepository.deleteById(id);
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Uzsakymai n = found.get();
			   n.setId(id);
			   n.setBusena(busena);	
			   uzsakymaiRepository.save(n);	
			   res = "Saved";
			}		
		return res;
	}	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Uzsakymai> getAllUzsakymai() {
		// This returns a JSON or XML with the users
		return uzsakymaiRepository.findAll();
	}
}
