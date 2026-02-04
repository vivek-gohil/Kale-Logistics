package com.kalelogistics.main.service;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kalelogistics.main.domain.BookIssue;
import com.kalelogistics.main.dto.BookDTO;
import com.kalelogistics.main.dto.BookIssueRequestDTO;
import com.kalelogistics.main.dto.BookIssueResponseDTO;
import com.kalelogistics.main.dto.MemberDTO;
import com.kalelogistics.main.repository.BookIssueRepository;
import com.kalelogistics.main.service.client.BooksFeignClient;
import com.kalelogistics.main.service.client.MembersFeignClient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BookIssueService {
	private final BookIssueRepository bookIssueRepository;
	private final BooksFeignClient booksFeignClient;
	private final MembersFeignClient membersFeignClient;

	public BookIssueResponseDTO issueBook(BookIssueRequestDTO bookIssueRequestDTO) {

		log.info(bookIssueRequestDTO.toString());

		// Get Book Details (BookDTO) = http://localhost:8081/books/{bookCode}
		BookDTO bookDTO = null;
		ResponseEntity<BookDTO> bookResponseEntity = booksFeignClient.getBook(bookIssueRequestDTO.getBookCode());
		if (bookResponseEntity != null) {
			bookDTO = bookResponseEntity.getBody();

			log.info(bookDTO.toString());
		}

		// Get Member Details (MemberDTO) = http://localhost:8082/members/{memberCode}
		MemberDTO memberDTO = null;
		ResponseEntity<MemberDTO> memberResponseEntity = membersFeignClient
				.getMember(bookIssueRequestDTO.getMemberCode());

		if (memberResponseEntity != null) {
			memberDTO = memberResponseEntity.getBody();
			log.info(memberDTO.toString());
		}

		if (memberDTO != null && bookDTO != null) {
			BookIssue bookIssue = null;
			if (bookDTO.isIssuable() && bookDTO.isIssued() == false && memberDTO.isActive()) {
				if (memberDTO.getMemberType().equals("STUDENT")
						&& bookIssueRepository.countIssuedBooks(memberDTO.getMemberCode()) <= 3) {
					bookIssue = new BookIssue("", memberDTO.getMemberCode(), bookDTO.getBookCode(), LocalDate.now(),
							LocalDate.now().plusDays(10), null);
					bookIssueRepository.issueBook(bookIssue);
				}
				if (memberDTO.getMemberType().equals("FACULTY")
						&& bookIssueRepository.countIssuedBooks(memberDTO.getMemberCode()) <= 25) {
					bookIssue = new BookIssue("", memberDTO.getMemberCode(), bookDTO.getBookCode(), LocalDate.now(),
							LocalDate.now().plusDays(90), null);
					bookIssueRepository.issueBook(bookIssue);
				}
			}

			return new BookIssueResponseDTO("Book Issued Successfully", bookIssueRequestDTO.getMemberCode(),
					bookIssueRequestDTO.getBookCode(), LocalDate.now());
		} else {
			return new BookIssueResponseDTO("Failed to issue book as one of service is failed !!", null, null, null);
		}

	}
}
