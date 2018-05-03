package com.dao;

import java.util.List;

import com.model.Job;

public interface JobDao {

	void addJob(Job job);//insert into job table
	List<Job> getAllJobs();//select * from job table
	Job getJob(int id);
}
