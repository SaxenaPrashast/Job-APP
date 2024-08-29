package com.example.Job.APP.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private List<Job> jobs = new ArrayList<>();
    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobs;
    }
}




/*
GET / jobs: Get all jobs
GET / jobs/{id}:Get a specific job by id
POST/jobs:Create a new job(request body should contain the job details)
DELETE/jobs/{id}:Delete a specific job by ID
PUT/jobs/{id}/company:Get the company associated with a specific job by ID
//GET/jobs/{id}/company:Get the company associated with a specific job by ID

Example API URLs:
GET{base_url}/jobs
GET{base_url}/jobs/1
POST{base_url}/jobs
DELETE{base_url}/jobs/1
PUT{base_url}/jobs/1
 */