package cz.sinj.system;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Jednoduchý systém pro obsluhu fronty.
 * **/
@RestController
public class TicketsController {

    Queue<Ticket> queue = new LinkedList<>();
    int id = 0;
    /**
     * Zobrazení ticketu, který je právě na řadě. (Nejstarší)
     * Vrací nejstarší ticket.
     * @return String
     * **/
    @GetMapping("/now")
    public String getNow() {
        Ticket ticket = queue.peek();
        if (ticket != null) {
            return ("(" + ticket.getId() + ", " + ticket.getDate() + ", " + ticket.getPosition() + ")");
        } else {
            return "Queue is empty.";
        }
    }

    /**
     * Vypsání celé fronty.
     * Vrací seznam všech ticketů ve frontě.
     * @return String
     * **/
    @GetMapping("/all")
    public String getAll() {
        String returnString = "";
        StringBuilder buffer = new StringBuilder();
        for (Ticket ticket : queue) {
            returnString = ("(" + ticket.getId() + ", " + ticket.getDate() + ", " + ticket.getPosition() + ")" + "<br>");
            buffer.append(returnString);
        }
        return buffer.toString();
    }

    /**
     * Smazání nejstaršího ticketu, který je právě na řadě.
     * Vrací právě smazaný ticket.
     * @return String
     * **/
    @GetMapping("/delete")
    public String delete() {
        Ticket ticket = queue.poll();
        if (ticket != null) {

            for (Ticket ticketChange : queue) {
                int position = ticketChange.getPosition();
                ticketChange.setPosition(position - 1);
            }

            return ("(" + ticket.getId() + ", " + ticket.getDate() + ", " + ticket.getPosition() + ")");
        } else {
            return "Queue is empty.";
        }
    }

    /**
     * Vytvoření nového ticketu.
     * Vrací nově vytvořený ticket.
     * @return String
     * **/
    @GetMapping("/new")
    public String newTicket() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        int size = queue.size();
        Ticket ticket = new Ticket();
        ticket.setId(id);
        id++;
        ticket.setDate(now.format(formatter));
        ticket.setPosition(size);

        if (queue.offer(ticket)) {
            return ("(" + ticket.getId() + ", " + ticket.getDate() + ", " + ticket.getPosition() + ")");
        } else {
            return "Not enough space.";
        }
    }


}
