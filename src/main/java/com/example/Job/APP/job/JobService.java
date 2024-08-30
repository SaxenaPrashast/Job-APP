package com.example.Job.APP.job;



import java.util.List;

public interface JobService {
    List<Job> findAll();  //will return all the jobs
    void createJob(Job job);

    Job getJobById(Long id);
}