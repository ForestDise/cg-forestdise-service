package com.forestdise.controller.sellingController;

import com.forestdise.dto.OptionTableDTO;
import com.forestdise.entity.OptionTable;
import com.forestdise.payload.request.OptionRequest;
import com.forestdise.payload.response.OptionCreateResponse;
import com.forestdise.service.impl.OptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<OptionCreateResponse> createOption(@RequestBody OptionRequest optionRequest, @PathVariable("product_id") Long product_id){
        OptionCreateResponse optionCreateResponse= new OptionCreateResponse();
        OptionTableDTO optionDto = OptionTableDTO.builder()
                .name(optionRequest.getName())
                .build();
        OptionTable option =optionService.createOption(optionDto,product_id);

        if (option != null) {
            optionCreateResponse.setMessage("Option created successfully");
            optionCreateResponse.setOptionId(option.getId());
            return new ResponseEntity<>(optionCreateResponse, HttpStatus.CREATED);
        } else {
            optionCreateResponse.setMessage("Failed to create Option");
            return new ResponseEntity<>(optionCreateResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
