package cz.sinj.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ticket {

    @Id
    private Integer id;
    private String date;
    private Integer position;



}
