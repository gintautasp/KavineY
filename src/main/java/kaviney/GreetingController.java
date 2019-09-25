package kaviney;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ernadaslinks.Menu;



@Controller
public class GreetingController {
	
	private static SessionFactory factory;	

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
    
	@GetMapping(path="/top-patiekalai")
	public  String											// @ResponseBody Iterable<TopPatiekalai> 
		getTopPatiekalai(
			@RequestParam String laikotarpis_nuo
			, @RequestParam String laikotarpis_iki
			, Model model
	) {
		
//		 Map<String, String> properties = new HashMap<String, String>();
//		  properties.put("javax.persistence.jdbc.user", "root");
//		  properties.put("javax.persistence.jdbc.password", "");
//		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopPatiekalaiAtaskaita");   // Persistence.createEntityManagerFactory( "jdbc:mysql://localhost:3306/spring_jpa/kavine;user=root;password=");		
		
//	    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "TopPatiekalaiAtaskaita" ); // "Eclipselink_JPA" );
//		EntityManager entitymanager = emf.createEntityManager();
				
//		TopPatiekalaiAtaskaita tp = new TopPatiekalaiAtaskaita( entitymanager );

//		return tp.topPatiekalai(laikotarpis_nuo, laikotarpis_iki);
		
//	    HibernateUtil hibernateUtil = new HibernateUtil();
		
 
		      
		try {
			
			factory = new Configuration().configure().buildSessionFactory();
			
		} catch (Throwable ex) {
			
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}		
		
		Session session = factory.getCurrentSession();
		// String sqlQuery = "select openmode from ";
		// Query query = session.createNativeQuery(sqlQuery);
		// List<Object[]> listResults = query.getResultList();
		
		TopPatiekalaiAtaskaita top_patieklai_ataskaita =  new TopPatiekalaiAtaskaita( session );
        model.addAttribute("lst_top_patiekalai", top_patieklai_ataskaita.topPatiekalai(laikotarpis_nuo, laikotarpis_iki) ); 		
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
