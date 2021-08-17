package com.sysambientes.sysambientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.sysambientes.sysambientes.model.Link;
import com.sysambientes.sysambientes.repository.LinkRepository;

@Service
public class LinkService {

	@Autowired
	private LinkRepository linkRepository;


	public LinkService() { }
	
	public <S extends Link> S create(S linkOriginal) {

		String caracteres;
		String header="https://";
		String header2="http://";
		String headerServidor="https://zg-avaliacao.herokuapp.com/";
		StringBuilder codigoUnico;
		caracteres = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		codigoUnico = new StringBuilder(5);
		Boolean flag;
		do{
			for(int i = 0; i < 5; i++) {
				int myindex = (int)(caracteres.length() * Math.random());
				codigoUnico.append(caracteres.charAt(myindex));
			}
			if(linkRepository.findbyLinkReduzido(headerServidor+codigoUnico.toString())!= null){
				flag=true;
			}else{
				flag=false;
			}
		}while (flag);


		Link link = new Link();

		if(!linkOriginal.getLinkOriginal().contains(header) && !linkOriginal.getLinkOriginal().contains(header2)){
			linkOriginal.setLinkOriginal(header + linkOriginal.getLinkOriginal());
		}
		link.setLinkOriginal(linkOriginal.getLinkOriginal());
		link.setLinkReduzido(headerServidor+codigoUnico.toString());
		link.setQtdDeAcesso(0);
		linkOriginal.setLinkOriginal(link.getLinkReduzido());
		linkRepository.save(link);
		return linkOriginal;

	}

	public <S extends Link> S update(S entity) {
		return linkRepository.save(entity);
	}

	public List<Link> findAll() {
		return linkRepository.findAll(Sort.by(Sort.Direction.DESC, "qtdDeAcesso"));
	}

	public Link findbyLinkOriginal(String linkReduzido) {
		Link linkOpt = linkRepository.findbyLinkReduzido(linkReduzido);
		return linkOpt;
	}







}
