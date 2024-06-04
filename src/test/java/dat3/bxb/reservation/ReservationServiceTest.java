package dat3.bxb.reservation;

import dat3.bxb.activity.Activity;
import dat3.bxb.activity.ActivityRepository;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    private ReservationService reservationService;
    private ReservationRepository reservationRepository;
    private ActivityRepository activityRepository;
    private UserWithRolesRepository userWithRolesRepository;

    @BeforeEach
    void setUp() {
        reservationRepository = mock(ReservationRepository.class);
        activityRepository = mock(ActivityRepository.class);
        userWithRolesRepository = mock(UserWithRolesRepository.class);
        reservationService = new ReservationService(reservationRepository, activityRepository, userWithRolesRepository);
    }

    @Test
    void getAllReservations() {
        // Create a Reservation with a non-null Activity
        Activity activity = new Activity();
        activity.setId(1);

        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setActivity(activity);
        reservation.setStartTime(LocalDateTime.now());
        reservation.setPartySize(4);
        reservation.setUserWithRoles(new UserWithRoles());
        reservation.setCustomerName("Customer Name");
        reservation.setCustomerPhone("123456789");
        reservation.setCreated(LocalDateTime.now());
        reservation.setEdited(LocalDateTime.now());

        when(reservationRepository.findAll()).thenReturn(List.of(reservation));

        List<ReservationDTO> result = reservationService.getAllReservations();

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getActivityId());
        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    void getReservationById() {
        // Create a Reservation with a non-null Activity
        Activity activity = new Activity();
        activity.setId(1);

        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setActivity(activity);
        reservation.setStartTime(LocalDateTime.now());
        reservation.setPartySize(4);
        reservation.setUserWithRoles(new UserWithRoles());
        reservation.setCustomerName("Customer Name");
        reservation.setCustomerPhone("123456789");
        reservation.setCreated(LocalDateTime.now());
        reservation.setEdited(LocalDateTime.now());

        when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));

        ReservationDTO result = reservationService.getReservationById(1);

        assertEquals(1, result.getId());
        assertEquals(1, result.getActivityId());
        verify(reservationRepository, times(1)).findById(1);
    }

    @Test
    void createReservation() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setActivityId(1);
        reservationDTO.setStartTime(LocalDateTime.now());
        reservationDTO.setPartySize(4);
        reservationDTO.setUserWithRolesUsername("user");
        reservationDTO.setCustomerName("Customer Name");
        reservationDTO.setCustomerPhone("123456789");

        Activity activity = new Activity();
        activity.setId(1);
        when(activityRepository.findById(1)).thenReturn(Optional.of(activity));
        when(reservationRepository.findByActivityIdAndStartTime(1, reservationDTO.getStartTime()))
                .thenReturn(Collections.emptyList());
        when(userWithRolesRepository.findByUsername("user")).thenReturn(new UserWithRoles());

        ReservationDTO result = reservationService.createReservation(reservationDTO);

        ArgumentCaptor<Reservation> captor = ArgumentCaptor.forClass(Reservation.class);
        verify(reservationRepository, times(1)).save(captor.capture());

        Reservation savedReservation = captor.getValue();
        assertEquals(1, savedReservation.getActivity().getId());
        assertEquals(reservationDTO.getPartySize(), savedReservation.getPartySize());
        assertEquals(reservationDTO.getCustomerName(), savedReservation.getCustomerName());
        assertEquals(reservationDTO.getCustomerPhone(), savedReservation.getCustomerPhone());
    }

    @Test
    void updateReservation() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setActivityId(1);
        reservationDTO.setStartTime(LocalDateTime.now());
        reservationDTO.setPartySize(4);
        reservationDTO.setUserWithRolesUsername("user");
        reservationDTO.setCustomerName("Customer Name");
        reservationDTO.setCustomerPhone("123456789");

        Reservation existingReservation = new Reservation();
        existingReservation.setId(1);
        when(reservationRepository.findById(1)).thenReturn(Optional.of(existingReservation));

        Activity activity = new Activity();
        activity.setId(1);
        when(activityRepository.findById(1)).thenReturn(Optional.of(activity));
        when(reservationRepository.findByActivityIdAndStartTime(1, reservationDTO.getStartTime()))
                .thenReturn(Collections.emptyList());
        when(userWithRolesRepository.findByUsername("user")).thenReturn(new UserWithRoles());

        ReservationDTO result = reservationService.updateReservation(1, reservationDTO);

        ArgumentCaptor<Reservation> captor = ArgumentCaptor.forClass(Reservation.class);
        verify(reservationRepository, times(1)).save(captor.capture());

        Reservation savedReservation = captor.getValue();
        assertEquals(1, savedReservation.getActivity().getId());
        assertEquals(reservationDTO.getPartySize(), savedReservation.getPartySize());
        assertEquals(reservationDTO.getCustomerName(), savedReservation.getCustomerName());
        assertEquals(reservationDTO.getCustomerPhone(), savedReservation.getCustomerPhone());
    }

    @Test
    void deleteReservation() {
        when(reservationRepository.existsById(1)).thenReturn(true);

        reservationService.deleteReservation(1);

        verify(reservationRepository, times(1)).deleteById(1);
    }
}
