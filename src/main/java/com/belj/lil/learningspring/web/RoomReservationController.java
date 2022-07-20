package com.belj.lil.learningspring.web;

import com.belj.lil.learningspring.business.ReservationService;
import com.belj.lil.learningspring.business.RoomReservation;
import com.belj.lil.learningspring.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {

    private final DateUtils _dateUtils;
    private final ReservationService reservationService;

    public RoomReservationController(DateUtils _dateUtils, ReservationService reservationService) {
        this._dateUtils = _dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required = false) String dateString, Model model)
    {
        Date date = this._dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservationList);
        return "roomres";
    }
}
