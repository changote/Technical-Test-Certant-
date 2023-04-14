package com.boutique.app.controllers;

import com.boutique.app.models.entity.Client;
import com.boutique.app.models.service.ClientService;
import com.boutique.app.models.service.TurnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping( "/listar")
    public String listar(Model model){
        model.addAttribute("title","Agendar turno");
        model.addAttribute("clientlist",clientService.findAll());
        return "listar";
    }
    @GetMapping( "/findclient")
    public String listar2(Model model){
        model.addAttribute("title","Listado de clientes");
        model.addAttribute("clientlist",clientService.findAll());
        return "client/findclient";
    }

    @GetMapping("/{id}")
    public String profileClient(@PathVariable int id, Map<String,Object> model) {
        Client client = clientService.findOne(id);
        model.put("client", client);
        model.put("title", "Detalle cliente: " + client.getName());
        return "client/client";
    }

    @GetMapping("/form")
    public String createClient(Map<String,Object>model){
        Client client = new Client();
        model.put("client",client);
        model.put("title","Formulario de cliente");
        return "client/clientform";
    }

    @PostMapping("/form")
    public String save(@Valid Client client, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("title","Formulario de cliente");
            return "client/clientform";
        }
        clientService.save(client);
        return "redirect:listar";
    }

}
