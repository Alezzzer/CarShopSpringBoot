package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.AzKomentariDTO;
import com.dto.AzTemaDTO;
import com.dto.KomentarRequest;
import com.proxy.ProxyKomentar;

@Service
public class BlogService {
@Autowired 
ProxyKomentar proxykomentar;
	

	public List<AzTemaDTO> vratiTeme() {
		List<AzTemaDTO> lista= proxykomentar.getAllAzTema();
		return lista;
	}

	public List<AzKomentariDTO> vratiKomentare(){
		List<AzKomentariDTO> lista=proxykomentar.getAllAzKomentari();
		return lista;
	}
	
	public List<AzKomentariDTO> vratiKomentareNaTemu(int temaId){
		List<AzKomentariDTO> lista=proxykomentar.getAzKomentariByTemaId(temaId);
		return lista;
	}
	
	public List<AzKomentariDTO> vratiMojeKomentare(int korisnikId){
		List<AzKomentariDTO> lista=proxykomentar.getAzKomentarById(korisnikId);
		return lista;
	}
	
	public AzKomentariDTO dodajKomentar(KomentarRequest kom,int korisnikId) {
		AzKomentariDTO komentar=proxykomentar.addNewKomentar(kom, korisnikId);
		return komentar;
	}
}
