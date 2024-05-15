package dat3.bxb.reservation;

import dat3.bxb.activity.ActivityRepository;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.stereotype.Service;

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

    private ReservationDTO convertToDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
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

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setActivity(activityRepository.findById(
                reservationDTO.getActivityId())
                .orElseThrow(() -> new IllegalArgumentException("Activity not found with ID: " + reservationDTO.getActivityId())));
        reservation.setStartTime(reservationDTO.getStartTime());
        reservation.setPartySize(reservationDTO.getPartySize());

        // Fix the typo here: missing closing parenthesis in findByUsername method
        reservation.setUserWithRoles(userWithRolesRepository.findByUsername(reservationDTO.getUserWithRolesUsername()));

        reservation.setCustomerName(reservationDTO.getCustomerName());
        reservation.setCustomerPhone(reservationDTO.getCustomerPhone());
        reservation.setCreated(reservationDTO.getCreated());
        reservation.setEdited(reservationDTO.getEdited());

        // Save the reservation to the repository
        reservationRepository.save(reservation);

        // Convert the saved reservation to DTO and return it
        return convertToDTO(reservation);
    }

    public ReservationDTO getReservationById(int id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with ID: " + id));
        return convertToDTO(reservation);
    }
}
