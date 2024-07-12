package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.entity.Account;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {
	@Autowired
	private IAccountService accountService;

	@GetMapping()
	public ResponseEntity<?> getAllAccounts() {
		List<Account> accountListDB = accountService.getAllAccounts();
		List<AccountDto> accountListDto = new ArrayList<>();

		// convert accountListDB --> accountListDto
		for (Account accountDB : accountListDB) {
			AccountDto accountDto = new AccountDto();
			accountDto.setId(accountDB.getId());
			accountDto.setEmail(accountDB.getEmail());
			accountDto.setUsername(accountDB.getUsername());
			accountDto.setFullname(accountDB.getFullname());
			accountDto.setAvatarImageName(accountDB.getAvatarImageName());
			accountDto.setMobile(accountDB.getMobile());
			accountDto.setAddress(accountDB.getAddress());
			accountDto.setCreateDate(accountDB.getCreateDate());
			accountDto.setStatus(accountDB.getStatus().toString());

			accountListDto.add(accountDto);
		}

		return new ResponseEntity<>(accountListDto, HttpStatus.OK);
	}
}
