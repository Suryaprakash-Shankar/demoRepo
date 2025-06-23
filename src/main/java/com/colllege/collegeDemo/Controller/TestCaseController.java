package com.colllege.collegeDemo.Controller;

import com.colllege.collegeDemo.Exception.ResourceException;
import com.colllege.collegeDemo.Modle.TestCase;
import com.colllege.collegeDemo.Repository.TestCaseRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcase/details")

public class TestCaseController {

    @Autowired
    private TestCaseRepository testCaseRepository;

    @PostMapping("/create")
    public TestCase postvalue(@RequestBody TestCase testCase){
        return testCaseRepository.save(testCase);
    }

    @GetMapping("/read")
    public List<TestCase> GetAllValue(){
        return testCaseRepository.findAll();
    }

//  Get BY ID
    @GetMapping("/ReadById/{Id}")
    public ResponseEntity<TestCase> Getbyid(@PathVariable Integer Id){
        TestCase testCase = testCaseRepository.findById(Id).orElseThrow(() -> new ResourceException("Not Exist in this ID:" + Id));
        return ResponseEntity.ok(testCase);
    }

//    Update the value
    @PutMapping("/Update/{Id}")
    public ResponseEntity<TestCase> Update(@PathVariable Integer Id , @RequestBody TestCase details){
        TestCase Update = testCaseRepository.findById(Id).orElseThrow(() -> new ResourceException("Updater Details Not Found" +Id));
        Update.setName(details.getName());
        Update.setMobile(details.getMobile());
        Update.setAddress(details.getAddress());

        testCaseRepository.save(Update);
        return ResponseEntity.ok(Update);
    }

//    Delete The Data
    @DeleteMapping("/Delete/{Id}")

    public ResponseEntity<HttpStatus> Deleter(@PathVariable Integer Id){

        TestCase testCase = testCaseRepository.findById(Id).orElseThrow(()-> new ResourceException("No Id Found No Delete Is Performed Here In This Id : " +Id));

        testCaseRepository.delete(testCase);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


}


// Total CRUD OPERATION IS DONE on Monday