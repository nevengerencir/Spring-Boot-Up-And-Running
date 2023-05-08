package nevengerencir.hospital.controllers;

import nevengerencir.hospital.entities.Doctor;
import nevengerencir.hospital.entities.Patient;
import nevengerencir.hospital.model.Visitor;
import nevengerencir.hospital.repos.PatientRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class MainController {
    private final PatientRepo patientRepo;
    private final Visitor visitor;



    public MainController(PatientRepo patientRepo, Visitor visitor) {
        this.patientRepo = patientRepo;
        this.visitor = visitor;
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        Doctor doctor = new Doctor();

        doctor.setName("Lucas");
        patient1.setName("Karlo");
        patient1.setDoctor(doctor);
        patient2.setName("Neven");
        patient2.setDoctor(doctor);

        patientRepo.saveAll(List.of(patient1,patient2));

    }

    @GetMapping("/{id}")
    public Optional<Patient> findById(@PathVariable  String id){
        return patientRepo.findById(Integer.valueOf(id));
    }
    @GetMapping("/visitor")
    public Visitor getVisitor(){
        return visitor;
    }
}

