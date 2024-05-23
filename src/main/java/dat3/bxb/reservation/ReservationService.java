package dat3.bxb.reservation;

import dat3.bxb.activity.Activity;
import dat3.bxb.activity.ActivityRepository;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ActivityRepository activityRepository;
    private final UserWithRolesRepository userWithRolesRepository;

    public ReservationService(ReservationRepository reservationRepository, ActivityRepository activityRepository, UserWithRolesRepository userWithRolesRepository) {
        this.reservationRepository = reservationRepository;
        this.activityRepository = activityRepository;
        this.userWithRolesRepository = userWithRolesRepository;
    }

    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(this::convertToDTO).toList();
    }

    public ReservationDTO getReservationById(int id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with ID: " + id));
        return convertToDTO(reservation);
    }

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Activity activity = activityRepository.findById(reservationDTO.getActivityId())
                .orElseThrow(() -> new IllegalArgumentException("Activity not found with ID: " + reservationDTO.getActivityId()));
        LocalDateTime startTime = reservationDTO.getStartTime();

        // Check for existing reservations with the same activity_id and start_time
        List<Reservation> existingReservations = reservationRepository.findByActivityIdAndStartTime(activity.getId(), startTime);
        if (!existingReservations.isEmpty()) {
            throw new IllegalArgumentException("A reservation already exists for the selected activity at the specified start time.");
        }

        Reservation reservation = new Reservation();
        reservation.setActivity(activity);
        reservation.setStartTime(startTime);
        reservation.setPartySize(reservationDTO.getPartySize());
        reservation.setUserWithRoles(userWithRolesRepository.findByUsername(reservationDTO.getUserWithRolesUsername()));
        reservation.setCustomerName(reservationDTO.getCustomerName());
        reservation.setCustomerPhone(reservationDTO.getCustomerPhone());
        reservation.setCreated(reservationDTO.getCreated());
        reservation.setEdited(reservationDTO.getEdited());

        reservationRepository.save(reservation);

        return convertToDTO(reservation);
    }

    public ReservationDTO updateReservation(int id, ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with ID: " + id));
        Activity activity = activityRepository.findById(reservationDTO.getActivityId())
                .orElseThrow(() -> new IllegalArgumentException("Activity not found with ID: " + reservationDTO.getActivityId()));
        LocalDateTime startTime = reservationDTO.getStartTime();

        // Check for existing reservations with the same activity_id and start_time, excluding the current reservation
        List<Reservation> existingReservations = reservationRepository.findByActivityIdAndStartTime(activity.getId(), startTime);
        if (!existingReservations.isEmpty() && existingReservations.stream().anyMatch(r -> r.getId() != id)) {
            throw new IllegalArgumentException("A reservation already exists for the selected activity at the specified start time.");
        }

        reservation.setActivity(activity);
        reservation.setStartTime(startTime);
        reservation.setPartySize(reservationDTO.getPartySize());
        reservation.setUserWithRoles(userWithRolesRepository.findByUsername(reservationDTO.getUserWithRolesUsername()));
        reservation.setCustomerName(reservationDTO.getCustomerName());
        reservation.setCustomerPhone(reservationDTO.getCustomerPhone());
        reservation.setCreated(reservationDTO.getCreated());
        reservation.setEdited(reservationDTO.getEdited());

        reservationRepository.save(reservation);

        return convertToDTO(reservation);
    }

    public void deleteReservation(int id) {
        if (!reservationRepository.existsById(id)) {
            throw new IllegalArgumentException("Reservation not found with ID: " + id);
        }
        reservationRepository.deleteById(id);
    }

    private ReservationDTO convertToDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setActivityId(reservation.getActivity().getId());
        dto.setStartTime(reservation.getStartTime());
        dto.setPartySize(reservation.getPartySize());
        dto.setUserWithRolesUsername(reservation.getUserWithRoles().getUsername());
        dto.setCustomerName(reservation.getCustomerName());
        dto.setCustomerPhone(reservation.getCustomerPhone());
        dto.setCreated(reservation.getCreated());
        dto.setEdited(reservation.getEdited());
        return dto;
    }
}