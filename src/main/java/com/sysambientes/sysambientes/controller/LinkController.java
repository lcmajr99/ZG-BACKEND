package com.sysambientes.sysambientes.controller;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sysambientes.sysambientes.model.Link;
import com.sysambientes.sysambientes.services.LinkService;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LinkController {

	@Autowired
	private LinkService linkService;
	@RequestMapping(method = RequestMethod.POST)
	public Link criaLink(@RequestBody Link linkOriginal) {
		return linkService.create(linkOriginal);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void retornaLink(@PathVariable String id,  HttpServletResponse response) throws IOException {
		String headerServidor="localhost:8080/";
		Link link = linkService.findbyLinkOriginal(headerServidor+id);
		link.setQtdDeAcesso(link.getQtdDeAcesso()+1);
		linkService.update(link);
		response.sendRedirect(link.getLinkOriginal());
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Link>> findAll() {
		List<Link> linkList = linkService.findAll();
		return new ResponseEntity<>(linkList, HttpStatus.OK);
	}
}