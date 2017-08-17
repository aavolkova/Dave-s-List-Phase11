package me.anna.demo.controllers;

import me.anna.demo.RoomRepository;
import me.anna.demo.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    RoomRepository roomRepository;

    // Display the home page
    @GetMapping("/")
    public String showIndex(Model model)
    {
        String myMessage = "Welcome to the Dave's List - Phase 1 ";
        model.addAttribute("message", myMessage);
        return "index";

    }


    // home page
    @GetMapping("/addRoom")
    public String indexPageGet(Model model) {

        model.addAttribute("newRoom", new Room());
        return "addRoom";
    }


    @PostMapping("/addRoom")
    public String addRooms(@Valid @ModelAttribute("newRoom") Room room, BindingResult bindingResult) {


        if(bindingResult.hasErrors()){
            return "addRoom";
        }

        roomRepository.save(room);
        return "resultRoomAdded";


    }






//    // Show Available rooms
//    @GetMapping("/available")
//    public String showAvailableRooms(Model model) {
//        Iterable<Room> availableRooms = roomRepository.findAll();
//
//        model.addAttribute("availablerooms", availableRooms);
//
//        return "available";
//    }


    // Show Available rooms
    @GetMapping("/available")
    public String showAvailableRooms(Model model) {
        ArrayList<Room> arrR = new ArrayList<Room>();
        Iterable<Room> availableRooms = roomRepository.findAll();
        for(Room roo : availableRooms)
        {
            if(roo.getIsRented() == false)
                arrR.add(roo);
        }
        model.addAttribute("availablerooms", arrR);

        return "available";
    }


    // Show Rented rooms
    @GetMapping("/rented")
    public String showRentedRooms(Model model) {
        ArrayList<Room> arrR = new ArrayList<Room>();
        Iterable<Room> rentedRooms = roomRepository.findAll();
        for(Room roo : rentedRooms)
        {
            if(roo.getIsRented()== true)
                arrR.add(roo);
        }

        model.addAttribute("rented", arrR);

        return "rented";
    }


}
