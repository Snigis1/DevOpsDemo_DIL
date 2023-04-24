package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TicketController {

    private Map<Integer, Ticket> tickets = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.tickets.put(1,new Ticket(1, "Neue Kachel erstellen", "Neue Kachel soll die Farbe orange haben."));
        System.out.println("Init Data");
    }

    @GetMapping("/tickettest")
    public String tickettest() {
        return "Ticket app is up and running!";
    }

    @GetMapping("/services/ticketping")
    public String ticketping() {
        String languageCode = "de";
        return "{ \"status\": \"ok\", \"userId\": \"admin"+ "\", \"languageCode\": \"" + languageCode + "\",\"version\": \"0.0.1" + "\"}";
    }

    @GetMapping("/ticketcount")
    public int ticketcount() {
        return this.tickets.size();
    }

    @GetMapping("/services/ticket")
    public List<PathListEntry<Integer>> ticket() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var ticket : this.tickets.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(ticket.getId(), "ticketKey");
            entry.setName(ticket.getTitle());
            entry.getDetails().add(ticket.getDescription());
            entry.setTooltip(ticket.getDescription());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/ticket/{id}")
    public Ticket getTicket(@PathVariable Integer id) {
        return this.tickets.get(id);
    }

    @PostMapping("/services/ticket")
    public void createTicket(@RequestBody Ticket ticket) {
        var newId = this.tickets.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        ticket.setId(newId);
        this.tickets.put(newId, ticket);
    }

    @PutMapping("/services/ticket/{id}")
    public void createTicket(@PathVariable Integer id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        this.tickets.put(id, ticket);
    }

    @DeleteMapping("/services/ticket/{id}")
    public Ticket deleteTicket(@PathVariable Integer id) {
        return this.tickets.remove(id);
    }


}
