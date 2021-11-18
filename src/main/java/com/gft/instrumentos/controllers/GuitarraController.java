package com.gft.instrumentos.controllers;

import com.gft.instrumentos.entities.Guitarra;
import com.gft.instrumentos.services.GuitarraService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("guitarras")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GuitarraController {
    GuitarraService guitarraService;

    @GetMapping
    public ModelAndView listarGuitarras() {
        ModelAndView mv = new ModelAndView("guitarras/lista.html");
        mv.addObject("guitarras", guitarraService.listarGuitarras());

        return mv;
    }

    @GetMapping("editar")
    public ModelAndView criar(@RequestParam(required = false) Long id) {
        ModelAndView mv = new ModelAndView("guitarras/criar.html");

        Guitarra guitarra = new Guitarra();;
        if (id != null) {
            try {
                guitarra = guitarraService.obterGuitarra(id);
            } catch (Exception e) {
                mv.addObject("mensagem", e.getMessage());
            }
        }

        mv.addObject("guitarra", guitarra);

        return mv;
    }

    @PostMapping("editar")
    public ModelAndView salvar(Guitarra guitarra) {
        ModelAndView mv = new ModelAndView("redirect:/guitarras");
        guitarraService.salvarGuitarra(guitarra);

        return mv;
    }

    @GetMapping("excluir")
    public ModelAndView excluirGuitarra(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/guitarras");

        try {
            guitarraService.excluirGuitarra(id);
            redirectAttributes.addFlashAttribute("mensagem", "Guitarra excluída com sucesso");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir guitarra: " + e.getMessage());
        }

        return mv;
    }
}
