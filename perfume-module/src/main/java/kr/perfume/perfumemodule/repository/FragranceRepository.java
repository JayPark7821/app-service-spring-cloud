package kr.perfume.perfumemodule.repository;

import kr.perfume.commonmodule.entity.perfume.fragrance.Fragrance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FragranceRepository extends JpaRepository<Fragrance, Long> {
}
