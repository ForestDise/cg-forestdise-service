package com.forestdise.controller.sellingController;

import com.forestdise.dto.OptionTableDto;
import com.forestdise.entity.OptionTable;
import com.forestdise.payload.request.OptionRequest;
import com.forestdise.payload.response.OptionCreateResponse;
import com.forestdise.service.impl.OptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/option/{product_id}")
public class OptionController {
    private final OptionServiceImpl optionService;
    @Autowired
    public OptionController(OptionServiceImpl optionService ) {
        this.optionService = optionService;
    }
    @PostMapping("/create")
    public ResponseEntity<OptionCreateResponse> createOption(@RequestBody List<String> optionRequest, @PathVariable("product_id") Long product_id){
        OptionCreateResponse optionCreateResponse= new OptionCreateResponse();
        List<OptionTableDto> optionTableDtoList = new ArrayList<>();
        for(String ele : optionRequest){
            OptionTableDto optionTableDto = OptionTableDto.builder()
                    .name(ele)
                    .build();
            optionTableDtoList.add(optionTableDto);
        }
        List<OptionTableDto> options =optionService.createOption(optionTableDtoList,product_id);

        if (options != null) {
            optionCreateResponse.setMessage("Option created successfully");
            optionCreateResponse.setOptionTableDtoList(options);
            return new ResponseEntity<>(optionCreateResponse, HttpStatus.CREATED);
        } else {
            optionCreateResponse.setMessage("Failed to create Option");
            return new ResponseEntity<>(optionCreateResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
