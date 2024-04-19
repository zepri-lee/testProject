package studio.thinkground.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.data.entity.Latecomer;
import studio.thinkground.data.repository.LatecomerRepository;

@RestController
@RequestMapping("/latecomers")
public class LatecomerController {
    @Autowired
    private LatecomerRepository latecomerRepository;

    @GetMapping("/")
    public List<Latecomer> getAllLatecomers() {
        return latecomerRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Latecomer> getAllLatecomers(@RequestParam Long id) {
        return latecomerRepository.findById(id);
    }    

    @PostMapping("/")
    public Latecomer addLatecomer(@RequestBody Latecomer latecomer) {
        latecomer.setLateTime(LocalDateTime.now()); // 현재 시간으로 설정
        return latecomerRepository.save(latecomer);
    }
}

