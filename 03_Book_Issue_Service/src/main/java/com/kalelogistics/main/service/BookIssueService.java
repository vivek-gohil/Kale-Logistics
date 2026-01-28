package com.kalelogistics.main.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.kalelogistics.main.domain.BookIssue;
import com.kalelogistics.main.dto.BookDTO;
import com.kalelogistics.main.dto.BookIssueRequestDTO;
import com.kalelogistics.main.dto.BookIssueResponseDTO;
import com.kalelogistics.main.dto.MemberDTO;
import com.kalelogistics.main.repository.BookIssueRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BookIssueService {
	private final BookIssueRepository bookIssueRepository;
	private final WebClient webClient;

	public BookIssueResponseDTO issueBook(BookIssueRequestDTO bookIssueRequestDTO) {

		log.info(bookIssueRequestDTO.toString());

		// Get Book Details (BookDTO) = http://localhost:8081/books/{bookCode}
		BookDTO bookDTO = webClient.get().uri("http://localhost:8081/books/" + bookIssueRequestDTO.getBookCode())
				.retrieve().bodyToMono(BookDTO.class).block();
		log.info(bookDTO.toString());

		// Get Member Details (MemberDTO) = http://localhost:8082/members/{memberCode}
		MemberDTO memberDTO = webClient.get()
				.uri("http://localhost:8082/members/" + bookIssueRequestDTO.getMemberCode()).retrieve()
				.bodyToMono(MemberDTO.class).block();
		log.info(memberDTO.toString());

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

		return new BookIssueResponseDTO("Book Issued Successfully", memberDTO.getMemberCode(), bookDTO.getBookCode(),
				bookIssue.getDueDate());
	}
}
