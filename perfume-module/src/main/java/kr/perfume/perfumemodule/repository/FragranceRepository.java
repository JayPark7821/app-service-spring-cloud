package kr.perfume.perfumemodule.repository;

import kr.perfume.perfumemodule.entity.fragrance.Fragrance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FragranceRepository extends JpaRepository<Fragrance, Long> {
}
