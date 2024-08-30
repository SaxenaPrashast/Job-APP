package com.example.Job.APP.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private JobService jobService;//creating an object of the interface JobService

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }
    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added successfully";
    }
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null){
            return job;
        }
        return new Job("Slay employee",1L,"Bengaluru","50000","200000","Test job");
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