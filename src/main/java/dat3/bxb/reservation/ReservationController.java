package dat3.bxb.reservation;

import dat3.bxb.exception.customexceptions.BadRequestException;
import dat3.bxb.exception.customexceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing reservations.
 */
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * GET /reservations : Get all reservations.
     *
     * @return the list of reservations
     */
    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    /**
     * GET /reservations/{id} : Get a reservation by ID.
     *
     * @param id the ID of the reservation
     * @return the ReservationDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable int id) {
        Optional<ReservationDTO> reservationDTO = Optional.ofNullable(reservationService.getReservationById(id));
        if (reservationDTO.isPresent()) {
            return ResponseEntity.ok(reservationDTO.get());
        } else {
            throw new ResourceNotFoundException("Reservation not found with ID: " + id);
        }
    }

    /**
     * POST /reservations/create : Create a new reservation.
     *
     * @param reservationDTO the reservation data transfer object
     * @return the created ReservationDTO
     */
    @PostMapping("/create")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        try {
            ReservationDTO createdReservation = reservationService.createReservation(reservationDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid reservation data: " + e.getMessage());
        }
    }

    /**
     * PATCH /reservations/{id} : Update an existing reservation.
     *
     * @param id the ID of the reservation to update
     * @param reservationDTO the reservation data transfer object
     * @return the updated ReservationDTO
     */
    @PatchMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable int id, @RequestBody ReservationDTO reservationDTO) {
        try {
            ReservationDTO updatedReservation = reservationService.updateReservation(id, reservationDTO);
            return ResponseEntity.ok(updatedReservation);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Reservation not found with ID: " + id);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid reservation data: " + e.getMessage());
        }
    }

    /**
     * DELETE /reservations/{id} : Delete a reservation by ID.
     *
     * @param id the ID of the reservation to delete
     * @return a ResponseEntity indicating the result
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Reservation not found with ID: " + id);
        }
    }
}