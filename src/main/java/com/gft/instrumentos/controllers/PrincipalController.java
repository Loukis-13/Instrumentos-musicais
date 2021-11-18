package com.gft.instrumentos.controllers;

import com.gft.instrumentos.services.GuitarraService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PrincipalController {
    GuitarraService guitarraService;

    @GetMapping
    public ModelAndView inicio() {
        ModelAndView mv = new ModelAndView("guitarras/lista.html");
        mv.addObject("guitarras", guitarraService.listarGuitarras());

        return mv;
    }
}
