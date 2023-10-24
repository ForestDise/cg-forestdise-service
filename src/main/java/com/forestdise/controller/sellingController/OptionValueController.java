package com.forestdise.controller.sellingController;

import com.forestdise.dto.OptionTableDto;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.entity.OptionTable;
import com.forestdise.entity.OptionValue;
import com.forestdise.payload.request.OptionRequest;
import com.forestdise.payload.request.OptionValueRequest;
import com.forestdise.payload.response.OptionCreateResponse;
import com.forestdise.payload.response.OptionValueCreateResponse;
import com.forestdise.service.impl.OptionServiceImpl;
import com.forestdise.service.impl.OptionValueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/option-value/{option_id}")
public class OptionValueController {
    private final OptionValueServiceImpl optionValueService;
    @Autowired
    public OptionValueController(OptionValueServiceImpl optionValueService ) {
        this.optionValueService = optionValueService;
    }
    @PostMapping("/create")
    public ResponseEntity<OptionValueCreateResponse> createOptionValue(@RequestBody List<String> valueRequest, @PathVariable("option_id") Long option_id){
        OptionValueCreateResponse optionValueCreateResponse= new OptionValueCreateResponse();
        List<OptionValueDto> optionValueDtoList = new ArrayList<>();
        for(String ele : valueRequest){
            OptionValueDto optionValueDto = OptionValueDto.builder()
                    .value(ele)
                    .build();
            optionValueDtoList.add(optionValueDto);
        }
        List<OptionValueDto> optionValue =optionValueService.createOptionValue(optionValueDtoList,option_id);
        if (optionValue != null) {
            optionValueCreateResponse.setMessage("OptionValue created successfully");
            optionValueCreateResponse.setOptionValueDtoList(optionValue);
            return new ResponseEntity<>(optionValueCreateResponse, HttpStatus.CREATED);
        } else {
            optionValueCreateResponse.setMessage("Failed to create OptionValue");
            return new ResponseEntity<>(optionValueCreateResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
