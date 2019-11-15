package hello;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FormularioController {
    @RequestMapping(value = "/formulario", method=RequestMethod.GET)
    public ModelAndView formulario(Model model){
        model.addAttribute("formulario", new Formulario());
        return new ModelAndView("formulario.html");
    }
    @RequestMapping(value = "/formulario", method=RequestMethod.POST)
    public ModelAndView resultado(@ModelAttribute Formulario formulario){
        return new ModelAndView("resultado.html");
    }
    
}