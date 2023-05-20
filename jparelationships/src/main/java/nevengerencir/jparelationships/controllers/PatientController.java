package nevengerencir.jparelationships.controllers;

import nevengerencir.jparelationships.entities.Doctor;
import nevengerencir.jparelationships.entities.Patient;
import nevengerencir.jparelationships.repos.PatientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;




    @RestController
    @RequestMapping("/patient")
    public class PatientController {
        private final PatientRepository patientRepository;

        public PatientController(PatientRepository patientRepository) {
            this.patientRepository = patientRepository;
            Doctor doctor = new Doctor();
            doctor.setName("Marko");
            Patient patient1 = new Patient();
            Patient patient2 = new Patient();

            patient1.setName("Lucas");
            patient2.setName("Ivan");
            patient1.setDoctor(doctor);
            patient2.setDoctor(doctor);
            patientRepository.saveAll(List.of(patient2,patient1));
        }


        @GetMapping("/{id}")
        public Optional<Patient> findUserById(@PathVariable String id){
            return patientRepository.findById(Integer.valueOf(id));
        }
    }
