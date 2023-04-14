package com.boutique.app.controllers;

import com.boutique.app.models.entity.*;
import com.boutique.app.models.service.ClientService;
import com.boutique.app.models.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/turn")
@SessionAttributes("turn")
public class TurnController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private TurnService turnService;

    @GetMapping("/typeservice/{clientId}")
    public String selectService(@PathVariable int clientId, Map<String,Object> model){
        model.put("title","Tipo de servicio");
        Client client = clientService.findOne(clientId);
        model.put("client", client);
        return "/carservices/typeservice";
    }

    @GetMapping("/oilchangeform/{clientId}")
    public String createOilChange(@PathVariable int clientId, Map<String,Object> model){
        Client client = clientService.findOne(clientId);
        if(client == null){
            return "redirect:/client/listar";
        }
        Turn turn = new Turn();
        turn.setClient(client);

        model.put("turn",turn);
        model.put("title","Crear turno");

        return "carservices/oilchangeform";
    }


    @PostMapping("/oilchangeform")
    public String saveOilChange(@Valid Turn turn, BindingResult result, @RequestParam("plate") String plate, @RequestParam("cartype") String cartype,
                                @RequestParam("oiltype") String oiltype, @RequestParam("date") String date, Model model){
        if(result.hasErrors()){
            System.out.println("------------------------------------------------------------------------------------");
            model.addAttribute("title","Crear turno");
            return "carservices/oilchangeform";
        }



        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); // se define el formato de la fecha
        try {
            turn.setDate(formato.parse(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        OilChange oilChange = new OilChange();
        oilChange.setCarType(cartype);
        oilChange.setType(oiltype);
        oilChange.servicePrice();
        turn.setService(oilChange);
        turn.setPlate(plate);
        turnService.saveService(turn.getService());
        Client client=turn.getClient();
        client.getTurnList().add(turn);
        clientService.save(client);
        return "redirect:/client/" + turn.getClient().getId();
    }


    ///////////////////

    @GetMapping("/washform/{clientId}")
    public String createWash(@PathVariable int clientId, Map<String,Object> model){
        Client client = clientService.findOne(clientId);
        if(client == null){
            return "redirect:/listar";
        }
        Turn turn = new Turn();
        turn.setClient(client);

        model.put("turn",turn);
        model.put("title","Crear turno");

        return "/carservices/washform";
    }

    @PostMapping("/washform")
    public String saveWash(@Valid Turn turn, BindingResult result,  @RequestParam("type") String type, @RequestParam("plate") String plate,
                           @RequestParam("date") String date, Model model){
        if(result.hasErrors()){
            System.out.println("------------------------------------------------------------------------------------");
            model.addAttribute("title","Crear turno");
            return "carservices/washform";
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); // se define el formato de la fecha
        try {
            turn.setDate(formato.parse(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Wash wash = new Wash();
        wash.setType(type);
        wash.servicePrice();
        turn.setService(wash);
        turn.setPlate(plate);
        turnService.saveService(turn.getService());
        Client client=turn.getClient();
        client.getTurnList().add(turn);
        clientService.save(client);
        return "redirect:/client/" + turn.getClient().getId();
    }

    ///////////////////

    @GetMapping("/aligmentform/{clientId}")
    public String createAligment(@PathVariable int clientId, Map<String,Object> model){
        Client client = clientService.findOne(clientId);
        if(client == null){
            return "redirect:/listar";
        }
        Turn turn = new Turn();
        turn.setClient(client);

        model.put("turn",turn);
        model.put("title","Crear turno");

        return "/carservices/aligmentform";
    }

    @PostMapping("/aligmentform")
    public String saveAligment(@Valid Turn turn, BindingResult result,  @RequestParam("tyre") Boolean tyre, @RequestParam("plate") String plate,
                               @RequestParam("date") String date, Model model){
        if(result.hasErrors()){
            System.out.println("------------------------------------------------------------------------------------");
            model.addAttribute("title","Crear turno");
            return "carservices/aligmentform";
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); // se define el formato de la fecha
        try {
            turn.setDate(formato.parse(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        AligmentAndBalance andBalance = new AligmentAndBalance();
        andBalance.setTyreChange(tyre);
        andBalance.servicePrice();
        turn.setService(andBalance);
        turn.setPlate(plate);
        turnService.saveService(turn.getService());
        Client client=turn.getClient();
        client.getTurnList().add(turn);
        clientService.save(client);
        return "redirect:/client/" + turn.getClient().getId();
    }


}
