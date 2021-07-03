package com.example.demo.controller;


import com.example.demo.service.NbpService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nbp")
public class NbpController {
    private NbpService nbpService;

    public NbpController(NbpService nbpService){
        this.nbpService = nbpService;
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 402, message = "STOP!!! You shall not get access to this resource"),
            @ApiResponse(code = 403, message = "This item is FORBIDDEN..."),
            @ApiResponse(code = 404, message = "Currency or dates not found"),
            @ApiResponse(code = 504, message = "Server is on fire :(")}
    )
    @ApiOperation(value = "Get average price of currency from -> to dates", notes = "Provide your average currency price between date <-> to")
    @GetMapping("/{currency}/{from}/{to}")
    public ResponseEntity<Double> getAvgLastDays(
            @ApiParam(value = "Currency you want to retrieve", example = "eur")
            @PathVariable String currency,

            @ApiParam(value = "Amount of days", example = "2012-01-01")
            @PathVariable String from,

            @ApiParam(value = "Amount of days", example = "2012-01-31")
            @PathVariable String to){
        return ResponseEntity.ok(nbpService.getAvgRateDate(currency, from, to));
    }



}

