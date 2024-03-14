package com.example.giftsertifikate.service.gift_sertificate;

import com.example.giftsertifikate.controller.dto.GiftSertificateDto;
import com.example.giftsertifikate.controller.dto.SearchDto;
import com.example.giftsertifikate.entity.GiftSertificate;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GiftSertificateService {
    GiftSertificateDto add(GiftSertificateDto giftSertificateDto);

    List<GiftSertificate> getSearchGifts(Pageable pageable, SearchDto searchDto);


}
