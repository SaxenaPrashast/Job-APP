package com.example.Job.APP.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private JobService jobService;//creating an object of the interface JobService

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
//    @GetMapping("/jobs")
//    public List<Job> findAll(){
//        return jobService.findAll();
//    }

//    @GetMapping("/jobs")
    @RequestMapping(value="/jobs",method = RequestMethod.GET)//can also use request mapping anotation accepts two parameters value(defines address) and method(defines the get post put etc )
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }
//    @PostMapping("/jobs")
//    public String createJob(@RequestBody Job job){
//        jobService.createJob(job);
//        return "Job added successfully";
//    }



    //Using Response entity
    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
    }
//    @GetMapping("/jobs/{id}")
//    public Job getJobById(@PathVariable Long id){
//        Job job = jobService.getJobById(id);
//        if(job!=null){
//            return job;
//        }
//        return new Job("Slay employee",1L,"Bengaluru","50000","200000","Test job");
//    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("Job deleted sucessfully",HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> UpdateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if(updated){
            return new ResponseEntity<>("Job upadated sucessfully",HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}




/*
GET / jobs: Get all jobs
GET / jobs/{id}:Get a specific job by id
POST/jobs:Create a new job(request body should contain the job details)
DELETE/jobs/{id}:Delete a specific job by ID
PUT/jobs/{id}/company:Get the company associated with a specific job by ID(request body should contain the updated job details)
//GET/jobs/{id}/company:Get the company associated with a specific job by ID

Example API URLs:
GET{base_url}/jobs
GET{base_url}/jobs/1
POST{base_url}/jobs
DELETE{base_url}/jobs/1
PUT{base_url}/jobs/1
 */