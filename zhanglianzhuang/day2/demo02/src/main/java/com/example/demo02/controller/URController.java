package com.example.demo02.controller;

import com.example.demo02.service.URService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class URController {
	@Autowired
	private URService urService;
}
