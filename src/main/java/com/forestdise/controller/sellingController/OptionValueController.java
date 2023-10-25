package com.forestdise.controller.sellingController;

import com.forestdise.dto.OptionValueDTO;
import com.forestdise.entity.OptionValue;
import com.forestdise.payload.request.OptionValueRequest;
import com.forestdise.payload.response.OptionValueCreateResponse;
import com.forestdise.service.impl.OptionValueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/option-value/{option_id}/{variant_id}")
public class OptionValueController {
    private final OptionValueServiceImpl optionValueService;
    @Autowired
    public OptionValueController(OptionValueServiceImpl optionValueService ) {
        this.optionValueService = optionValueService;
    }
    @PostMapping("/create")
    public ResponseEntity<OptionValueCreateResponse> createOptionValue(@RequestBody OptionValueRequest optionValueRequest, @PathVariable("option_id") Long option_id,@PathVariable("variant_id") Long variant_id){
        OptionValueCreateResponse optionValueCreateResponse= new OptionValueCreateResponse();
        OptionValueDTO optionValueDto = OptionValueDTO.builder()
                .value(optionValueRequest.getValue())
                .build();
        OptionValue optionValue =optionValueService.createOptionValue(optionValueDto,option_id, variant_id);

        if (optionValue != null) {
            optionValueCreateResponse.setMessage("OptionValue created successfully");
            optionValueCreateResponse.setOptionValue_Id(optionValue.getId());
            return new ResponseEntity<>(optionValueCreateResponse, HttpStatus.CREATED);
        } else {
            optionValueCreateResponse.setMessage("Failed to create OptionValue");
            return new ResponseEntity<>(optionValueCreateResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
