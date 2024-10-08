package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.AzKomentari;

@Repository
public interface AzKomentariRepository extends JpaRepository<AzKomentari, Integer> {
    List<AzKomentari> findByAzTema_TemaId(int temaId);
    List<AzKomentari> findByAzKorisnici_KorisnikId(int korisnikId);
}