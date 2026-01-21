package com.kalelogistics.main.domain;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

public class Project {
	private int projectId;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	private double dudget;

	public Project() {
		System.out.println("Default constructor of Project");
	}

	public Project(int projectId, String title, LocalDate startDate, LocalDate endDate, double dudget) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dudget = dudget;
		System.out.println("Overloaded constructor of Project");
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getDudget() {
		return dudget;
	}

	public void setDudget(double dudget) {
		this.dudget = dudget;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", title=" + title + ", startDate=" + startDate + ", endDate="
				+ endDate + ", dudget=" + dudget + "]";
	}

}
