package id.co.quiz1_prg7_038.repository;

import id.co.quiz1_prg7_038.model.Pembayaran;
import id.co.quiz1_prg7_038.model.PembayaranPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static id.co.quiz1_prg7_038.constant.PembayaranConstant.*;
@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, PembayaranPK> {
    @Query(value = qAllData, nativeQuery = true)
    List<Pembayaran> findAll();

}
