package com.spring.esercizio1.controller;

import java.util.LinkedList;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "Lotto")
public class ListaLotto {

	@GetMapping(path = "NumeriVincenti")
	public LinkedList<Integer> numeri() {
		LinkedList<Integer> l = new LinkedList<>();
		Random r = new Random();
		Integer num;

		for (int i = 0; i < 5; i++) {
			num = r.nextInt(7);
			if (l.contains(num)) {
				i--;
				continue;
			} else {
				l.add(num);
			}

		}

		return l;

	}
}
