package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n02.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    FlorService florService;


    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> getAllFlors() {
        ArrayList<FlorDTO> allFlors = new ArrayList<>();
        allFlors.addAll(florService.getAll());
        return new ResponseEntity<>(allFlors, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FlorDTO> addFlor(@RequestBody FlorDTO florDTO) {
        florService.saveFlor(florDTO);
        return new ResponseEntity<>(florDTO, HttpStatus.CREATED);
    }

    @GetMapping(path = "getOne/{id}")
    public ResponseEntity<Optional<FlorDTO>> getByID(@PathVariable("id") Integer id) {
        Optional<FlorDTO> florDTO = florService.getByID(id);
        if (florDTO.isPresent()) {
            return new ResponseEntity<>(florDTO, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable("id") Integer id) {
        boolean florDTO = florService.deleteByID(id);
        if (florDTO) {
            return new ResponseEntity<>("The flower with ID: " + id + " was deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("The flower with ID: " + id + " was not found", HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping(path = "/update/{id}")
    public ResponseEntity<FlorDTO> updateByID(@RequestBody FlorDTO florDTO, @PathVariable("id") Integer id) {
        FlorDTO dto = florService.updateByID(id, florDTO);
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
