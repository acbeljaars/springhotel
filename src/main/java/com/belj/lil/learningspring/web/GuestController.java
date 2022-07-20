package com.belj.lil.learningspring.web;

import com.belj.lil.learningspring.business.ReservationService;
import com.belj.lil.learningspring.business.RoomReservation;
import com.belj.lil.learningspring.data.Guest;
import com.belj.lil.learningspring.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestController {

    private final DateUtils _dateUtils;
    private final ReservationService reservationService;

    public GuestController(DateUtils _dateUtils, ReservationService reservationService) {
        this._dateUtils = _dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String getGuests(@RequestParam(value="date", required = false) String dateString, Model model)
    {
        List<Guest> guestList = this.reservationService.getGuests();
        model.addAttribute("guests", guestList);
        return "guests";
    }
}
