package id.co.quiz1_prg7_038.repository;

import id.co.quiz1_prg7_038.model.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static id.co.quiz1_prg7_038.constant.LayananConstant.*;

@Repository
public interface LayananRepository extends JpaRepository<Layanan, Integer> {
    @Query(value = qAllData, nativeQuery = true)
    List<Layanan> findAll();
}
