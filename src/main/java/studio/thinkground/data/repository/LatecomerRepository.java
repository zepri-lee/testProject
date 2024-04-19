package studio.thinkground.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studio.thinkground.data.entity.Latecomer;

public interface LatecomerRepository extends JpaRepository<Latecomer, Long> {
}

