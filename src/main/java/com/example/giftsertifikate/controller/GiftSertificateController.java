package com.example.giftsertifikate.controller;


import com.example.giftsertifikate.controller.dto.GiftSertificateDto;
import com.example.giftsertifikate.controller.dto.SearchDto;
import com.example.giftsertifikate.entity.GiftSertificate;
import com.example.giftsertifikate.service.gift_sertificate.GiftSertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gift")
public class GiftSertificateController {
    private final GiftSertificateService giftSertificateService;

    @PostMapping("/add")
    public GiftSertificateDto addGift(
            @RequestBody GiftSertificateDto giftSertificateDto
    ){
        giftSertificateService.add(giftSertificateDto);
        return giftSertificateDto;
    }

    @GetMapping("/get-all")
    public List<GiftSertificate> getAllGift(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(defaultValue = "tag") String searchBy,
            @RequestParam(defaultValue = "tag") String search
    ){
        defaultMethod();
        Pageable page1 = PageRequest.of(page,size, Sort.Direction.ASC,sortBy);
        if(sortDir.equals("desc")){
            page1 = PageRequest.of(page,size, Sort.Direction.DESC,sortBy);
        }
        return giftSertificateService.getSearchGifts(page1, new SearchDto(searchBy,search));
    }

    private void defaultMethod(){
//        giftSertificateService.add(new GiftSertificate("bugun","7-mart",null));
//        giftSertificateService.add(new GiftSertificate("bugun1","7-mart",null));
//        giftSertificateService.add(new GiftSertificate("bugun2","7-mart",null));
//        giftSertificateService.add(new GiftSertificate("bugun3","7-mart",null));
//        giftSertificateService.add(new GiftSertificate("bugun4","7-mart",null));
    }
}
