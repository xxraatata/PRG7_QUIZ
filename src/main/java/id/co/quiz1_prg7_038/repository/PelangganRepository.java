package id.co.quiz1_prg7_038.repository;

import id.co.quiz1_prg7_038.model.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static id.co.quiz1_prg7_038.constant.PelangganConstant.*;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, String> {
    @Query(value = qAllData, nativeQuery = true)
    List<Pelanggan> findAll();
}
