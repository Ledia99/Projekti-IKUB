package CinemaBookingsFinal.Domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "seat")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Seat {
    @Id
    @GeneratedValue
    @Column(name = "seat_id")
    private Integer id;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    @JsonManagedReference
    private Cinema cinema;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Booking> bookedSeats;
}

